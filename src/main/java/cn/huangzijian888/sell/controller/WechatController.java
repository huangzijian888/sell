package cn.huangzijian888.sell.controller;

import cn.huangzijian888.sell.config.ProjectUrlConfig;
import cn.huangzijian888.sell.config.WechatAccountConfig;
import cn.huangzijian888.sell.enums.ResultEnum;
import cn.huangzijian888.sell.exception.SellException;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huangzijian888
 * @date: 2019/10/15 03:59
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxMpService wxOpenService;

    @Autowired
    private WxCpService wxCpService;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @Autowired
    private WechatAccountConfig accountConfig;

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {
        String url = projectUrlConfig.getWechatMpAuthorize() + "/sell/wechat/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLUtil.encode(returnUrl));
        log.info("【微信网页授权】获取code，result={}", redirectUrl);
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) {
        return this.getUserInfo(wxMpService, code, returnUrl);
    }

    @GetMapping("/qrAuthorize")
    public String qrAuthorize(@RequestParam("returnUrl") String returnUrl) {
        String url = projectUrlConfig.getWechatOpenAuthorize() + "/sell/wechat/qrUserInfo";
        String redirectUrl = wxOpenService.buildQrConnectUrl(url, WxConsts.QrConnectScope.SNSAPI_LOGIN, URLUtil.encode(returnUrl));
        return "redirect:" + redirectUrl;
    }

    @GetMapping("qrUserInfo")
    public String qrUserInfo(@RequestParam("code") String code,
                             @RequestParam("state") String returnUrl) {
        return this.getUserInfo(wxOpenService, code, returnUrl);
    }

    @GetMapping("/cpQrAuthorize")
    public String cpQrAuthorize() throws WxErrorException {

        String url = "https://open.work.weixin.qq.com/wwopen/sso/qrConnect?appid="
                + accountConfig.getCorpId() + "&agentid="
                + accountConfig.getAgentId()
                + "&redirect_uri=" + accountConfig.getRedirectUri();
        return "redirect:" + url;
    }

    @GetMapping("/cpQrReturn")
    public ModelAndView cpQrReturn(@RequestParam("code") String code,
                                   Map<String, Object> map) throws WxErrorException {
        String url = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo";
        HashMap<String, Object> param = new HashMap<>(2);
        param.put("access_token", wxCpService.getAccessToken());
        param.put("code", code);
        JSONObject jsonObject = JSONUtil.parseObj(HttpUtil.get(url, param));
        String userId = jsonObject.getStr("UserId");
        if (StringUtils.isEmpty(userId)) {
            map.put("msg", "登录失败");
            map.put("url", projectUrlConfig.getSell() + "wechat/cpQrAuthorize");
            return new ModelAndView("common/error", map);
        }
        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "seller/login?openid=" + userId);
    }

    private String getUserInfo(WxMpService wxMpService, String code, String returnUrl) {

        WxMpOAuth2AccessToken wxMpOAuth2AccessToken;
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.info("【微信网页授权】{}", e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();

        return "redirect:" + returnUrl + "?openid=" + openId;
    }
}

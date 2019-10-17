package cn.huangzijian888.sell.controller;

import cn.huangzijian888.sell.config.ProjectUrlConfig;
import cn.huangzijian888.sell.constant.CookieConstant;
import cn.huangzijian888.sell.constant.RedisConstant;
import cn.huangzijian888.sell.dataobject.SellerInfo;
import cn.huangzijian888.sell.enums.ResultEnum;
import cn.huangzijian888.sell.service.SellerService;
import cn.huangzijian888.sell.utils.CookieUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 卖家用户
 *
 * @author: huangzijian888
 * @date: 2019/10/17 23:37
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    ProjectUrlConfig projectUrlConfig;
    @Autowired
    private SellerService sellerService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              HttpServletResponse response,
                              Map<String, Object> map) {

        // openid去和数据库里面的数据做匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        if (sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", projectUrlConfig.getSell() + "wechat/cpQrAuthorize");
            return new ModelAndView("common/error", map);
        }

        // 设置token至Redis
        String token = IdUtil.randomUUID();
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), openid, expire, TimeUnit.SECONDS);

        // 设置token到cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);
        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "seller/order/list");
    }

    @GetMapping("logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {

        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null) {
            // 清除Redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));

            // 清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }
        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());

        map.put("url", projectUrlConfig.getSell() + "seller/order/list");

        return new ModelAndView("common/success", map);

    }
}

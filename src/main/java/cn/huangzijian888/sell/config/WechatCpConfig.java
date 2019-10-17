package cn.huangzijian888.sell.config;

import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.api.impl.WxCpServiceImpl;
import me.chanjar.weixin.cp.config.WxCpConfigStorage;
import me.chanjar.weixin.cp.config.impl.WxCpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: huangzijian888
 * @date: 2019/10/17 21:12
 */
@Component
public class WechatCpConfig {

    @Autowired
    private WechatAccountConfig accountConfig;

    @Bean
    public WxCpService wxCpService() {
        WxCpServiceImpl wxCpService = new WxCpServiceImpl();
        wxCpService.setWxCpConfigStorage(wxCpConfigStorage());
        return wxCpService;
    }

    @Bean
    public WxCpConfigStorage wxCpConfigStorage() {
        WxCpDefaultConfigImpl config = new WxCpDefaultConfigImpl();
        config.setCorpId(accountConfig.getCorpId());
        config.setCorpSecret(accountConfig.getCorpSecret());
        config.setAgentId(accountConfig.getAgentId());
        config.setOauth2redirectUri(accountConfig.getRedirectUri());
        return config;
    }
}

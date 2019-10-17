package cn.huangzijian888.sell.config;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Binary Wang
 */
@Configuration
@ConditionalOnClass(WxPayService.class)
@AllArgsConstructor
public class WxPayConfiguration {

    @Autowired
    private WechatAccountConfig accountConfig;

    @Bean
    @ConditionalOnMissingBean
    public WxPayService wxService() {
        WxPayConfig payConfig = new WxPayConfig();
        payConfig.setAppId(StringUtils.trimToNull(this.accountConfig.getMpAppId()));
        payConfig.setMchId(StringUtils.trimToNull(this.accountConfig.getMchId()));
        payConfig.setMchKey(StringUtils.trimToNull(this.accountConfig.getMchKey()));
        payConfig.setKeyPath(StringUtils.trimToNull(this.accountConfig.getKeyPath()));
        payConfig.setNotifyUrl(StringUtils.trimToNull(this.accountConfig.getNotifyUrl()));

        // 可以指定是否使用沙箱环境
        payConfig.setUseSandboxEnv(false);

        WxPayService wxPayService = new WxPayServiceImpl();
        wxPayService.setConfig(payConfig);
        return wxPayService;
    }

}

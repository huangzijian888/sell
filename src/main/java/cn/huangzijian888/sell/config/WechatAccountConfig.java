package cn.huangzijian888.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: huangzijian888
 * @date: 2019/10/15 04:16
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    /**
     * 公众平台id
     */
    private String mpAppId;

    /**
     * 公众平台秘钥
     */
    private String mpAppSecret;

    /**
     * 开放平台id
     */
    private String openAppId;

    /**
     * 开放平台秘钥
     */
    private String openAppSecret;

    /**
     * 企业微信的CorpID
     */
    private String corpId;

    /**
     * 企业微信网页应用ID
     */
    private Integer agentId;

    /**
     * 企业网页应用Secret
     */
    private String corpSecret;

    /**
     * 企业微信重定向地址
     */
    private String redirectUri;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * 商户密钥
     */
    private String mchKey;

    /**
     * 商户证书路径
     */
    private String keyPath;

    /**
     * 微信支付异步通知地址
     */
    private String notifyUrl;

    /**
     * 微信模板id
     */
    private Map<String, String> templateId;

}

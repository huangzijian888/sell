package cn.huangzijian888.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: huangzijian888
 * @date: 2019/10/17 19:36
 */
@Data
@Component
@ConfigurationProperties(prefix = "project")
public class ProjectUrlConfig {

    /**
     * 微信公众平台授权URL
     */
    private String wechatMpAuthorize;

    /**
     * 微信开放平台授权URL
     */
    private String wechatOpenAuthorize;

    /**
     * 微信企业平台授权URL
     */
    private String wechatCpAuthorize;

    /**
     * 点餐系统
     */
    private String sell;

}




package cn.huangzijian888.sell.handler;

import cn.huangzijian888.sell.config.ProjectUrlConfig;
import cn.huangzijian888.sell.exception.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: huangzijian888
 * @date: 2019/10/18 01:14
 */
@ControllerAdvice
public class SellExceptionHandle {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    /**
     * 拦截登录异常
     *
     * @return
     */
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handleAuthorizeException() {
        return new ModelAndView("redirect:" + projectUrlConfig.getWechatCpAuthorize());
    }
}

package cn.huangzijian888.sell.handler;

import cn.huangzijian888.sell.config.ProjectUrlConfig;
import cn.huangzijian888.sell.exception.SellException;
import cn.huangzijian888.sell.exception.SellerAuthorizeException;
import cn.huangzijian888.sell.utils.ResultVoUtil;
import cn.huangzijian888.sell.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:" + projectUrlConfig.getWechatCpAuthorize());
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellException(SellException e) {
        return ResultVoUtil.error(e.getCode(), e.getMessage());
    }
}

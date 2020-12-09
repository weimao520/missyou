package com.lin.missyou.code;

import com.lin.missyou.code.configuration.ExceptionCodeConfiguration;
import com.lin.missyou.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * @author WeiMao
 * @create 2020-04-18 15:51
 */
@ControllerAdvice
public class GlobalExceptionAdvice {


    @Autowired
    ExceptionCodeConfiguration codeConfiguration;
    /**
     * 处理位置异常
     * ExceptionHandler   设置拦截的级别
     * @param req
     * @param e
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest req,Exception e){

        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
        // 打印错误
        System.out.println(e);
        return new UnifyResponse(9999,"服务器异常",method+"  "+requestUrl);
    }


    @ExceptionHandler(value = HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest req, HttpException e){
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
        // 打印错误
        System.out.println(e);

        UnifyResponse message = new UnifyResponse(e.getCode(), codeConfiguration.getMessage(e.getCode()), method + "  " + requestUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());

        ResponseEntity<UnifyResponse> r = new ResponseEntity<>(message,headers,httpStatus);
        return r;
    }

    /**
     * 检验 错误拦截
     *
     * @param req
     * @param e
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public UnifyResponse handleBeanValidation(HttpServletRequest req, MethodArgumentNotValidException e) {
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String message = this.formatAllErrorMessage(errors);

        return new UnifyResponse(10001, message, method + "  " + requestUrl);
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public UnifyResponse handleConstraintException(HttpServletRequest req,ConstraintViolationException e){
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
        String message = e.getMessage();
        return new UnifyResponse(10001, message, method + "  " + requestUrl);

    }

    private String formatAllErrorMessage(  List<ObjectError> errors){
        StringBuffer errorMsg = new StringBuffer();
        errors.forEach(e->{
            errorMsg.append(e.getDefaultMessage()).append(";");
        });
        return errorMsg.toString();
    }
}

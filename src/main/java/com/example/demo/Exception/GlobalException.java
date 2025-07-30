package com.example.demo.Exception;

import com.example.demo.Control.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

//@ControllerAdvice
//@RestController
@RestControllerAdvice
public class GlobalException {
    private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);
    // 捕获所有未处理异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleAllException(HttpServletRequest request, Exception ex) {
        logger.error("请求地址: {}, 发生异常: {}", request.getRequestURI(), ex.getMessage(), ex);
        return new Result(0, "服务器异常，请联系管理员", null);
    }
    // 处理自定义业务异常示例
    @ExceptionHandler(MyBusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleBusinessException(MyBusinessException ex) {
        logger.warn("业务异常: {}", ex.getMessage());
        return new Result(0, ex.getMessage(), null);
    }
    // 处理请求参数绑定异常（例如JSON解析错误）
    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleHttpMessageNotReadableException(org.springframework.http.converter.HttpMessageNotReadableException ex) {
        logger.warn("请求参数解析失败: {}", ex.getMessage());
        return new Result(0, "请求参数格式错误", null);
    }
    // 处理文件上传相关异常
    @ExceptionHandler(org.springframework.web.multipart.MultipartException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleMultipartException(org.springframework.web.multipart.MultipartException ex) {
        logger.warn("文件上传失败: {}", ex.getMessage());
        return new Result(0, "文件上传失败，请重试", null);
    }
}

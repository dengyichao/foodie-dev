package com.dyc.exception;

import com.dyc.utils.JSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * @description:
 * @author: dengyichao
 * @createDate: 2020/2/21
 * @version: 1.0
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    // 上传文件500k捕获异常：MaxUploadSizeExceededException
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public JSONResult handlerMaxUploadFile(MaxUploadSizeExceededException ex){
        return JSONResult.errorMsg("文件上传大小不能超过500K，请压缩图片或降低图片质量在上传");
    }
}

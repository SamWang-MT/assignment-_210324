package com.company.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.core.ResultGenerator;

@RestControllerAdvice
public class GlobalDefaultExceptionHandler {
	private final Logger log = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

	/**
	 * BindException
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result handleMethodArgumentNotValidException(BindException e) {
		outPutError(BindException.class, ResultCode.FAIL, e);
		BindingResult bindingResult = e.getBindingResult();
		return ResultGenerator.genFailResult("");
	}

	/**
	 * Exception MethodArgumentTypeMismatchException
	 */

	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result handlerMethodArgumentTypeException(MethodArgumentTypeMismatchException e) {
		return ResultGenerator.genParameterExceptionResult();
	}

	/**
	 * Exception
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result handlerException(Exception e) {
		e.printStackTrace();
		return ResultGenerator.genInternalServerErrorResult();
	}

	public void outPutError(Class errorType, Enum secondaryErrorType, Throwable throwable) {
		log.error("[{}] {}: {}", errorType.getSimpleName(), secondaryErrorType, throwable.getMessage(), throwable);
	}

	public void outPutErrorWarn(Class errorType, Enum secondaryErrorType, Throwable throwable) {
		log.warn("[{}] {}: {}", errorType.getSimpleName(), secondaryErrorType, throwable.getMessage());
	}

}
package com.company.project.core;

/**
 * ResultGenerator
 */

public class ResultGenerator {
	private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
	private static final String DEFAULT_UNAUTHORIZED_MESSAGE = "UNAUTHORIZED";
	private static final String DEFAULT_INTERNAL_SERVER_ERROR_MESSAGE = "INTERNAL SERVER ERROR";
	private static final String DEFAULT_PARAMETER_EXCEPTION_MESSAGE = "PARAMETER_EXCEPTION";

	@SuppressWarnings("rawtypes")
	public static Result genSuccessResult() {
		return new Result().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> Result<T> genSuccessResult(T data) {
		return new Result().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE).setData(data);
	}

	@SuppressWarnings("rawtypes")
	public static Result genFailResult(String message) {
		return new Result().setCode(ResultCode.FAIL).setMessage(message);
	}

	@SuppressWarnings("rawtypes")
	public static Result genResult(String message) {
		return new Result().setCode(ResultCode.FAIL).setMessage(message);
	}

	@SuppressWarnings("rawtypes")
	public static Result genUnauthorizedResult() {
		return new Result().setCode(ResultCode.UNAUTHORIZED).setMessage(DEFAULT_UNAUTHORIZED_MESSAGE);
	}

	@SuppressWarnings("rawtypes")
	public static Result genParameterExceptionResult() {
		return new Result().setCode(ResultCode.FAIL).setMessage(DEFAULT_PARAMETER_EXCEPTION_MESSAGE);
	}
	
	@SuppressWarnings("rawtypes")
	public static Result genInternalServerErrorResult() {
		return new Result().setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage(DEFAULT_INTERNAL_SERVER_ERROR_MESSAGE);
	}
}

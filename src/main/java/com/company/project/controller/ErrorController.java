package com.company.project.controller;

/*
 * import javax.servlet.http.HttpServletRequest;
 * 
 * import org.springframework.boot.web.servlet.error.ErrorController; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestControllerAdvice;
 * 
 * import com.company.project.core.Result; import
 * com.company.project.core.ResultGenerator;
 * 
 * @RestControllerAdvice class MainsiteErrorController implements
 * ErrorController {
 * 
 * @RequestMapping("/error") public Result handleError(HttpServletRequest
 * request) {
 * 
 * Integer statusCode = (Integer)
 * request.getAttribute("javax.servlet.error.status_code"); if (statusCode ==
 * 404) { return ResultGenerator.genNotFoundResult(); } else { return
 * ResultGenerator.genInternalServerErrorResult(); } }
 * 
 * @Override public String getErrorPath() { return "/error"; } }
 */


import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;

import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
 
/**
 * 
 */

@ApiIgnore
@Controller
public class ErrorController extends AbstractErrorController {
    public ErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }
    @RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Result handleError(HttpServletRequest request) {
    	Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
    	if (statusCode == 404) {
			return ResultGenerator.genNotFoundResult();
		}      
        return ResultGenerator.genUnkonownerrorResult();
    }
    @Override
    public String getErrorPath() {
        return "/error";
    }
}




package com.zm.media.core.base.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by USERA on 2019/2/13.
 * controller基类
 */
public class BaseController {

    protected HttpServletResponse response;
    protected HttpServletRequest request;

    @ModelAttribute
    public void setResponse(HttpServletResponse response) {
        this.response = response;
        this.response.setHeader("Access-Control-Allow-Origin", "*");
    }

    @ModelAttribute
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

}

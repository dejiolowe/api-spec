package com.sanef.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseApiController {
    @Autowired
    protected MessageSource messages;

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected ApplicationEventPublisher eventPublisher;

    protected String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }


}

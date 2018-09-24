package com.sanef.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;

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

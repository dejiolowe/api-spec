package com.openbanking.api.ng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;

public abstract class BaseService {
	@Autowired
	protected MessageSource messages;

	@Autowired
	protected ApplicationEventPublisher eventPublisher;



}

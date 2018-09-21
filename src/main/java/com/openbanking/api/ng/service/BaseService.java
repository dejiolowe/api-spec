package com.openbanking.api.ng.service;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ClassPathResource;

public abstract class BaseService {
	

	@Value("${OPB_HOME:}")
	private String OPB_HOME;

	
	@Autowired
	protected MessageSource messages;

	@Autowired
	protected ApplicationEventPublisher eventPublisher;


	protected File getOBNDataFile(String dataFile) throws Exception{
		if(StringUtils.isEmpty(OPB_HOME)) {
		ClassPathResource classPathResource=new ClassPathResource(String.format("OPB_HOME/data/%s",dataFile));
		return classPathResource.getFile();
		}else {
			return new File(OPB_HOME);
		}
	}


}

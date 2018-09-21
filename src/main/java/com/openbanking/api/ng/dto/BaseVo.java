package com.openbanking.api.ng.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.openbanking.api.ng.common.ApplicationConstants;

import lombok.Data;

@Data
public class BaseVo implements Serializable {

	
	private Long id;

	
	private String name;

	
	private String description;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ApplicationConstants.DATE_TIME_FORMAT)
	private Date dateCreated;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ApplicationConstants.DATE_TIME_FORMAT)
	private Date dateLastModified;
	
	
	private Boolean active;
	
	
	private boolean pendingApproval;
	
	
	private String orgId;
	

	
	private Long memberId;


}

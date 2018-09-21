package com.openbanking.api.ng.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(exclude = { "owner" }, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetailsDto extends  BaseVo {

	@NotNull
	
	private Long memberId;
	
	private String address1;
	
	private String address2;

}

package com.openbanking.api.ng.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class CardProductsDto implements Serializable {

private String type;

private String limit;

private String description;
}

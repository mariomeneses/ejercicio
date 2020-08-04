package com.globallogic.ejercicio.dto;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonPropertyOrder({ "uuid", "number", "cityCode", "countryCode" })
@JsonInclude(value = Include.NON_DEFAULT, content = Include.NON_EMPTY)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Data
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2598846096101805203L;

	private Long id;
	private String number;
	private String cityCode;
	private String countryCode;

}

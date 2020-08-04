package com.globallogic.ejercicio.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonPropertyOrder({ "uuid", "name", "email", "password", "phones", "created", "modified", "lastLogin", "isActive" })
@JsonInclude(value = Include.NON_DEFAULT, content = Include.NON_EMPTY)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Datapublic class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 893459664066303170L;
	
	private UUID uuid;

	private String name;

	private String email;
	
	private String password;
	
	private List<Phone> phones;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate created;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate modified;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate lastLogin;

	private boolean isActive;

}

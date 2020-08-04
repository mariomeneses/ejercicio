package com.globallogic.ejercicio.controller;

import static java.util.Objects.isNull;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.ejercicio.dto.User;
import com.globallogic.ejercicio.entity.UserEntity;
import com.globallogic.ejercicio.exception.BadRequestException;
import com.globallogic.ejercicio.service.UserService;
import com.globallogic.ejercicio.validator.ValidateField;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author
 *
 */
@RestController
@Log4j2
public class Controller {

	private UserService userService;

	@Autowired
	public Controller(UserService userService) {
		this.userService = userService;
	}

	/**
	 * insert user
	 * 
	 * @param usr
	 * @return
	 * @throws BadRequestException
	 */
	@PostMapping(value = "/user/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody @Valid User usr) throws BadRequestException {
		log.debug("createUser: " + usr);

		if (!ValidateField.isValidEmail(usr.getEmail())) {
			throw new BadRequestException("Formato de correo inválido");
		}
		if (!ValidateField.isValidPassword(usr.getPassword())) {
			throw new BadRequestException("Contraseña debe contener una mayúscula, letras minúsculas, y dos números)");
		}
		UserEntity user = this.userService.findByEmail(usr.getEmail());
		UserEntity us;
		if (isNull(user)) {
			us = this.userService.processData(usr);
		} else {
			throw new BadRequestException("El correo ya	se encuentra registrado");
		}
		log.info("GUARDARRRRR ----: " + usr);
		BeanUtils.copyProperties(this.userService.save(us), usr);
		return new ResponseEntity<>(usr, HttpStatus.CREATED);
	}

}

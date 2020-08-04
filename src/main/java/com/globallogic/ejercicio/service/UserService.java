package com.globallogic.ejercicio.service;

import com.globallogic.ejercicio.dto.User;
import com.globallogic.ejercicio.entity.UserEntity;

public interface UserService {
	
	UserEntity findByEmail(String email);

	UserEntity save(UserEntity usr);

	UserEntity processData(User us);

}

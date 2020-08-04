package com.globallogic.ejercicio.util;

import com.globallogic.ejercicio.dto.User;
import com.globallogic.ejercicio.entity.UserEntity;

public final class ConvertUser {

	public static User setUserDto(UserEntity u) {

		User us = new User();
		us.setUuid(u.getUuid());
		us.setCreated(u.getCreated());
		us.setModified(u.getModified());
		us.setLastLogin(u.getLastLogin());
		us.setActive(u.isActive());

		return us;
	}
	
}

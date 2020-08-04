package com.globallogic.ejercicio.service.impl;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.ejercicio.dto.User;
import com.globallogic.ejercicio.entity.UserEntity;
import com.globallogic.ejercicio.repository.UserRepository;
import com.globallogic.ejercicio.service.UserService;
import com.globallogic.ejercicio.util.ConvertPhone;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserEntity processData(User us) {
		log.info("processData: " + us);
		UserEntity user = new UserEntity();
		BeanUtils.copyProperties(us, user);
		LocalDate date = LocalDate.now();
		user.setCreated(date);
		user.setModified(date);
		user.setLastLogin(date);
		user.setActive(Boolean.TRUE);
//		List<PhoneEntity> list = new ArrayList<>();

		user.setPhones(ConvertPhone.setListaPhoneDto(us.getPhones()));
		log.info("GUARDARRRRR ----: " + user);
		return user;
	}

	@Override
	public UserEntity findByEmail(String email) {
		log.info("findByEmail: " + email);
		return this.userRepository.findByEmail(email);
	}

	@Override
	public UserEntity save(UserEntity usr) {
		log.info("save: " + usr);
		return this.userRepository.save(usr);
	}

}

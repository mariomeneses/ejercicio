package com.globallogic.ejercicio.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.globallogic.ejercicio.dto.Phone;
import com.globallogic.ejercicio.entity.PhoneEntity;

public final class ConvertPhone {

	public static PhoneEntity setPhoneDto(Phone p) {

		PhoneEntity ph = new PhoneEntity();
		ph.setCityCode(p.getCityCode());
		ph.setCountryCode(p.getCountryCode());
		ph.setNumber(p.getNumber());

		return ph;
	}

	public static List<PhoneEntity> setListaPhoneDto(List<Phone> list) {
		List<PhoneEntity> lista = new ArrayList<>();
		if (!CollectionUtils.isEmpty(list)) {
			list.stream().forEach(param -> lista.add(setPhoneDto(param)));
		}
		return lista;
	}

}

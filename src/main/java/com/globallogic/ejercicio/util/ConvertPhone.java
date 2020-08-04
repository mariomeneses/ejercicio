package com.globallogic.ejercicio.util;

import java.util.ArrayList;
import java.util.List;

import com.globallogic.ejercicio.dto.Phone;
import com.globallogic.ejercicio.entity.PhoneEntity;

public final class ConvertPhone {

	public static List<PhoneEntity> setListaPhoneDto(List<Phone> list) {
		List<PhoneEntity> lista = new ArrayList<>();
		list.forEach((p) -> {
			PhoneEntity phone = new PhoneEntity();
			phone.setCityCode(p.getCityCode());
			phone.setCountryCode(p.getCountryCode());
			phone.setNumber(p.getNumber());
			lista.add(phone);
		});
		return lista;
	}

}

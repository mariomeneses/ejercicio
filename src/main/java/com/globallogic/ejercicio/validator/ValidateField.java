package com.globallogic.ejercicio.validator;

import static java.util.Objects.isNull;

public final class ValidateField {

	public static boolean isValidEmail(String value) {
		if (!isNull(value)) {
			return value.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
		}
		return false;
	}

	public static boolean isValidPassword(String value) {
		if (!isNull(value)) {
			return value.matches("(?=(.*\\d){2})(?=.*?[A-Z]).{4,}$");
		}
		return false;
	}

}

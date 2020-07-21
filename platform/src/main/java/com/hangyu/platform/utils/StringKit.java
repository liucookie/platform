package com.hangyu.platform.utils;

import com.hangyu.platform.global.PlatException;

public class StringKit {
	public static void checkValueIsEmpty(String name, String value) {
		if (value == null || value.replaceFirst("^\\s*", "").replaceFirst("\\s*$", "").length() == 0) {
			throw new PlatException(name + "为空");
		}
	}
	public static boolean checkValueIsEmpty(String value) {
		if (value == null || value.replaceFirst("^\\s*", "").replaceFirst("\\s*$", "").length() == 0) {
			return true;
		}
		return false;
	}

}

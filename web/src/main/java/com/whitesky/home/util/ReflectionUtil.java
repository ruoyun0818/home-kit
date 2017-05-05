package com.whitesky.home.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectionUtil {
	public static final Integer ARRAY_FRIST_INDEX = 0;

	public static final String PATTERN_MAPPER = "Mapper";

	public static Class<?> getArgumentType(Class<?> cls) {

		Type[] types = ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments();

		return (Class<?>) types[ARRAY_FRIST_INDEX];
	}

}

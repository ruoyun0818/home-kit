package com.whitesky.home.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReflectionUtil {
	public static final Integer ARRAY_FRIST_INDEX = 0;

	public static final String PATTERN_MAPPER = "Mapper";

	public static Class<?> getArgumentType(Class<?> cls) {

		Type[] types = ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments();

		return (Class<?>) types[ARRAY_FRIST_INDEX];
	}

	public static Class<?> getMatcherMapper(Class<?> cls) {
		Class<?>[] classes = cls.getInterfaces();
		Pattern pattern = Pattern.compile(getArgumentType(cls).getSimpleName() + PATTERN_MAPPER);
		for (Class<?> c : classes) {
			Matcher matcher = pattern.matcher(c.getSimpleName());
			if (matcher.find()) {
				return c;
			}
		}
		return null;
	}
}

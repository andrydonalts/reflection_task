package com.andry.reflection_task.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.andry.reflection_task.annotations.ReflectionInvoke;
import com.andry.reflection_task.model.entity.Fraction;
import com.andry.reflection_task.view.View;

public class ReflectionUtil {
	
	public static void invokeMethodsWithAnnotation() throws Exception {
		Class classFraction = Class.forName("com.andry.reflection_task.model.entity.Fraction");
		Object fractionObject = classFraction.newInstance();

		Field numerator = classFraction.getDeclaredField("numerator");
		Field denumerator = classFraction.getDeclaredField("denumerator");
		numerator.setAccessible(true);
		denumerator.setAccessible(true);
		numerator.set(fractionObject, 1);
		denumerator.set(fractionObject, 4);
		for (Method method : classFraction.getMethods()) {
			if (method.isAnnotationPresent(ReflectionInvoke.class)) { 
				View.printMessage(method.getName());
				View.printMessage(method.invoke(fractionObject, fractionObject).toString());
			}
		}
	}
	
	public static void getAllMethods() throws Exception {
		Class classFraction = Class.forName("com.andry.reflection_task.model.entity.Fraction");
		Object fractionObject = classFraction.newInstance();
		for (Method method : classFraction.getMethods()) {
			View.printMessage(Modifier.toString(method.getModifiers()) + " " + method.getReturnType() + 
						" " + method.getName());
		}
	}
	
	public static void getField() throws Exception {
		Class classFraction = Class.forName("com.andry.reflection_task.model.entity.Fraction");
		Object fractionObject = classFraction.newInstance();
		for (Field field : classFraction.getDeclaredFields()) {
			View.printMessage(Modifier.toString(field.getModifiers())+ " " + field.getType() + " " + field.getName());
		}
	}
	
	public static void getConstructors() throws Exception {
		Class classFraction = Class.forName("com.andry.reflection_task.model.entity.Fraction");
		Object fractionObject = classFraction.newInstance();
		for (Constructor<Fraction> constructor: classFraction.getConstructors()) {
			View.printMessage(constructor.getName() + " " + constructor.getParameterCount());
		}
	}
}

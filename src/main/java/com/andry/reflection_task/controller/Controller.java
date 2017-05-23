package com.andry.reflection_task.controller;

import com.andry.reflection_task.model.Model;
import com.andry.reflection_task.model.entity.ComplexFraction;
import com.andry.reflection_task.model.entity.Fraction;
import com.andry.reflection_task.view.View;

public class Controller {
	private Model model;
	private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void process() {
    	Fraction fraction = new Fraction(-1, 2);
    	Fraction fraction1 = new Fraction(2, 5);
    	try {
    		System.out.println("invoking methods with annotation");
			ReflectionUtil.invokeMethodsWithAnnotation();
			ReflectionUtil.getAllMethods();
			ReflectionUtil.getField();
			ReflectionUtil.getConstructors();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}

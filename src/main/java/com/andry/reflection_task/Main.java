package com.andry.reflection_task;

import com.andry.reflection_task.view.View;
import com.andry.reflection_task.controller.Controller;
import com.andry.reflection_task.model.Model;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) {
    	Model model = new Model();
    	View view = new View();
    	Controller controller = new Controller(model, view);
    	
    	controller.process();
    }
}

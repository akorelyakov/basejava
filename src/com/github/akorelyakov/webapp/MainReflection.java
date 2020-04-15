package com.github.akorelyakov.webapp;

import com.github.akorelyakov.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume();
        Field field = resume.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(resume));
        field.set(resume, "new_uuid");
        System.out.println(resume);
        System.out.println("-----------------------------------");
        // TODO : invoke r.toString via reflection
        Method method = resume.getClass().getMethod("toString");
        System.out.println(method.invoke(resume));
    }
}
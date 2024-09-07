/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.learning;

import java.lang.annotation.Annotation;

/**
 *
 * @author adity
 */
public class MainExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DemoAnnotation obj = new DemoAnnotation();
        Class c = obj.getClass();
        System.out.println(c.getName());
        MyAnno an = (MyAnno) c.getAnnotation(MyAnno.class);
        System.out.println(an.myValue());
        System.out.println(an.name());
        System.out.println(an.city());
    }
}

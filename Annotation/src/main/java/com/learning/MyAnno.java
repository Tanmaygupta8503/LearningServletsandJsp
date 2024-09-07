/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.learning;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author adity
 */



//@interface MyAnno { // Marker interface if empty
//    
//}


//@Target(ElementType.METHOD) // can be used in method
//@Target(ElementType.FIELD) //can be used in field
//@Target(ElementType.CONSTRUCTOR) // can be used in constructor
//@Target(ElementType.LOCAL_VARIABLE) //local variable
//@Target({ElementType.TYPE, ElementType.METHOD})

@Target(ElementType.TYPE) // can be used in class , interface and enumeration
@Retention(RetentionPolicy.RUNTIME)// this annotaion available during the runtime
@interface MyAnno{
    int myValue() default 0; //should have return type and cant have the parameter list
    
    String name() default "Tanmay";
    
    String city() default "Delhi";
}
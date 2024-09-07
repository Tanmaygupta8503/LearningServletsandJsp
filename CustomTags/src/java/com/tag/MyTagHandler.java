/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;
import java.util.Date;

/**
 *
 * @author adity
 */
public class MyTagHandler extends TagSupport{

    @Override
    public int doStartTag() throws JspException {
        try{
            JspWriter out = pageContext.getOut();
            out.println("<h1>This is my custom tag</h1>");
            out.println(new Date().toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
    
}

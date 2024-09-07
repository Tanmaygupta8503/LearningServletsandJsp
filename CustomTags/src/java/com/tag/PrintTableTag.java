package com.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;


/**
 *
 * @author adity
 */
public class PrintTableTag extends TagSupport{

    private int number;
    private String color;
    public void setNumber(int number) {
        this.number = number;
    }
    public void setColor(String color){
        this.color = color;
    }
    
    @Override
    public int doStartTag() throws JspException {
        try{
            JspWriter out = pageContext.getOut();
            out.println("<br>");
            out.println("<div style='color:"+color+"'>");
            for(int i = 1 ; i <= 10 ; i ++) {
                out.println(number + "\t*\t" + i + "\t=\t" + number * i + "<br>");
            }
            out.println("<div>");
        }catch(Exception e){
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
    
}

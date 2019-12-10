package com.gpdi.annotation.current;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class ImportDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ImportDemo.class);
        String arr[]=context.getBeanDefinitionNames();
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

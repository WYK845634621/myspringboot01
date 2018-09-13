package com.yikai.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class Myspringboot01Application {

	public static void main(String[] args) {

		SpringApplication.run(Myspringboot01Application.class, args);
	}


	@Bean
	public  MyViewResolver myViewResolver(){
		return  new MyViewResolver();
	}


	private  static  class MyViewResolver implements ViewResolver{

		@Nullable
		@Override
		public View resolveViewName(String s, Locale locale) throws Exception {
			return null;
		}
	}



}

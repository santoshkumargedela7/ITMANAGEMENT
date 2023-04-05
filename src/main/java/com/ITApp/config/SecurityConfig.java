package com.ITApp.config;

import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@SuppressWarnings("deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter{
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("/register").permitAll()
//			.antMatchers("/login").permitAll()
//			.antMatchers("/confirm").permitAll();
		http.cors().and().csrf().disable();
	}
	
	 @Bean
	     JavaMailSender javaMailSender() { 
	          return new JavaMailSender() {
				
				@Override
				public void send(SimpleMailMessage... simpleMessages) throws MailException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void send(SimpleMailMessage simpleMessage) throws MailException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void send(MimeMessage... mimeMessages) throws MailException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void send(MimeMessage mimeMessage) throws MailException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public MimeMessage createMimeMessage(InputStream contentStream) throws MailException {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public MimeMessage createMimeMessage() {
					// TODO Auto-generated method stub
					return null;
				}
			};
	    }
}

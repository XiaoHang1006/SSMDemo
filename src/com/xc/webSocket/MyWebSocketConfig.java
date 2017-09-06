package com.xc.webSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.sun.org.apache.xml.internal.resolver.helpers.Debug;

@Configuration
@EnableWebSocket
public class MyWebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		System.out.println("socket已经被注册了");
		registry.addHandler(myHandler(), "/test").addInterceptors(new HandleShake());
	}

	@Bean
	public WebSocketHandler myHandler()
	{
		System.out.println("这里被执行了");
		return new MyHandlerTest();
	}
}

package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.cloud.context.config.annotation.RefreshScope;

//@RefreshScope
@RestController
public class MessageRestController {
	@Value("${message:'Hello world, ${eureka.instance.metadata-map.uuid} (port: ${server.port}).'}")
	private String message;
	
	@Value("${eureka.instance.metadata-map.instanceId}")
	private String instanceId;

	@RequestMapping("/")
	protected String getMessage(@Value("(port: ${server.port})") String portMsg) {
		return ("Hello world. " + portMsg);
	}
	
	@RequestMapping("/id")
	protected String getInstanceId() {
		return this.instanceId;
	}

	@RequestMapping("/info")
	protected String infoMessage() {
		return this.message;
	}
}

package cn.xiaoshuiping.samplexml;

import cn.xiaoshuiping.samplexml.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Collections;

public class SampleXmlApplication  implements CommandLineRunner {

	private static final String CONTEXT_XML = "classpath:/META-INF/application-context.xml";

	@Autowired
	private HelloWorldService helloWorldService;

	@Override
	public void run(String... args) {
		System.out.println(this.helloWorldService.getHelloMessage());
	}

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication();
		application.setSources(Collections.singleton(CONTEXT_XML));
		application.run(args);
	}

}

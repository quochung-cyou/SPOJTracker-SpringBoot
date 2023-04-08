package com.quochungcyou.spring_spoj;

import com.quochungcyou.spring_spoj.APiUtils.JsoupHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableScheduling
public class MainApp {
	public static JsoupHelper jsoupHelper = new JsoupHelper();

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);

		jsoupHelper.crawlData();
	}

}

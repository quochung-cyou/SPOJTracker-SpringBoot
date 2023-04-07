package com.quochungcyou.spring_spoj;

import com.quochungcyou.spring_spoj.APiUtils.JsoupHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpojtournamentApplication {

	public static void main(String[] args) {


		SpringApplication.run(SpojtournamentApplication.class, args);
		JsoupHelper jsoupHelper = new JsoupHelper();


	}

}

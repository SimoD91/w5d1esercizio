package it.epicode.w5d1esercizio;

import it.epicode.w5d1esercizio.bean.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class W5d1esercizioApplication {

	public static void main(String[] args) {

		SpringApplication.run(W5d1esercizioApplication.class, args);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Menu menu = (Menu) ctx.getBean("listamenu");
		System.out.println(menu);
	}
}

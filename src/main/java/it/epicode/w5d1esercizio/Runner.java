package it.epicode.w5d1esercizio;

import it.epicode.w5d1esercizio.bean.*;
import it.epicode.w5d1esercizio.service.PizzaService;
import it.epicode.w5d1esercizio.service.ToppingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.springframework.core.annotation.Order(1)
public class Runner implements CommandLineRunner {
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private ToppingService toppingService;
    private Logger logger = LoggerFactory.getLogger("w5d1");
    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Table t1 = ctx.getBean("tavolo1", Table.class);

        //logger.info("Il tavolo 1 è: " + t1);

        Menu menu = ctx.getBean("menu", Menu.class);

        menu.stampaMenu();

        Order order = new Order(t1, 6);

        List<Pizza> pizze = menu.getPizze();

        List<Bevanda> bevande = menu.getBevande();

        order.setPizze(pizze);
        order.setBevande(bevande);

        pizzaService.salvaPizze(pizze);

        logger.info("L'ordine è: " + order);

        logger.info("Il totale dell'ordine è: " +order.totaleOrdine());
    }
}

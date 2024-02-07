package it.epicode.w5d1esercizio;

import it.epicode.w5d1esercizio.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    private Logger logger = LoggerFactory.getLogger("w5d2p");

    @Bean("p1")
    @Scope("prototype")
    public Pizza getPizza(){
        Pizza p = new Pizza();
        p.setNome("Margherita");
        p.setIngrediente("Pomodoro");
        p.setPrezzo(10);
        p.setCalorie(200);
        p.setToppings(List.of(new Toppings ("Formaggio")));
        return p;
    }
    @Bean("p2")
    @Scope("prototype")
    public Pizza getPizza2(){
        Pizza p2 = new Pizza();
        p2.setNome("Diavola");
        p2.setIngrediente("Pomodoro");
        p2.setPrezzo(12);
        p2.setCalorie(250);
        p2.setToppings(List.of(new Toppings ("Funghi")));
        return p2;
    }
    @Bean("p3")
    @Scope("prototype")
    public Pizza getPizza3(){
        Pizza p3 = new Pizza();
        p3.setNome("Funghi");
        p3.setIngrediente("Pomodoro");
        p3.setPrezzo(17);
        p3.setCalorie(100);
        p3.setToppings(List.of(new Toppings ("Salsiccia")));
        return p3;
    }
    @Bean("cocacola")
    @Scope("singleton")
    public Bevanda getCocaCola(){
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Cocacola");
        bevanda.setPrezzo(5);
        bevanda.setCalorie(100);
        bevanda.setLitri(2);
        return bevanda;
    }
    @Bean("fanta")
    @Scope("singleton")
    public Bevanda getFanta(){
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Fanta");
        bevanda.setPrezzo(5);
        bevanda.setCalorie(80);
        bevanda.setLitri(2);
        return bevanda;
    }
    @Bean("sprite")
    @Scope("singleton")
    public Bevanda getSprite(){
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Sprite");
        bevanda.setPrezzo(4);
        bevanda.setCalorie(70);
        bevanda.setLitri(1);
        return bevanda;
    }

    @Bean("formaggio")
    @Scope("singleton")
    public Toppings getFormaggio(){
        Toppings toppings = new Toppings();
        toppings.setNomeTopping("Formaggio");
        return toppings;
    }
    @Bean("funghi")
    @Scope("singleton")
    public Toppings getFunghi() {
        Toppings toppings = new Toppings();
        toppings.setNomeTopping("Funghi");
        return toppings;
    }
    @Bean("salsiccia")
    @Scope("singleton")
    public Toppings getSalsiccia() {
        Toppings toppings = new Toppings();
        toppings.setNomeTopping("Salsiccia");
        return toppings;
    }


    @Bean("menu")
    public Menu getListaMenu() {
        logger.info("MENU");
    return new Menu(List.of(getPizza(), getPizza2(), getPizza3()),
            List.of(getCocaCola(), getFanta(), getSprite()), List.of(getFormaggio(), getFunghi(), getSalsiccia()));
    }
    @Bean("tavolo1")
    public Table tavolo1(@Value("${tavolo1.coperto}") String coperto){
        Table tavolo = new Table();
        tavolo.setNumero(1);
            tavolo.setTableState(TableState.LIBERO);
        tavolo.setNumeroMaxCoperti(6);
        tavolo.setCostoCoperto(Double.parseDouble(coperto));
        return tavolo;
    }
    @Bean("tavolo2")
    public Table tavolo2(@Value("${tavolo2.coperto}") String coperto){
        Table tavolo = new Table();
        tavolo.setNumero(2);
        tavolo.setTableState(TableState.LIBERO);
        tavolo.setNumeroMaxCoperti(8);
        tavolo.setCostoCoperto(Double.parseDouble(coperto));
        return tavolo;
    }
}

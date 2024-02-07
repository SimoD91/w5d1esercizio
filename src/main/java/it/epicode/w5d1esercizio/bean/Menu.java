package it.epicode.w5d1esercizio.bean;

import lombok.*;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.logging.Logger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Menu {
    private List<Pizza> pizze;
    private List<Bevanda> bevande;
    private List<Toppings> toppings;

    public void stampaMenu() {
        pizze.stream().forEach(pizze -> System.out.println(pizze));
        bevande.stream().forEach(bevande -> System.out.println(bevande));
        toppings.stream().forEach(toppings -> System.out.println(toppings));
    }
}

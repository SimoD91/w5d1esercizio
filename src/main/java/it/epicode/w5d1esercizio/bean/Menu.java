package it.epicode.w5d1esercizio.bean;

import lombok.*;

import java.util.List;
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

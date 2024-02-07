package it.epicode.w5d1esercizio.bean;

import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order{
    private int numeroOrdine;
    private OrderState orderState;
    private int numeroCoperti;
    private LocalTime oraOrdine;

    private Table table;
    private List<Pizza> pizze;
    private List<Bevanda> bevande;
    private int contatore;


    public Order(Table table, int numeroCoperti) throws Exception{
        if(numeroCoperti<=table.getNumeroMaxCoperti())
            this.numeroCoperti=numeroCoperti;
        else
            throw new Exception("Numero max coperti del tavolo superato");

        if(table.getTableState().equals(TableState.LIBERO))
            this.table=table;
        else
            throw new Exception("Tavolo occupato");
        numeroOrdine=contatore++;
        orderState=OrderState.IN_CORSO;
        oraOrdine = LocalTime.now();

        pizze = new ArrayList<>();
        bevande = new ArrayList<>();
    }
    public double totaleOrdine(){
        double totale = table.getCostoCoperto()*numeroCoperti;

        totale = totale + pizze.stream().mapToDouble(pizza -> pizza.getPrezzo()).sum() +
                bevande.stream().mapToDouble(drink -> drink.getPrezzo()).sum();
        return totale;
    }
}

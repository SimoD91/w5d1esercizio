package it.epicode.w5d1esercizio.service;

import it.epicode.w5d1esercizio.bean.Pizza;
import it.epicode.w5d1esercizio.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public void salvaPizze(List<Pizza> pizze){
        pizzaRepository.saveAll(pizze);
    }

    public void aggiornaPizza(Pizza pizza){
        Pizza p = pizzaRepository.findById(pizza.getId()).get();
        p.setNome(pizza.getNome());
        p.setIngrediente(pizza.getIngrediente());
        p.setPrezzo(pizza.getPrezzo());
        p.setCalorie(pizza.getCalorie());
        pizzaRepository.save(p);
    }

    public Pizza cercaPizzaPerId(int id){
        return pizzaRepository.findById(id).get();
    }

}

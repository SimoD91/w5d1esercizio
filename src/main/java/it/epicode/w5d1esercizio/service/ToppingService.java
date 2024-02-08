package it.epicode.w5d1esercizio.service;

import it.epicode.w5d1esercizio.bean.Toppings;
import it.epicode.w5d1esercizio.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToppingService {
    @Autowired
    private ToppingRepository toppingRepository;

    public void salvaTopping(Toppings topping) {
        toppingRepository.save(topping);
    }

    public void aggiornaTopping(Toppings topping) {
        Toppings t = toppingRepository.findById(topping.getId()).get();
        t.setNomeTopping(topping.getNomeTopping());
        toppingRepository.save(t);
    }

    public Toppings cercaToppingPerId(int id) {
        return toppingRepository.findById(id).get();

    }
}
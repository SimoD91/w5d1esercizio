package it.epicode.w5d1esercizio.service;

import it.epicode.w5d1esercizio.bean.Bevanda;
import it.epicode.w5d1esercizio.bean.Pizza;
import it.epicode.w5d1esercizio.repository.BevandeRepository;
import it.epicode.w5d1esercizio.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BevandeService {

    @Autowired
    private BevandeRepository bevandeRepository;

    @Service
    public class BevandaService {

        @Autowired
        private BevandeRepository bevandaRepository;

        public void salvaBevanda(Bevanda bevanda){
            bevandaRepository.save(bevanda);
        }

        public void aggiornaBevanda(Bevanda bevanda){
            Bevanda b = bevandaRepository.findById(bevanda.getId()).get();
        b.setNome(bevanda.getNome());
        b.setPrezzo(bevanda.getPrezzo());
        b.setCalorie(bevanda.getCalorie());
        b.setLitri(bevanda.getLitri());
        bevandaRepository.save(b);
    }

    public Bevanda cercaBevandaPerId(int id) {
        return bevandaRepository.findById(id).get();
            }
    }
}

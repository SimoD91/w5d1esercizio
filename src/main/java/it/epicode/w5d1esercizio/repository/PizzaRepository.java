package it.epicode.w5d1esercizio.repository;

import it.epicode.w5d1esercizio.bean.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Integer> {
}

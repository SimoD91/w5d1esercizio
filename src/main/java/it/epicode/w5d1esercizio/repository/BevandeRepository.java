package it.epicode.w5d1esercizio.repository;

import it.epicode.w5d1esercizio.bean.Bevanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BevandeRepository extends JpaRepository<Bevanda, Integer> {
}

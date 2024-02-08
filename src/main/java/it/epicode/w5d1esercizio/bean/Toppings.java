package it.epicode.w5d1esercizio.bean;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Toppings {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String nomeTopping;

        @ManyToOne
        @JoinColumn(name = "pizza_id")
        private Pizza pizza;

        public Toppings(String nomeTopping) {
                this.nomeTopping = nomeTopping;
        }
}


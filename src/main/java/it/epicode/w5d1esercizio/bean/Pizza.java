package it.epicode.w5d1esercizio.bean;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Component("pizza")
@Data
public class Pizza{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String ingrediente;
    private int prezzo;
    private int calorie;

    @OneToMany(mappedBy = "pizza", cascade = CascadeType.REMOVE)
    private List<Toppings> toppings;

    @Override
    public String toString() {
        return "Pizza{" +
                "nome='" + nome + '\'' +
                ", ingrediente='" + ingrediente + '\'' +
                ", prezzo=" + prezzo +
                ", calorie=" + calorie +
                '}';
    }
}

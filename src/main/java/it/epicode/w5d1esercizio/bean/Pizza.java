package it.epicode.w5d1esercizio.bean;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pizza{
    private String nome;
    private String ingrediente;
    private int prezzo;
    private int calorie;
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

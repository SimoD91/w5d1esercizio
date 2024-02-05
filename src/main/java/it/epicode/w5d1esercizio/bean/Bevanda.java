package it.epicode.w5d1esercizio.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Bevanda{
    private String nome;
    private int prezzo;
    private int calorie;
    private int litri;

    @Override
    public String toString() {
        return "Bevanda{" +
                "nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                ", calorie=" + calorie +
                ", litri=" + litri +
                '}';
    }
}


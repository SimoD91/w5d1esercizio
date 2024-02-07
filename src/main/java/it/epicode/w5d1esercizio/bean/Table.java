package it.epicode.w5d1esercizio.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Table {
    private int numero;
    private int numeroMaxCoperti;
    private double costoCoperto;
    private TableState tableState;
}

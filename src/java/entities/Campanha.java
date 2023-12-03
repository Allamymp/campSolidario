package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Campanha {

    private int codigo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String objetivo;
    private String descricao;
    private List<Insumo> insumos;
    private Emergencia emergencia;
    private Ong ong;

     
  public void adicionarInsumo(Insumo insumo) {
    if (insumos == null) {
        insumos = new ArrayList<>();
    }
    insumos.add(insumo);
}


    public void removerInsumo(Insumo insumo) {
        insumos.remove(insumo);
    }

    public void setInsumos(Insumo insumo) {
        //metodo nao permitido
    }

  public LocalDate stringToDate(String data) {
    try {
        return LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    } catch (DateTimeParseException e) {
        throw new IllegalArgumentException("Formato de data inválido. Use o formato dd/MM/yyyy.", e);
    }
}

    public String dateToString(LocalDate date){
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    public String getDiasRestantes(){
      return String.valueOf(ChronoUnit.DAYS.between(LocalDate.now(), this.dataFim));
    }
}

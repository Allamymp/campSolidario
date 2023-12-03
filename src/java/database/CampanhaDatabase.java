 
package database;

import enums.Categorias;
import entities.Campanha;
import entities.Emergencia;
import entities.Insumo;
import entities.Ong;
import java.time.LocalDate;
import java.util.*;
 
public class CampanhaDatabase {
    
    public static List<Campanha> campanhaDB = new ArrayList<>();
    
    static{
        Campanha campanha = new Campanha();
        campanha.setCodigo(0);
        campanha.setDataInicio(LocalDate.now());
        campanha.setDataFim(campanha.stringToDate("31/12/2023"));
        campanha.setObjetivo("Objetivo Teste");
        campanha.setDescricao("Descricao teste");
        campanha.adicionarInsumo(new Insumo(2, "Nome Teste", "Marca Teste", Categorias.TESTE, 1));
        campanha.setEmergencia( new Emergencia(2, "Local Teste", "Tipo Teste", "Descricao Teste"));
        campanha.setOng(new Ong(2, "Nome Teste", "Login Teste", "Senha Teste"));
    }
    
     public static void create(Campanha u) {
        campanhaDB.add(u);
    }
    public static void update(Campanha u){
        for(Campanha campanhaAux : campanhaDB){
           if(u.getDataInicio()!=null&&u.getDataInicio()!=campanhaAux.getDataInicio()){
               campanhaAux.setDataInicio(u.getDataInicio());
           }
           if(u.getDataFim()!= null && u.getDataFim()!= campanhaAux.getDataFim()){
               campanhaAux.setDataFim(u.getDataFim());
           }
           if(u.getObjetivo()!=null&& !u.getObjetivo().isEmpty()&&!u.getObjetivo().equalsIgnoreCase(campanhaAux.getObjetivo())){
               campanhaAux.setObjetivo(u.getObjetivo());
           }
           if(u.getDescricao()!=null&& !u.getDescricao().isEmpty()&&!u.getDescricao().equalsIgnoreCase(campanhaAux.getDescricao())){
               campanhaAux.setDescricao(u.getDescricao());
           }
           if(u.getEmergencia()!=null && !u.getEmergencia().equals(campanhaAux.getEmergencia())){
               campanhaAux.setEmergencia(u.getEmergencia());
           }
           if(u.getOng()!= null && !u.getOng().equals(campanhaAux.getEmergencia())){
               campanhaAux.setOng(u.getOng());
           }
        }
    }
    public static Campanha read(int codigo){
        
        for(Campanha campanhaAux: campanhaDB){
            if(campanhaAux.getCodigo()==codigo){
                return campanhaAux;
            }
        }
        return null;
    }
    public static void delete(Campanha u){
        campanhaDB.remove(u);
    }
    public static List<Campanha> readAll(){
        return campanhaDB;
    }
    
}

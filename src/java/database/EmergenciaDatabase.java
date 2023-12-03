
package database;
import entities.Emergencia;
import java.util.*;


public class EmergenciaDatabase {
    
    
    public static List<Emergencia> emergenciaDB = new ArrayList<>();

    static {
        Emergencia emergencia = new Emergencia(1, "Local Teste", "Tipo Teste", "Descricao Teste");
        emergenciaDB.add(emergencia);
    }

    public static void create(Emergencia u) {
        emergenciaDB.add(u);
    }
    public static void update(Emergencia u){
        for(Emergencia admAux : emergenciaDB){
           if(u.getLocal()!=null&&!u.getLocal().isEmpty()&&!u.getLocal().equalsIgnoreCase(admAux.getLocal())){
               admAux.setLocal(u.getLocal());
           }
           if(u.getTipo()!=null&&!u.getTipo().isEmpty()&&!u.getTipo().equalsIgnoreCase(admAux.getTipo())){
               admAux.setTipo(u.getTipo());
           }
           if(u.getDescricao()!=null&&!u.getDescricao().isEmpty()){
               admAux.setDescricao(u.getDescricao());
           }
        }
    }
    public static Emergencia read(int codigo){
        
        for(Emergencia uAux: emergenciaDB){
            if(uAux.getCodigo()==codigo){
                return uAux;
            }
        }
        return null;
    }
    public static void delete(Emergencia u){
        emergenciaDB.remove(u);
    }
    public static List<Emergencia> readAll(){
        return emergenciaDB;
    }
    
    
}

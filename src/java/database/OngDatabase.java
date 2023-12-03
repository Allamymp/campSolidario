
package database;

import entities.Ong;
import java.util.*;

public class OngDatabase {
    
       
    public static List<Ong> ongDB = new ArrayList<>();

    static {
        Ong Ong = new Ong(1, "Nome Teste", "Login Teste","Senha  teste");
    }

    public static void create(Ong u) {
        ongDB.add(u);
    }
    public static void update(Ong u){
        for(Ong ongAux : ongDB){
            if(u.getNome()!=null&&!u.getNome().isEmpty()&&!u.getNome().equalsIgnoreCase(ongAux.getNome())){
                ongAux.setNome(u.getNome());
            }
            if(u.getLogin()!=null&&!u.getLogin().isEmpty()&&!u.getLogin().equalsIgnoreCase(ongAux.getLogin())){
                ongAux.setLogin(u.getLogin());
            }
            if(u.getSenha()!=null&&!u.getSenha().isEmpty()&&!u.getSenha().equalsIgnoreCase(ongAux.getSenha())){
                ongAux.setSenha(u.getSenha());
            }
        }
    }
    public static Ong read(int codigo){
        
        for(Ong uAux: ongDB){
            if(uAux.getCodigo()==codigo){
                return uAux;
            }
        }
        return null;
    }
    public static void delete(Ong u){
        ongDB.remove(u);
    }
    public static List<Ong> readAll(){
        return ongDB;
    }
    
}

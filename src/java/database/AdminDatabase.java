
package database;

import entities.Admin;
import java.util.*;

public class AdminDatabase {

    public static List<Admin> admDB = new ArrayList<>();

    static {
        Admin adm = new Admin(1, "admin", "123");
        admDB.add(adm);
    }

    public static void create(Admin u) {
        admDB.add(u);
    }
    public static void update(Admin u){
        for(Admin admAux : admDB){
            if(admAux.getCodigo() == u.getCodigo()){
                if(u.getLogin()!=null&& !u.getLogin().isEmpty()&&!u.getLogin().equals(admAux.getLogin())){
                    admAux.setLogin(u.getLogin());
                }
                if(u.getSenha()!=null&&!u.getSenha().isEmpty()&&!u.getSenha().equals(admAux.getSenha())){
                    admAux.setSenha(u.getSenha());
                }
            }
        }
    }
    public static Admin read(int codigo){
        
        for(Admin uAux: admDB){
            if(uAux.getCodigo()==codigo){
                return uAux;
            }
        }
        return null;
    }
    public static void delete(Admin u){
        admDB.remove(u);
    }
    public static List<Admin> readAll(){
        return admDB;
    }
    
}


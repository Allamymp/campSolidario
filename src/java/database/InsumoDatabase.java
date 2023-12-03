
package database;

import enums.Categorias;
import entities.Insumo;
import java.util.*;

public class InsumoDatabase {
    
       
    public static List<Insumo> insumoDB = new ArrayList<>();

    static {
        insumoDB.add(new Insumo(1, "Nome Teste", "Marca Teste", Categorias.TESTE,5));
    }

    public static void create(Insumo u) {
        insumoDB.add(u);
    }
    public static void update(Insumo u){
        for(Insumo insumoAux : insumoDB){
         if(u.getNome()!=null&&!u.getNome().isEmpty()&&!u.getNome().equalsIgnoreCase(insumoAux.getNome())){
             insumoAux.setNome(u.getNome());
         }
         if(u.getMarca()!=null&&!u.getMarca().isEmpty()&&!u.getMarca().equalsIgnoreCase(insumoAux.getMarca())){
             insumoAux.setMarca(u.getMarca());
         }
         if(u.getCategoria()!=null&&u.getCategoria()!=insumoAux.getCategoria()){
             insumoAux.setCategoria(u.getCategoria());
         }
         if(u.getQuantidade()!=insumoAux.getQuantidade()&&u.getQuantidade()>-1){
             insumoAux.setQuantidade(u.getQuantidade());
         }
        }
    }
    public static Insumo read(int codigo){
        
        for(Insumo uAux: insumoDB){
            if(uAux.getCodigo()==codigo){
                return uAux;
            }
        }
        return null;
    }
    public static void delete(Insumo u){
        insumoDB.remove(u);
    }
    public static List<Insumo> readAll(){
        return insumoDB;
    }
    
}

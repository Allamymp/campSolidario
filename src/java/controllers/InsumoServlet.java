
package controllers;

import database.InsumoDatabase;
import entities.Insumo;
import enums.Categorias;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsumoServlet")
public class InsumoServlet extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("listarInsumo".equals(action)) {
            listarInsumo(request, response);
        } else if ("delete".equals(action)) {
            doDelete(request, response);
        }

    }

    private void listarInsumo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("listInsumo", InsumoDatabase.readAll());
        request.getRequestDispatcher("/listarInsumo.jsp").forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Insumo insumoToDelete = InsumoDatabase.read(codigo);

            if (insumoToDelete != null) {
                InsumoDatabase.delete(insumoToDelete);
            }
            listarInsumo(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("edit".equals(action)) {
            editarInsumo(request, response);
            listarInsumo(request, response);
        }
        if ("findById".equals(action)) {
            findById(request, response);
        }

    }

   private void editarInsumo(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    try {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String novoNome = request.getParameter("nome");
        String novaMarca = request.getParameter("marca");
        String categoriaString = request.getParameter("categoria").toUpperCase(); 
        Categorias novaCategoria = Categorias.valueOf(categoriaString); 
        
        int quantidade = 0;
        String quantidadeStr = request.getParameter("quantidade");
        if (quantidadeStr != null && !quantidadeStr.isEmpty()) {
            quantidade = Integer.parseInt(quantidadeStr);
        }

        Insumo insumoAtualizado = new Insumo(codigo, novoNome, novaMarca, novaCategoria, quantidade);
        InsumoDatabase.update(insumoAtualizado);

        System.out.println("Insumo Atualizado: " + insumoAtualizado);

    } catch (NumberFormatException e) {
        e.printStackTrace();
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
    }
 
}



    private void findById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Insumo> list = new ArrayList<>();
        if (Integer.parseInt(request.getParameter("codigo")) <= InsumoDatabase.readAll().size()) {
            list.add(InsumoDatabase.read(Integer.parseInt(request.getParameter("codigo"))));
        } else {
            list = null;
        }

        request.setAttribute("listInsumo", list);
        request.getRequestDispatcher("/listarInsumo.jsp").forward(request, response);
    }
}

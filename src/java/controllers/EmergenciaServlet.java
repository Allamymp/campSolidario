package controllers;

import database.EmergenciaDatabase;
import entities.Emergencia;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmergenciaServlet")
public class EmergenciaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("listarEmergencia".equals(action)) {
            listarEmergencia(request, response);
        } else if ("delete".equals(action)) {
            doDelete(request, response);
        }

    }

    private void listarEmergencia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("listEmergencia", EmergenciaDatabase.readAll());
        request.getRequestDispatcher("/listarEmergencia.jsp").forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Emergencia emergenciaToDelete = EmergenciaDatabase.read(codigo);

            if (emergenciaToDelete != null) {
                EmergenciaDatabase.delete(emergenciaToDelete);
            }
            listarEmergencia(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("edit".equals(action)) {
            editarEmergencia(request, response);
            listarEmergencia(request, response);
        }
        if ("findById".equals(action)) {
            findById(request, response);
        }

    }

    private void editarEmergencia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String novoLocal = request.getParameter("local");
             String novoTipo = request.getParameter("tipo");
            String novaDescricao = request.getParameter("descricao");
           

            EmergenciaDatabase.update(new Emergencia(codigo, novoLocal,novoTipo, novaDescricao));

        } catch (NumberFormatException e) {

            e.printStackTrace();
        }
    }

    private void findById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Emergencia> list = new ArrayList<>();
        if (Integer.parseInt(request.getParameter("codigo")) <= EmergenciaDatabase.readAll().size()) {
            list.add(EmergenciaDatabase.read(Integer.parseInt(request.getParameter("codigo"))));
        } else {
            list = null;
        }

        request.setAttribute("listEmergencia", list);
        request.getRequestDispatcher("/listarEmergencia.jsp").forward(request, response);
    }
}

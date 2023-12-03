
import database.AdminDatabase;
import entities.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("listarAdmins".equals(action)) {
            listarAdmins(request, response);
        } else if ("delete".equals(action)) {
            doDelete(request, response);
        }

    }

    private void listarAdmins(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("listAdm", AdminDatabase.readAll());
        request.getRequestDispatcher("/listarAdmins.jsp").forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Admin adminToDelete = AdminDatabase.read(codigo);

            if (adminToDelete != null) {
                AdminDatabase.delete(adminToDelete);
            }
            listarAdmins(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("edit".equals(action)) {
            editarAdmin(request, response);
            listarAdmins(request, response);
        }
        if ("findById".equals(action)) {
            findById(request, response);
        }

    }

    private void editarAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String novoLogin = request.getParameter("login");
            String novaSenha = request.getParameter("senha");

            AdminDatabase.update(new Admin(codigo, novoLogin, novaSenha));

        } catch (NumberFormatException e) {

            e.printStackTrace();
        }
    }

    private void findById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Admin> list = new ArrayList<>();
        if (Integer.parseInt(request.getParameter("codigo")) <= AdminDatabase.readAll().size()) {
              list.add(AdminDatabase.read(Integer.parseInt(request.getParameter("codigo"))));
        } else {
          list = null;
        }

        request.setAttribute("listAdm", list);
        request.getRequestDispatcher("/listarAdmins.jsp").forward(request, response);
    }
}

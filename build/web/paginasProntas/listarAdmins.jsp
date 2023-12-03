<%@page import="entities.Admin"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@ include file="./templates/head.jsp" %>

        <style>
            h2 {
                font-weight: bold;
                font-size: 40px;
                margin-bottom: 20px;
            }

            table {
                font-size: 20px;
            }

            td,
            th {
                border: 1px solid #dddddd;
                text-align: center;
                padding: 20px;
            }

            #delete button,
            #edit button {
                background: none;
                border: none;
                color: white;
                cursor: pointer;
                font-size: 30px;
            }

            #delete,
            #edit {
                background: none;
                border: none;
                padding: 0px;
                padding-right: 5px;
                padding-left: 10px;
            }

            #editForm {
                display: none;
            }
        </style>

        <title>Camp Solidario - Admins</title>
    </head>

    <body>
        <%@include file="./templates/sideBar.jsp" %>
        <div class="container">
            <h2>Admins Cadastrados</h2>
            <% List<Admin> listAdm = (List<Admin>) request.getAttribute("listAdm");%>
            <table>
                <tr>
                    <th>Código</th>
                    <th>Login</th>
                    <th>Senha</th>
                </tr>
                <% if (listAdm != null) {
                    for (Admin adm : listAdm) {%>
                <tr>
                    <td><%= adm.getCodigo()%></td>
                    <td><%= adm.getLogin()%></td>
                    <td><%= adm.getSenha()%></td>
                    <td id="delete">
                        <a href="<%= request.getContextPath()%>/AdminServlet?action=delete&codigo=<%= adm.getCodigo()%>"
                           onclick="return confirm('Tem certeza que deseja excluir o administrador?');"
                           title="deletar" class="material-symbols-outlined">delete</a>
                    </td>
                    <td id="edit"<%= adm.getCodigo()%>>
                        <button title="editar" class="material-symbols-outlined edit-button">edit_square</button>
                        <form id="editForm"<%= adm.getCodigo()%> method="post"
                              action="<%= request.getContextPath()%>/AdminServlet?action=edit">
                            <input type="hidden" name="codigo" value="<%= adm.getCodigo()%>">
                            <input type="text" id="editLogin" name="login" placeholder="Login">
                            <input type="password" id="editSenha" name="senha" placeholder="Senha">
                            <input type="submit" value="Salvar">
                        </form>
                    </td>
                </tr>
                <%}
                } else {
                    // Se a lista for nula, exiba uma mensagem ou tome outra ação adequada.
                %>
                <tr>
                    <td colspan="3">Nenhum administrador cadastrado.</td>
                </tr>
                <% }%>
            </table>
        </div>

        <script>
            document.querySelectorAll('.edit-button').forEach(function (button) {
                button.addEventListener('click', function () {
                    var adminId = this.parentElement.id.replace('edit', '');
                    var editForm = document.getElementById('editForm' + adminId);
                    if (editForm.style.display === 'block') {
                        editForm.style.display = 'none';
                    } else {
                        editForm.style.display = 'block';
                    }
                });
            });
        </script>

    </body>

</html>

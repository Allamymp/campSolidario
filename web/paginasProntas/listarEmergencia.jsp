<%@page import="entities.Emergencia"%>
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

        <title>Camp Solidario - Emergencias</title>
    </head>

    <body>
        <%@include file="./templates/sideBar.jsp" %>
        <div class="container">
            <h2>Emergencias Cadastradas</h2>
            <% List<Emergencia> listEmergencia = (List<Emergencia>) request.getAttribute("listEmergencia");%>
            <table>
                <tr>
                    <th>Código</th>
                    <th>Local</th>
                    <th>Tipo</th>
                    <th>Descrição</th>
                </tr>
                <% if (listEmergencia != null) {
                        for (Emergencia emergencia : listEmergencia) {%>
                <tr>
                    <td><%= emergencia.getCodigo()%></td>
                    <td><%= emergencia.getLocal()%></td>
                    <td><%= emergencia.getTipo()%></td>
                    <td><%= emergencia.getDescricao()%></td>

                    <td id="delete">
                        <a href="<%= request.getContextPath()%>/EmergenciaServlet?action=delete&codigo=<%= emergencia.getCodigo()%>"
                           onclick="return confirm('Tem certeza que deseja excluir a Emergencia?');"
                           title="deletar" class="material-symbols-outlined">delete</a>
                    </td>
                    <td id="edit"<%= emergencia.getCodigo()%>>
                        <button title="editar" class="material-symbols-outlined edit-button">edit_square</button>
                        <form id="editForm"<%= emergencia.getCodigo()%> method="post"
                              action="<%= request.getContextPath()%>/EmergenciaServlet?action=edit">
                            <input type="hidden" name="codigo" value="<%= emergencia.getCodigo()%>">
                            <input type="text" id="editLogin" name="local" placeholder="Local">
                            <input type="text" id="editTipo" name="tipo" placeholder="Tipo">
                            <input type="text" id="editDescricao" name="descricao" placeholder="Descricao">

                            <input type="submit" value="Salvar">
                        </form>
                    </td>
                </tr>
                <%}
                } else {
                    // Se a lista for nula, exiba uma mensagem ou tome outra ação adequada.
                %>
                <tr>
                    <td colspan="4">Nenhuma Emergencia a listar.</td>
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

<%@page import="entities.Insumo"%>
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

        <title>Camp Solidario - Insumos</title>
    </head>

    <body>
        <%@include file="./templates/sideBar.jsp" %>
        <div class="container">
            <h2>Insumos Cadastrados</h2>
            <% List<Insumo> listInsumo = (List<Insumo>) request.getAttribute("listInsumo");%>
            <table>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Marca</th>
                    <th>Categoria</th>
                    <th>Quantidade</th>

                </tr>
                <% if (listInsumo != null) {
                        for (Insumo insumo : listInsumo) {%>
                <tr>
                    <td><%= insumo.getCodigo()%></td>
                    <td><%= insumo.getNome()%></td>
                    <td><%= insumo.getMarca()%></td>
                    <td><%= insumo.getCategoria()%></td>
                    <td><%= insumo.getQuantidade()%></td>


                    <td id="delete">
                        <a href="<%= request.getContextPath()%>/InsumoServlet?action=delete&codigo=<%= insumo.getCodigo()%>"
                           onclick="return confirm('Tem certeza que deseja excluir o Insumo?');"
                           title="deletar" class="material-symbols-outlined">delete</a>
                    </td>
                    <td id="edit"<%= insumo.getCodigo()%>>
                        <button title="editar" class="material-symbols-outlined edit-button">edit_square</button>
                        <form id="editForm"<%= insumo.getCodigo()%> method="post"
                              action="<%= request.getContextPath()%>/InsumoServlet?action=edit">
                            <input type="hidden" name="codigo" value="<%= insumo.getCodigo()%>">
                            <input type="text" id="editNome" name="nome" placeholder="Nome">
                            <input type="text" id="editMarca" name="marca" placeholder="Marca">

                            <select id="editCategoria" name="categoria">
                                <option value="DESCONHECIDO">DESCONHECIDO</option>
                                <option value="MEDICACAO">MEDICACAO</option>
                                <option value="ALIMENTO">ALIMENTO</option>
                                <option value="ROUPA">ROUPA</option>
                                <option value="TESTE">TESTE</option>
                            </select>

                            <input type="number" id="editQuantidade" name="quantidade" placeholder="Quantidade">
                            <input type="submit" value="Salvar">
                        </form>

                    </td>
                </tr>
                <%}
                } else {
                 
                %>
                <tr>
                    <td colspan="5">Nenhum Insumo a listar.</td>
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

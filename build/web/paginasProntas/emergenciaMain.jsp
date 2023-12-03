<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="./templates/head.jsp" %>
    <title>Camp Solidario - Emergencia</title>
    <style>
      
        #editForm {
            display: none;
        }
    </style>
</head>
<body>
    <%@include file="./templates/sideBar.jsp" %>
    <div class="container">
        <a href="./EmergenciaServlet?action=listarEmergencia">Listar Emergencias</a>
        <a href="#" id="findEmergenciaLink">Encontrar Emergencia por código</a>
        <form id="editForm" method="post" action="<%= request.getContextPath()%>/EmergenciaServlet">
            <input type="hidden" name="action" value="findById">
            <label for="codigo">Código:</label>
            <input type="text" id="codigo" name="codigo" required>
            <input type="submit" value="Enviar">
        </form>
        <a href="#">Adicionar Emergencia</a>
    </div>
    <script>
        document.getElementById('findEmergenciaLink').addEventListener('click', function (event) {
            event.preventDefault();
            var editForm = document.getElementById('editForm');
            if (editForm.style.display === 'block') {
                editForm.style.display = 'none';
            } else {
                editForm.style.display = 'block';
            }
        });
    </script>
</body>
</html>

<!DOCTYPE html>
<!--https://campsolidario.w3spaces.com/index.html-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <%@ include file="./templates/head.jsp" %>
    <title>Camp Solidario - Login</title>
</head>
<body>
    <%@include file="./templates/sideBar.jsp" %>
        <div class="container">
            <div class="formContainer">
                <h2>LOGIN</h2>
                <form>
                <input type="text" class="input" placeholder="Username"  name="login" id="login" required>
                <input type="password" class="input" placeholder="Password" name="senha" id="senha" required>
                <select id="tipoUsuario" name="tipoUsuario">
                     <option value="ong">ONG</option>
                    <option value="admin">Admin</option>                    
                </select>
                <button  id="submitButton" type="submit">Enviar</button>
                 </form>
            </div>
        </div>
  
    
</body>
</html>



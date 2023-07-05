<%-- 
    Document   : registrarUsuario
    Created on : 24/05/2022, 10:56:42 AM
    Author     : SENA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/RegistrarUsuario.css" rel="stylesheet" type="text/css"/>

        <title>Registrar Usuario</title>
    </head>
    <body>
        <div class="Registro">
            <div class="left">
           
            <center>
                <h1>Registrar usuario</h1>
                <form method="post" action="Usuario">
                    <table>
                        <tr>
                            Usuario <br><br>
                        <input type="email" name="txtUsuario" required><br><br>
                        clave <br><br>
                        <input type="password" name="txtClave" required><br>
                        </tr>
                    </table><br>
                    <button>Registrarse</button>
                    <input type="hidden" value="1" name="opcion">

                </form><br>
                <%
            if (request.getAttribute("mensajeError") != null) {%>

                <h4 class="mensaje">

                    ${mensajeError}
                    <% } else { %>
                    ${mensajeExito}
                </h4>
                <%}%>
            
                <a href="index.jsp" class="inicio">Inicia Sesión aquí</a>
               
            </center>
        </div>
    </body>
</html>

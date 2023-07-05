<%-- 
    Document   : index
    Created on : 25/05/2022, 08:28:18 AM
    Author     : SENA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/index.css" rel="stylesheet" type="text/css"/>

        <title>Inicio Sesión</title>
    </head>
    <body>
        <div class="session">
            <div class="left">
             
                <svg enable-background="new 0 0 300 302.5" version="1.1" viewBox="0 0 300 302.5" xml:space="preserve" xmlns="http://www.w3.org/2000/svg">
               
            </div>
            <center>
                <h1>Iniciar Sesión</h1>
                <form method="post" action="Usuario">
                    <table>
                        <tr>
                            usuario <br><br>
                        <input type="text" name="txtUsuario" placeholder="Ingresa tu correo" required><br><br>
                        clave <br><br>
                        <input type="password" name="txtClave" placeholder="Ingresa tu contraseña" required><br><br>
                        </tr>
                    </table>
                    <button>Iniciar</button>
                    <input type="hidden" value="4" name="opcion">
                 
                    <button><a href="registrarUsuario.jsp">Registrarse</a></button>
                       

                </form><br>
                <%
            if (request.getAttribute("mensajeError") != null) {%>
                ${mensajeError}
                <% } else { %>
                ${mensajeExito}
                <%}%>
            </center>
        </div>
    </body>
</html>
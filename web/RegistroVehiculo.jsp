<%-- 
    Document   : RegistroVehiculo
    Created on : 25/05/2022, 08:44:19 PM
    Author     : yuliana
--%>

<%@page import="ModeloVO.CategoriaVO"%>
<%@page import="ModeloDAO.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/RegistrarVehiculo.css" rel="stylesheet" type="text/css"/>
     
        <title>Registrar Vehiculo</title>
    </head>
    <body>
    <center>
                <header class="header">
           
            <h1 class="titulo">Concesionario</h1>
            <h2 class="title">bienvenid@ a el Concesionario Web</h2>
        </header>
        <form method="post" action="Sesiones" class="cerrar" >
            <input type="submit" value="Cerrar Sesión" id="guardar">
        </form>
        <h1 class="titulo2">Registrar Vehiculo</h1>
        <form method="post" action="Vehiculo" class="registro">
            <table>
                <tr>
                    Placa del vehículo <br>
                <input type="text" name="txtplaca"><br><br>
                datos del usuario <br>
                <input type="text" name="txtdat"><br><br>
                Categoria <br>
                <select name="txtcat">
                    <option>Seleccione..</option>
                    <%                        CategoriaDAO catDAO = new CategoriaDAO();
                        for (CategoriaVO catVO : catDAO.listar()) {
                    %>
                    <option value="<%=catVO.getCatId()%>"><%=catVO.getCatIpo()%></option>
                    <%}%>
                </select><br><br>
                Modelo <br>
                <input type="text" name="txtmodelo"><br><br>
                Marca<br>
                <select type="text" name="txtmarca" >
                    <option>Seleccione..</option>
                    <option>HONDA</option>
                    <option>ACURA</option>
                    <option>MAZDA</option>
                    <option>TOYOTA</option>
                    <option>CHEVROLET</option>
                    <option>FERRARI</option>
                    <option>FORD</option>
                    <option>MERCEDES</option>
                </select><br><br>
                Estado <br>
                <select type="text" name="txtestado">
                    <option>Seleccione..</option>
                    <option>NUEVO</option>
                    <option>USADO</option>
                </select><br><br>
                Precio <br>
                <input type="text" name="txtprecio"><br><br>

                </tr>
            </table><br>
            <button class="btn2">Registrar Vehiculo</button>
            <input type="hidden" value="1" name="opcion">
            <button class="btn1"><a  href="Vendedor.jsp" >Volver Atras</a></button>

        </form><br><br>
        <%
            if (request.getAttribute("mensajeError") != null) {%>
        ${mensajeError}
        <% } else { %>
        ${mensajeExito}
        <%}%>

    </center>
</body>
</html>

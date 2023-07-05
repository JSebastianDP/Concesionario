<%-- 
    Document   : Vendedor
    Created on : 27/06/2022, 06:34:47 PM
    Author     : yuliana
--%>

<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/Vendedor.css" rel="stylesheet" type="text/css"/>
      
    </head>


    <body>
        <header class="header">
            <h1 class="Concesionario">Concesionario Web </h1>
            <h2 class="">Sea bienvenido usuario: <%=usuario%> </h2>
            <form method="post" action="Sesiones"  >
            <input type="submit" value="Cerrar Sesión" id="guardar" >
        </form>
        </header>
        
 
        <img src="IMG/Actualizar.png" clasS="ActualizarV"alt=""/>
        <img src="IMG/registrar vehiculo.jpg" class="RegistrarV"alt=""/>
        <button class="btn1"><a  href="RegistroVehiculo.jsp">Registrar Vehiculo</button></a>
        <button class="btn2"><a  href="ConsultarVehiculo.jsp">Actualizar Vehiculo</button></a>

</body>
</html>

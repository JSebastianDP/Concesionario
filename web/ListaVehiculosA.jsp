<%-- 
    Document   : listaVehiculos1
    Created on : 27/06/2022, 11:48:42 PM
    Author     : karen_b
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.VehiculoDAO"%>
<%@page import="ModeloVO.VehiculoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="CSS/consultarVehiculo.css" rel="stylesheet" type="text/css"/>
        <title>Lista de Vehículos </title>
    </head>
    <body><center>
        <header class="header">
           
            <h1 class="titulo">Concesionario </h1>
            <h2 class="title">bienvenid@ al concesionario</h2>
        </header>
        <form method="post" action="Sesiones" class="cerrar" >
            <input type="submit" value="Cerrar Sesión" id="guardar">
        </form>

        <h1 class="titulo2">Lista de Vehículos Administrador</h1>

        <form method="post" action="Vehiculo">
            <table  class="table users " >
                <tr class="bg-primary">
                    <th >PLACA</th>
                    <th >DATOS</th>
                    <th >CATEGORÍA</th>
                    <th >MODELO</th>
                    <th>MARCA</th>
                    <th>ESTADO</th>
                    <th>PRECIO</th>
                    <th>DATOS PERSONALES</th>

                </tr>

                <%

                    VehiculoVO vehVO = new VehiculoVO();
                    VehiculoDAO vehDAO = new VehiculoDAO();

                    ArrayList<VehiculoVO> listaVehiculos = vehDAO.listar();
                    for (int i = 0; i < listaVehiculos.size(); i++) {
                        vehVO = listaVehiculos.get(i);


                %>  


                <tr >
                    <td><%=vehVO.getVehPlaca()%></td>
                <input type="hidden" value="6" name="opcion">

                <td><%=vehVO.getDatId()%></td>
                <td><%=vehVO.getCatId()%></td>
                <td><%=vehVO.getVehModelo()%></td>
                <td><%=vehVO.getVehMarca()%></td>
                <td><%=vehVO.getVehEstado()%></td>
                <td><%=vehVO.getVehPrecio()%></td>
                <td><button name="datos" class="BotonVolver" value="<%=vehVO.getDatId()%>">Consultar</button></td>


                </tr>

                <% }%>  
            </table>
            <button class="BotonVolver"><a href="menu.jsp">Volver Atras</a></button>
        </form>
    </center>

</body>
</html>

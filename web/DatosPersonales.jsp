<%-- 
    Document   : DatosPersonales
    Created on : 28/06/2022, 12:20:36 AM
    Author     : yuliana
--%>

<%@page import="ModeloDAO.DatosPersonalesDAO"%>
<%@page import="ModeloVO.DatosPersonalesVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/DatosP.css" rel="stylesheet" type="text/css"/>
       
        <title>Datos personales</title>
    </head>
    <body>

        <header class="header">
         
            <h1 class="titulo">Concesionario</h1>
            <h2 class="title">bienvenid@ a el Concesionario Web </h2>
        </header>
        <form method="post" action="Sesiones" class="cerrar" >
            <input type="submit" value="Cerrar Sesión" id="guardar">
        </form>
        
        <h1 class="titulo2">Datos personales</h1>
        
        <form method="post" action="Vehiculo">
            <table class="table users">
                <tr>
                    <th >Nombre</th>
                    <th >Apellido</th>
                    <th >Tipo Documento</th>
                    <th >Numero Documento</th>
                    <th >Telefono</th>
                    <th>Correo</th>
                </tr>

                <%

                    DatosPersonalesVO datVO = new DatosPersonalesVO();
                    DatosPersonalesDAO datDAO = new DatosPersonalesDAO();

                    datVO = (DatosPersonalesVO)request.getAttribute("datosPersonales");

                    if (datVO != null) {

                %>  


                <tr >
                    <td><%=datVO.getDatNombre()%></td>
                    <td><%=datVO.getDatApellido()%></td>
                    <td><%=datVO.getDatTipoId()%></td>
                    <td><%=datVO.getDatNumeroId()%></td>
                    <td><%=datVO.getDatTelefono()%></td>
                    <td><%=datVO.getDatCorreo()%></td>
                </tr>

                <% }%>  
            </table>
            
            <button class="cons"><a href="ConsultarVehiculo.jsp">Volver Atras</a></button>
        </form>
    </center>

</body>
</html>

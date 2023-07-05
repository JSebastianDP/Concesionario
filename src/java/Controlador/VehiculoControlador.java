/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.DatosPersonalesDAO;
import ModeloDAO.VehiculoDAO;
import ModeloVO.DatosPersonalesVO;
import ModeloVO.VehiculoVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SENA
 */
@WebServlet(name = "VehiculoControlador", urlPatterns = {"/Vehiculo"})
public class VehiculoControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//1.  recibir datos de las vistas 
        String vehplaca = request.getParameter("txtplaca");
        String datid = request.getParameter("txtdat");
        String catid = request.getParameter("txtcat");
        String vehmodelo = request.getParameter("txtmodelo");
        String vehmarca = request.getParameter("txtmarca");
        String vehestado = request.getParameter("txtestado");
        String vehprecio = request.getParameter("txtprecio");
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        //2. ¿Quien tiene los datos de forma segura en el sistema? el VO se instancia
        VehiculoVO vehVO = new VehiculoVO(vehplaca, datid, catid, vehmodelo, vehmarca, vehestado, vehprecio);
        //3. ¿quien hace las operaciones ? DAO se instanci el DAO
        VehiculoDAO vehDAO = new VehiculoDAO(vehVO);
        //4.Administrar operaciones 
        String DatosP = request.getParameter("DatosP");

        switch (opcion) {

            case 1://agreagar registro 
                if (vehDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "el vehiculo se registro correctamente");

                } else {
                    request.setAttribute("mensajeError", "el vehiculo no se registro correctamente");
                }
                request.getRequestDispatcher("RegistroVehiculo.jsp").forward(request, response);
                break;
            case 2: //Metodo de actualizar 
                if (vehDAO.actualizarRegistro()) 
                {

                    request.setAttribute("mensajeExito", "El vehiculo se actulizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "El vehiculo NO se actualizo correctamente");
                }

                request.getRequestDispatcher("ConsultarVehiculo.jsp").forward(request, response);
                break;
            case 3: //Metodo de eliminar registro
                if (vehDAO.eliminarRegistro()) {

                    request.setAttribute("mensajeExito", "El vehiculo se elimino correctamente");
                } else {
                    request.setAttribute("mensajeError", "El vehiculo NO se elimino correctamente");
                }

                request.getRequestDispatcher("eliminarVehiculo.jsp").forward(request, response);
                break;
            case 4: //Metodo de consultar vehiculo
                vehVO = vehDAO.consultarPlaca(vehplaca);
                if (vehVO != null) {

                    request.setAttribute("VehiculoConsultado", vehVO);
                    request.getRequestDispatcher("ActualizarVehiculo.jsp").forward(request, response);

                } else {
                    request.setAttribute("mensajeError", "el vehiculo no existe!");
                }
                 request.getRequestDispatcher("ConsultarVehiculo.jsp").forward(request, response);
                break;
            case 5://consultar datos personales
                DatosPersonalesVO datVO = new DatosPersonalesVO();
                DatosPersonalesDAO datDAO = new DatosPersonalesDAO();

                datVO = datDAO.consultarDatos(DatosP);

                if (datVO != null) {
                    request.setAttribute("datosPersonales", datVO);
                    request.getRequestDispatcher("DatosPersonales.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "Los datos no se encontraron");
                    request.getRequestDispatcher("ConsultarVehiculo.jsp").forward(request, response);
                }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

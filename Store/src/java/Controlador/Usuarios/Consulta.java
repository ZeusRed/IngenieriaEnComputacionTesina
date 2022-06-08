/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Usuarios;

import Logica.UsuariosManager;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer ES 15
 */
@WebServlet(name = "ConsultaUsuario", urlPatterns = {"/ConsultaUsuario"})
public class Consulta extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           int valorSubmit = Integer.parseInt(request.getParameter("id"));
               UsuariosManager manager = new UsuariosManager();
            Usuario usuario = manager.GetUsuario(valorSubmit);
               if(usuario.getIdUsuario()==0){
                    request.setAttribute("detalle1", usuario);
           //  request.getRequestDispatcher("/Vistas/AccionesUsuario/EditarUsuario.jsp").forward(request, response);
                request.getRequestDispatcher("Vistas/error.jsp").forward(request, response);
               }else{
                    request.setAttribute("detalle1", usuario);
           //  request.getRequestDispatcher("/Vistas/AccionesUsuario/EditarUsuario.jsp").forward(request, response);
                request.getRequestDispatcher("Vistas/Usuarios/detalleUsuario.jsp").forward(request, response);
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

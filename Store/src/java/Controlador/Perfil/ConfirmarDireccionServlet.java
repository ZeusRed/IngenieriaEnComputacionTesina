/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Perfil;

import Logica.DireccionesManager;
import Modelo.Direccion;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;
import org.json.simple.JSONObject;

/**
 *
 * @author Acer ES 15
 */
@WebServlet(name = "ConfirmarDireccion", urlPatterns = {"/ConfirmarDireccion"})
public class ConfirmarDireccionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String calle = request.getParameter("calle");
            String colonia = request.getParameter("colonia");
            int cp = Integer.parseInt(request.getParameter("cp"));
            int numero = Integer.parseInt(request.getParameter("numero"));

            Direccion dir = new Direccion();

            dir.setCalle(calle);
            dir.setColonia(colonia);
            dir.setCodigoPostal(cp);
            dir.setNumero(numero);

            Cookie[] my_cookies = null;

            // Get an array of Cookies associated with the this domain
            my_cookies = request.getCookies();
            Optional<String> val = leerCookie("User_id", my_cookies);

            int idUser = Integer.parseInt(val.get());
            DireccionesManager manager = new DireccionesManager();
            int estatus = manager.saveDireccion(dir, idUser);
            JSONObject data = new JSONObject();
            if (estatus == 1) {

                data.put("isNewDireccion", true);
            } else {

                data.put("isNewDireccion", false);
            }
            out.print(data.toString());
        }
    }

    public Optional<String> leerCookie(String key, Cookie[] cockies) {
        return Arrays.stream(cockies)
                .filter(c -> key.equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Compras;

import Logica.CarritoManager;
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

 
@WebServlet(name = "ConfirmarCompra", urlPatterns = {"/ConfirmarCompra"})
public class ConfirmarCompra extends HttpServlet {

  /*  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Cookie[] my_cookies = null;
            my_cookies = request.getCookies();
            Optional<String> val = leerCookie("User_id", my_cookies);
            int valorSubmit = Integer.parseInt(val.get());
            JSONObject data = new JSONObject();
            CarritoManager carrito = new CarritoManager();
            int estatus = 0;
            //estatus = carrito.confirmarCompra(valorSubmit);
            if (estatus == 1) {
                data.put("confirm", true);
            } else {
                data.put("confirm", false);
            }
            out.print(data.toString());
        }
    }
*/
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String noTarjeta = request.getParameter("noTarjeta");
            String codigoSeg = request.getParameter("codSeg");
            String fechaSeg = request.getParameter("fecSeg");
            int idDireccion = Integer.parseInt(request.getParameter("idDir"));

            Cookie[] my_cookies = null;

            my_cookies = request.getCookies();
            Optional<String> val = leerCookie("User_id", my_cookies);

            int valorSubmit = Integer.parseInt(val.get());
            CarritoManager manager = new CarritoManager();

            int estatus = manager.confirmarCompra(valorSubmit, noTarjeta, codigoSeg, fechaSeg, idDireccion);
            JSONObject data = new JSONObject();
            if (estatus == 1) {

                data.put("isCompraConfirmed", true);
            } else {

                data.put("isCompraConfirmed", false);
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

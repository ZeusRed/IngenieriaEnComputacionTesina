/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.WishList;

import Logica.WishlistManager;
import Modelo.WishlistDetalle;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Acer ES 15
 */
@WebServlet(name = "Delete", urlPatterns = {"/Delete"})
public class WishListDeleteItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int idwhislist = Integer.parseInt(request.getParameter("deleteWish"));
            WishlistManager manager = new WishlistManager();
            Cookie[] my_cookies = null;
            List<WishlistDetalle> listaProds = new ArrayList<>();
            my_cookies = request.getCookies();
            Optional<String> val = leerCookie("User_id", my_cookies);
            List<WishlistDetalle> estatus = null;
            if (val != null) {
                int id = Integer.parseInt(val.get());
               estatus  = manager.EliminaProductoWishList(idwhislist,id);
                

                
                request.setAttribute("whis", estatus);

            } else {
                request.setAttribute("whis", estatus);
            }

            if (estatus != null) {

                request.getRequestDispatcher("Vistas/WishList/index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("Vistas/Compras/index.jsp").forward(request, response);
            }

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

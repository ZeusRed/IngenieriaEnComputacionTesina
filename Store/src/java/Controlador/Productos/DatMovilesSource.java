/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Productos;

import Logica.ProductosManager;
import Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

 
@WebServlet(name = "DatMovilesSource", urlPatterns = {"/DatMovilesSource"})
public class DatMovilesSource extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int id = Integer.parseInt(request.getParameter("idCP"));
            ProductosManager manager = new ProductosManager();
            List<Producto> prods = manager.GetProdsId(id);
            ProductosManager prs = new ProductosManager();

            String base64Image = "";
            /*List<String> content = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            String toAdd;
            toAdd = "Hola";
            content.add(toAdd);
        }
        request.setAttribute("lst", content);*/
            int i = 0;
            HashMap<String, List<Producto>> map = new HashMap<String, List<Producto>>();
            List<Producto> prodsInner = new ArrayList<Producto>();
          /*  for (Producto prod : prods) {

                if (prods.size() > 4) {
                    if (i == 3) {
                        map.put("" + i, prodsInner);

                        i = 0;
                        prodsInner.clear();

                        prod.setBase64Image(Base64.getEncoder().encodeToString(prod.getImagen()));
                        prod.setIteracion(i);
                        prodsInner.add(prod);
                        i++;
                    } else {
                        prod.setBase64Image(Base64.getEncoder().encodeToString(prod.getImagen()));
                        prod.setIteracion(i);
                        prodsInner.add(prod);
                        i++;
                    }
                } else {
                    if (prods.size() > 1) {
                        // add 2
                        if (prods.size() < 3) {
                            if (i == 1) {
                                map.put("" + i, prodsInner);

                                i = 0;
                                prodsInner.clear();

                                prod.setBase64Image(Base64.getEncoder().encodeToString(prod.getImagen()));
                                prod.setIteracion(i);
                                prodsInner.add(prod);
                                i++;
                            } else {
                                prod.setBase64Image(Base64.getEncoder().encodeToString(prod.getImagen()));
                                prod.setIteracion(i);
                                prodsInner.add(prod);
                                i++;
                            }

                        } else {
                            //add 3
                            if (i == 2) {
                                map.put("" + i, prodsInner);

                                i = 0;
                                prodsInner.clear();

                                prod.setBase64Image(Base64.getEncoder().encodeToString(prod.getImagen()));
                                prod.setIteracion(i);
                                prodsInner.add(prod);
                                i++;
                            } else {
                                prod.setBase64Image(Base64.getEncoder().encodeToString(prod.getImagen()));
                                prod.setIteracion(i);
                                prodsInner.add(prod);
                                i++;
                            }
                        }
                    } else {
                        // add 1 
                        prod.setBase64Image(Base64.getEncoder().encodeToString(prod.getImagen()));
                        prod.setIteracion(i);
                        prodsInner.add(prod);
                        map.put("" + i, prodsInner);
                    }
                }

            }*/   
          for (int j = 0; j < prods.size(); j++) {
                         
                if(j<prods.size()){
                  Producto prod = prods.get(j);
                    prod.setBase64Image(Base64.getEncoder().encodeToString(prod.getImagen()));
                    prod.setIteracion(j);
                    prodsInner.add(prod);
                }else{
                    //
                }
                if (j + 1 == prods.size() || j+1 % 3 == 0) {
                    

                    map.put("" + j, new ArrayList<Producto>(prodsInner));
                    prodsInner.clear();
                } else {
                  //
                }
            }
            request.setAttribute("map", map);

            request.getRequestDispatcher("Vistas/Productos/Moviles.jsp").forward(request, response);
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

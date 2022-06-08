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
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.simple.JSONObject;

@WebServlet("/EditarProductoSet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB 
        maxFileSize = 1024 * 1024 * 10, // 10 MB 
        maxRequestSize = 1024 * 1024 * 100 // 100 MB 
)

public class EditarProductoSet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public EditarProductoSet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
        try (PrintWriter out = response.getWriter()) {
            int id = Integer.parseInt(request.getParameter("id"));
            String descrip = request.getParameter("descripcion");
            double precio = Double.parseDouble(request.getParameter("precio"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));

            Producto prod = new Producto();
            prod.setIdProducto(id);
            prod.setDescripcion(descrip);
            prod.setPrecio(precio);
            prod.setExistencia(cantidad);

            ProductosManager manager = new ProductosManager();
            int estatus = manager.EditarProd(prod);

            JSONObject data = new JSONObject();
            if (estatus == 1) {
                data.put("Respuesta", true);

            } else {
                data.put("Respuesta", false);
            }

            out.print(data.toJSONString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            int id = Integer.parseInt(request.getParameter("idP"));
            int idG = Integer.parseInt(request.getParameter("idG"));
            if (idG == 0) {
                Part filePart = request.getPart("0"); // Retrieves <input type="file" name="file">
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());

                InputStream fileContent = filePart.getInputStream();
                String header = filePart.getHeader("content-disposition");
                String filename = header.substring(header.indexOf("filename=\"")).split("\"")[1];  //getting filename

                ProductosManager manager = new ProductosManager();
                int estatus = manager.EditarGaleria(id, filePart);

                JSONObject dataS = new JSONObject();

                if (estatus == 1) {
                    Producto prod2 = manager.GetProd(id);

                    dataS.put("dato", true);
                } else {
                    System.out.println(false);
                    dataS.put("Respuesta", false);
                }

                out.print(dataS.toJSONString());
            } else {

                Part filePart = request.getPart(request.getParameter("idG")); // Retrieves <input type="file" name="file">
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());

                InputStream fileContent = filePart.getInputStream();
                String header = filePart.getHeader("content-disposition");
                String filename = header.substring(header.indexOf("filename=\"")).split("\"")[1];  //getting filename

                ProductosManager manager = new ProductosManager();
                int estatus = manager.EditarGaleriaProds(id,idG, filePart);

                JSONObject dataS = new JSONObject();

                if (estatus == 1) {
                    Producto prod2 = manager.GetProd(id);

                    dataS.put("dato", true);
                } else {
                    System.out.println(false);
                    dataS.put("Respuesta", false);
                }

                out.print(dataS.toJSONString());
            }
        }

    }

}

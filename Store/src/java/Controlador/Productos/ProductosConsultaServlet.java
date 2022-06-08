
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
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@WebServlet(name = "ProductosConsulta", urlPatterns = {"/ProductosConsulta"})
public class ProductosConsultaServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
     
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
          try (PrintWriter out = response.getWriter()) {
            System.out.println(request.getParameter("reqValue"));

            request.setCharacterEncoding("utf8");

            response.setContentType("application/json");
            ProductosManager manager = new ProductosManager();
            List<Producto> prods = manager.GetProds();

            JSONArray jsonArray = new JSONArray();
            for (Producto prod : prods) {
                JSONObject data = new JSONObject();
                data.put("id", prod.getIdProducto());
                data.put("descripcion", prod.getDescripcion());
                data.put("precio", prod.getPrecio());
                data.put("existencia", prod.getExistencia());
                data.put("imagen", prod.getBase64Image());

                jsonArray.add(data);

            }

            out.print(jsonArray.toString());

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

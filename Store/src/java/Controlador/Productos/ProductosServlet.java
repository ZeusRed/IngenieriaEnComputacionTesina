package Controlador.Productos;

import Logica.ProductosManager;
import Logica.UsuariosManager;
import Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.*;

/**
 * Servlet implementation class TablaDel2
 */
@WebServlet("/Productos")
public class ProductosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
        /*Nombre  y permisos*/
        String nombreUsuario = "Reynaldo Mejía Rivera";
        String perfilTipo = "1"; // 1:administrador  - 0 comprador

        request.setAttribute("tipoPerfil", perfilTipo);
        request.setAttribute("nombreUsuario", nombreUsuario);
        /* ProductosManager manager2 = new ProductosManager();
        List<Producto> prods2 = manager2.GetProds();
        ProductosManager prs = new ProductosManager();
        //int reg = prs.RegistraGaleria("C:\\julia-9.jpg");
        String base64Image = "";
        List<String> content = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            String toAdd;
            toAdd = "Hola";
            content.add(toAdd);
        }
        request.setAttribute("lst", content);
        int i = 0;
        HashMap<String, List<Producto>> map = new HashMap<String, List<Producto>>();
        List<Producto> prodsInner = new ArrayList<Producto>();
        for (Producto prod : prods2) {

            if (prods2.size() > 4) {
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
                if (prods2.size() > 1) {
                    // add 2
                    if (prods2.size() < 3) {
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

        }
        request.setAttribute("map", map);
        request.setAttribute("prod", prods2); 
         */
        request.getRequestDispatcher("Vistas/Productos/index.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String nombreUsuario = "Reynaldo Mejía Rivera";

        JSONObject jsonObject;

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }

            int i = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

package Logica;

import Modelo.GaleriaProducto;
import Modelo.Producto;
import com.mysql.cj.jdbc.Blob;
import jakarta.servlet.http.Part;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ProductosManager extends Conexion {

    public List<Producto> GetProds() {
        List<Producto> prods = new ArrayList<Producto>();

        try {
            Connection conexion = getConection();
            String query = "select * from producto";
            PreparedStatement st = conexion.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt(1));
                prod.setDescripcion(rs.getString(2));
                prod.setPrecio(rs.getDouble(3));
                prod.setExistencia(rs.getInt(4));

                prod.setIdcattipoproducto(rs.getInt(5));

                Blob image = (Blob) rs.getBlob(6);
                if (image != null) {
                    prod.setImagen(image.getBytes(1, (int) image.length()));

                    prod.setBase64Image(Base64.getEncoder().encodeToString(prod.getImagen()));
                }
                prods.add(prod);

            }
            System.out.println("Registros obtenidos correctamente");

            List<GaleriaProducto> gals = new ArrayList<>();
            for (Producto prod : prods) {
                Connection conexion2 = getConection();
                String query2 = "select * from galeriaproductos where idProducto = ?";
                PreparedStatement st2 = conexion2.prepareStatement(query2);
                int idP = prod.getIdProducto();
                st2.setInt(1, idP);
                ResultSet rs2 = st2.executeQuery();

                while (rs2.next()) {
                    GaleriaProducto gal = new GaleriaProducto();

                    gal.setIdgaleriaProductos(rs2.getInt(1));

                    Blob image = (Blob) rs2.getBlob(2);
                    gal.setImagen(image.getBytes(1, (int) image.length()));
                    gal.setIdProducto(rs2.getInt(3));
                    gals.add(gal);

                }
                List<String> imagenesB64 = new ArrayList<>();
                for (GaleriaProducto g : gals) {
                    String img = Base64.getEncoder().encodeToString(g.getImagen());
                    g.setBase64Image(img);
                }
                prod.setGaleria(new ArrayList<GaleriaProducto>(gals));
                gals.clear();
                System.out.println("Registros obtenidos correctamente");
            }

            conexion.close();

        } catch (SQLException E) {
            System.out.println("Error________________:" + E.getMessage());

            return null;
        }

        return prods;

    }

    public List<Producto> GetProdsId(int idCatProd) {
        List<Producto> prods = new ArrayList<Producto>();

        try {
            Connection conexion = getConection();
            String query = "select * from producto where idcattipoproducto=?";
            PreparedStatement st = conexion.prepareStatement(query);
            st.setInt(1, idCatProd);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt(1));
                prod.setDescripcion(rs.getString(2));
                prod.setPrecio(rs.getDouble(3));
                prod.setExistencia(rs.getInt(4));

                prod.setIdcattipoproducto(rs.getInt(5));
                Blob image = (Blob) rs.getBlob(6);
                prod.setImagen(image.getBytes(1, (int) image.length()));
                prod.setBase64Image(Base64.getEncoder().encodeToString(prod.getImagen()));
                prods.add(prod);

            }
            System.out.println("Registros obtenidos correctamente");

            for (Producto prod : prods) {
                List<GaleriaProducto> gals = new ArrayList<>();
                Connection conexion2 = getConection();
                String query2 = "select * from galeriaproductos where idProducto = ?";
                PreparedStatement st2 = conexion2.prepareStatement(query2);
                int idP = prod.getIdProducto();
                st2.setInt(1, idP);
                ResultSet rs2 = st2.executeQuery();

                while (rs2.next()) {
                    GaleriaProducto gal = new GaleriaProducto();

                    gal.setIdgaleriaProductos(rs2.getInt(1));

                    Blob image = (Blob) rs2.getBlob(2);
                    gal.setImagen(image.getBytes(1, (int) image.length()));
                    gal.setIdProducto(rs2.getInt(3));
                    gals.add(gal);

                }
                List<String> imagenesB64 = new ArrayList<>();
                for (GaleriaProducto g : gals) {
                    String img = Base64.getEncoder().encodeToString(g.getImagen());
                    g.setBase64Image(img);
                }

                prod.setGaleria(new ArrayList<GaleriaProducto>(gals));
                gals.clear();
                System.out.println("Registros obtenidos correctamente");
            }

            conexion.close();

        } catch (SQLException E) {
            System.out.println("Error________________:" + E.getMessage());

            return null;
        }

        return prods;

    }

    public Producto GetProd(int id) {
        Producto prod = new Producto();

        try {
            Connection conexion = getConection();
            String query = "select * from producto where idProducto=?";
            PreparedStatement st = conexion.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                prod.setIdProducto(rs.getInt(1));
                prod.setDescripcion(rs.getString(2));
                prod.setPrecio(rs.getDouble(3));
                prod.setExistencia(rs.getInt(4));

                prod.setIdcattipoproducto(rs.getInt(5));
                Blob image = (Blob) rs.getBlob(6);
                if (image != null) {
                    prod.setImagen(image.getBytes(1, (int) image.length()));

                    prod.setBase64Image(Base64.getEncoder().encodeToString(prod.getImagen()));
                }

            }
            List<GaleriaProducto> gals = new ArrayList<>();

            Connection conexion2 = getConection();
            String query2 = "select * from galeriaproductos where idProducto = ?";
            PreparedStatement st2 = conexion2.prepareStatement(query2);
            int idP = prod.getIdProducto();
            st2.setInt(1, idP);
            ResultSet rs2 = st2.executeQuery();

            while (rs2.next()) {
                GaleriaProducto gal = new GaleriaProducto();

                gal.setIdgaleriaProductos(rs2.getInt(1));

                Blob image = (Blob) rs2.getBlob(2);
                gal.setImagen(image.getBytes(1, (int) image.length()));
                gal.setIdProducto(rs2.getInt(3));
                gals.add(gal);

            }
            List<String> imagenesB64 = new ArrayList<>();
            for (GaleriaProducto g : gals) {
                String img = Base64.getEncoder().encodeToString(g.getImagen());
                g.setBase64Image(img);
            }
            prod.setGaleria(gals);
            System.out.println("Registros obtenidos correctamente");

            return prod;
        } catch (SQLException e) {
            return null;
        }
    }

    public int RegistraProd() {
        int estatus = 0;
        try {
            Connection con = getConection();
            String query = "insert  into producto (Descripcion,precio,existencia,idcattipoproducto,Imagen)" + "values(?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(query);

            InputStream in = new FileInputStream("C:\\julia-12.jpg");
            //pstmt.setBlob(2, in);

            st.setString(1, "asdf");
            st.setDouble(2, Double.parseDouble("125.25"));
            st.setInt(3, 1);
            st.setInt(4, 1);
            //st.setBinaryStream(5, (InputStream) fis, (int) (new File(path).length()));
            st.setBlob(5, in);
            estatus = st.executeUpdate();
            System.out.println("Registrado correctamente");
            con.close();
            return estatus;

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return 0;
        } catch (FileNotFoundException ex) {
            System.out.println("Error:" + ex.getMessage());
            return 0;
        }

    }

    public int RegistraProdDatos(Producto prod) {
        int estatus = 0;
        try {
            Connection con = getConection();
            String query = "insert  into producto (Descripcion,precio,existencia,idcattipoproducto)" + "values(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(query);

            // InputStream in = new FileInputStream("C:\\julia-12.jpg");
            //pstmt.setBlob(2, in);
            st.setString(1, prod.getDescripcion());
            st.setDouble(2, prod.getPrecio());
            st.setInt(3, prod.getExistencia());
            st.setInt(4, prod.getIdcattipoproducto());
            //st.setBinaryStream(5, (InputStream) fis, (int) (new File(path).length()));
            // st.setBlob(5, null);
            estatus = st.executeUpdate();
            System.out.println("Registrado correctamente");
            con.close();
            return estatus;

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return 0;
        }

    }

    public int RegistraGaleria(String gal) {
        int estatus = 0;
        try {
            Connection con = getConection();
            String query = "insert  into galeriaproductos (Imagen,idProducto)" + "values(?,?)";
            PreparedStatement st = con.prepareStatement(query);

            InputStream in = new FileInputStream(gal);

            st.setBlob(1, in);
            st.setInt(2, 3);
            estatus = st.executeUpdate();
            System.out.println("Registrado correctamente");
            con.close();
            return estatus;

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return 0;
        } catch (FileNotFoundException ex) {
            System.out.println("Error:" + ex.getMessage());
            return 0;
        }
    }

    public int EditarProd(Producto prod) {
        int estatus = 0;
        try {
            Connection con = getConection();
            String query = "update producto set Descripcion=?, precio=?,existencia=? where idProducto=? ";
            PreparedStatement st = con.prepareStatement(query);

            st.setString(1, prod.getDescripcion());
            st.setDouble(2, prod.getPrecio());
            st.setInt(3, prod.getExistencia());
            st.setInt(4, prod.getIdProducto());
            //st.setInt(6, u.getIdcattipousuario());

            estatus = st.executeUpdate();
            System.out.println("Actualizado correctamente");
            con.close();
            return estatus;

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return 0;
        }
    }

    public int EditarGaleria(int idProd, Part filePart) throws FileNotFoundException, IOException {
        int estatus = 0;
        try {
            Connection con = getConection();
            String query = "update producto set Imagen=? where idProducto=? ";
            PreparedStatement st = con.prepareStatement(query);

            InputStream in = filePart.getInputStream();// new FileInputStream("C:\\julia-12.jpg");

            st.setBlob(1, in);
            st.setInt(2, idProd);

            //st.setInt(6, u.getIdcattipousuario());
            estatus = st.executeUpdate();
            System.out.println("Actualizado correctamente la imagen ");
            con.close();
            return estatus;

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return 0;
        }
    }

    public int EditarGaleriaProds(int idProd, int idG, Part filePart) throws FileNotFoundException, IOException {
        int estatus = 0;
        try {
            Connection con = getConection();
            String query = "update galeriaproductos set Imagen=? where idgaleriaProductos=? && idProducto=?";
            PreparedStatement st = con.prepareStatement(query);

            InputStream in = filePart.getInputStream();// new FileInputStream("C:\\julia-12.jpg");

            st.setBlob(1, in);
            st.setInt(2, idG);
            st.setInt(3, idProd);

            //st.setInt(6, u.getIdcattipousuario());
            estatus = st.executeUpdate();
            System.out.println("Actualizado correctamente la imagen en la galeria ");
            con.close();
            return estatus;

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return 0;
        }
    }
}

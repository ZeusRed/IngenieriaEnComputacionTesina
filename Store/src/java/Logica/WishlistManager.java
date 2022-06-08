/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.WishlistDetalle;
import Modelo.Wishlist;
import Modelo.Producto;
import Modelo.ProductoVenta;
import Modelo.Venta;
import Modelo.VentaUsuario;
import com.mysql.cj.jdbc.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class WishlistManager extends Conexion {

    public List<WishlistDetalle> ListProductosWishList(int idUsuario) {
        Connection conexion = getConection();
        List<WishlistDetalle> WishList = new ArrayList<>();
        try {
            String query = "select * from wishlist where idusuario=?";

            PreparedStatement st = conexion.prepareStatement(query);
            st.setInt(1, idUsuario);
            ResultSet rs = st.executeQuery();

            List<Wishlist> wishUsuario = new ArrayList<>();
            while (rs.next()) {
                Wishlist w = new Wishlist();
                w.setIdwishlist(rs.getInt(1));
                w.setDescripcion(rs.getString(2));
                w.setIdProducto(rs.getInt(3));
                w.setIdusuario(rs.getInt(4));
                wishUsuario.add(w);
            }
            /*
            System.out.println("Registros obtenidos correctamente 1");
            List<Venta> ventas = new ArrayList<>();

              for (VentaUsuario v : ventasUsuario) {
                String query2 = "select * from venta where idventa=?";

                PreparedStatement st2 = conexion.prepareStatement(query2);
                st2.setInt(1, v.getIdVenta());
                ResultSet rs2 = st2.executeQuery();

                while (rs2.next()) {
                    Venta venta = new Venta();
                    venta.setIdVenta(rs2.getInt(1));
                    venta.setFechaVenta(rs2.getDate(2));
                    venta.setTotalVenta(rs2.getDouble(3));
                    ventas.add(venta);
                }
            }

            System.out.println("Registros obtenidos correctamente 2");
            
           List<ProductoVenta> productosVentas = new ArrayList<>();
            for (Venta v : ventas) {
                String query3 = "select * from productoventa where idventa=?";

                PreparedStatement st3 = conexion.prepareStatement(query3);
                st3.setInt(1, v.getIdVenta());
                ResultSet rs3 = st3.executeQuery();

                while (rs3.next()) {
                    ProductoVenta wl = new ProductoVenta();
                    wl.setIdProductoVenta(rs3.getInt(1));
                    wl.setIdVenta(rs3.getInt(2));
                    wl.setIdProducto(rs3.getInt(3));
                    productosVentas.add(wl);
                }
            }*/

            List<Producto> productos = new ArrayList<>();
            for (Wishlist wl : wishUsuario) {
                String query3 = "select * from producto where idproducto=?";

                PreparedStatement st3 = conexion.prepareStatement(query3);
                st3.setInt(1, wl.getIdProducto());
                ResultSet rs3 = st3.executeQuery();
                Producto prod = new Producto();
                while (rs3.next()) {

                    prod.setIdProducto(rs3.getInt(1));
                    prod.setDescripcion(rs3.getString(2));
                    prod.setPrecio(rs3.getDouble(3));
                    prod.setExistencia(rs3.getInt(4));

                    prod.setIdcattipoproducto(rs3.getInt(5));

                    Blob image = (Blob) rs3.getBlob(6);
                    if (image != null) {
                        prod.setImagen(image.getBytes(1, (int) image.length()));

                        prod.setBase64Image(Base64.getEncoder().encodeToString(prod.getImagen()));
                    }
                    productos.add(prod);
                }
                // for (Producto prod : productos) {
                WishlistDetalle detalle = new WishlistDetalle();
                detalle.setIdwhislist(wl.getIdwishlist());
                detalle.setProducto(prod.getDescripcion());
                detalle.setSubtotal(prod.getPrecio());
                detalle.setBase64Image(prod.getBase64Image());
                detalle.setCantidad(1);
                WishList.add(detalle);
                //}
            }

            System.out.println("Registros obtenidos correctamente 3");
            conexion.close();
            return WishList;

        } catch (Exception e) {
             
            System.out.println("Registros incorrectos........" + e.getMessage());
            return null;
        }

    }

    public List<WishlistDetalle>  EliminaProductoWishList(int idwhislistProducto,int idUsuario) {

        int estatus = 0;
        List<WishlistDetalle> datos=null;
        try {
            Connection con = getConection();
            String query = "delete from wishlist where idwishlist=?";
            PreparedStatement st = con.prepareStatement(query);

            st.setInt(1, idwhislistProducto);

            estatus = st.executeUpdate();
            System.out.println("Eliminado de la whislist  correctamente");
            datos=ListProductosWishList(idUsuario);
            con.close();
            return datos;

        } catch (SQLException E) {
       
            System.out.println("Error:" + E.getMessage());
            return null;
        }
    }
}

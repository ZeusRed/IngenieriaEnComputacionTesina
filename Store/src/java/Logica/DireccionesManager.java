package Logica;

import Modelo.Direccion;
import Modelo.UsuarioDireccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer ES 15
 */
public class DireccionesManager extends Conexion {

    public List<Direccion> getDirecciones(int idUser) {
        Connection conexion = getConection();
        List<Direccion> direcciones = new ArrayList<>();
        try {
            /**
             * Este es un modulo de prueba
             *
             *
             *
             * String query2 = "select * from direccion";
             *
             * PreparedStatement st2 = conexion.prepareStatement(query2); //
             * st2.setInt(1, udir.getIdDireccion()); ResultSet rs2 =
             * st2.executeQuery();
             *
             * while (rs2.next()) { Direccion dir = new Direccion();
             * dir.setIdDireccion(rs2.getInt(1));
             * dir.setCalle(rs2.getString(2)); dir.setColonia(rs2.getString(3));
             * dir.setCodigoPostal(rs2.getInt(4)); dir.setNumero(rs2.getInt(5));
             * direcciones.add(dir); } return direcciones; *
             *
             */
            //consulta direcciones usuario

            String query = "select * from usuariodireccion where idusuario=?";

            PreparedStatement st = conexion.prepareStatement(query);
            st.setInt(1, idUser);
            ResultSet rs = st.executeQuery();

            List<UsuarioDireccion> usuarioDireccion = new ArrayList<>();

            while (rs.next()) {
                UsuarioDireccion ud = new UsuarioDireccion();
                ud.setIdusuarioDireccion(rs.getInt(1));
                ud.setIdDireccion(rs.getInt(2));
                ud.setIdUsuario(rs.getInt(3));
                usuarioDireccion.add(ud);
            }
            System.out.println("Registros obtenidos correctamente 1");
            //consulta direcciones
            for (UsuarioDireccion udir : usuarioDireccion) {
                String query2 = "select * from direccion where idDireccion=?";

                PreparedStatement st2 = conexion.prepareStatement(query2);
                st2.setInt(1, udir.getIdDireccion());
                ResultSet rs2 = st2.executeQuery();

                while (rs2.next()) {
                    Direccion dir = new Direccion();
                    dir.setIdDireccion(rs2.getInt(1));
                    dir.setCalle(rs2.getString(2));
                    dir.setColonia(rs2.getString(3));
                    dir.setCodigoPostal(rs2.getInt(4));
                    dir.setNumero(rs2.getInt(5));
                    direcciones.add(dir);
                }
            }
            //regresa direcciones
            return direcciones;

        } catch (SQLException e) {
            System.out.println("Error--------->" + e.getMessage());
            return null;
        }

    }

    public int saveDireccion(Direccion direccion, int idUser) {
        int estatus = 0;
        Connection con = getConection();
        try {

            String query = "insert into direccion(calle,colonia,codigoPostal,numero)" + "values(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, direccion.getCalle());
            st.setString(2, direccion.getColonia());
            st.setInt(3, direccion.getCodigoPostal());
            st.setInt(4, direccion.getNumero());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            int idDireccion = 0;
            if (rs.next()) {
                idDireccion = rs.getInt(1);
                System.out.println("Registrado correctamente");
            }
            if (idDireccion != 0) {
                String query2 = "insert into usuarioDireccion(idDireccion,idusuario)" + "values(?,?)";
                PreparedStatement st2 = con.prepareStatement(query2);

                st2.setInt(1, idDireccion);
                st2.setInt(2, idUser);

                estatus = st2.executeUpdate();

                con.close();
                return 1;
            } else {
                con.close();
                return 0;
            }

        } catch (SQLException E) {

            System.out.println("Error:" + E.getMessage());
            return 0;
        }
    }

    public int deleteDireccion(int idDir, int idUser) {
        int estatus = 0;
        try {
            Connection con = getConection();

            String query2 = "delete from usuariodireccion  where idDireccion=? and  idusuario=?";
            PreparedStatement st2 = con.prepareStatement(query2);

            st2.setInt(1, idDir);
            st2.setInt(2, idUser);
            estatus = st2.executeUpdate();

            if (estatus != 1) {
                System.out.println("Direccion Eliminada correctamente");
            } else {
                System.out.println("Direccion noo Eliminada correctamente");
                //eliminar direccion usuario

                String query = "delete from direccion  where idDireccion=?";
                PreparedStatement st = con.prepareStatement(query);

                st.setInt(1, idDir);

                estatus = st.executeUpdate();

                return estatus;
            }

            con.close();
            return estatus;

        } catch (SQLException E) {
            System.out.println("Error al eliminar:" + E.getMessage());
            return 0;
        }
    }
}

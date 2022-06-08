/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.CatTipoUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatTipoUsuarioManager extends Conexion {

    public List<CatTipoUsuario> GetListCatTipoUsuario() {
        List<CatTipoUsuario> lstCatUsuario = new ArrayList<>();
        try {
            Connection con = getConection();
            String query = "select * from cattipousuario ";
            PreparedStatement st = con.prepareStatement(query);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CatTipoUsuario ctu = new CatTipoUsuario();
                ctu.setIdcattipoUsuario(rs.getInt(1));
                ctu.setDescripcion(rs.getString(2));
                lstCatUsuario.add(ctu);
            }
            System.out.println("Registros obtenidos correctamente");
            con.close();

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return null;
        }
        return lstCatUsuario;

    }

    public CatTipoUsuario GetCatTipoUsuario(int id) {
        CatTipoUsuario ctu = new CatTipoUsuario();
        try {
            Connection con = getConection();
            String query = "select * from cattipousuario where idcattipoUsuario=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                ctu.setIdcattipoUsuario(rs.getInt(1));
                ctu.setDescripcion(rs.getString(2));

            }
            System.out.println("Registros obtenidos correctamente");
            con.close();

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return null;
        }
        return ctu;

    }

    public int registrarCatTipoUsuario(CatTipoUsuario ctu) {
        try {
            int estatus = 0;
            Connection con = getConection();
            String query = "insert into cattipousuario(Descripcion)values(?)";
            PreparedStatement st = con.prepareStatement(query);

            st.setString(1, ctu.getDescripcion());
            estatus = st.executeUpdate();
            con.close();
            return estatus;
        } catch (Exception r) {
            return 0;
        }
    }

    public int actualizarCatTipoUsuario(CatTipoUsuario ctu) {
        try {
            int estatus = 0;
            Connection con = getConection();
            String query = "update cattipousuario set Descripcion=? where idcattipoUsuario=? ";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, ctu.getDescripcion());
            st.setInt(2, ctu.getIdcattipoUsuario());
            estatus = st.executeUpdate();
            con.close();
            return estatus;

        } catch (SQLException r) {
            return 0;
        }
    }

    public int borrarCatTipoUsuario(int ctu) {
        try {
            int estatus = 0;
            Connection con = getConection();
            String query = "delete from cattipousuario  where idcattipoUsuario=? ";

            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, ctu);
            estatus = st.executeUpdate();

            con.close();
            return estatus;

        } catch (SQLException E) {
            System.out.println("Error:" + E.getMessage());
            return 0;
        }
    }
}

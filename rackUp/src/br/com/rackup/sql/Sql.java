package br.com.rackup.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Alert;

public class Sql {

    /**
     * Esse Metodo não retorna nenhum resultado
     * @param query
     * @param values
     */
    public boolean executeQuery(String query,ArrayList values) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(query);
            if(!values.isEmpty()){
                int index = 1;
                for (int i = 0; i <= values.size()-1; i++) {
                    stmt.setObject(index, values.get(i));
                    index++;
                }
            }
            stmt.execute();

            return true;

        } catch (SQLException ex) {
//            Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
//            dialogoInfo.setHeaderText("Ocorreu Um erro");
//            dialogoInfo.setContentText(""+ex);
//            dialogoInfo.showAndWait();
            System.out.println("Ex:"+ex);
            return  false;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    /**
     * Esse metodo retorna um arrayList com os dados da tabela buscados pela query
     * @param query
     * @param values
     * @param retorno
     * @return
     */
    public ArrayList executeQuery(String query,ArrayList values,String[] retorno) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(query);
            if(!values.isEmpty()){
                int index = 1;
                for (int i = 0; i <= values.size()-1; i++) {
                    stmt.setObject(index, values.get(i));
                    index++;
                }
            }
            rs = stmt.executeQuery();
            ArrayList arrayRetornado = new ArrayList();
            while(rs.next()){
                ArrayList novo = new ArrayList();
                for (int i = 0; i <= retorno.length-1; i++) {
                    novo.add(rs.getString(retorno[i]));//rs.getObject(retorno[i])

                }
                arrayRetornado.add(novo);
            }

            return arrayRetornado;

        } catch (SQLException ex) {
            Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
            dialogoInfo.setHeaderText("Ocorreu Um erro");
            dialogoInfo.setContentText(""+ex);
            dialogoInfo.showAndWait();
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return null;

    }
}

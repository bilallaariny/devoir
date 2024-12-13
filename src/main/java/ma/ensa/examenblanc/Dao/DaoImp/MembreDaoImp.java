package ma.ensa.examenblanc.Dao.DaoImp;

import ma.ensa.examenblanc.Dao.MembreDao;
import ma.ensa.examenblanc.Incident;
import ma.ensa.examenblanc.Membre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import  ma.ensa.examenblanc.dbConnexion;
import  java.sql.Connection;

public class MembreDaoImp implements MembreDao {
    @Override
    public void insere(Membre m) {
        String sql="INSERT INTO MEMBRE (identifiant,nom,prenom,email,phone) VALUES (?,?,?,?,?)";
        dbConnexion db=new dbConnexion();
        Connection conn=db.getConn();
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, m.getIdentifiant());
            stm.setString(2, m.getNom());
            stm.setString(3, m.getPrenom());
            stm.setString(4,m.getEmail());
            stm.setString(5, m.getPhone());
        }catch (SQLException s){

        }

    }
    @Override
    public List<Incident> chargerListIncidents(){
        String sql="SELECT * FROM INCIDENT";
        dbConnexion db=new dbConnexion();
        Connection conn=db.getConn();
        List<Incident> listincident=new ArrayList<>();
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                listincident.add(new Incident(
                        rs.getString("reference"),
                        rs.getDate("time"),
                        rs.getString("status")
                ));
            }
        }catch(SQLException e){

        }
        return listincident;
    }
}

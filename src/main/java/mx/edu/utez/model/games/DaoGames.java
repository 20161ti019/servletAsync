package mx.edu.utez.model.games;

import mx.edu.utez.model.category.BeanCategory;
import mx.edu.utez.service.ConnectionMySQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class DaoGames {
    private Connection con;
    private CallableStatement cstm;
    private ResultSet rs;
    final private Logger CONSOLE = LoggerFactory.getLogger(DaoGames.class);

    public List<BeanGames> findAll(){
        List<BeanGames> listGames = new ArrayList<>();
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_findGames}");
            rs = cstm.executeQuery();

            while (rs.next()){
                BeanCategory beanCategory = new BeanCategory();
                BeanGames beanGames = new BeanGames();

                beanCategory.setIdCategory(rs.getInt("idCategory"));
                beanCategory.setName(rs.getString("name"));
                beanCategory.setStatus(rs.getInt("status"));

                beanGames.setIdGames(rs.getInt("idGames"));
                beanGames.setName(rs.getString("name"));
                byte[] imgBytes = rs.getBytes("imgGames");
                beanGames.setImgGame(Base64.getEncoder().encodeToString(imgBytes));
                beanGames.setDatePremiere(rs.getString("date_Premiere"));
                beanGames.setStatus(rs.getInt("status"));
                beanGames.setCategory_idCategory(beanCategory);
            }
        }catch (SQLException e){
            CONSOLE.error("Ocurrio un error: " + e.getMessage());
        }finally {
            ConnectionMySQL.closeConnections(con,cstm,rs);
        }
        return listGames;
    }

    public BeanGames findId(long id){
        BeanGames game = null;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("SELECT * FROM games AS g INNER JOIN category AS c ON g.Category_idCategory = c.idCategory WHERE g.idGames = ?");
            cstm.setLong(1,id);
            rs = cstm.executeQuery();

            if (rs.next()){
                BeanCategory category = new BeanCategory();
                game = new BeanGames();

                game.setIdGames(rs.getInt("idGames"));
                game.setName(rs.getString("name"));
                byte[] imgBytes = rs.getBytes("imgGames");
                game.setImgGame(Base64.getEncoder().encodeToString(imgBytes));
                game.setDatePremiere(rs.getString("date_Premiere"));
                game.setStatus(rs.getInt("status"));

                category.setIdCategory(rs.getInt("idCategory"));
                category.setName(rs.getString("name"));
                category.setStatus(rs.getInt("status"));

                game.setCategory_idCategory(category);
            }
        }catch (SQLException e){
                CONSOLE.error("Ocurrio un error: "+e.getMessage());
        }finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return game;
    }

    public boolean create(BeanGames games){
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_create(?,?,?,?)}");
            cstm.setString(1, games.getName());
            cstm.setString(2,games.getImgGame());
            cstm.setString(3,games.getDatePremiere());
            cstm.setInt(4,games.getStatus());
            cstm.execute();
            flag = true;
        } catch (SQLException e) {
            CONSOLE.error("ocurrido un error: " + e.getMessage());
        }finally {
            ConnectionMySQL.closeConnections(con,cstm);
        }
        return flag;
    }

    public boolean update(BeanGames games){
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_update(?,?,?,?)}");
            cstm.setString(1, games.getName());
            cstm.setString(2,games.getImgGame());
            cstm.setString(3,games.getDatePremiere());
            cstm.setInt(4,games.getStatus());
            cstm.execute();
            flag = true;
        } catch (SQLException e) {
            CONSOLE.error("ocurrido un error: " + e.getMessage());
        }finally {
            ConnectionMySQL.closeConnections(con,cstm);
        }
        return flag;
    }

    public boolean delete(long idGames){
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_delete(?)}");
            cstm.setLong(1,idGames);

            flag = cstm.execute();
        } catch (SQLException e) {
            CONSOLE.error("Ocurrio un error: "+ e.getMessage());
        }finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public static void main(String[] args) {
        BeanGames beanGames = new BeanGames();
        BeanCategory beanCategory = new BeanCategory();
        DaoGames daoGames = new DaoGames();

        List<BeanGames> listGames = new ArrayList<>();
        listGames = daoGames.findAll();

        for (int i=0; i<listGames.size();i++){
            System.out.println(listGames.get(i).getName());
        }
    }

}

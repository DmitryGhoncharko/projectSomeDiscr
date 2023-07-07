package by.webproj.carshowroom.model.dao;

import by.webproj.carshowroom.entity.Score;
import by.webproj.carshowroom.model.connection.ConnectionPool;
import lombok.RequiredArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ScoreDao {
    private final ConnectionPool connectionPool;

   public List<Score> showTop50(){
        List<Score> scores = new ArrayList<>();
        try(Connection connection = connectionPool.getConnection(); Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT id, name, scope" +
                    "FROM carshowroom.data " +
                    "ORDER BY scope DESC " +
                    "LIMIT 50;");
            while (resultSet.next()){
                scores.add(new Score(resultSet.getLong("id"),resultSet.getString("name"),resultSet.getLong("scope")));
            }
        }catch (SQLException e){

        }
        return scores;
    }

    public void add(Score score){
       try(Connection connection = connectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("insert into  data(name,scope) values (?,?)")){
           preparedStatement.setString(1,score.getName());
           preparedStatement.setLong(2,score.getScope());
            preparedStatement.execute();
       }catch (SQLException e){

       }
    }
    public Optional<Score> getByName(String name){
       try(Connection connection = connectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("select id, name, scope from carshowroom.data where name = ?")){
           preparedStatement.setString(1,name);
           ResultSet resultSet=  preparedStatement.executeQuery();
           if(resultSet.next()){
               return Optional.of(new Score(resultSet.getLong(1),resultSet.getString(2),resultSet.getLong(3)));
           }
       }catch (SQLException e){

       }
       return Optional.empty();
    }

    public void update(Score score){
       try(Connection connection = connectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("update carshowroom.data set scope = ? where name = ?")){
           preparedStatement.setLong(1,score.getScope());
           preparedStatement.setString(2,score.getName());
           preparedStatement.execute();
       }catch (SQLException e){

       }
    }
}

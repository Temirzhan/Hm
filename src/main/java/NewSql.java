import java.sql.*;
import java.util.List;

public class NewSql {
private Connection connection;
private Statement statement;
private ResultSet rs;
private   String primaryLoad;
private   String updateStr = "insert into Cat(Name, Health, Damage,Satiety) values ('";

    public NewSql(String primaryLoad) {
        this.primaryLoad = primaryLoad;
    }


    public void newConect(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Zoo2.db");
            statement = connection.createStatement();
            statement.execute(primaryLoad);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateSql(Cat cat){
        try {
            statement.executeUpdate(updateStr+cat.getName()+"', "+cat.getHealth()+", "+cat.getDamage()+", "+cat.isSatiety()+");");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateSql(Cat[] cat){
        try {
            for (Cat c:cat) {
                statement.executeUpdate(updateStr+c.getName()+"', "+c.getHealth()+", "+c.getDamage()+", "+c.isSatiety()+");");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close()  {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Cat[] getSql()  {
        List<Cat> catList = null;
    
        try {
            rs =statement.executeQuery("select * from Cat;");
            while (rs.next()) {
                catList.add(new Cat(rs.getString("Name"),rs.getInt("Health"),rs.getInt("Damage")));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
        return rs;
    }

    public void printSql(){
        try {
        while (rs.next()) {

                System.out.println("Cat " + rs.getString("Name")
                        + " Health: " + rs.getInt("Health") + " Damage: " + rs.getInt("Damage") + " Satiety: "+ rs.getBoolean("Satiety" ));


        } } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        close();
    }


}

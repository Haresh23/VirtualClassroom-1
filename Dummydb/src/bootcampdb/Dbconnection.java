package bootcampdb;
import java.sql.*;
public class Dbconnection {

    void tableCreate(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection  con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","TEST","12345");
            Statement	st = con.createStatement();
            String query="create table register(Email_id varchar2(20) primary key,Name varchar2(20),Password varchar2(20),Designation varchar2(10))";
            int result = st.executeUpdate(query);
            con.close();
            System.out.println("Success!	"+result);
        }
        catch(Exception e){
            System.out.println("---------->	"+e);
        }
    }

    public boolean insertTable(Jbeans jb){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection  con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","TEST","12345");
            Statement  st = con.createStatement();
            String query=String.format("insert into register values('%s','%s','%s','%s')",jb.getEmail(),jb.getName(),jb.getPassword(),jb.getDesignation());
            st.executeUpdate(query);
            con.setAutoCommit(true);
            con.close();
            return true;
        }
        catch(Exception e){
            System.out.println("---------->  "+e);
        }
        return false;
    }

    Dbconnection(){

        if(!checkTable()){
            tableCreate();
        }
    }
    boolean checkTable(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection  con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","TEST","12345");
            DatabaseMetaData meta = con.getMetaData();
            ResultSet resultSet = meta.getTables(null, null,"register",null);
            return resultSet.next();
        }
        catch(Exception ee){ System.out.println(ee);
        }
        return	false;
    }

}
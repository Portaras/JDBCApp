import java.sql.*;
import java.io.*;


class TestApp{
    public static void main (String args[])  
    {
        Connection connection=null;
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver Loaded Successfully");
                String url="jdbc:mysql://localhost:3306/octbatch";
                String user="root";
                String password="ARASUars@2788";

                if (connection==null)
                {
                    connection = DriverManager.getConnection(url,user,password);
                    System.out.println("Connection Established Successfully :" + connection.getClass().getName());
                    


                }
            }
        catch (ClassNotFoundException | SQLException ce)
        {
            ce.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                    connection.close();
                    System.out.println("Connection closed Successfully");
            }
            catch (SQLException se)
            {
                se.printStackTrace();
            }

        }
    }
}
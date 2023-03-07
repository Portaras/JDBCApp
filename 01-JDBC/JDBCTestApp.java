import java.sql.*;
import java.io.*;


class TestApp{
    public static void main (String args[])  
    {
        Connection connection=null;
        Statement statement = null;
        ResultSet resultSet = null;
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
                if (connection !=null)
                {
                    statement = connection.createStatement();
                }
                if (statement !=null)
                {
                    String query = "Select sid,sname,sage,saddr from student";
                    resultSet = statement.executeQuery(query);
                }
                if (resultSet!=null)
                {
                    System.out.println ("SID\tSNAME\tSAGE\tSADDRESS");
                    while (resultSet.next())
                    {
                        int sid = resultSet.getInt(1);
                        String sname = resultSet.getString(2);
                        int sage = resultSet.getInt(3);
                        String saddr = resultSet.getString(4);
                        System.out.println(sid+"\t"+sname+"\t"+sage+"\t "+saddr);

                    }
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
package jdbc;

import java.sql.*;

public class postgress {

	public static void main(String[] args)throws Exception
	{
		
        Class.forName("org.postgresql.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb","postgres","tanu@30");
		
		System.out.println("Db connected");
		
		PreparedStatement ps=con.prepareStatement("insert into emp values(2,'sia','sia@gmail.com')");
		ps.executeUpdate();
		System.out.println("record inserted");

	}

}

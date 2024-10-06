package jdbc;
import java.util.*;
import java.sql.*;


public class Registration {

	public static void main(String[] args) throws Exception
	{
		
         Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
		
		System.out.println("Db connected");
		
		Thread t1=new Thread();
		
		Scanner s1=new Scanner(System.in);
		
		PreparedStatement ps2=con.prepareStatement("delete from reg");
		ps2.executeUpdate();
		
		System.out.println("Enter the username");
		String name=s1.next();
		
		t1.sleep(1000);
		System.out.println("Enter the password");
		String pass=s1.next();
		
		t1.sleep(1000);
		System.out.println("Enter the Email");
		String Email=s1.next();
		
		t1.sleep(1000);
		System.out.println("Re-Enter the Email");
		String Re_email=s1.next();
		
		PreparedStatement ps=con.prepareStatement("insert into reg values('"+name+"','"+pass+"','"+Email+"','"+Re_email+"')");
		ps.executeUpdate();
		
		System.out.println("Registration successfull");
		
		System.out.println("-------------------------------------------------------------------------------");
		
		System.out.println("Registration details are:-");
		
		
		
		PreparedStatement ps1=con.prepareStatement("select * from reg");
		ResultSet rs=ps1.executeQuery();
		
		while(rs.next())
		{
			
			System.out.println("username is"+rs.getString("username"));
			
			t1.sleep(1000);
			System.out.println("password is"+rs.getString("password"));
			
			t1.sleep(1000);
			System.out.println("Email is"+rs.getString("email"));
			
			t1.sleep(1000);
			System.out.println("confirm email is"+rs.getString("confirm_email"));
		}

	
	}

}

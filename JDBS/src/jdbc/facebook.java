package jdbc;

import java.sql.*;
import java.util.*;

public class facebook {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");

		System.out.println("Db connected");

		String a, b, c, d, pass;
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the choice");
		choice = sc.nextInt();

		switch (choice) {

		case 1:
			System.out.println("Enter the Username:");
			a = sc.next();
			System.out.println("Enter the Email:");
			b = sc.next();
			System.out.println("Enter the Password:");
			c = sc.next();
			System.out.println("Enter the confirm password:");
			d = sc.next();

			PreparedStatement ps = con.prepareStatement("insert into facebook values('" + a + "' ,'" + b + "','" + c + "','" + d + "')");

			ps.executeUpdate();
			System.out.println("record inserted");

			break;

		case 2:

			System.out.println("----------------------Registration form-----------------------------");
			System.out.println("Enter the Username:");
			a = sc.next();

			PreparedStatement ps1 = con.prepareStatement("select * from facebook where username='" + a + "' ");
			ResultSet rs = ps1.executeQuery();
		
			if (rs.next())
			{
				System.out.println("Username already exist");
			} 
			else 
			{
				System.out.println("Enter the Email:");
				b = sc.next();
				System.out.println("Enter the Password:");
				c = sc.next();
				System.out.println("Enter the confirm password:");
				d = sc.next();

				PreparedStatement ps2 = con.prepareStatement("insert into facebook values('" + a + "' ,'" + b + "','" + c + "','" + d + "')");

				ps2.executeUpdate();
				System.out.println("Registration successfull");

			}

			break;

		case 3:
			String x,y;
			System.out.println("----------------------login page---------------------------------");
			System.out.println("Enter the Email");
			x = sc.next();
			System.out.println("Enter the password");
			y = sc.next();

			PreparedStatement ps2=con.prepareStatement("select * from facebook where email='"+x+"' and pass='"+y+"' ");
		
			ResultSet rs1 = ps2.executeQuery();
			if(rs1.next())
			{
				System.out.println("Login successfull");
			
			} 
			else 
			{
				System.out.println("Forgot your password");
				System.out.println("Enter the new password");
				pass = sc.next();
				PreparedStatement ps3 = con.prepareStatement("update facebook set pass='" + pass + "' where email='" + x + "'");

				ps3.executeUpdate();

				System.out.println("Login successfull");
			}

			System.out.println("-------------------------thank you-----------------------------------");

			break;

		}

	}

}

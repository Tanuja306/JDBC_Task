package jdbc;
import java.sql.*;
import java.util.*;

public class db_connection {

	public static void main(String[] args) throws Exception
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
		
		System.out.println("Db connected");
		
		int choice;
		int a;
		String b,c;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the choice");
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("enter the student id:");
			a=sc.nextInt();
			System.out.println("enter the student name:");
			b=sc.next();
			System.out.println("enter the student email:");
			c=sc.next();
			
			PreparedStatement ps=con.prepareStatement("insert into stud values('"+a+"' ,'"+b+"','"+c+"')");
			
			ps.executeUpdate();
			System.out.println("record inserted");
			
			break;
			
			
		case 2:
			System.out.println("Enter the id");
			a=sc.nextInt();
            PreparedStatement ps1=con.prepareStatement("delete from stud where sid='"+a+"'");
			
			ps1.executeUpdate();
			System.out.println("record deleted");
			
			break;
	
			
		case 3:
			System.out.println("enter the name");
			b=sc.next();
			
			 PreparedStatement ps2=con.prepareStatement("update stud set sname='"+b+"' where sid=2");
				
				ps2.executeUpdate();
				System.out.println("record updated");
				
				break;
			
		
			
	
			
		}
		
		
		
		
		
		

	}

}

import java.rmi.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdditionServer {

	private static Connection conn;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				   
		try{
			System.setSecurityManager(new RMISecurityManager());
						
			Addition Hello = new Addition();
			Naming.rebind("Pro", Hello);
			
			System.out.println("Sunucu haz�r");
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Sunucu hatas�: "+ e);
		}
	}
}

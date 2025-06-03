package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ATM_Simulation_System {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// database connection
		
		final String data_baseUrl="jdbc:mysql://localhost:3306/atm_db";
		final String user_name="root";
		final String pwd="18At1a0415@#";
		
		// to take the input pin from user
		
		Scanner sc= new Scanner(System.in);
		
		
		// connection to mysql_db and validating pin
		try {
		Connection con=DriverManager.getConnection(data_baseUrl,user_name,pwd);
		
	 int attempts= 0;
	 ResultSet res= null;
	 PreparedStatement ps= null;
	 int userid=-1;
	 double balance=0.0;
	 boolean autenticated=false;
	 
	 // Login  attempts max-3 entries
	 
	 while(attempts<3 && !autenticated) {
		 System.out.println("Enter your User ID:");
		 String inputId=sc.nextLine();
		 System.out.println("Enter your 4- digit PIN:");
		 String inputPin=sc.nextLine();
		 
		 ps= con.prepareStatement("SELECT * FROM users WHERE id =? AND pin=?");
		 ps.setString(1,inputId);
		ps.setString(2, inputPin);
		 res=ps.executeQuery();
		 
		 if(res.next()) {
			 userid=res.getInt("id");
			 balance=res.getDouble("balance");
			 autenticated=true;
			 
		 }else {
			 
			 attempts++;
			 if(attempts<3) {
				 System.out.println("Incorrect PIN. Try again");
			 }
		 }
		 
		 if(!autenticated) {
			 System.out.println("⚠️ Access Denied. Too many failed attempts");
			 return;
		 }
		 
		 // user Menu
		 
		 int choice;
		 
		  do {
		    	System.out.println("\n----ATM Menu----");
		    System.out.println("1.Check Balance");
		    System.out.println("2.Deposit Money");
		    System.out.println("3.Withdraw Money");
		    System.out.println("4.Exit");
		    System.out.println("Enter your choice");
		    choice= sc.nextInt();
		    
		    switch(choice) {
		    case 1:
		    	System.out.println("Your current balance is :"+ balance);
		    	break;
		    	
		    case 2:
		    	System.out.println("\n Select Denominations to Deposit");
		    	System.out.println("Number of  ₹100 notes:");
		    	int n100=sc.nextInt();
		    	System.out.println("Number of  ₹200 notes:");
		    	int n200= sc.nextInt();
		    	System.out.println("Number of  ₹500 notes:");
		    	int n500=sc.nextInt();
		    	
		    	double depositAmount= (n100*100)+(n200*200)+(n500*500);
		    	balance+= depositAmount;
		    	updateBalance(con,userid,balance);
		    	System.out.println( depositAmount + "deposited successfully.");
	            break;
		    case 3:
		    	System.out.println("Enter amount to withdraw:");
		    	double withdraw= sc.nextDouble();
		    	if(withdraw<=balance) {
		    		balance-=withdraw;
		    		updateBalance(con,userid,balance);
		    		System.out.println("Withdrawl successful.");
		    		
		    	}else {
		    		System.out.println("Insufficient balance.");
		    	}
		    	break;
		    	
		    case 4:
		    	System.out.println("Thank you for using the ATM.");
		    	break;
		    
		    
		    default:
		    	System.out.println("Invalid choice");
	 }
		 
		  } while(choice!=4);
		  con.close();
		  sc.close();
		  
	 }		 
	 }catch(Exception e) {
		 System.out.println("Database  error:"+ e.getMessage());
	 }
			 
	}
	
	private static void updateBalance(Connection con, int userid, double newBalance)throws SQLException{
		
		PreparedStatement update= con.prepareStatement("UPDATE users SET balance=? where id=?");
		
		update.setDouble(1,newBalance);
		update.setInt(2, userid);
		update.executeUpdate();
	
	}
}


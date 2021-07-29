import java.util.Scanner;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.io.FileWriter;
import java.sql.*;

/**
 * This program is for a structural engineering company called Poised.
 * <p>
 * This program is a project Management System which should be able to:
 * Access and edit a database:
 * Take in new projects
 * Read and edit all existing projects, this includes:
 * updating Customer, Project, Architect and contractor details.
 * Output Invoices, Finalized projects, and all the projects received.
 *
 * 
 * 
 * @author Jrosh
 */

public class Poised {
	public static void main(String [] args) {
		// declare Scanner objects
	    Scanner input = new Scanner(System.in);
	    Scanner inputOne = new Scanner(System.in);
	    Scanner inputTwo = new Scanner(System.in);
	    Scanner inputThree = new Scanner(System.in);
	    Scanner choice = new Scanner(System.in);
	    Scanner inp = new Scanner(System.in);
	    Scanner menuChoice = new Scanner(System.in);
	    // declare objects 
	    structuralEng engineer = null;
	    Project project = null;
	    Customer customer = null;
	    Architect architect = null;
	    ProjectMan manager = null;
	    
    //print out the the menu and options
    System.out.println("Welcome to Poised Project Management.\n");
    System.out.println("Please select an option from the menu below: \n1) Register a new project\n2) Edit an existing project\n3) View incomplete projects\n4) View projects overdue.");
    String choiceOne = menuChoice.next();
    while(!choiceOne.equals("0")) {
    	//create a try block that creates a connection with the server to access database
    	try {	
    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisedpms?useSSL=false","Joshua","PyperMayRoelf");
    		Statement statement = connection.createStatement();
    		ResultSet results;
    		int rowsAffected;

    		if (choiceOne.equals("1")) {
    			//Customer details section
    			System.out.println("Please enter the Customers name: ");
    			String customerName = inp.next();
    			System.out.println("Please enter the Customers surname:  ");
    			String surname = input.next();
    			System.out.println("Please enter the cellphone number: ");
    			int cellNo = inputTwo.nextInt();
    			System.out.println("Please enter the email address: ");
    			String emailAd = inp.next();
    			inp.nextLine();
    			System.out.println("Please enter the physical address of the customer: ");
    			String physAdd = inputOne.nextLine();
    			System.out.println("Please enter the customers ID number: ");
    			String customerId = inputTwo.next();
    			//create the Customer object
    			customer = new Customer(customerName, surname, cellNo, emailAd, physAdd,customerId);


    			System.out.println("What is the name of the Structural Engineer");
    			String name = inputOne.next();
    			System.out.println("What is the Structural Engineers cellphone number?");
    			int cellNum = inputOne.nextInt(); 
    			System.out.println("What is the Structural Engineers email address?");
    			String emailAdd = inputOne.next();
    			System.out.println("Where is the physical address of the Structural Engineer");
    			String physAd = inputThree.next();
    			System.out.println("What is the Id number of the Structural Engineer");
    			String EngID = inputTwo.next();
                //create engineer object
    			engineer = new structuralEng(name, cellNum, emailAdd, physAd, EngID);


    			System.out.println("What is the name of the Architect: ");
    			String nameArchi = input.next();
    			System.out.println("What is the Architects cellphone number: ");
    			int cellNumb = input.nextInt();
    			System.out.println("What is the Architects email address: ");
    			String emailAddr = input.next();
    			input.nextLine();
    			System.out.println("Where is the physical address of the Architect: ");
    			String physAddr = input.nextLine();
    			System.out.println("What is the Id number of the architect");
    			String architectId = inputOne.next();
                //create architect object
    			architect = new Architect(nameArchi, cellNumb, emailAddr, physAddr, architectId);

    			System.out.println("What is the name of the Project Manager: ");
    			String nameMan = inputTwo.next();
    			System.out.println("What is the cellphone number of the Project Manager: ");
    			int cellNumMan = inputThree.nextInt();
    			System.out.println("What is the email address of the Project Manager: ");
    			String emailAddM = input.next();
    			System.out.println("What is the physical address of the Project Manager: ");
    			String physAdM = inputTwo.next();
    			System.out.println("What is the ID of the Project Manager: ");
    			String manID = inputThree.next();
                //create manager object
    			manager = new ProjectMan(nameMan,cellNumMan,emailAddM,physAdM,manID);

    			System.out.println("Please enter the project Name: ");
    			String projName = input.next();
    			System.out.println("Please enter the building type: ");
    			String buildType = input.next();
    			System.out.println("Please enter a project number: ");
    			int projectNo = input.nextInt();
    			System.out.println("Please enter the physical address where the project will take place: ");
    			String physA = inp.next() + inp.nextLine();
    			System.out.println("Please enter the ERF number: ");
    			String erfNo = input.next();
    			input.nextLine();
    			System.out.println("What is the total cost of the build: ");
    			String total = input.next();
    			System.out.println("What is the amount that has been paid up to date?");
    			String amountPaid = inputOne.next();
    			inputOne.nextLine();
    			LocalDate deadLi = dateSetter(input);
    			Date deadLine= java.sql.Date.valueOf(deadLi);
    			String complete = "Incomplete";
    			// initialize project
    			project = new Project(projName, customerId, EngID, architectId, manID, buildType, projectNo, physA , erfNo, Integer.valueOf(total), Integer.valueOf(amountPaid), deadLine,complete);
    			// print out the project object
    			System.out.print("\n"+project + "\n");
                //create a project in the database
    			String sql = "INSERT INTO poised(Project_num,Project_name,Type,Physical_address,Customer_ID,Engineer_ID,Architect_ID,Project_managerID,ERF_num,Total,Amount_Paid,DeadLine,complete) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    			//use PreparedStatement
    			PreparedStatement update = connection.prepareStatement(sql);
    			update.setInt(1, projectNo);
    			update.setString(2, projName);
    			update.setString(3, buildType);
    			update.setString(4, physA);
    			update.setString(5,customerId);
    			update.setString(6,EngID);
    			update.setString(7, architectId);
    			update.setString(8, manID);
    			update.setString(9,erfNo);
    			update.setInt(10, Integer.valueOf(total));
    			update.setInt(11,Integer.valueOf(amountPaid));
    			update.setDate(12, deadLine);
    			update.setString(13,complete);
    			update.execute();

    			results = statement.executeQuery("SELECT * FROM poised");
    			//Print out the query
    			while (results.next()) {
    				
    				System.out.println(results.getInt("Project_num")+ ", " +results.getString("Project_name") +", " +results.getString("Type")+", "+ results.getString("Physical_address")+", "+ results.getString("Customer_ID") + ", " + results.getString("Engineer_ID") + ", " + results.getString("Architect_ID")+", "+ results.getString("Project_managerID")+ ", " + results.getString("ERF_num")+"," + results.getInt("Total")+ ", " + results.getInt("Amount_Paid")+ ", " + results.getDate("Deadline")+", " + results.getString("complete"));
    			
    			}
    		}

    		if (choiceOne.equals("2")) {
    			//access project by project number
    			System.out.println("Please enter the number of the project you would like to edit. Press '0' to exit ");
    			//option to break the loop
    			String number = input.next();
    		    if (number.equals("0")){
    		    	break;
    		    }
    			results = statement.executeQuery("SELECT * FROM poised WHERE Project_Num = '"+number+"'");
    			//check if project number exists
    			if (results.equals(number)) {
    				
	    			while (results.next()) {
	    				
	    				System.out.println(results.getInt("Project_num")+ ", " +results.getString("Project_name") +", " +results.getString("Type")+", "+ results.getString("Physical_address")+", "+ results.getString("Customer_ID") + ", " + results.getString("Engineer_ID") + ", " + results.getString("Architect_ID")+", "+ results.getString("Project_managerID")+ ", " + results.getString("ERF_num")+"," + results.getInt("Total")+ ", " + results.getInt("Amount_Paid")+ ", " + results.getDate("Deadline")+", " + results.getString("complete"));
	    			   
	    			    }
	    			System.out.println("\n\nPlease select one of the following: \n1) To change the deadline. \n2) To change the amount paid. \n3) Update Contractor details \n4) Update Architect details \n5) To mark project as complete and finalize");
	    			String choiceTwo = inputOne.next();
	    			if (choiceTwo.equals("1")) {
	    				
	    				//reopen the projectStream to overwrite the file with the new changes
	    				LocalDate newDeadLi = dateSetter(input);
	    				Date newDeadLine = java.sql.Date.valueOf(newDeadLi);
	    				rowsAffected = statement.executeUpdate("UPDATE poised SET Deadline = '"+newDeadLine+"' WHERE Project_num = '"+number+"'");
	    				System.out.println("Query complete, "+ rowsAffected + " rows updated.");
	    			    
	    			    }
	    			if (choiceTwo.equals("2")) {
	    				//change amount paid
	    				System.out.println("Please enter the amount paid to date: \n");
	    				int newAmount = inputOne.nextInt();
	    				rowsAffected = statement.executeUpdate("UPDATE poised SET Amount_Paid = '"+newAmount+"' WHERE Project_num = '"+number+"'");
	    				System.out.println("Query complete, "+ rowsAffected + " rows updated.");
	    			   
	    			    }
	    			//update contractor details
	    			if (choiceTwo.equals("3")) {
	    				
	    				System.out.println("Please enter the ID number of the Structural Engineer: \n");
	    				String idEng = inputThree.next();
	    				rowsAffected = statement.executeUpdate("UPDATE poised SET Engineer_ID = '"+idEng+"' WHERE Project_num = '"+number+"'");
	    				System.out.println("Query complete, "+ rowsAffected + " rows updated.");
	    			    
	    			    }
	    			//update architect details
	    			if (choiceTwo.equals("4")) {
	    				
	    				System.out.println("Please enter the ID number of the architect: ");
	    				String idAr = inputThree.next();
	    				rowsAffected = statement.executeUpdate("UPDATE poised SET Architect_ID + '"+idAr+"' WHERE Project_num = '"+number+"'");
	    				System.out.println("Query complete, "+ rowsAffected + " rows updated.");
	    			    
	    			    } 
	    			if (choiceTwo.equals("5")) {
	    				//Finalizing task code
	    				System.out.println("Would you like to finalize this task: ");
	    				String choiceFinal = inp.next();
	    				if (choiceFinal.equalsIgnoreCase("yes")) {
	    					System.out.println("Would you like to mark this task as complete: ");
	    					String choiceComp = inputTwo.next() +inputTwo.nextLine();
	    					if(choiceComp.equalsIgnoreCase("yes")) {
	    						System.out.println("Please enter the completion date: ");
	    						String compDate = inputOne.next();
	    						rowsAffected = statement.executeUpdate("UPDATE poised SET complete = '"+compDate+"' WHERE Project_num = '"+number+"'");
	    						System.out.println("Query complete, "+ rowsAffected + " rows updated.");
	    						int due = project.getTotal() - project.getAmountPaid(); 
	    						if (due > 0) {
	    							
	    							customer.invoice(due);
	    						
	    						}else {
	    							
	    							System.out.println("Task finalised");
	    						    
	    						    }
	    					    }
	    				    }
	    			    }
	    			
    			}else {
    				//output error if project number does not exist
    				System.out.println("The project number you have entered does not exist");
    			
    			    }
    		    }
    		if(choiceOne.equals("3")) {
    			//display incomplete projects
    			System.out.println("Incomplete projects: \n");
    			results = statement.executeQuery("SELECT * FROM poised WHERE complete = 'Incomplete'");
    			while (results.next()) {
    				
    				System.out.println(results.getInt("Project_num")+ ", " +results.getString("Project_name") +", " +results.getString("Type")+", "+ results.getString("Physical_address")+", "+ results.getString("Customer_ID") + ", " + results.getString("Engineer_ID") + ", " + results.getString("Architect_ID")+", "+ results.getString("Project_managerID")+ ", " + results.getString("ERF_num")+"," + results.getInt("Total")+ ", " + results.getInt("Amount_Paid")+ ", " + results.getDate("Deadline")+", " + results.getString("complete"));
    			   
    			    }results.close();
    		    }

    		// display the overdue projects using dateSetter method
    		if(choiceOne.equals("4")) {
    			
    			LocalDate current = LocalDate.now();
    			Date currentDate = java.sql.Date.valueOf(current);
    			results = statement.executeQuery("SELECT * FROM poised");
    			System.out.println("Projects overdue: \n");
    			while (results.next()) {
    				int compare = currentDate.compareTo(results.getDate("DeadLine"));
    				if (compare > 0) {
    					
    					System.out.println(results.getInt("Project_num")+ ", " +results.getString("Project_name") +", " +results.getString("Type")+", "+ results.getString("Physical_address")+", "+ results.getString("Customer_ID") + ", " + results.getString("Engineer_ID") + ", " + results.getString("Architect_ID")+", "+ results.getString("Project_managerID")+ ", " + results.getString("ERF_num")+"," + results.getInt("Total")+ ", " + results.getInt("Amount_Paid")+ ", " + results.getDate("Deadline")+", " + results.getString("complete"));
    				    
    				    }
    			    }
    		    }
    		connection.close();
    		statement.close();
    	    }

    	catch(SQLException e) {
    		
    		e.printStackTrace();
    	   
    	    }
    	catch(InputMismatchException e) {
    		
    		System.out.println(e.getMessage());
    		
    	}
    	catch(Exception e) {
    		
    		System.out.println(e.getMessage());
    	
    	    }
        }
	}
	
	/**
	 * Method to get a valid date 
	 * @param input A Scanner input to take in entries of type LocalDate e.g yyyy/mm/dd
	 * 
	 * @return deadLines an of type LocalDate in the form stated above
	 * 
	 */
	//create a static method with return type LocalDate
	public static LocalDate dateSetter(Scanner input) {
		while(true) {
			//declare variables
			LocalDate today = LocalDate.now();
			int curYear = today.getYear();
			int curMonth = today.getMonthValue();
			int curDay = today.getDayOfMonth();
			int yearDueInt = 0;
			int monthDueInt = 0;
			int dayDueInt = 0;
			int daysInMonth = 0;
			
			while(true) {
				System.out.println("Enter the year the project is due: \n");
				yearDueInt = input.nextInt();
				//if year due is less than the current year give error
				if (yearDueInt < curYear) {
					System.out.println("Deadline cannot be in the past.");
				    } else {
				    	break;
					
				    }
			    }
			
			while(true) {
				System.out.println("Please enter the month the project is due: \n");
				monthDueInt = input.nextInt();
				if (monthDueInt == (curYear) && monthDueInt < curMonth) {
					System.out.println("This month has already passed. Invalid date.");
				    }else if (monthDueInt <1 || monthDueInt>12 ) {
				    	
					System.out.println("Please enter a valid month.");
				    } else {
				    	
					break;
				    }
			    }
			//use switch to cycle through cases to decide how many days are in a month
			switch(monthDueInt) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
			    daysInMonth = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				daysInMonth = 30;
				break;
			case 2:
				if((yearDueInt % 4 == 0) && !((yearDueInt %100 ==0) || (yearDueInt % 4 ==0))) 
					daysInMonth = 29;
				else 
					daysInMonth = 28;
					
			        break;
				
			}
		
		 	while (true) {
				System.out.println("Please enter the day the project is due: \n");
				dayDueInt = input.nextInt();
				if (yearDueInt == curYear && monthDueInt == curMonth && dayDueInt <= curDay) {
					System.out.println("Deadline cannot be before the current month"); 
					
				    }else if (dayDueInt > daysInMonth) {
				    	
					System.out.println("Deadline day cannot be greater than there are days in this month");
				    }else {
				    	
					break;
					
				    }
			    }
			//return localDate object
			LocalDate deadLines = LocalDate.of(yearDueInt,monthDueInt,dayDueInt);
			return deadLines;
	
		   }
		}
	}
	
 

   
 
	   

	
	


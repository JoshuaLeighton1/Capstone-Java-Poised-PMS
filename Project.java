import java.sql.*;
import java.time.LocalDate;
import java.util.Date;
/**
 * This class deals with all the details of a project
 * @author Jrosh
 *
 */
//defining a project class

public class Project {
	//attributes
	String projName;
	String buildType;
	int projectNo;
	String physA;
	String erfNo;
	int total;
	int amountPaid;
	Date deadLine;
	String customerId;
	String EngID;
	String architectId;
	String manID;
	String complete;
	LocalDate deadLi;

	
	
	//all the methods
	/*
	 * Create Project object
	 * @param projName project name
	 * @param customerId Customer Identity Number
	 * @param Structural Engineer Identity Number
	 * @param architectId Architect Identity Number
	 * @param buildType Type of Building to be done
	 * @param projectNo The Project number
	 * @param PhysA Physical Address of the project
	 * @param erfNo ERF number
	 * @param total Total cost of the project
	 * @param amountPaid Amount paid to date
	 * @param deadLine Deadline of the project
	 * @param complete Project status
	 * 
	 */
	public Project(String projName, String customerId, String EngID, String architectId, String manID,String buildType, int projectNo, String physA, String erfNo, int total, int amountPaid,Date deadLine, String complete) {

		this.projName = projName;
		this.customerId = customerId;
		this.EngID = EngID;
		this.architectId = architectId;
		this.manID = manID;
		this.buildType = buildType;
		this.projectNo = projectNo;
		this.physA = physA;
		this.erfNo = erfNo;
		this.total = total;
		this.amountPaid = amountPaid;
		this.deadLine = deadLine;
		this.complete = complete;
	    }

	//defining the setters
	
	public void setAmount(int newAmount) {
		amountPaid = newAmount;
		
	    }
	
	public void setDeadLine(Date newDead) {
		deadLine = newDead;
				
	    }
	public void setDeadLi(LocalDate newDead) {
		deadLi = newDead;
	}
	public void setComplete(String comp) {
		complete = comp;
		
	    }
	
	//defining the getters
	public String getComp() {
		return complete;
		
	    }
	
	public LocalDate getDeadli() {
		return deadLi;
	    }
	public Date getDeadLine() {
		return deadLine;
	}
	
	
	public int getAmountPaid() {
		return amountPaid;
		
	    }
	
	public  int getTotal() {
		return total;
		
	    }
	
	public String getCustID() {
		return customerId;
		
	    }
	
	/**
	 * Prints out the project details as a string
	 */
	
	public String toString() {
		String output = "Project Name: " + projName;
		output += "\nID of Client: " + customerId;
		output += "\nID of Contractor: " + EngID;
		output += "\nID of Architect: " + architectId;
		output += "\nID of Project Manager: " + manID;
		output += "\nBuilding Type: " + buildType;
		output += "\nproject number: " + projectNo;
		output += "\nPhysical address of the project: " + physA;
		output += "\nERF Number: "+ erfNo;
		output += "\nTotal Cost: " + total;
		output += "\nAmount paid to date: " + amountPaid;
		output += "\nDeadline: " + deadLine;
		output += "\nComplete: " + complete;
		return output;
		
	    }
	
	 
	public String toDatabase() {
		
		String output = "'"+projectNo+"'";
		output += ",'"+projName+"'";
		output += ",'"+buildType+"'";
		output += ",'"+physA+"'";
		output += ",'"+customerId+"'";
		output += ",'"+EngID+"'";
		output += ",'"+architectId+"'";
		output += ",'"+manID+"'";
		output += ",'"+erfNo+"'";
		output += ",'"+total+"'";
		output += ",'"+amountPaid+"'";
		output += ",'"+deadLine+"'";
		output += ",'"+complete+"'";
		return output;
		
	    }
	

    }

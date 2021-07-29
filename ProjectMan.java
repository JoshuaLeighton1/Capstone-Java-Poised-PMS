
public class ProjectMan {// attributes
	String nameMan;
	int cellNumMan;
	String emailAddM;
	String physAdM;
	String manID;
    /**
     * 
     * @param name Name of Project Manager
     * @param cellNum Cell number of the Project Manager
     * @param emailAdd Email Address of the Project Manager
     * @param physAd Physical Address of the Project Manager
     * @param manId Project Manager Identity number
     */
	public ProjectMan(String nameMan, int cellNumMan, String emailAddM, String physAdM, String manID) {
		this.nameMan = nameMan;
		this.cellNumMan = cellNumMan;
		this.emailAddM = emailAddM;
		this.physAdM = physAdM;
		this.manID = manID;
		
	    }
	
	//defining setters
	
	public void setName(String newName) {
		nameMan = newName;
		
	    }
	 
	public void setCell(int newCell) {
		cellNumMan = newCell;
	    } 
	
	public void setEmailAd(String newEmail) {
		emailAddM = newEmail;
		
	    }
	
	public void setPhysAd(String newAd) {
		physAdM= newAd;
		
	    }
	
	//defining getters
	
	public String getName() {
		return nameMan;
		
	    }
	
	public int getCellNum() {
		return cellNumMan;
		
	    }
	public String toString() {
		String output = "Name: " + nameMan;
		output += "\nCellphone number: " + cellNumMan;
		output += "\nEmail Address: " + emailAddM;
		output += "\nPhysical address : " + physAdM;
		
		return output;
	    }
	public String toFile() {
		String output = nameMan +","+cellNumMan+","+emailAddM+","+physAdM+","+manID;
		return output;
				
	    }


}



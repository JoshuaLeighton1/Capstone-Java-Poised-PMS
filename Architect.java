
/**
 * This Class stores all the information of the Architect Object
 * @author Jrosh
 *
 */

public class Architect {
	// attributes 
	String nameArchi;
	int cellNumb;
	String emailAddr;
	String physAddr;
	String architectId;
	
    /**
     * 
     * @param nameArchi Name of the Architect
     * @param cellNumb Cell number of the Architect
     * @param emailAddr email address of the Architect
     * @param physAddr physical address of the Architect
     * @param architectId Identity number of the Architect
     */
	
	public Architect(String nameArchi, int cellNumb, String emailAddr, String physAddr, String architectId) {
		
		this.nameArchi = nameArchi;
		this.cellNumb = cellNumb;
		this.emailAddr = emailAddr;
		this.physAddr = physAddr;
		this.architectId = architectId;
		
	    }
	// setters and getters
	public void setName(String name) {
		
		nameArchi = name;
		
	    }
	
	public void setEmail(String email) {
		
		emailAddr = email;
	    
	    }
	public void setAddress(String address) {
		
		physAddr = address;
	  
	   }
	public void setCell(int Cell) {
		cellNumb = Cell;
		
	    }
	public String getID() {
		return architectId;
		
	    }
	public String getName() {
		return nameArchi;
		
	    }    
	
	public int getCell() {
		return cellNumb;
	    
	    }
	
	public String getEmail() {
		return emailAddr;
	
	    }
	
    public String toString() {
    	String output = "Name: " + nameArchi;
    	output += "\nCellphone number: " + cellNumb;
    	output += "\nEmail Address: " + emailAddr;
    	output += "\nPhysical Address: " + physAddr;
    	return output;
    	
        }
    
    public String toFile() {
    	String output = nameArchi +","+cellNumb+","+emailAddr+","+physAddr+","+architectId;
    	return output;
    	
        }
	

}
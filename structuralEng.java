
public class structuralEng {
	// attributes
			String name;
			int cellNum;
			String emailAdd;
			String physAd;
			String EngID;
		    /**
		     * 
		     * @param name Name of structural Engineer
		     * @param cellNum Cell number of the structural Engineer
		     * @param emailAdd Email Address of the structural Engineer
		     * @param physAd Physical Address of the structural Engineer
		     * @param EngID structural Engineer Identity number
		     */
			public structuralEng(String name, int cellNum, String emailAdd, String physAd, String EngID) {
				this.name = name;
				this.cellNum = cellNum;
				this.emailAdd = emailAdd;
				this.physAd = physAd;
				this.EngID = EngID;
				
			    }
			
			//defining setters
			
			public void setName(String newName) {
				name = newName;
				
			    }
			 
			public void setCell(int newCell) {
				cellNum = newCell;
			    } 
			
			public void setEmailAd(String newEmail) {
				emailAdd = newEmail;
				
			    }
			
			public void setPhysAd(String newAd) {
				physAd = newAd;
				
			    }
			
			//defining getters
			
			public String getName() {
				return name;
				
			    }
			
			public int getCellNum() {
				return cellNum;
				
			    }
			public String toString() {
				String output = "Name: " + name;
				output += "\nCellphone number: " + cellNum;
				output += "\nEmail Address: " + emailAdd;
				output += "\nPhysical address : " + physAd;
				
				return output;
			    }
			public String toFile() {
				String output = name +","+cellNum+","+emailAdd+","+physAd+","+EngID;
				return output;
						
			    }

		}




/**
 * This class creates three enumerated values; WEAPON, ARMOR and OTHER.
 * @author Zachary Brennan
 */
	public enum ItemType { 
		WEAPON ("WEAPON"), 
		ARMOR ("ARMOR"), 
		OTHER ("OTHER");


		private final String name;

		private ItemType(String s){
			name = s;
		}

		public String toString(){
			return this.name;
		}	
	}

/*This class creates three enumerated values.
 *
 * @author Zachary Brennan
 * @version 09/26/19
 */
	enum ItemType { 
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

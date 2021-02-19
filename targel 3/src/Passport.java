
public class Passport {
		private String name;
		private int passportNum;
		private Date expirtey;
		
		
		public Passport (String name,int passportNum,Date expirtey) {
			setName(name);
			setPassportNum(passportNum);
			this.expirtey=expirtey;
		}
		
		public Date getExpirtey() {
	
			return expirtey;
		}

		public void setExpirtey(Date expirtey) {
			this.expirtey.setDay( expirtey.getDay()); 
			this.expirtey.setMonth( expirtey.getMonth()); 
			this.expirtey.setYear( expirtey.getYear()); 
		

		}

		public String getName(){
			return name;
		}
		
		public void setName (String name) {
			this.name=name;
		}
		
		public int GetPassportNum() {
			return passportNum;
		}
		
		public void setPassportNum(int passportNum) {
			this.passportNum=passportNum;
		}
		
		public boolean isValid(Date CheckDate) {
			if(expirtey.before(CheckDate)) {
				return true;
			}
					
			return false;
			
		}
		
		public void setExpiryDate(Date newDate) {
			expirtey.setDay(newDate.getDay());
			expirtey.setMonth(newDate.getMonth());
			expirtey.setYear(newDate.getYear());
		}
		
		public boolean equals(Passport Other) {
			
			if(this.name.equals(Other.name)&&this.passportNum==Other.passportNum&&this.expirtey.equals(Other.expirtey)) {
				return true;
			}
			return false;
		}
		
		
}


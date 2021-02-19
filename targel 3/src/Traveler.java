
public class Traveler {
	
	protected Passport passport;
	private boolean paid;
	private boolean coronaPatient;


	public Traveler(Passport passport,boolean paid,boolean coronaPatient) {
		this.passport=passport;
		this.paid=paid;
		setCoronaPatient(coronaPatient);
	}
	public Passport getPassport() {
		return passport;
	}
	public boolean getCoronaPatient() {
		return coronaPatient;
	}

	public void setCoronaPatient(boolean coronaPatient) {
		this.coronaPatient = coronaPatient;
	}
	
	public void pay() {
		paid=true;
		if(paid=true) {
			paid();	
		}
		
	}
	
	public boolean paid() {
		return true;
	}
	@Override
	public String toString() {
		String traveler=" "+passport.getName()+" "+passport.GetPassportNum()+" "+passport.getExpirtey().toString()+" "+paid;
		return traveler;
	}
	
	public boolean checkTravel(Date date) {
		if(passport.getExpirtey().before(date)) {
			return true;
		}
		
		return false;
	}
	
	public boolean equals(Traveler Other) {
		if(passport.equals(Other.passport)&&this.paid==Other.paid) {
			return true;
		}
		return false;
	}
}

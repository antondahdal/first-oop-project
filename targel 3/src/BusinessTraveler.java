import java.util.ArrayList;

public class BusinessTraveler extends Traveler implements InstantCheck {
	private Date depatureDate;
	
	public BusinessTraveler(Passport passport,Date depatureDate,boolean status,boolean coronaPatient) {
		super(passport,status,coronaPatient);
		this.depatureDate=depatureDate;
		
	}

	public Date getDepatureDate() {
		return depatureDate;
	}
	@Override
	public boolean checkNow(Trip t) {
		
			if(t.getTo()==Country.Egypt||t.getTo()==Country.China||t.getTo()==Country.France||t.getTo()==Country.Italy
					||t.getTo()==Country.Russia||t.getTo()==Country.USA) {
				return true;
				
			}
		
		return false;

	  }
	@Override
	public boolean isCoronaSafe() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}

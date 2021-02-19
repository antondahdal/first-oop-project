
public class Tourist extends BusinessTraveler{
	private Date arrivalDate;
	private final int maxDays=15;
	private int x;
	private int x1;
	
	public Tourist(Passport passport,boolean status,Date depatureDate,boolean coronaPatient,Date arrivalDate) {
		super(passport,depatureDate,status,coronaPatient);
		x=depatureDate.getDay()-arrivalDate.getDay();
		if(x-maxDays<=maxDays) {
			this.arrivalDate=arrivalDate;
		}
		
		if(arrivalDate.getDay()-depatureDate.getDay()>maxDays) {
			
			 x1=(arrivalDate.getDay()-depatureDate.getDay()-15);
			arrivalDate.setDay(arrivalDate.getDay()-x1);
			this.arrivalDate=arrivalDate;
		}
	}

	public int getX1() {
		return x1;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public int getMaxDays() {
		return maxDays;
	}

	public int getX() {
		return -x;
	}
	
	
	
	
	
}

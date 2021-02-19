import java.util.ArrayList;

public class DemoClass {

	private static final String String = null;

	public static void main(String[] args) throws CantAdd, CoronaWarn {
		// TODO Auto-generated method stub
		TravelAgency TravelAgency = new TravelAgency();

		Plane p=new Plane(200,2,"first plane max travelers");
		Plane p1=new Plane(100,1,"second plan min traelers");

		Trip i=new Trip(p,Country.Australia,Country.Canada);
		Trip io=new Trip(p1,Country.Australia,Country.Canada);
		 
		Date date=new Date(1,2,5);
		Passport passprt1=new Passport("anton",44,date);
		Passport passprt2=new Passport("abdo",44,date);
		Passport passprt3=new Passport("julie",44,date);
		Passport passprt4=new Passport("juliana",44,date);
		Passport passprt5=new Passport("bella",44,date);
		Passport passprt6=new Passport("geris",44,date);
		Traveler t1=new Traveler(passprt1,true,true);
		Traveler t2=new Traveler(passprt2,true,true);
		Traveler t3=new Traveler(passprt3,true,true);
		Traveler t4=new Traveler(passprt4,true,true);
		Traveler t5=new Traveler(passprt5,true,true);
		Traveler t6=new Traveler(passprt6,true,true);
		
		
		io.addTraveler(t1);
		io.addTraveler(t2);
		io.addTraveler(t3);
		io.addTraveler(t6);
		io.addTraveler(t5);
		io.addTraveler(t4);
		io.addTraveler(t6);
 
		i.addTraveler(t1);
		i.addTraveler(t2);
		i.addTraveler(t3);
		i.addTraveler(t4);
	
		i.addTraveler(t6);
		
		TravelAgency.addTrip(i);	
		TravelAgency.addTrip(io);
		System.out.print(TravelAgency.findUnsafeTrips());

		
		TravelAgency.AddTraveler(t1);
		TravelAgency.AddTraveler(t2);
		TravelAgency.AddTraveler(t3);
		TravelAgency.AddTraveler(t4);
		TravelAgency.AddTraveler(t5);
		TravelAgency.AddTraveler(t6);
		
	}
}
	



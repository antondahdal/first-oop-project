import java.util.*;
import java.io.*;
public class TravelAgency implements Serializable,Comparable<TravelAgency>{
	int counter=0;
	private String TravelAgencyName;
	private ArrayList<Traveler> travelers;
	private ArrayList<Trip>trips; 
	public TravelAgency() {
		this.travelers=new ArrayList<Traveler> ();
		this.trips=new ArrayList<Trip>();
		}
	
	public void AddTraveler(Traveler traveler) {
		if(!travelers.contains(traveler)) {
			travelers.add(traveler);
		}
		
		
		
	}
	
	
	public boolean removeTraveler(Traveler traveler) {
		if(travelers.contains(traveler)) {
			travelers.remove(traveler);
			return true;
		}
		else	return false;
	}
	
	public void addTrip(Trip trip) throws CantAdd{
		if(!trips.contains(trip)) {
			trips.add(trip);
		}
		else {
			throw new CantAdd("Can not add this Trip : "+ trip.toString()+ "  becuase it's already exist");
		}
	}
	
	public boolean removeTrip(Trip trip) {
		if(trips.contains(trip)) {
			trips.remove(trip);
			return true;
		}
		else return false;
	}
	
	public boolean addTraveler(Trip trip,Traveler traveler )throws CantAdd {
		if(!trip.getTravelers().contains(traveler)) {
			trip.addTraveler(traveler);
			return true;
		}
		else {
			throw new CantAdd("Can not add the traveler to The Trip ");
			
			
		}
	}
	
	
	public boolean removeTraveler(Trip trip,Traveler traveler) {
		if(trip.getTravelers().contains(traveler)) {
			trip.removeTraveler(traveler);
			return true;
		}
		else return false;
	}
	
	
	public ArrayList<Trip> findUnsafeTrips() throws CoronaWarn{
		ArrayList<Trip>unsafeTrips=new ArrayList<Trip>();
		for(Trip t:trips) {
			if(t.getPlane().isCoronaSafe()==false) {
				unsafeTrips.add(t);
			}
		}
		if(unsafeTrips.size()==trips.size()) {
			throw new CoronaWarn("all the trips unsafe");
		}
		else return unsafeTrips;
	}
	
	public Plane getPlaneWithMaxTrips() {
		int counter=0;
		Plane maxTrips = null;
		ArrayList<Plane>plane=new ArrayList<Plane>();

		for(Trip t:trips) {
			plane.add(t.getPlane());
		}
		for(Plane p:plane) {
			int counter1=Collections.frequency(plane, p);
		if(counter1>counter) {
			counter=counter1;
			maxTrips=p;
		
		}
		}
		
		return maxTrips;
		}
	  
	
	  public ArrayList<Traveler>findRecoveredTravelers() throws CoronaWarn{
		  ArrayList<Traveler> recoverdTravelers=new ArrayList<Traveler>();
		for(Traveler r:travelers) {	
			if(r instanceof BusinessTraveler) {
				BusinessTraveler x=((BusinessTraveler)r);
				for(Trip t:trips) {
					if(x.checkNow(t)&&t.containsTraveler(x) ) {
					recoverdTravelers.add(x);
					}
				}
				
			}
		
		}
		if(recoverdTravelers.size()/travelers.size()<10) {
			throw new CoronaWarn("percentage of recoverd Busniess travelers from corona is under 10%");
		}
		return recoverdTravelers;
}
	
	// targel 6
	public ArrayList<Tourist> getAboveDays (int Other) {
		ArrayList<Tourist> aboveDays=new ArrayList<Tourist>();
		for(Traveler e:travelers) {
			if(e instanceof Tourist) {
				 Tourist e1= (Tourist)e;
				 if(e1.getX()>=Other) {
					 aboveDays.add(e1);	 
				 }
		}
	}
		return aboveDays;
	}

//targel 7
public int businessTravelersBefore(Date Before) {
	
	for(Traveler b:travelers) {
		if(b instanceof BusinessTraveler) {
			BusinessTraveler b1=(BusinessTraveler)b;
		if(b1.getDepatureDate().getYear()<=Before.getYear()) {
			counter++;
			if(b1.getDepatureDate().getYear()==Before.getYear()) {
				if(b1.getDepatureDate().getMonth()<Before.getMonth()) {
					counter++;
				}					
					if(b1.getDepatureDate().getMonth()<Before.getMonth()) {
						if(b1.getDepatureDate().getDay()<=Before.getDay()) {
							counter++;
						}
						
							}
			
								}
			
									}
			
		
										}
	}
	return counter;
}






List<Traveler>getSortedTouristsByName(){
	List<Traveler>sortedByName=new ArrayList<Traveler>();
	Collections.sort(travelers,new Comparator<Traveler>() {
		public int compare(Traveler t1,Traveler t2) {
			return t1.passport.getName().compareTo(t2.passport.getName());
		}
	});
	sortedByName=travelers;
	return sortedByName;

}

List<Trip>getSortedTripsByTravelersCount(){
	List<Trip> travelersCount=new ArrayList<Trip>();
	Collections.sort(trips,new Comparator<Trip>() {
		public int compare(Trip t1,Trip t2) {
		System.out.println("t1 "+ t1.travelers.size()+" t2 "+t2.travelers.size());
			return  Integer.valueOf(t2.travelers.size()).compareTo(t1.travelers.size());
		
		}
	});
travelersCount=trips;	
return travelersCount;
}
static TravelAgency loadTravelerAgencyData()  {
	TravelAgency o1=null;
	FileInputStream fis;
	
		
	try {
		 fis=new FileInputStream("travel_agency.bn");
		ObjectInputStream ois= new ObjectInputStream(fis);
			
		o1=(TravelAgency)ois.readObject();
		fis.close();
		ois.close();
	}
	catch(Exception err) {
		err.printStackTrace();
	}	
		return o1;
	
	}

static void saveTravelAgencyData(TravelAgency tagency) {
	FileOutputStream fos;
	try {
		fos = new FileOutputStream("travel_agency.bn");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(tagency);
		fos.close();
		oos.close();


	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
public void writeTravelersListToFile(List<Traveler>travelers) {
	
	try {
		FileWriter fw=new FileWriter("travelers.txt");
		for(Traveler t:travelers) {
			fw.write(t.toString()+"\n");
		}
		fw.close();
	}
	catch(Exception err) {
		err.printStackTrace();
	}
}
public boolean isThereSharedTravelersTrips(Trip t1,Trip t2) {
	
	return Collections.disjoint(t1.travelers, t2.travelers);
	
}

@Override
public int compareTo(TravelAgency o) {
	// TODO Auto-generated method stub
	return 0;
}


}
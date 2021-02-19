import java.util.*;
public class Trip {
private Plane plane;
private Country from;
private Country to;
ArrayList<Traveler> travelers;
public Trip(Plane plane,Country from,Country to) {
	setPlane(plane);
	setFrom(from);
	setTo(to);
	this.travelers=new ArrayList<Traveler>();
}	
public Plane getPlane() {
	return plane;
}
public void setPlane(Plane plane) {
	this.plane = plane;
}
public Country getFrom() {
	return from;
}
public void setFrom(Country from) {
	this.from = from;
}
public Country getTo() {
	return to;
}
public void setTo(Country to) {
	this.to = to;
}
public ArrayList<Traveler> getTravelers() {
	return travelers;
}

@Override
public String toString() {
	String tripDetails=plane.toString()+" \n"+"from"+this.from+"\n "+"to"+this.to;
	return tripDetails;
}

@Override
public boolean equals(Object other) {
	if(other.getClass().getName()=="Trip") {
		Trip trip=(Trip)other;
		return this.plane.equals(trip.plane)&&this.from.equals(trip.from)&&this.to.equals(trip.to);
	}
	
	return false;
}

public boolean addTraveler(Traveler traveler) {
	if(plane.getCapacity()<200&&travelers.contains(traveler)==false) {
		travelers.add(traveler);
		return true;
	}
	return false;		
}
public boolean removeTraveler(Traveler traveler) {
	if(travelers.contains(traveler)==true) {
		travelers.remove(traveler);
		return true;
	}
	return false;
}

public boolean containsTraveler(Traveler traveler) {
	if(travelers.contains(traveler)) {
		return true;
	}
	else return false;
		
}
}

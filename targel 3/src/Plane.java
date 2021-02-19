
public class Plane implements CoronaSafeable {

private int maxflying;
private int capacity;
private String id;


public Plane(int maxFlying,int capacity,String id) {
	
	setMaxflying(maxFlying);
	setCapacity(capacity);
	setId(id);
}



public void setCapacity(int capacity) {
	this.capacity=capacity;
}

public int getCapacity() {
	return capacity;
}



public int getMaxflying() {
	return maxflying;
}



public void setMaxflying(int maxflying) {
	this.maxflying = maxflying;
}



public String getId() {
	return id;
}



public void setId(String id) {
	this.id = id;
}
@Override
public boolean equals(Object other) {
	if(other.getClass().getName()=="Plane") {
		Plane otherPlane=(Plane)other;
		return this.capacity==otherPlane.capacity&&this.maxflying==otherPlane.maxflying&&this.id.equals(otherPlane.id);
	}
	return false;
}
@Override
public String toString() {
	String planeDetails="plane_id "+this.id+"\n"+"Capacity "+this.capacity+"\n"+"Max Flying height "+this.maxflying+"\n"+"Is Corona safe "
+isCoronaSafe();
	return planeDetails;
}
@Override
public boolean isCoronaSafe() {
	if(maxflying/capacity<=50) {
	return true;
	}
	return false;
}
}

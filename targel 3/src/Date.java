
public class Date implements Comparable<Date> {
protected int day;
protected int month;
protected int year;
String x;

Date(){
	day=1;
	month=1;
	year=2011;
}

public Date(int day,int month,int year) {
	setDay(day);
	setMonth(month);
	setYear(year);


}



public int getDay() {
	return day;
}
public void setDay(int day) {
	if(day>=1&&day<=30) {
		this.day = day;
		}
	else {this.day=1;}
	
}
public int getMonth() {
	return month;
}
public void setMonth(int month) {
	if(month>=1&&month<=12) {
		this.month = month;
	}
	else {
	this.month=1;
	}

	}
	

public int getYear() {
	return year;
}
public void setYear(int year) {
	if(year>=2010) {
		this.year = year;
	}
	else {
		this.year=2011;
	}
	
}

public boolean before(Date Other) {
	if(this.year>Other.year) {
		return true;
	
	}
	if(this.year==Other.year) {
		if(this.month>Other.month) {
			return true;
		}
		else if(this.month==Other.month) {
			if(this.day>Other.day) {
				return true;
			}
			
			}
		else {
			return false;
		}
	}
	
	return false;
}


public String toString() {
	String date= day+" ,"+month+","+year;
	return date;
}

public boolean equals(Date Other) {
	if(this.day==Other.day&&this.month==Other.month&&this.year==Other.year) {
		return true;
	}
	return false;
}

public int diffrenceDays(Date Other) {
	if(this.year<Other.year) {
		int x=Other.year-this.year;
		if(this.month<Other.month) {
			int y=Other.month-this.month;
			
			if(this.day<Other.day) {
				return this.day-Other.day+x*365+y*30;
			}
			else {
				return Other.day-this.day+x*365+y*30;
			}
			
			
		}
		
		else if(this.month>=Other.month) {
			int y=this.month-Other.month;
			if(this.day<Other.day) {
				return this.day-Other.day+x*365+-y*30;
			}
			else {
				return Other.day-this.day+x*365+-y*30;
			}
		}
	}
	
	else if(this.year>=Other.year) {
		int x=this.year-Other.year;
		if(this.month<Other.month) {
			int y=Other.month-this.month;
			
			if(this.day<Other.day) {
				return this.day-Other.day+x*365+y*30;
			}
			else {
				return Other.day-this.day+x*365+y*30;
			}
			
			
		}
		
		else if(this.month>=Other.month) {
			int y=this.month-Other.month;
			if(this.day<Other.day) {
				return this.day-Other.day+x*365+-y*30;
			}
			else {
				return Other.day-this.day+x*365+-y*30;
			}
		}
	}
		
	
	return 0;
}

public Date AddDays(int days) {
	 Date x= new Date((this.day+days),this.month,this.year);
	 return x;
	 }

@Override
public int compareTo(Date o) {
	return this.x.compareTo(o.x);
	
}
}

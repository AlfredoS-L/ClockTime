
public class ClockTime {
	//declaration of instance variables
	private int hour;
	private int minute;
	private int second;
	//default settings 
	public ClockTime() {
		//instance variables initialized to zero
		hour = 0;
		minute = 0;
		second = 0;
	}
	//alternate settings which allocate the
	//seconds accordingly
	public ClockTime(int hours, int minutes, int seconds) {
		//additional variables to add up the proper time
		int min = 0;
		int hr = 0;
		//conditions for seconds
		if (seconds < 0)
			second = 0;
		else {
			second = seconds % 60;
			min = seconds / 60;
		}
		//conditions for minutes
		if (minutes + min < 0)
			minute = 0;
		else {
			minute = (minutes + min) % 60;
			hr = (minutes + min) / 60;
		}
		//conditions for hours
		if (hours + hr < 0)
			hour = 0;
		else
			hour = (hours + hr) % 24;
	}
	//hours setter
	public void setHour(int hours) {
		if (hours < 0)
			hour = 0; //if negative set to zero
		else
			hour = hours % 24;
	}
	//minutes setter
	public void setMinute(int minutes) {
		if (minutes < 0)
			minute = 0; //if negative set to zero
		else
			minute = minutes % 60;
	}
	//seconds setter
	public void setSecond(int seconds) {
		if (seconds < 0)
			second = 0; //if negative set to zero
		else 
			second = seconds % 60;
	}
	//hour getter
	public int getHour() {
		return hour;
	}
	//minute getter
	public int getMinute() {
		return minute;
	}
	//second getter
	public int getSecond() {
		return second;
	}
	//creates a string for 24 hour clock
	public String toString() {
		//formatting the string for leading zeros
        String secP = String.format("%02d", getSecond());
        String minP = String.format("%02d", getMinute());
        String hrP = String.format("%02d", getHour());
		//creating the string that will be returned
        String print = new String (hrP + ":" + minP + ":" + secP);
		return print;
	}
	//creates a string for A.M P.M clock
	public String toString12() {
		
		//formatting the string for leading zeros
        String secP = String.format("%02d", getSecond());
        String minP = String.format("%02d", getMinute());
        String hrAm = String.format("%02d", getHour());
        String hrPm = String.format("%02d", getHour() % 12);
        
		//creating the string that will be returned
        if (getHour() <= 12) {
        	String printAm = new String (hrAm + ":" + minP + ":" + secP + " A.M.");
        	return printAm; //returns AM string
        }
        else {
        	String printPm = new String (hrPm + ":" + minP + ":" + secP + " P.M.");
        	return printPm; //returns PM string
        }
	}
	//takes in an integer variable that adds to the time
	public void advance(int add) {
		//variables that convert times into seconds
		int hourToSec = getHour() * 3600;
		int minToSec = getMinute() * 60;
		int sec = getSecond();
		//holds value for total seconds
		int totalSec = add + hourToSec + minToSec + sec;
		//converting back to seconds
		hour = totalSec / 3600;
		minute = (totalSec % 3600) / 60;
		second = (totalSec % 3600) % 60;
		
	}
	//checks to see if two clocks hold the same value
	public boolean equals(ClockTime clock) {
		//holds value of current times
		int cHr = clock.hour;
		int cMin = clock.minute;
		int cSec = clock.second;
		//returns checked values
		return (hour == cHr && minute == cMin && second == cSec);
	}
}

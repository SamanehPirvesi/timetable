package timetable;

//import java.text.SimpleDateFormat;
//import java.util.Date;

public class Stop implements Comparable<Stop>{
	private String stationName;
	// SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
	// Date date = new Date();

	private int hour;
	private int minute;

	public Stop(String stationName, int hour, int minute) {
		
		this.stationName = stationName;
		this.hour = hour;
		this.minute = minute;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public int compareTo(Stop d) {
		int hourDiffrent=d.getHour();
		if(hour==hourDiffrent) {
			int minuteDiffrent=d.getMinute();
			return  minuteDiffrent-minute;
			
		}
		return hourDiffrent-hour;
	}

}

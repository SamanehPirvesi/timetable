package timetable;

public class Step {
	private String StationNameForStep;
	private int hour;
	private int minute;
	private Path path;

	public Step(String stationNameForStep, int hour, int minute) {
		
		StationNameForStep = stationNameForStep;
		this.hour = hour;
		this.minute = minute;
	}

	public String getStationNameForStep() {
		return StationNameForStep;
	}

	public void setStationNameForStep(String stationNameForStep) {
		StationNameForStep = stationNameForStep;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	
	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public int delay() {
		
		int sum=0;
		for(Stop i:path.getStopStations()) {
		if (StationNameForStep.equals(i.getStationName())) {
			int b=(i.getHour()-this.hour)*60;
			int c=i.getMinute()-this.minute;
			 sum=c+b;
			}
		
		}
		
		return sum;
	}
	
	

}

package timetable;

import java.util.ArrayList;
import java.util.List;

public class Train implements Comparable<Train> {
	private Path path;
	private int year=2018;
	private int month;
	private int day;
	private List<Step> pass=new ArrayList<>();

	

	public List<Step> getPass() {
		return pass;
	}


	public void setPass(List<Step> pass) {
		this.pass = pass;
	}


	public int getMonth() {
		return month;
	}


	public Train(   int month, int day) {
		
		
		
		
		this.month = month;
		this.day = day;
	}

	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMounth() {
		return month;
	}

	public void setMonth(int mounth) {
		this.month = mounth;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}
	
	public void registerStep(String StationName ,int hour , int minute) {
		
		Step step=new Step(StationName , hour ,  minute);
		step.setPath(this.path);
		pass.add(step);
	}


	@Override
	public int compareTo(Train o) {
		int monthDiffrent=o.getMonth();
		if (month==monthDiffrent) {
			int dayDiffrent=o.getDay();
			//accending order
			//return dayDiffrent-day;
			//desending order
			return day-dayDiffrent;
			
		}
		//accending order
		//return monthDiffrent-month;
		//desending order
		return month-monthDiffrent;
		
	}
	
	public boolean arrived() {
		
		String lastStationName=path.getStopStations().get(0).getStationName();
		for(Step step:pass) {
			if(lastStationName.equals(step.getStationNameForStep())) {
				return true;
				
			}
		}
		
		
	return false;
	}
	
	public int maxDelay() {
		//because are maximum delay are minus ex:[-10,-5] result is -10 because the train by 10 minutes late
		int min=0;
			for(Step step:pass) {
				if (min > step.delay()) {
					min=step.delay();
				}
			
		}
		
		return min;
	}
	

	
}

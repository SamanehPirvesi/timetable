package timetable;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Path {
	private String pathCode;
	private String category;
	private String type = "ordinary";
	private List<Stop> stopStations = new ArrayList<>();
	private List<Train> trains = new ArrayList<>();

	public Path(String pathCode, String category) {

		this.pathCode = pathCode;
		this.category = category;

	}

	public List<Stop> getStopStations() {
		Collections.sort(stopStations);
		
		return stopStations;
	}

	public List<Train> getTrains() {
		return trains;
	}

	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}

	public void setStopStations(List<Stop> stopStations) {
		this.stopStations = stopStations;
	}

	public String getPathCode() {
		return pathCode;
	}

	public void setPathCode(String pathCode) {
		this.pathCode = pathCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void addTrain(Train train) {
		this.trains.add(train);
	}

	public void addStation(String stationName, int hour, int minute) {
		Stop stopStation = new Stop(stationName, hour, minute);

		stopStations.add(stopStation);

	}

	public void getStations(String pathcode) {
		if (pathcode.equals(this.pathCode)) {
		Collections.sort(stopStations);
			for (Stop s : stopStations) {
			
				
				System.out.println(s.getStationName() + " " + s.getHour() + " " + s.getMinute());

			}

		}
	}

	public void getTrains(String pathcode) {
		if (pathcode.equals(this.pathCode)) {
			// for (Train t : trains) {
			Collections.sort(trains);

			for (Train temp : trains) {

				System.out.println(temp.getYear() + " " + temp.getMonth() + " " + temp.getDay());
			}
		}
		
		

	}
}

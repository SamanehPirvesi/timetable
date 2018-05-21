import timetable.Path;

import timetable.Stop;
import timetable.TimeTable;
import timetable.Train;

public class TimeTableRun {

	public static void main(String[] args) {

		TimeTable control = new TimeTable();

		control.creatPath("I01", "INTERCITY");
		control.creatPath("I02", "INTERCITY");
		control.creatPath("E01", "EUROSTAR");
		control.creatPath("R10", "REGIONAL");

		control.getPath("I01").addStation("milan", 12, 10);
		control.getPath("I01").addStation("torino", 17, 34);
		control.getPath("I01").addStation("firenze", 19, 34);
		control.getPath("I02").addStation("genova", 19, 30);

		control.newTrain("I01", 8, 28);
		control.newTrain("I01", 6, 12);
		control.newTrain("I02", 8, 29);
		

		control.getPath("I01").getTrains().get(0).registerStep("milan", 12, 20);
		control.getPath("I01").getTrains().get(0).registerStep("torino", 18, 40);
		control.getPath("I01").getTrains().get(0).registerStep("firenze", 19,32);

		control.setOverTime("R10", true);
		int maxDelay=control.getPath("I01").getTrains().get(0).maxDelay();
		System.out.println(Math.abs(maxDelay)+" minutes is the longest delay");
		
		System.out.println(control.getPath("I01").getTrains().get(0).arrived());
		
		System.out.println(control.getPath("I01").getTrains().get(0).getPass().get(1).delay());

		for (Path p : control.getPaths().values()) {

			System.out.println(p.getPathCode() + " " + p.getCategory() + " " + p.getType());
			for (Train t : p.getTrains()) {
				System.out.println(
						p.getPathCode() + " " + p.getCategory() + " " + p.getType() + " " + t.getMonth() + t.getDay());
			}
			for (Stop s : p.getStopStations()) {
				System.out.println(p.getPathCode() + " " + p.getCategory() + " " + p.getType() + " " + s.getHour()
						+ s.getMinute());

			}
		}

		System.out.println("information abut path:");

		for (Train t : control.getPath("I01").getTrains()) {
			System.out.println(control.getPath("I01").getPathCode() + " " + control.getPath("I01").getCategory() + " "
					+ control.getPath("I01").getType() + " " + t.getMonth() + t.getDay());
		}
		for (Stop s : control.getPath("I01").getStopStations()) {
			System.out.println(control.getPath("I01").getPathCode() + " " + control.getPath("I01").getCategory() + " "
					+ control.getPath("I01").getType() + " " + s.getHour() + s.getMinute());

		}
		
		control.getPath("I01").getStations("I01");
		control.getPath("I01").getTrains("I01");

		for (Stop s : control.getPath("I01").getStopStations()) {
			
			
			System.out.println(s.getStationName() + " " + s.getHour() + " " + s.getMinute());

		}
	
	}
	
	
	
}

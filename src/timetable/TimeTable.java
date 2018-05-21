package timetable;



import java.util.Map;
import java.util.TreeMap;

public class TimeTable {

	private Map<String, Path> paths = new TreeMap<>();

	
	public TimeTable() {

	}

	public Map<String, Path> getPaths() {
		return paths;
	}

	public void setPaths(Map<String, Path> paths) {
		this.paths = paths;
	}

	public void creatPath(String pathcode, String category) {
		Path path = new Path(pathcode, category);
		paths.put(pathcode, path);
	}

	

	public void newTrain(String pathCode, int month, int day) {

		Train train = new Train(month, day);
		Path p1=paths.get(pathCode);
		if (p1!=null) {
			p1.addTrain(train);
			train.setPath(p1);
		}

	}

	public boolean isOverTime(String pathCodeForOverTime) {

		boolean isordinary = false;
		if (paths.get(pathCodeForOverTime).getType() == "overtime") {
			isordinary = true;
		}
		return isordinary;
	}

	public void setOverTime(String pathCodeOverTime, boolean typeOfPathForOverTime) {
		if (typeOfPathForOverTime == true) {

			paths.get(pathCodeOverTime).setType("overtime");

		}
	}

	public Path getPath(String code) {
		return paths.get(code);
	}



	

}

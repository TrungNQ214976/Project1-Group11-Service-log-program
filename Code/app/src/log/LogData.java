package log;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class LogData {
	private ArrayList<Log> data;
	
	public LogData(ArrayList<Log> log) {
		data = log;
	}
	
	public ArrayList<String> getKeys(){
		if(data == null) {
			return null;
		}
		return data.get(0).getAllField();
	}
	
	
	public ArrayList<Log> filterByDate(LocalDateTime dateTime) {
		return null;
	}
	
	public ArrayList<Log> filterByIpAddress(String ipString, int significant) {
		return null;
		
	}
}
package dataio;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Test {
	public static void main(String[] args) {
		DataProcess dataProcess = new DataProcess("../data/iptables.log");
		dataProcess.readLogFile();
		JSONObject jsonData =  dataProcess.analyse();
		System.out.println(dataProcess.getLines().get(0));
		System.out.println(dataProcess.getLines().get(73));
		dataProcess.writeToFile(jsonData);
	}
}

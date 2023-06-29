package dataio;

import java.io.*;
import java.util.*;
import org.json.simple.JSONObject;

public class DataProcess {
	private String filePath;
	private StringBuilder data = new StringBuilder("");
	private int nW = 0;
	private ArrayList<String> lines;
	
	public ArrayList<String> getLines() {
		return lines;
	}

	public DataProcess(String filePath) {
		this.filePath = filePath;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public StringBuilder getData() {
		return data;
	}
	
	//	Read file
	public String readLogFile() {
		FileReader file;
		data = new StringBuilder(""); 
		try {
			file = new FileReader(filePath);
			BufferedReader reader = new BufferedReader(file);
			
			String string; 
			while((string = reader.readLine()) != null) {
				if(string.contains("iptables: ")) {					
					data.append(string.replace("  ", " ")+"\n");
				}
			}
			System.out.println("Read successfully!");
			reader.close();
			return data.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean writeToFile(StringBuilder dataStringBuilder) {
		try {
			FileWriter file = new FileWriter("../data/log_"+String.valueOf(nW++)+".txt");
			BufferedWriter writer = new BufferedWriter(file);
			writer.write(dataStringBuilder.toString());
			System.out.println("Write successfully!");
			writer.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean writeToFile(JSONObject jsonData) {
		try {
			FileWriter file = new FileWriter("../data/log_"+String.valueOf(nW++)+".json");
			BufferedWriter writer = new BufferedWriter(file);
			writer.write(jsonData.toString());
			System.out.println("Write successfully!");
			writer.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	

	private JSONObject analyseLine(int i) {
		
		JSONObject jsonObject = new JSONObject();
		
//		Jun  6 15:33:38 trungserver kernel: [ 5831.690568] iptables: IN=ens33 OUT= MAC=00:0c:29:85:59:5c:00:50:56:c0:00:08:08:00 SRC=192.168.17.1 DST=192.168.17.128 LEN=76 TOS=0x00 PREC=0x00 TTL=128 ID=14219 DF PROTO=TCP SPT=56326 DPT=22 WINDOW=513 RES=0x00 ACK PSH URGP=0
		String[] line = lines.get(i).split(" ");
		jsonObject.put("date", String.join(" ", line[0],line[1],line[2]));
		jsonObject.put("host", line[3]);
		jsonObject.put("time from boot", String.join(" ", line[5], line[6]));
		jsonObject.put("firewallRuleName", line[7]);
		
		for (int j = 8; j < line.length; j++) {
			String[] subStrings =  line[j].split("=");
			if(subStrings.length == 1) {
				if(subStrings[0].equals("OUT")) {
					jsonObject.put(subStrings[0], "false");
				} else {					
					jsonObject.put(subStrings[0], "true");
				}
			} else {
				jsonObject.put(subStrings[0], subStrings[1]);
			}
			System.out.println(subStrings[0]);
		}
		return jsonObject;
	}
	
	public JSONObject analyse() {
		toArrayList();
		JSONObject jsonData = new JSONObject();
		for (int i = 0; i < lines.size(); i++) {
			jsonData.put("ID"+String.valueOf(i), analyseLine(i));
		}
		return jsonData;
	}
	
	private void toArrayList() {
		lines = new ArrayList<String>(Arrays.asList(data.toString().split("\n")));
	}
	
}
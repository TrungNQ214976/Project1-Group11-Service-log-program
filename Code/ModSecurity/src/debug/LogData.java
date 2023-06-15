package debug;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class LogData {
    static String Attackname= Process.getAttack();
    static String Time = Process.getDate();
    static String Msg = Process.getMsg();



    static JsonElement extractLog(Process process) {
        JsonObject logObject = new JsonObject();
        logObject.addProperty("Attackname",Process.getAttack());
        logObject.addProperty("Time",Process.getDate());
        logObject.addProperty("Msg",Process.getMsg());

        return logObject;
    }

}



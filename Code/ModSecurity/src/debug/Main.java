package debug;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader reader;
        JsonArray jsonObject = new JsonArray();
        int count = 1;
        try {
            reader = new BufferedReader(new FileReader("/home/dumi/IdeaProjects/test2/src/debug/log"));
            String line = reader.readLine();

            while (line != null) {
                Process process = new Process(line);
                jsonObject.add(LogData.extractLog(process));
                count ++;
                // read next line
                line = reader.readLine();

            }
            reader.close();
            //System.out.println(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(jsonObject);
            FileWriter myWriter = new FileWriter("/home/dumi/IdeaProjects/test2/src/debug/debug.json");
            //myWriter.write("[");
            myWriter.write(String.valueOf(json));
            //myWriter.write("]");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Reader reader1 = Files.newBufferedReader(Paths.get("/home/dumi/IdeaProjects/test2/src/debug/debug.json"));

        // convert JSON array to list of users
        List<Log> users = new Gson().fromJson(jsonObject, new TypeToken<List<Log>>() {}.getType());
        ArrayList<String> attacktype = new ArrayList<>();
        for (int k =0 ; k<count-1; k++){
            if(users.get(k) != null){
                if (!(attacktype.contains(users.get(k).Attackname)) ) {
                    attacktype.add(users.get(k).Attackname);
                }
            }else break;

        }
        GetAttack(users, "REQUEST-941-APPLICATION-ATTACK-XSS");
    }
    static Log GetAttack(List<Log> users, String Attackname){
        for (int i = 0 ; i<users.size() ; i++){
            if ((users.get(i).Attackname).equals(Attackname)){
                System.out.println(users.get(i).Attackname);
                System.out.println(users.get(i).Time);
                System.out.println(users.get(i).Msg);
            }
        }

        return null;
    }
}






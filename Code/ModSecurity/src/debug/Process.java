package debug;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Process {
    private static String line;
    static Pattern getPattern_for_msg = Pattern.compile("[msg]+ [\\\"]+.*]");
    static Pattern pattern_for_attack = Pattern.compile("\\[file \".+\\/(.*?).conf\"\\]");
    static Pattern pattern_for_date = Pattern.compile("(?:(?:0[1-9])|(?:[12][0-9])|(?:3[01])|[1-9])\\/\\b(?:Jan(?:uary)?|Feb(?:ruary)?|Mar(?:ch)?|Apr(?:il)?|May|Jun(?:e)?|Jul(?:y)?|Aug(?:ust)?|Sep(?:tember)?|Oct(?:ober)?|Nov(?:ember)?|Dec(?:ember)?)\\b\\/(?>\\d\\d){1,2}\\:(?:2[0123]|[01]?[0-9]):(?:[0-5][0-9]):(?:(?:[0-5]?[0-9]|60)(?:[:.,][0-9]+)?)");
    public Process(String line) {
        Process.line = line;
    }


    static String getAttack(){
        Matcher matcherAttack = pattern_for_attack.matcher(line);
        matcherAttack.find();
        return matcherAttack.group(1);
    }
    static String getDate(){
        Matcher matcherDate = pattern_for_date.matcher(line);
        matcherDate.find();
        return matcherDate.group();
    }
    static String getMsg(){
        Matcher matcherMsg = getPattern_for_msg.matcher(line);
        matcherMsg.find();
        return matcherMsg.group();
    }
}


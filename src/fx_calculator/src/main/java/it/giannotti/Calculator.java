package it.giannotti;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static String calculate(String operation) throws ScriptException {
        final String regex = "[\\d\\+\\*\\-\\/\\^\\(\\)\\[\\]\\{\\}E\\.]";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(operation);
        operation = "";
        while(matcher.find()) {
            for(int i = 0;i <= matcher.groupCount();i++) {
                operation += matcher.group(i);
            }
        }
        operation = operation.replace("^", "**");

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
        return engine.eval(operation).toString();
    }

}

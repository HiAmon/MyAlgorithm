package od;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class HJ50 {
    public static void main(String[] args) {


        Scanner scan = new  Scanner(System.in);
        String input = scan.nextLine();
        input = input.replace("[","(");
        input = input.replace("{","(");
        input = input.replace("}",")");
        input = input.replace("]",")");
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            System.out.println(scriptEngine.eval(input));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}

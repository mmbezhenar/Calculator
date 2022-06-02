package org.example;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;


public class Calculator {
    public static void main(String[] args) {
        //((1+2*9))
        try {
            calculate(input());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Object calculate(String input) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = null;
        try {
            result = engine.eval(input);
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
        return result;
    }


    public static String input() {
        String value;
        try(Scanner in = new Scanner(System.in)) {
            value = in.nextLine();
        }

        try {
            return checkBrackets(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static String checkBrackets(String value) {
        int countOpenBrackets = 0;
        int countClosedBrackets = 0;
        for(int i = 0; i< value.length(); i++){
            String[] strings = value.split("");
            if(strings[i].contains("(")) {
                countOpenBrackets++;
            } else if (strings[i].contains(")")) {
                countClosedBrackets++;
            }
        }

        if(countClosedBrackets == countOpenBrackets){
            return value;
        }
        else{
            try {
                throw new Exception("Number of open-closed brackets should be equals");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


}

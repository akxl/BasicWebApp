package com.develogical;

import java.util.ArrayList;
import java.util.List;

public class QueryProcessor {

    public String process(String query) {

        System.out.println("The query is: " + query);

        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("jedi")) {
            return "The jedi think that they are cool. Also, they fight the sith.";
        }
        if (query.toLowerCase().contains("what is your name")) {
            return "naughtiest-maximus";
        }
        if (query.toLowerCase().contains("which of the following numbers is the largest:")) {
            String numbers;

            numbers = query.toLowerCase().split(":")[2];
            String[] numberList = numbers.split(",");
            Integer maximum = -9999;
            for (String string : numberList) {
                if (Integer.parseInt(string.trim()) > maximum) {
                    maximum = Integer.parseInt(string.trim());
                }
            }

            return maximum.toString();

        }
        if (query.toLowerCase().contains("plus")) {
            String[] numerList = query.split(" ");
            Integer sum = 0;
            for(int i=0; i<numerList.length; i++){
                if(numerList[i].matches("\\d+")){
                    sum += Integer.parseInt(numerList[i]);
                }
            }
            return sum.toString();
        }


        return "";
    }
}

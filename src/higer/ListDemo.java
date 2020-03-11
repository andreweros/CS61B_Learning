package higer;

import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class ListDemo {

    public static List<String> getWords(String inputFileName) throws IOException {
        List<String> lst = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new FileReader(inputFileName));
        String str;
        while ((str = in.readLine()) != null) {
            lst.add(str); //optionally, define a cleanString() method that cleans the string first.
        }
        return lst;
    }

    public static int countUniqueWords(List<String> words) {
        Set<String> ss = new HashSet<>();
        for (String s : words) {
            ss.add(s);
        }
        return ss.size();
    }


    public static void main(String[] args) throws IOException {
        List<String> words = getWords("src/higer/in.txt");

        List<String> targets = new ArrayList<>();
        targets.add("lottery");

        System.out.println(countUniqueWords(words));
    }
}

package qaqources.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        String[] langs = new String[4];
        langs[0] = "Phyton";
        langs[1] = "Java;";
        langs[2] = "C#";
        langs[3] = "JavaSkript";

        String[] langSecond = {"Phyton", "Java;", "C#", "JavaSkript", "Angular"};

        //1 sposob wyswietlenia wszystkich elementow tablicy
        for (int i = 0; i < langs.length; i++) {
            System.out.println("To jest element tablicy " + langs.length);
            System.out.println("To jest element tablicy1 " + langs[i]);
        }
        //2 sposob wyswietlenia wszystkich elementow tablicy
        for (String l : langs) {
            System.out.println("Element tablicy wyswielany w prostszy sposob2 " + l);
        }
        List<String> languages=new ArrayList<>();
        languages.add("Java test");
        languages.add("Phyton test");
        languages.add("C# test");
        languages.add("JavaSkript test");

        //3 sposob wyswietlenia wszystkich elementow listy
        for(int i=0;i<languages.size();i++){
            System.out.println("To jest element listy3 "+languages.get(i));
        }
        //4 sposob wyswietlenia wszystkich elementow listy
        for(String l:languages){
            System.out.println("To jest element listy test4 "+l);
        }
        //5 zmiana na liste typu tablica
        List<String> languagesArray= Arrays.asList("Java test","Phyton test","C# test","JavaSkript test");

        for(String l:languagesArray){
            System.out.println("To jest element listy test5 "+l);
        }

    }
}

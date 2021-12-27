package upperCase;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class UpperCase {
    /*
    Method that invoke a scanner object and ask for the word that will get upper case
     */
    private static String getTextFromUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce the text to make it upper case");
        return sc.nextLine();
    }
    /*
    Method that pass the inputText to the child class
     */
    private static void parsingInputText(OutputStreamWriter osw, String inputText){
        PrintWriter pw = new PrintWriter(osw);
        pw.print(inputText);
        pw.close();
    }

    public static void main(String[] args) throws IOException {
        String inputText = getTextFromUser();
        //Calling to child class
        Process pr = Runtime.getRuntime().exec("java upperCase.UpperCaseChild ");

        OutputStream os = pr.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        //Giving the text to uppercase to the child class
        parsingInputText(osw, inputText);

        BufferedReader reader = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        String line = reader.readLine();
        System.out.println(line);
        reader.close();
    }
}

package randoms;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Objects;
import java.util.Scanner;

public class randoms {
    private static String inputUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce enter to continue or fin to close the app");
        return sc.nextLine();
    }

    public static void main(String[] args) {
        boolean flag = true;

        try{
            while (flag){
                if (Objects.equals(inputUser(), "")){
                    Process pr = Runtime.getRuntime().exec("java randoms.randomsChild ");
                    OutputStream os = pr.getOutputStream();
                    System.out.println(os);

                }if (Objects.equals(inputUser(), "fin")){
                    flag = false;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

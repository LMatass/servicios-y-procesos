package randoms;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;

public class randomsChild {
    private static int randomNumber(){
        Random rand = new Random();
        return rand.nextInt(10);
    }

    public static void main(String[] args) {
        System.out.println(randomNumber());
    }


}

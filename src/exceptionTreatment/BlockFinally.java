package exceptionTreatment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BlockFinally {
    public static void main(String[] Args){

        File file = new File("C:\\Projects\\Java\\Java_course\\exceptionTreatment\\in.txt");
        Scanner sc = null;

        try{
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Error opening file: " + e.getMessage());
        }

        finally{
            if(sc != null){
                sc.close();
            }
            System.out.println("Finally block executed.");
        }


    }
}

package com.company;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class WorkingWithFiles {

    public static void main(String[] args)
    {
        try {

            // If movies does not exist no file is  created, if movies
            // does exist then the new File object points to the existing
            // file
            File file = new File("movies");
            file.createNewFile();

            //write some data to the file
            PrintWriter pw = new PrintWriter(file);

            Scanner keyboard = new Scanner(System.in);
            System.out.print("Enter the name of your favorite movies.");
            System.out.println("Press 'q' to quit:");
            String result = keyboard.nextLine();
            if (!result.equals("q")){
                pw.println(result);
            }

            while(!result.equals("q"))
            {
                result = keyboard.nextLine();
                pw.println(result);
            }
            pw.flush();
            pw.close();

            //read our file
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ( (line = br.readLine())!= null)
            {
                System.out.println(line);
            }
            br.close();


        } catch (IOException e) {
            System.out.println("Oops! An error occurred.");
        }
    }
}

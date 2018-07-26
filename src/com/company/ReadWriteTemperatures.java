package com.company;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class ReadWriteTemperatures {

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String result;

        try {

            File file = new File("temperatures");
            file.createNewFile();

            PrintWriter pw = new PrintWriter(file);

            for (int i=1; i <= 15; i++)
            {
                System.out.print("Enter a temperature:");
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
        } finally {
            keyboard.close();
        }
    }
}

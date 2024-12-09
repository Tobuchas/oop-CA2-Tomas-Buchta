package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Name:
 * Class Group:
 */
public class Question5
{    //Java Identifier Count (Map)

    public static void readFile(String fileName) throws IOException
    {
        HashMap<String, Integer> identifierCountMap = new HashMap<>();
        HashMap<String, ArrayList<String>> mapOfLines = new HashMap<>();

        File inputFile = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;
        int lineCount = 0;

        while ((line = reader.readLine()) != null)
        {
            lineCount++;
            //Splitting text into identifiers
            String[] split = line.split("[^A-Za-z0-9_]+");

            for (String identifier : split)
            {
                //First instance of
                if (identifierCountMap.get(identifier) == null)
                {
                    identifierCountMap.put(identifier, 0);
                    ArrayList<String> arrayList = new ArrayList<>();
                    mapOfLines.put(identifier, arrayList);
                }

                identifierCountMap.put(identifier, identifierCountMap.get(identifier) + 1);
                mapOfLines.get(identifier).add(lineCount + ". " + line);
            }
        }

        for (String identifier : identifierCountMap.keySet())
        {
            //Removing empty identifiers
            if (!identifier.equals(""))
            {
                System.out.println("'" + identifier + "' " + identifierCountMap.get(identifier));
                for (String lineWithId : mapOfLines.get(identifier))
                {
                    System.out.println(lineWithId);
                }
            }
        }
        reader.close();
    }

    public static void main(String[] args) throws IOException
    {
        readFile("src/main/java/org/example/Question2.java");
    }
}

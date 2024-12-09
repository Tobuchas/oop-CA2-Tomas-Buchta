package org.example;

import java.io.*;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Name:
 * Class Group:
 */
public class Question3
{   //Nested HTML (Stack)

    /*
filename: name of the file to test.
*/
    public static boolean validate(String filename) throws IOException
    {
        Stack<String> stack = new Stack<>();


        File inputFile = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String html = "";
        String line;
        while ((line = reader.readLine()) != null)
        {
            html = html + line;
        }
        reader.close();


        System.out.println(html);

        Pattern pattern = Pattern.compile("<(/?[A-Za-z]*)>");
        Matcher matcher = pattern.matcher(html);

        while (matcher.find())
        {
            String tag = matcher.group(1).toLowerCase();
            System.out.println("Tag: " + tag);
            printStack(stack);
            if (tag.startsWith("/"))
            {
                //end of tag
                if (stack.empty()) return false;
                if (!tag.equals("/" + stack.peek())) return false;
                stack.pop();
            }
            else
            {
                if (!tag.equals("br"))
                {
                    //start of tag
                    stack.push(tag);
                }
            }
        }
        return stack.empty();
    }

    private static void printStack(Stack<String> stack)
    {
        for (String tag : stack)
        {
            System.out.print(tag + ",");
            System.out.println();
        }
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws IOException
    {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for (String fName : files)
        {
            System.out.print(fName + ": ");
            if (validate(fName))
            {
                System.out.println("This file is valid");
            }
            else
            {
                System.out.println("This file is invalid");
            }
        }
    }


}



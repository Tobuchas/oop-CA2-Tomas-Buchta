package org.example;

import java.util.Scanner;
import java.util.Stack;

/**
 * Name:
 * Class Group:
 */
public class Question2  // Car Parking - Stack
{
    public static void runSimulation()
    {
        Stack<Integer> street = new Stack<>();
        Stack<Integer> driveway = new Stack<>();

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.print("Write number: ");
            int input = scanner.nextInt();
            if (input == 0) break;
            if (input > 0)
            {
                driveway.push(input);
                System.out.println("Driveway");
                printStack(driveway);
            }
            if (input < 0)
            {
                int car = -input;
//                System.out.println("Driveway");
//                printStack(driveway);
//                System.out.println("Street");
//                printStack(street);
//                System.out.println("cars out");
                while (!driveway.empty() && driveway.peek() != car)
                {
                    Integer carOut = driveway.pop();
                    street.push(carOut);
                }
//                System.out.println("Driveway");
//                printStack(driveway);
//                System.out.println("Street");
//                printStack(street);
//                System.out.println("car out");
                if (!driveway.empty())
                {
                    driveway.pop();
                }
                else
                {
                    System.out.println("404: Car not found");
                }
//                System.out.println("cars back");
                while (!street.empty())
                {
                    Integer carOut = street.pop();
                    driveway.push(carOut);
                }
                System.out.println("Driveway");
                printStack(driveway);
//                System.out.println("Street");
//                printStack(street);

            }
        }
    }

    private static void printStack(Stack<Integer> driveway)
    {
        for (Integer car : driveway)
        {
            System.out.print(car + ",");
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        runSimulation();
    }
}

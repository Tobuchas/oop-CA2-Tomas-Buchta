package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Name:
 * Class Group:
 */
public class Question7  // Shares Tax Calculations (Queue)
{

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        Queue<Share> shares = new LinkedList<>();
        Share current = null;
        double totalGain = 0;
        String command = "";
        System.out.println("Welcome to the Shares");
        System.out.println("Commands:\n'buy' (qty) (price)\n'sell' (qty) (price)\n'quit");
        do
        {
            System.out.print(">");
            command = in.next();
            if (command.equalsIgnoreCase("buy"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
                shares.add(new Share(qty, price));
                System.out.println("Gained " + qty + " shares.");
            }
            else if (command.equals("sell"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
                if (current == null)
                {
                    current = shares.poll();
                }
                int toBeSold = qty;
                double gain = 0;
                while (toBeSold > 0)
                {
                    if (current.getQuantity() <= toBeSold)
                    {
                        toBeSold = toBeSold - current.getQuantity();
                        gain = gain + current.getQuantity() * (price - current.getPrice());
                        if (shares.isEmpty()) break;
                        current = shares.poll();
                    }
                    else
                    {
                        current.setQuantity(current.getQuantity() - toBeSold);
                        gain = gain + toBeSold * (price - current.getPrice());
                        toBeSold = 0;
                    }
                }
                System.out.println("Gain of trade is: " + gain);
                totalGain = totalGain + gain;
            }
        }
        while (!command.equalsIgnoreCase("quit"));
        System.out.println("Total gain is: " + totalGain);
    }
}
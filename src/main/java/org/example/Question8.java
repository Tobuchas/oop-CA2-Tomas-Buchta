package org.example;

import java.util.*;

/**
 * Name:
 * Class Group:
 */
public class Question8  // Multi-company (Queue)
{
    /*
   Will repeatedly ask the user to enter the commands in the format
   buy company qty price
   or
   sell company qty price
   or
   quit
    */
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        String command = "";
        double totalGain = 0;
        Map<String, Queue<Share>> shares = new HashMap<>();

        System.out.println("Welcome to the Shares");
        System.out.println("Commands:\n'buy' (company) (qty) (price)\n'sell' (company) (qty) (price)\n'printall'\n'print' (company)\n'quit'");
        do
        {
            System.out.print(">");
            command = in.next();
            if (command.equalsIgnoreCase("buy"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();

                if (shares.get(company) == null)
                {
                    shares.put(company, new LinkedList<>());
                }
                shares.get(company).add(new Share(qty, price));
            }
            else if (command.equals("sell"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                Queue<Share> shareQueue = shares.get(company);
                if (shareQueue == null)
                {
                    System.out.println("Cannot sell shares you do not have!");
                    continue;
                }
                int toBeSold = qty;
                double gain = 0;
                while (toBeSold > 0)
                {
                    Share current = shareQueue.peek();
                    if (current.getQuantity() <= toBeSold)
                    {
                        toBeSold = toBeSold - current.getQuantity();
                        gain = gain + current.getQuantity() * (price - current.getPrice());
                        if (shares.isEmpty()) break;
                        shareQueue.poll();
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

                // Code to sell shares and calculate profit here
            }
            else if (command.equals("printall"))
            {
                for (String company : shares.keySet())
                {
                    System.out.println(company + ",");
                    Queue<Share> shareQueue = shares.get(company);
                    if (shareQueue == null)
                    {
                        System.out.println("Cannot sell shares you do not have!");
                        continue;
                    }
                    for (Share share : shareQueue)
                    {
                        System.out.print("[" + share.getQuantity() + " of " + share.getPrice() + "] ");
                    }
                    System.out.println();
                }
            }
            else if (command.equals("print"))
            {
                String company = in.next();
                Queue<Share> shareQueue = shares.get(company);
                if (shareQueue == null)
                {
                    System.out.println("Cannot sell shares you do not have!");
                    continue;
                }
                for (Share share : shareQueue)
                {
                    System.out.print("[" + share.getQuantity() + " of " + share.getPrice() + "] ");
                }
                System.out.println();
            }

        } while (!command.equalsIgnoreCase("quit"));
    }
}

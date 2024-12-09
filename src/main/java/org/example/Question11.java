package org.example;

import java.io.*;
import java.util.*;

/**
 * Name:
 * Class Group:
 */
public class Question11
{

    public static void main(String[] args) throws IOException
    {
        //BUG FIX: Cant use any set because same values are evaluated as the same thing
        // and in DistanceTo.compareTo 'target' is not used in evaluation,
        // so I am using a LinkedList

        Map<String, LinkedList<DistanceTo>> map = new HashMap<>();
        File inputFile = new File("cities.txt");
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;

        while ((line = reader.readLine()) != null)
        {
            String[] split = line.split(" ");
            if (split.length < 3) continue;
            String from = split[0];
            String to = split[1];
            Integer distance = Integer.valueOf(split[2]);
//            System.out.println(from + " " + to + " " + distance);

            if (map.get(from) == null)
            {
//                System.out.println("New for " + from);
                map.put(from, new LinkedList<>());
            }
            if (map.get(to) == null)
            {
//                System.out.println("New to " + to);
                map.put(to, new LinkedList<>());
            }
            map.get(from).add(new DistanceTo(to, distance));
            map.get(to).add(new DistanceTo(from, distance));
//            for (Map.Entry<String, LinkedList<DistanceTo>> entry : map.entrySet())
//            {
//                System.out.println("[" + entry.getKey() + " of " + entry.getValue().size() + "] ");
//            }
//            System.out.println("Repete");
        }

        String from = "Phx";
        Map<String, Integer> shortestKnownDistance = new HashMap<>();
        PriorityQueue<DistanceTo> queue = new PriorityQueue<>();
        queue.add(new DistanceTo(from, 0));

        while (!queue.isEmpty())
        {
//            System.out.println("Queue right now");
//            for (DistanceTo dist : queue)
//            {
//                System.out.print("[" + dist.getTarget() + " of " + dist.getDistance() + "] ");
//            }
//            System.out.println();

            DistanceTo current = queue.poll();
//            System.out.println("Current right now");
//            System.out.println("[" + current.getTarget() + " of " + current.getDistance() + "] ");
            if (shortestKnownDistance.get(current.getTarget()) == null)
            {
                //Saving the distance
                shortestKnownDistance.put(current.getTarget(), current.getDistance());

                LinkedList<DistanceTo> distanceTos = map.get(current.getTarget());
                for (DistanceTo dist : distanceTos)
                {
                    queue.add(new DistanceTo(dist.getTarget(), dist.getDistance() + current.getDistance()));
                }
            }
//            System.out.println("Shortest right now");
//            for (Map.Entry<String, Integer> entry : shortestKnownDistance.entrySet())
//            {
//                System.out.println("[" + entry.getKey() + " of " + entry.getValue() + "] ");
//            }
        }

        //Output
        System.out.println("Shortest path to");
        for (Map.Entry<String, Integer> entry : shortestKnownDistance.entrySet())
        {
            System.out.println("[" + entry.getKey() + " of " + entry.getValue() + "] ");
        }
    }
}

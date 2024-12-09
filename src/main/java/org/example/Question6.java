package org.example;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Name:
 * Class Group:
 */

public class Question6      // Flight take-off (Queue)
{

    static Queue<String> takeOffs = new ArrayDeque<>();
    static Queue<String> lands = new ArrayDeque<>();

    public static void main(String[] args)
    {
        takeoff("Flight-100"); // is queued for ‘take off’
        takeoff("Flight-220"); // is queued
        land("Flight-320"); // is queued for landing
        takeoff("Flight-EI104"); // queued for takeoff
        next(); // will complete landing of the landing of Flight-320
        next(); // will complete takeoff of Flight-100    }
    }

    public static void next()
    {
        if (!lands.isEmpty())
        {
            String poll = lands.poll();
            System.out.println("Flight " + poll + " is landing");
        }
        else if (!takeOffs.isEmpty())
        {
            String poll = takeOffs.poll();
            System.out.println("Flight " + poll + " is taking off");
        }
        else
        {
            System.out.println("Nothing in the queue!");
        }
    }

    public static void takeoff(String flight)
    {
        takeOffs.add(flight);
    }

    public static void land(String flight)
    {
        lands.add(flight);
    }
}

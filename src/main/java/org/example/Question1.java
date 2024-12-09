package org.example;

import java.util.ArrayList;

/**
 * Your Name:
 * Class Group:
 */
public class Question1
{    // Interfaces
    public interface IMeasurableContainer
    {
        double weight();

        double rectangularVolume();
    }

    static class Box implements IMeasurableContainer
    {
        private double length, width, depth, weight;

        public Box(double length, double width, double depth, double weight)
        {
            this.length = length;
            this.width = width;
            this.depth = depth;
            this.weight = weight;
        }

        @Override
        public double weight()
        {
            return weight;
        }

        @Override
        public double rectangularVolume()
        {
            return length * width * depth;
        }
    }

    static class Cylinder implements IMeasurableContainer
    {
        private double height, diameter, weight;

        public Cylinder(double height, double diameter, double weight)
        {
            this.height = height;
            this.diameter = diameter;
            this.weight = weight;
        }

        @Override
        public double weight()
        {
            return weight;
        }

        @Override
        public double rectangularVolume()
        {
            return diameter * diameter * height;
        }
    }

    static class Pyramid implements IMeasurableContainer
    {
        private double length, sideLength, weight;

        public Pyramid(double length, double sideLength, double weight)
        {
            this.length = length;
            this.sideLength = sideLength;
            this.weight = weight;
        }

        @Override
        public double weight()
        {
            return weight;
        }

        @Override
        public double rectangularVolume()
        {
            return length * sideLength * sideLength;
        }
    }

    static class ContainerManager
    {

        private ArrayList<IMeasurableContainer> containers = new ArrayList<>();

        public void add(IMeasurableContainer container)
        {
            containers.add(container);
        }

        public double totalWeight()
        {
            double sum = 0;
            for (IMeasurableContainer iMeasurableContainer : containers)
            {
                sum = sum + iMeasurableContainer.weight();
            }
            return sum;
        }

        public double totalRectangularVolume()
        {
            double sum = 0;
            for (IMeasurableContainer iMeasurableContainer : containers)
            {
                sum = sum + iMeasurableContainer.rectangularVolume();
            }
            return sum;
        }

        public void clearAll()
        {
            containers.clear();
        }

        public ArrayList<IMeasurableContainer> getAllContainers()
        {
            return containers;
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Question 1");

        ContainerManager containerManager = new ContainerManager();
        containerManager.add(new Box(10, 10, 10, 3));
        containerManager.add(new Box(10, 10, 10, 3));
        containerManager.add(new Box(10, 10, 10, 3));
        containerManager.add(new Box(10, 10, 10, 3));
        containerManager.add(new Cylinder(5, 1, 8));
        containerManager.add(new Pyramid(3, 3, 888));
        System.out.println(containerManager.totalRectangularVolume());
        System.out.println(containerManager.totalWeight());
    }
}



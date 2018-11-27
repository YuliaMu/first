package ru.stqa.first.sandbox;

public class myFirstProgram {
    public myFirstProgram() {
    }

    public static void main(String[] args){


        Point p1 = new Point(3, 6);
        Point p2 = new Point(5, 3);

        double b = distance(p1, p2);
        System.out.println(b);

        // b = p1.distance(p2);
        //System.out.println("Расстояние между двумя точками равно " + b);
    }
        public static double distance(Point p1, Point p2) {
           return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
      }

}
package ru.stqa.first.sandbox;

public class myFirstProgram {
    public static void main(String[] args){
        Point p1 = new Point(2, 3);
        Point p2 = new Point(4, 5);

        double b = p1.distance(p1, p2);
        System.out.println("Расстояние между двумя точками равно " + b);

         b = p1.distance(p2);
        System.out.println("Расстояние между двумя точками равно " + b);
    }
}
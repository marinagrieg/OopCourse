package ru.academits.grigoryeva.range.range_main;

import ru.academits.grigoryeva.range.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range range1 = new Range(-3, 68);

        System.out.println("Первый  диапазон:");

        System.out.printf("Верхняя граница = %f%n", range1.getFrom());
        System.out.printf("Нижняя граница = %f%n", range1.getTo());
        System.out.printf("Длина = %f%n", range1.getLength());

        System.out.println("Введите число для проверки:");
        double number1 = scanner.nextDouble();

        if (range1.isInside(number1)) {
            System.out.printf("Число %f принадлежит диапазону%n%n", number1);
        } else {
            System.out.printf("Число %f не принадлежит диапазону%n%n", number1);
        }

        range1.setFrom(-6);
        range1.setTo(90);

        System.out.printf("Нижняя граница = %f%n", range1.getFrom());
        System.out.printf("Верхняя граница = %f%n", range1.getTo());
        System.out.printf("Длина = %f%n", range1.getLength());

        System.out.println("Введите число для проверки:");
        double number2 = scanner.nextDouble();

        if (range1.isInside(number2)) {
            System.out.printf("Число %.2f принадлежит диапазону%n%n", number2);
        } else {
            System.out.printf("Число %.2f не принадлежит диапазону%n%n", number2);
        }

        Range range2 = new Range(100, 120);

        System.out.println("Второй диапазон:");

        System.out.printf("Нижняя граница = %f%n", range2.getFrom());
        System.out.printf("Верхняя граница = %f%n", range2.getTo());
        System.out.printf("Длина = %f%n%n", range2.getLength());

        Range intervalsIntersection = range1.getIntersection(range2);

        if (intervalsIntersection != null) {
            System.out.printf("Диапазон пересечения - от %f до %f%n", intervalsIntersection.getFrom(), intervalsIntersection.getTo());
        } else {
            System.out.println("Диапазоны не пересекаются");
        }
    }
}

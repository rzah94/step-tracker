package ru.rzah;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        printMenu();
        int userInput = scanner.nextInt();

        var stepTracker = new StepTracker();

        while (userInput != 4) {

            switch (userInput) {
                case 1:
                    stepTracker.setStep(getMonth(scanner), getDay(scanner), getStepAmount(scanner));
                    break;
                case 2:
                    stepTracker.getStatisticByMonth(getMonth(scanner));
                    break;
                case 3:
                    var stepGoal = getAmountStepsTarget(scanner);
                    stepTracker.setAmountStepsTarget(stepGoal);
                    break;
            }

            printMenu();
            userInput = scanner.nextInt();
        }
    }

    // Печатает меню
    public static void printMenu() {
        System.out.println("""
        Меню:
        1. Ввести количество шагов за определенный день;
        2. Напечатать статистику за определенный месяц
        3. Изменить цель по количеству шагов в день;
        4. Выйти из приложения
        
        """);
    }

    // Запрашивает цель по количеству шагов
    public static int getAmountStepsTarget(Scanner scanner) {
        System.out.print("Введите цель по количеству шагов: ");
        var stepGoal = scanner.nextInt();

        if (stepGoal > 0) {
            System.out.println("Цель по количеству шагов изменена на " + stepGoal);
            return stepGoal;
        }

        return getAmountStepsTarget(scanner);
    }

    // Запрашивает месяц
    public static short getMonth(Scanner scanner) {
        System.out.println("Укажите номер месяца: ");
        short month = scanner.nextShort();

        if (month >= 1 && month <= 12) {
            return month;
        }

        return getMonth(scanner);
    }

    // Запрашивает день
    public static short getDay(Scanner scanner) {
        System.out.println("Укажите день: ");
        short day = scanner.nextShort();

        if (day >= 1 && day <= 30) {
            return day;
        }

        return getDay(scanner);
    }

    // Запрашивает количество шагов
    public static int getStepAmount(Scanner scanner) {
        System.out.println("Укажите количество шагов: ");
        int steps = scanner.nextInt();

        if (steps > 0) {
            return steps;
        }

        return getStepAmount(scanner);
    }
}
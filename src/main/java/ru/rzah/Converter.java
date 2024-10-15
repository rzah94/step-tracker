package ru.rzah;

public class Converter {
    // Длина 1 шага в километрах
    private static final double stepPerKilometer = 0.00075;
    private static final double stepPerKcal = 0.05;

    public static double stepToKilometer(double step) {
        return step * stepPerKilometer;
    }

    public static double stepToKcal(double step) {
        return step * stepPerKcal;
    }
}
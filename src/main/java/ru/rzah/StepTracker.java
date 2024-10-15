package ru.rzah;

import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Data
public class StepTracker {
    private static final short monthsInYear = 12;
    // целевое количество шагов
    private int amountStepsTarget = 10_000;
    private final Map<Short, MonthData> steps = new HashMap<>();

    public StepTracker() {

        for (short month = 1; month <= monthsInYear; month++) {

            steps.put(month, new MonthData());
        }
    }

    public void setStep(short month, short day, int stepAmount) {
        var monthData = steps.get(month);
        monthData.setStep(day, stepAmount);
    }

    public void getStatisticByMonth(short month) {
        var monthData = steps.get(month);

        System.out.println(Arrays.toString(monthData.getStepsByDays()));
        System.out.println("Всего шагов: " + monthData.getTotalSteps());
        System.out.println("Максимум за день: " + monthData.getMaxSteps());
        System.out.println("Среднее количество шагов: " + monthData.getAverageSteps());
        System.out.println("Пройденная дистанция (в км): " + Converter.stepToKilometer(monthData.getTotalSteps()));
        System.out.println("Количество сожжённых килокалорий: " + Converter.stepToKcal(monthData.getTotalSteps()));
        System.out.println("Лучшая серия (дней подряд, когда шагов больше целевого): " + monthData.getBestSeries(amountStepsTarget));
    }
}
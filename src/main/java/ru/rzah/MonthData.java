package ru.rzah;

import java.util.ArrayList;
import java.util.List;


public class MonthData {
    private static final short daysInMonth = 30;
    private final List<Integer> data = new ArrayList<>();

    public MonthData() {
        for (short day = 0; day < daysInMonth; day++) {
            data.add(day, 0);
        }
    }

    public void setStep(short day, int step) {
        data.set(--day, step);
    }

    public String[] getStepsByDays() {
        var statisticByDays = new String[daysInMonth];
        for (short day = 0; day < daysInMonth; day++) {
            statisticByDays[day] = (day + 1) + " день: " + data.get(day);
        }
        return statisticByDays;
    }

    public int getTotalSteps() {
        var totalSteps = 0;
        for (short day = 0; day < daysInMonth; day++) {
            totalSteps += data.get(day);
        }
        return totalSteps;
    }

    public int getMaxSteps() {
        var maxSteps = 0;
        for (short day = 0; day < daysInMonth; day++) {
            if (data.get(day) > maxSteps) {
                maxSteps = data.get(day);
            }
        }
        return maxSteps;
    }

    public double getAverageSteps() {
        return (double) this.getTotalSteps() / daysInMonth;
    }

    public short getBestSeries(int amountStepsTarget) {
        var betterSeries = new ArrayList<Short>();
        short currentBetterSeries = 0;

        for (short day = 0; day < daysInMonth; day++) {

            var currentSteps = data.get(day);

            if (currentSteps > amountStepsTarget) {
                currentBetterSeries++;
            } else {
                betterSeries.add(currentBetterSeries);
                currentBetterSeries = 0;
            }
        }

        return betterSeries.stream().max(Short::compareTo).get();
    }
}

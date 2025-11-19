package ru.mikhailov.buildings;

public class House {
    private int floors;

    public House(int floors) {
        if (floors < 0)
            throw new RuntimeException("Кол.-во этажей не может быть отрицательным");
        this.floors = floors;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        if (floors < 0)
            throw new RuntimeException("Кол.-во этажей не может быть отрицательным");
        this.floors = floors;
    }

    @Override
    public String toString() {
        int lastTwo = floors % 100;
        int lastOne = floors % 10;

        String endString;

        if (lastTwo >= 11 && lastTwo <= 14) {
            endString = "этажами";
        } else if (lastOne == 1) {
            endString = "этажом";
        } else {
            endString = "этажами";
        }

        return String.format("дом с %d %s", floors, endString);
    }
}

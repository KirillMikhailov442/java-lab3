package ru.mikhailov.geometry;

public class Dot {
    private final int x;
    private final int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Dot dot = (Dot) obj;
        return x == dot.x && y == dot.y;
    }

    @Override
    public String toString() {
        return String.format("{%d:%d}", x, y);
    }
}
package ru.mikhailov.structures;

import java.util.Arrays;

public class ImmutableArray {
    private final int[] values;

    public ImmutableArray(int... values) {
        this.values = values;
    }

    public ImmutableArray(ImmutableArray immutableArray) {
        this.values = immutableArray.getValues();
    }

    public int find(int position) {
        if (position < 0 || position >= values.length) {
            throw new IllegalArgumentException(
                    String.format("Позиция %d вне диапазона [0, %d]", position, values.length - 1));
        }
        return values[position];
    }

    public ImmutableArray replace(int position, int newValue) {
        if (position < 0 || position >= values.length) {
            throw new IllegalArgumentException(
                    String.format("Позиция %d вне диапазона [0, %d]", position, values.length - 1));
        }

        int[] newArray = Arrays.copyOf(values, values.length);
        values[position] = newValue;
        return new ImmutableArray(newArray);
    }

    public boolean isEmpty() {
        return values.length == 0;
    }

    public int getSize() {
        return values.length;
    }

    public int[] getValues() {
        return this.values;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
            if (i < values.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
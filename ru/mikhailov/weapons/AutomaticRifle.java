package ru.mikhailov.weapons;

public class AutomaticRifle extends Pistol1_5 {
    private final int speed;

    public AutomaticRifle() {
        super(30, 30);
        speed = 30;
    }

    public AutomaticRifle(int maxAmmo) {
        super(maxAmmo, maxAmmo);
        speed = maxAmmo / 2;
    }

    public AutomaticRifle(int maxAmmo, int speed) {
        super(maxAmmo, maxAmmo);
        if (speed <= 0)
            throw new IllegalArgumentException("Скорострельность должна быть положительным числом");
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public String shootForNSeconds(int seconds) {
        if (seconds <= 0) {
            throw new IllegalArgumentException("Количество секунд должно быть положительным");
        }

        StringBuilder result = new StringBuilder();
        int totalShots = seconds * speed;
        int actualShots = Math.min(totalShots, getAmmo());

        for (int i = 0; i < actualShots; i++) {
            setAmmo(getAmmo() - 1);
            result.append("Бах!");
            if (i < actualShots - 1) {
                result.append(" ");
            }
        }

        int emptyShots = totalShots - actualShots;
        if (emptyShots > 0) {
            if (actualShots > 0) {
                result.append(" ");
            }
            for (int i = 0; i < emptyShots; i++) {
                result.append("Клац!");
                if (i < emptyShots - 1) {
                    result.append(" ");
                }
            }
        }

        return result.toString();
    }

    @Override
    public String toString() {
        return shootForNSeconds(1);
    }
}

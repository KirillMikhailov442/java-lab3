package ru.mikhailov.weapons;

public class Pistol4_1 extends Weapon4_1 {
    private int ammo;
    private final int maxAmmo;

    public Pistol4_1(int ammo, int maxAmmo) {
        super(ammo);
        this.ammo = ammo;
        this.maxAmmo = maxAmmo;
    }

    public Pistol4_1() {
        this(5, 5);
    }

    public int reload(int newAmmo) {
        if (newAmmo < 0)
            throw new RuntimeException("Вы не можете перезарядить магазин на отрицательное кол.-во патронов");
        int resAmmo = newAmmo - maxAmmo;
        setAmmo(newAmmo);
        return resAmmo > 0 ? resAmmo : 0;
    }

    public int unload() {
        int currentAmmo = ammo;
        setAmmo(0);
        return currentAmmo;
    }

    public boolean isload() {
        return ammo != 0 ? true : false;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    @Override
    public String toString() {
        if (ammo > 0) {
            ammo--;
            return "Бах!";
        } else {
            return "Клац!";
        }
    }

    @Override
    void shoot() {
        throw new UnsupportedOperationException("Unimplemented method 'shoot'");
    }
}
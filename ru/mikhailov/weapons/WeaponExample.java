package ru.mikhailov.weapons;

public class WeaponExample extends Weapon8_2 {

    public WeaponExample(int ammo) {
        super(ammo);
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public void showAmmo() {
        System.out.println(ammo);
    }

    @Override
    void shoot() {
        throw new UnsupportedOperationException("Unimplemented method 'shoot'");
    }
}

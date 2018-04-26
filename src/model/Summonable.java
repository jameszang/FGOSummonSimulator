package model;

import javax.swing.*;
import java.util.Objects;

public abstract class Summonable {
    protected String name;
    protected int id;
    protected ImageIcon icon;
    protected Rarity rarity;
    protected boolean rateUp;

    public Summonable(int id, String name, Rarity rarity, boolean rateUp) {
        this.name = name;
        this.id = id;
        this.rarity = rarity;
        this.rateUp = rateUp;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public boolean isRateUp() {
        return rateUp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summonable that = (Summonable) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }
}

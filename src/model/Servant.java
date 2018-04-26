package model;

import javax.swing.*;

public class Servant extends Summonable {

    public Servant(int id, String name, Rarity rarity, boolean rateUp) {
        super(id, name, rarity, rateUp);
        this.icon = new ImageIcon("servantIcons/" + id + ".png");
    }
}

package model;

import javax.swing.*;

public class CraftEssence extends Summonable {

    public CraftEssence(int id, String name, Rarity rarity, boolean rateUp) {
        super(id, name, rarity, rateUp);
        this.icon = new ImageIcon("ceIcons/" + id + ".png");
    }
}

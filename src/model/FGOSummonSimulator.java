package model;

import parsers.GachaInfoParser;
import ui.SummonScreenUI;

import javax.swing.*;

public class FGOSummonSimulator {

    public static void main(String[] args) throws Exception {
        GachaInfoParser parser = new GachaInfoParser("servantData.txt", "ceData.txt");
        parser.parse();
        SummonScreenUI summonScreenUI = new SummonScreenUI();
        SwingUtilities.invokeLater(summonScreenUI);
    }
}

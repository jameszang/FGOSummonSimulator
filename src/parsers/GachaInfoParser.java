package parsers;

import model.CONSTANTS;
import model.CraftEssence;
import model.Rarity;
import model.Servant;

import java.io.File;
import java.util.Scanner;

public class GachaInfoParser {
    private Scanner servantReader;
    private Scanner ceReader;

    public GachaInfoParser(String servantPath, String cePath) throws Exception {
        servantReader = new Scanner(new File(servantPath));
        ceReader = new Scanner(new File(cePath));
    }

    public void parse() {
        while (servantReader.hasNextLine()) {
            String[] info = servantReader.nextLine().split("/");
            String name = info[0];
            int id = Integer.parseInt(info[2]);
            boolean rateUp = (info[3].equals("Y"));
            Rarity rarity;
            switch (info[1]) {
                case "SSR": {
                    rarity = Rarity.SSR;
                    CONSTANTS.servants_SSR.add(new Servant(id, name, rarity, rateUp));
                    if (rateUp) {
                        CONSTANTS.servants_SSR_on_rateup = true;
                    }
                    break;
                }
                case "SR": {
                    rarity = Rarity.SR;
                    CONSTANTS.servants_SR.add(new Servant(id, name, rarity, rateUp));
                    if (rateUp) {
                        CONSTANTS.servants_SR_on_rateup = true;
                    }
                    break;
                }
                case "R": {
                    rarity = Rarity.R;
                    CONSTANTS.servants_R.add(new Servant(id, name, rarity, rateUp));
                    if (rateUp) {
                        CONSTANTS.servants_R_on_rateup = true;
                    }
                    break;
                }
            }
        }

        while (ceReader.hasNextLine()) {
            String[] info = ceReader.nextLine().split("/");
            String name = info[0];
            int id = Integer.parseInt(info[2]);
            boolean rateUp = (info[3].equals("Y"));
            Rarity rarity;
            switch (info[1]) {
                case "SSR": {
                    rarity = Rarity.SSR;
                    CONSTANTS.ce_SSR.add(new CraftEssence(id, name, rarity, rateUp));
                    if (rateUp) {
                        CONSTANTS.ce_SSR_on_rateup = true;
                    }
                    break;
                }
                case "SR": {
                    rarity = Rarity.SR;
                    CONSTANTS.ce_SR.add(new CraftEssence(id, name, rarity, rateUp));
                    if (rateUp) {
                        CONSTANTS.ce_SR_on_rateup = true;
                    }
                    break;
                }
                case "R": {
                    rarity = Rarity.R;
                    CONSTANTS.ce_R.add(new CraftEssence(id, name, rarity, rateUp));
                    if (rateUp) {
                        CONSTANTS.ce_R_on_rateup = true;
                    }
                    break;
                }
            }
        }
    }
}

package model;

import java.util.HashMap;
import java.util.Map;

public class StatisticsTracker {
    private int quartzCounter;
    private double cashCounter;
    private Map<Servant, Integer> SSRServants;
    private Map<Servant, Integer> SRServants;
    private Map<CraftEssence, Integer> SSRCEs;

    public StatisticsTracker() {
        quartzCounter = 0;
        cashCounter = 0;
        SSRServants = new HashMap<>();
        SRServants = new HashMap<>();
        SSRCEs = new HashMap<>();
    }

    public int getQuartzCounter() {
        return quartzCounter;
    }

    public double getCashCounter() {
        return Math.round(cashCounter * 100.0) / 100.0;
    }

    public int getQuartzRatio() {
        int sum = 0;
        for (Integer i : SSRServants.values()) {
            sum += i;
        }
        if (SSRServants.isEmpty()) {
            return quartzCounter;
        } else {
            return quartzCounter / sum;
        }
    }

    public Map<Servant, Integer> getSSRServants() {
        return SSRServants;
    }

    public Map<Servant, Integer> getSRServants() {
        return SRServants;
    }

    public Map<CraftEssence, Integer> getSSRCEs() {
        return SSRCEs;
    }

    public void addQuartz(int toAdd) {
        quartzCounter += toAdd;
    }

    public void addCash(double toAdd) {
        cashCounter += toAdd;
    }

    public void addSSRServant(Servant s) {
        if (SSRServants.containsKey(s)) {
            SSRServants.put(s, SSRServants.get(s) + 1);
        } else {
            SSRServants.put(s, 1);
        }
    }

    public void addSRServant(Servant s) {
        if (SRServants.containsKey(s)) {
            SRServants.put(s, SRServants.get(s) + 1);
        } else {
            SRServants.put(s, 1);
        }
    }

    public void addSSRCE(CraftEssence ce) {
        if (SSRCEs.containsKey(ce)) {
            SSRCEs.put(ce, SSRCEs.get(ce) + 1);
        } else {
            SSRCEs.put(ce, 1);
        }
    }

    public void clearAll() {
        quartzCounter = 0;
        cashCounter = 0;
        SSRServants.clear();
        SRServants.clear();
        SSRCEs.clear();
    }
}

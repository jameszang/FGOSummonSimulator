package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;

public class MultiSummonListener extends AbstractListener {
    private MultiSummon multiSummon;

    public MultiSummonListener(StatisticsTracker statisticsTracker, MultiSummon multiSummon, JPanel summonResultsPanel, JPanel SSRServantsSummoned, JPanel SRServantsSummoned, JPanel SSRCESummoned, JLabel quartzCounter, JLabel cashCounter, JLabel quartzRatio) {
        super(statisticsTracker, SSRServantsSummoned, SSRCESummoned, summonResultsPanel, SRServantsSummoned, quartzCounter, cashCounter, quartzRatio);
        this.multiSummon = multiSummon;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        summonResultsPanel.removeAll();
        SSRServantsSummoned.removeAll();
        SRServantsSummoned.removeAll();
        SSRCESummoned.removeAll();

        List<Summonable> summoned = multiSummon.summon();
        for (Summonable s : summoned) {
            summonResultsPanel.add(new JLabel(s.getIcon()));

            if (s instanceof Servant) {
                if (s.getRarity().equals(Rarity.SSR)) {
                    statisticsTracker.addSSRServant((Servant) s);
                } else if (s.getRarity().equals(Rarity.SR)) {
                    statisticsTracker.addSRServant((Servant) s);
                }
            } else {
                if (s.getRarity().equals(Rarity.SSR)) {
                    statisticsTracker.addSSRCE((CraftEssence) s);
                }
            }
        }

        SSRServantsSummoned.add(new JLabel("SSR Servants Summoned:\n"));
        SRServantsSummoned.add(new JLabel("SR Servants Summoned:\n"));
        SSRCESummoned.add(new JLabel("SSR CEs Summoned:\n"));

        Map<Servant, Integer> SSRServants = statisticsTracker.getSSRServants();
        Map<Servant, Integer> SRServants = statisticsTracker.getSRServants();
        Map<CraftEssence, Integer> SSRCEs = statisticsTracker.getSSRCEs();

        for (Servant s : SSRServants.keySet()) {
            SSRServantsSummoned.add(new JLabel(s.getName() + " x" + SSRServants.get(s)));
        }

        for (Servant s : SRServants.keySet()) {
            SRServantsSummoned.add(new JLabel(s.getName() + " x" + SRServants.get(s)));
        }

        for (CraftEssence ce : SSRCEs.keySet()) {
            SSRCESummoned.add(new JLabel(ce.getName() + " x" + SSRCEs.get(ce)));
        }

        statisticsTracker.addQuartz(30);
        statisticsTracker.addCash(10 * CONSTANTS.CASH_PER_SINGLE_SUMMON);
        quartzCounter.setText("Quartz spent: " + statisticsTracker.getQuartzCounter());
        cashCounter.setText("Amount spent: $" + statisticsTracker.getCashCounter());
        quartzRatio.setText("Quartz per SSR Servant: " + statisticsTracker.getQuartzRatio());

        summonResultsPanel.updateUI();
        SSRServantsSummoned.updateUI();
        SRServantsSummoned.updateUI();
        SSRCESummoned.updateUI();
    }
}

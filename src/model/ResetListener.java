package model;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ResetListener extends AbstractListener {

    public ResetListener(StatisticsTracker statisticsTracker, JPanel summonResultsPanel, JLabel quartzCounter, JLabel cashCounter, JLabel quartzRatio, JPanel SSRServantsSummoned, JPanel SRServantsSummoned, JPanel SSRCESummoned) {
        super(statisticsTracker, SSRServantsSummoned, SSRCESummoned, summonResultsPanel, SRServantsSummoned, quartzCounter, cashCounter, quartzRatio);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        summonResultsPanel.removeAll();

        statisticsTracker.clearAll();

        quartzCounter.setText("Quartz spent: " + statisticsTracker.getQuartzCounter());
        cashCounter.setText("Amount spent: $" + statisticsTracker.getCashCounter() + "0");
        quartzRatio.setText("Quartz per SSR Servant: "+ statisticsTracker.getQuartzRatio());
        SSRServantsSummoned.removeAll();
        SSRServantsSummoned.add(new JLabel("SSR Servants Summoned:\n"));
        SRServantsSummoned.removeAll();
        SRServantsSummoned.add(new JLabel("SR Servants Summoned:\n"));
        SSRCESummoned.removeAll();
        SSRCESummoned.add(new JLabel("SSR CEs Summoned:\n"));

        summonResultsPanel.updateUI();
        SSRServantsSummoned.updateUI();
        SRServantsSummoned.updateUI();
        SSRCESummoned.updateUI();
    }
}

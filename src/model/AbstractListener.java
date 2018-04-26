package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractListener implements ActionListener {
    protected StatisticsTracker statisticsTracker;

    protected JPanel summonResultsPanel;
    protected JLabel quartzCounter;
    protected JLabel cashCounter;
    protected JLabel quartzRatio;
    protected JPanel SSRServantsSummoned;
    protected JPanel SRServantsSummoned;
    protected JPanel SSRCESummoned;

    public AbstractListener(StatisticsTracker statisticsTracker, JPanel SSRServantsSummoned, JPanel SSRCESummoned, JPanel summonResultsPanel, JPanel SRServantsSummoned, JLabel quartzCounter, JLabel cashCounter, JLabel quartzRatio) {
        this.SSRServantsSummoned = SSRServantsSummoned;
        this.SSRCESummoned = SSRCESummoned;
        this.summonResultsPanel = summonResultsPanel;
        this.statisticsTracker = statisticsTracker;
        this.SRServantsSummoned = SRServantsSummoned;
        this.quartzCounter = quartzCounter;
        this.cashCounter = cashCounter;
        this.quartzRatio = quartzRatio;
    }

    @Override
    public abstract void actionPerformed(ActionEvent ae);
}

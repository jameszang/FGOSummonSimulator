package ui;

import model.*;

import javax.swing.*;
import java.awt.*;

public class SummonScreenUI implements Runnable {
    private JFrame frame;
    private StatisticsTracker statisticsTracker;
    private SingleSummon singleSummon;
    private MultiSummon multiSummon;

    public SummonScreenUI() {
        statisticsTracker = new StatisticsTracker();
        singleSummon = new SingleSummon();
        multiSummon = new MultiSummon();
    }

    @Override
    public void run() {
        frame = new JFrame("Summoning Simulator");
        frame.setPreferredSize(new Dimension(1250, 750));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(2, 1);
        container.setLayout(layout);

        JPanel summonResultsPanel = new JPanel(new GridLayout(2, 5));

        container.add(summonResultsPanel);

        //entire bottom half
        JPanel activityPanel = new JPanel(new GridLayout(1, 2));

        //splitter panel
        JPanel splitterPanel = new JPanel(new GridLayout(2, 3));

        //quartz counter
        JLabel quartzCounter = new JLabel("Quartz spent: " + statisticsTracker.getQuartzCounter());
        quartzCounter.setVerticalAlignment(SwingConstants.TOP);
        splitterPanel.add(quartzCounter);
        //cash counter
        JLabel cashCounter = new JLabel("Amount spent: $" + statisticsTracker.getCashCounter() + "0");
        cashCounter.setVerticalAlignment(SwingConstants.TOP);
        splitterPanel.add(cashCounter);
        //quartz/SSR ratio
        JLabel quartzRatio = new JLabel("Quartz per SSR Servant: "+ statisticsTracker.getQuartzRatio());
        quartzRatio.setVerticalAlignment(SwingConstants.TOP);
        splitterPanel.add(quartzRatio);
        //1x summon
        JButton singleSummonButton = new JButton("1x SUMMON");
        splitterPanel.add(singleSummonButton);
        //10x summon
        JButton multiSummonButton = new JButton("10x SUMMON");
        splitterPanel.add(multiSummonButton);
        //reset
        JButton resetButton = new JButton("RESET STATISTICS");
        splitterPanel.add(resetButton);

        //servants summoned
        JPanel trackerPanel = new JPanel(new GridLayout(1, 3));
        //5* Servants
        JPanel SSRServantsSummoned = new JPanel();
        BoxLayout SSRSLayout = new BoxLayout(SSRServantsSummoned, BoxLayout.Y_AXIS);
        SSRServantsSummoned.setLayout(SSRSLayout);
        SSRServantsSummoned.add(new JLabel("SSR Servants Summoned:\n"));
        //4* Servants
        JPanel SRServantsSummoned = new JPanel();
        BoxLayout SRSLayout = new BoxLayout(SRServantsSummoned, BoxLayout.Y_AXIS);
        SRServantsSummoned.setLayout(SRSLayout);
        SRServantsSummoned.add(new JLabel("SR Servants Summoned:\n"));
        //5* CEs
        JPanel SSRCESummoned = new JPanel();
        BoxLayout SSRCELayout = new BoxLayout(SSRCESummoned, BoxLayout.Y_AXIS);
        SSRCESummoned.setLayout(SSRCELayout);
        SSRCESummoned.add(new JLabel("SSR CEs Summoned:\n"));


        singleSummonButton.addActionListener(new SingleSummonListener(statisticsTracker, singleSummon, summonResultsPanel, SSRServantsSummoned, SRServantsSummoned, SSRCESummoned, quartzCounter, cashCounter, quartzRatio));
        multiSummonButton.addActionListener(new MultiSummonListener(statisticsTracker, multiSummon, summonResultsPanel, SSRServantsSummoned, SRServantsSummoned, SSRCESummoned, quartzCounter, cashCounter, quartzRatio));
        resetButton.addActionListener(new ResetListener(statisticsTracker, summonResultsPanel, quartzCounter, cashCounter, quartzRatio, SSRServantsSummoned, SRServantsSummoned, SSRCESummoned));
        trackerPanel.add(SSRServantsSummoned);
        trackerPanel.add(SRServantsSummoned);
        trackerPanel.add(SSRCESummoned);

        activityPanel.add(splitterPanel);
        activityPanel.add(trackerPanel);
        container.add(activityPanel);
    }

    public JFrame getFrame() {
        return frame;
    }
}

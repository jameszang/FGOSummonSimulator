package model;

import java.util.ArrayList;
import java.util.List;

public class MultiSummon {
    private List<Summonable> summonResults;
    private SingleSummon singleSummon;

    public MultiSummon() {
        summonResults = new ArrayList<>();
        singleSummon = new SingleSummon();
    }

    public List<Summonable> summon() {
        summonResults.clear();
        boolean SRSummoned = false;
        boolean ServantSummoned = false;
        for (int i = 0; i < 9; i++) {
            Summonable summoned = singleSummon.summon();
            summonResults.add(summoned);
            if (summoned.getRarity() == Rarity.SSR || summoned.getRarity() == Rarity.SR) {
                SRSummoned = true;
            }
            if (summoned instanceof Servant) {
                ServantSummoned = true;
            }
        }

        if (!SRSummoned) {
            Summonable summoned;
            do {
                summoned = singleSummon.summon();
            } while (summoned.getRarity() == Rarity.R);
            summonResults.add(summoned);
        } else if (!ServantSummoned) {
            Summonable summoned;
            do {
                summoned = singleSummon.summon();
            } while (!(summoned instanceof Servant));
            summonResults.add(summoned);
        } else {
            summonResults.add(singleSummon.summon());
        }
        return summonResults;
    }
}

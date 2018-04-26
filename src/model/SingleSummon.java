package model;

import java.util.Random;

public class SingleSummon {
    private Summonable summonResult;
    Random random;

    public SingleSummon() {
        summonResult = null;
        random = new Random();
    }

    public Summonable summon() {
        summonResult = null;

        int typeOfResult = random.nextInt(CONSTANTS.HUNDRED);
        int rateUpNum = random.nextInt(CONSTANTS.HUNDRED);
        boolean isRateUp;
        if (rateUpNum < CONSTANTS.RATE_UP_CHANCE) {
            isRateUp = true;
        } else {
            isRateUp = false;
        }
        do {
            if (typeOfResult >= CONSTANTS.SSR_SERVANT_BEGIN && typeOfResult <= CONSTANTS.SSR_SERVANT_END) {
                if (!CONSTANTS.servants_SSR_on_rateup) {
                    isRateUp = false;
                }
                summonResult = CONSTANTS.servants_SSR.get(random.nextInt(CONSTANTS.servants_SSR.size()));
            } else if (typeOfResult >= CONSTANTS.SR_SERVANT_BEGIN && typeOfResult <= CONSTANTS.SR_SERVANT_END) {
                if (!CONSTANTS.servants_SR_on_rateup) {
                    isRateUp = false;
                }
                summonResult = CONSTANTS.servants_SR.get(random.nextInt(CONSTANTS.servants_SR.size()));
            } else if (typeOfResult >= CONSTANTS.R_SERVANT_BEGIN && typeOfResult <= CONSTANTS.R_SERVANT_END) {
                if (!CONSTANTS.servants_R_on_rateup) {
                    isRateUp = false;
                }
                summonResult = CONSTANTS.servants_R.get(random.nextInt(CONSTANTS.servants_R.size()));
            } else if (typeOfResult >= CONSTANTS.SSR_CE_BEGIN && typeOfResult <= CONSTANTS.SSR_CE_END) {
                if (!CONSTANTS.ce_SSR_on_rateup) {
                    isRateUp = false;
                }
                summonResult = CONSTANTS.ce_SSR.get(random.nextInt(CONSTANTS.ce_SSR.size()));
            } else if (typeOfResult >= CONSTANTS.SR_CE_BEGIN && typeOfResult <= CONSTANTS.SR_CE_END) {
                if (!CONSTANTS.ce_SR_on_rateup) {
                    isRateUp = false;
                }
                summonResult = CONSTANTS.ce_SR.get(random.nextInt(CONSTANTS.ce_SR.size()));
            } else {
                if (!CONSTANTS.ce_R_on_rateup) {
                    isRateUp = false;
                }
                summonResult = CONSTANTS.ce_R.get(random.nextInt(CONSTANTS.ce_R.size()));
            }
        } while (summonResult.isRateUp() != isRateUp);

        return summonResult;
    }
}

package model;

import java.util.ArrayList;
import java.util.List;

public class CONSTANTS {
    public static final int HUNDRED = 100;
    public static final double CASH_PER_SINGLE_SUMMON = 2.35714;

    public static final int RATE_UP_CHANCE = 70;

    public static final int SSR_RATE_SERVANT = 1;
    public static final int SSR_RATE_CE = 4;

    public static final int SR_RATE_SERVANT = 3;
    public static final int SR_RATE_CE = 12;

    public static final int R_RATE_SERVANT = 40;
    public static final int R_RATE_CE = 40;

    public static final int SSR_SERVANT_BEGIN = 0; //0
    public static final int SSR_SERVANT_END = SSR_SERVANT_BEGIN + SSR_RATE_SERVANT - 1; //0
    public static final int SR_SERVANT_BEGIN = SSR_SERVANT_END + 1; //1
    public static final int SR_SERVANT_END = SR_SERVANT_BEGIN + SR_RATE_SERVANT - 1; //3
    public static final int R_SERVANT_BEGIN = SR_SERVANT_END + 1; //4
    public static final int R_SERVANT_END = R_SERVANT_BEGIN + R_RATE_SERVANT - 1; //43
    public static final int SSR_CE_BEGIN = R_SERVANT_END + 1; //44
    public static final int SSR_CE_END = SSR_CE_BEGIN + SSR_RATE_CE - 1; //47
    public static final int SR_CE_BEGIN = SSR_CE_END + 1; //48
    public static final int SR_CE_END = SR_CE_BEGIN + SR_RATE_CE - 1; //59;
    public static final int R_CE_BEGIN = SR_CE_END + 1; //60
    public static final int R_CE_END = R_CE_BEGIN + R_RATE_CE - 1; //99

    public static List<Servant> servants_SSR = new ArrayList<>();
    public static List<Servant> servants_SR = new ArrayList<>();
    public static List<Servant> servants_R = new ArrayList<>();
    public static List<CraftEssence> ce_SSR = new ArrayList<>();
    public static List<CraftEssence> ce_SR = new ArrayList<>();
    public static List<CraftEssence> ce_R = new ArrayList<>();

    public static boolean servants_SSR_on_rateup = false;
    public static boolean servants_SR_on_rateup = false;
    public static boolean servants_R_on_rateup = false;
    public static boolean ce_SSR_on_rateup = false;
    public static boolean ce_SR_on_rateup = false;
    public static boolean ce_R_on_rateup = false;
}

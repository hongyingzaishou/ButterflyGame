// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GameDictionary.java

package com.megacrit.cardcrawl.helpers;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.*;
import java.util.TreeMap;

public class GameDictionary
{

    public GameDictionary()
    {
    }

    public static void initialize()
    {
        keywords.put("[R]", TEXT[0]);
        keywords.put("[G]", TEXT[0]);
        keywords.put("[B]", TEXT[0]);
        keywords.put("[W]", TEXT[0]);
        keywords.put("[E]", TEXT[0]);
        createDictionaryEntry(ARTIFACT.NAMES, ARTIFACT.DESCRIPTION);
        createDictionaryEntry(BLOCK.NAMES, BLOCK.DESCRIPTION);
        createDictionaryEntry(BURN.NAMES, BURN.DESCRIPTION);
        createDictionaryEntry(CALM.NAMES, CALM.DESCRIPTION);
        createDictionaryEntry(CHANNEL.NAMES, CHANNEL.DESCRIPTION);
        createDictionaryEntry(CONFUSED.NAMES, CONFUSED.DESCRIPTION);
        createDictionaryEntry(CURSE.NAMES, CURSE.DESCRIPTION);
        createDictionaryEntry(DARK.NAMES, DARK.DESCRIPTION);
        createDictionaryEntry(DAZED.NAMES, DAZED.DESCRIPTION);
        createDictionaryEntry(DEXTERITY.NAMES, DEXTERITY.DESCRIPTION);
        createDictionaryEntry(ENLIGHTENMENT.NAMES, ENLIGHTENMENT.DESCRIPTION);
        createDictionaryEntry(ETHEREAL.NAMES, ETHEREAL.DESCRIPTION);
        createDictionaryEntry(EVOKE.NAMES, EVOKE.DESCRIPTION);
        createDictionaryEntry(EXHAUST.NAMES, EXHAUST.DESCRIPTION);
        createDictionaryEntry(FOCUS.NAMES, FOCUS.DESCRIPTION);
        createDictionaryEntry(FRAIL.NAMES, FRAIL.DESCRIPTION);
        createDictionaryEntry(FROST.NAMES, FROST.DESCRIPTION);
        createDictionaryEntry(INNATE.NAMES, INNATE.DESCRIPTION);
        createDictionaryEntry(INTANGIBLE.NAMES, INTANGIBLE.DESCRIPTION);
        createDictionaryEntry(LIGHTNING.NAMES, LIGHTNING.DESCRIPTION);
        createDictionaryEntry(LOCK_ON.NAMES, LOCK_ON.DESCRIPTION);
        createDictionaryEntry(LOCKED.NAMES, LOCKED.DESCRIPTION);
        createDictionaryEntry(OPENER.NAMES, OPENER.DESCRIPTION);
        createDictionaryEntry(PLASMA.NAMES, PLASMA.DESCRIPTION);
        createDictionaryEntry(POISON.NAMES, POISON.DESCRIPTION);
        createDictionaryEntry(PRAYER.NAMES, PRAYER.DESCRIPTION);
        createDictionaryEntry(RETAIN.NAMES, RETAIN.DESCRIPTION);
        createDictionaryEntry(SCRY.NAMES, SCRY.DESCRIPTION);
        createDictionaryEntry(SHIV.NAMES, SHIV.DESCRIPTION);
        createDictionaryEntry(STANCE.NAMES, STANCE.DESCRIPTION);
        createDictionaryEntry(STATUS.NAMES, STATUS.DESCRIPTION);
        createDictionaryEntry(STRENGTH.NAMES, STRENGTH.DESCRIPTION);
        createDictionaryEntry(STRIKE.NAMES, STRIKE.DESCRIPTION);
        createDictionaryEntry(THORNS.NAMES, THORNS.DESCRIPTION);
        createDictionaryEntry(TRANSFORM.NAMES, TRANSFORM.DESCRIPTION);
        createDictionaryEntry(UNKNOWN.NAMES, UNKNOWN.DESCRIPTION);
        createDictionaryEntry(UNPLAYABLE.NAMES, UNPLAYABLE.DESCRIPTION);
        createDictionaryEntry(UPGRADE.NAMES, UPGRADE.DESCRIPTION);
        createDictionaryEntry(VIGOR.NAMES, VIGOR.DESCRIPTION);
        createDictionaryEntry(VOID.NAMES, VOID.DESCRIPTION);
        createDictionaryEntry(VULNERABLE.NAMES, VULNERABLE.DESCRIPTION);
        createDictionaryEntry(WEAK.NAMES, WEAK.DESCRIPTION);
        createDictionaryEntry(WOUND.NAMES, WOUND.DESCRIPTION);
        createDictionaryEntry(WRATH.NAMES, WRATH.DESCRIPTION);
        createDictionaryEntry(REGEN.NAMES, REGEN.DESCRIPTION);
        createDictionaryEntry(RITUAL.NAMES, RITUAL.DESCRIPTION);
        createDictionaryEntry(FATAL.NAMES, FATAL.DESCRIPTION);
    }

    private static void createDictionaryEntry(String names[], String desc)
    {
        String as[] = names;
        int i = as.length;
        for(int j = 0; j < i; j++)
        {
            String n = as[j];
            keywords.put(n, desc);
            parentWord.put(n, names[0]);
        }

    }

    private static final KeywordStrings keywordStrings;
    public static final String TEXT[];
    public static final Keyword ARTIFACT;
    public static final Keyword BLOCK;
    public static final Keyword EVOKE;
    public static final Keyword CONFUSED;
    public static final Keyword CHANNEL;
    public static final Keyword CURSE;
    public static final Keyword DARK;
    public static final Keyword DEXTERITY;
    public static final Keyword ETHEREAL;
    public static final Keyword EXHAUST;
    public static final Keyword FRAIL;
    public static final Keyword FROST;
    public static final Keyword INNATE;
    public static final Keyword INTANGIBLE;
    public static final Keyword FOCUS;
    public static final Keyword LIGHTNING;
    public static final Keyword LOCKED;
    public static final Keyword LOCK_ON;
    public static final Keyword OPENER;
    public static final Keyword PLASMA;
    public static final Keyword POISON;
    public static final Keyword RETAIN;
    public static final Keyword SHIV;
    public static final Keyword STATUS;
    public static final Keyword STRENGTH;
    public static final Keyword STRIKE;
    public static final Keyword TRANSFORM;
    public static final Keyword UNKNOWN;
    public static final Keyword UNPLAYABLE;
    public static final Keyword UPGRADE;
    public static final Keyword VIGOR;
    public static final Keyword VOID;
    public static final Keyword VULNERABLE;
    public static final Keyword WEAK;
    public static final Keyword WOUND;
    public static final Keyword DAZED;
    public static final Keyword BURN;
    public static final Keyword THORNS;
    public static final Keyword STANCE;
    public static final Keyword WRATH;
    public static final Keyword CALM;
    public static final Keyword ENLIGHTENMENT;
    public static final Keyword SCRY;
    public static final Keyword PRAYER;
    public static final Keyword REGEN;
    public static final Keyword RITUAL;
    public static final Keyword FATAL;
    public static final TreeMap keywords = new TreeMap();
    public static final TreeMap parentWord = new TreeMap();

    static 
    {
        keywordStrings = CardCrawlGame.languagePack.getKeywordString("Game Dictionary");
        TEXT = keywordStrings.TEXT;
        ARTIFACT = keywordStrings.ARTIFACT;
        BLOCK = keywordStrings.BLOCK;
        EVOKE = keywordStrings.EVOKE;
        CONFUSED = keywordStrings.CONFUSED;
        CHANNEL = keywordStrings.CHANNEL;
        CURSE = keywordStrings.CURSE;
        DARK = keywordStrings.DARK;
        DEXTERITY = keywordStrings.DEXTERITY;
        ETHEREAL = keywordStrings.ETHEREAL;
        EXHAUST = keywordStrings.EXHAUST;
        FRAIL = keywordStrings.FRAIL;
        FROST = keywordStrings.FROST;
        INNATE = keywordStrings.INNATE;
        INTANGIBLE = keywordStrings.INTANGIBLE;
        FOCUS = keywordStrings.FOCUS;
        LIGHTNING = keywordStrings.LIGHTNING;
        LOCKED = keywordStrings.LOCKED;
        LOCK_ON = keywordStrings.LOCK_ON;
        OPENER = keywordStrings.OPENER;
        PLASMA = keywordStrings.PLASMA;
        POISON = keywordStrings.POISON;
        RETAIN = keywordStrings.RETAIN;
        SHIV = keywordStrings.SHIV;
        STATUS = keywordStrings.STATUS;
        STRENGTH = keywordStrings.STRENGTH;
        STRIKE = keywordStrings.STRIKE;
        TRANSFORM = keywordStrings.TRANSFORM;
        UNKNOWN = keywordStrings.UNKNOWN;
        UNPLAYABLE = keywordStrings.UNPLAYABLE;
        UPGRADE = keywordStrings.UPGRADE;
        VIGOR = keywordStrings.VIGOR;
        VOID = keywordStrings.VOID;
        VULNERABLE = keywordStrings.VULNERABLE;
        WEAK = keywordStrings.WEAK;
        WOUND = keywordStrings.WOUND;
        DAZED = keywordStrings.DAZED;
        BURN = keywordStrings.BURN;
        THORNS = keywordStrings.THORNS;
        STANCE = keywordStrings.STANCE;
        WRATH = keywordStrings.WRATH;
        CALM = keywordStrings.CALM;
        ENLIGHTENMENT = keywordStrings.DIVINITY;
        SCRY = keywordStrings.SCRY;
        PRAYER = keywordStrings.PRAYER;
        REGEN = keywordStrings.REGEN;
        RITUAL = keywordStrings.RITUAL;
        FATAL = keywordStrings.FATAL;
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PotionStrings.java

package com.megacrit.cardcrawl.localization;


// Referenced classes of package com.megacrit.cardcrawl.localization:
//            LocalizedStrings

public class PotionStrings
{

    public PotionStrings()
    {
    }

    public static PotionStrings getMockPotionString()
    {
        PotionStrings retVal = new PotionStrings();
        retVal.NAME = "[MISSING_NAME]";
        retVal.DESCRIPTIONS = LocalizedStrings.createMockStringArray(3);
        return retVal;
    }

    public String NAME;
    public String DESCRIPTIONS[];
}

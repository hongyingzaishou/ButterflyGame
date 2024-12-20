// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LiquidBronze.java

package com.megacrit.cardcrawl.potions;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.*;
import com.megacrit.cardcrawl.localization.*;
import com.megacrit.cardcrawl.powers.ThornsPower;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import java.util.ArrayList;
import java.util.TreeMap;

// Referenced classes of package com.megacrit.cardcrawl.potions:
//            AbstractPotion

public class LiquidBronze extends AbstractPotion
{

    public LiquidBronze()
    {
        super(potionStrings.NAME, "LiquidBronze", AbstractPotion.PotionRarity.UNCOMMON, AbstractPotion.PotionSize.SPIKY, AbstractPotion.PotionEffect.NONE, new Color(0xe2b821ff), new Color(0x18bcc0ff), null);
        isThrown = false;
    }

    public void initializeData()
    {
        potency = getPotency();
        description = (new StringBuilder()).append(potionStrings.DESCRIPTIONS[0]).append(potency).append(potionStrings.DESCRIPTIONS[1]).toString();
        tips.clear();
        tips.add(new PowerTip(name, description));
        tips.add(new PowerTip(TipHelper.capitalize(GameDictionary.THORNS.NAMES[0]), (String)GameDictionary.keywords.get(GameDictionary.THORNS.NAMES[0])));
    }

    public void use(AbstractCreature target)
    {
        target = AbstractDungeon.player;
        if(AbstractDungeon.getCurrRoom().phase == com.megacrit.cardcrawl.rooms.AbstractRoom.RoomPhase.COMBAT)
            addToBot(new ApplyPowerAction(target, AbstractDungeon.player, new ThornsPower(target, potency), potency));
    }

    public int getPotency(int ascensionLevel)
    {
        return 3;
    }

    public AbstractPotion makeCopy()
    {
        return new LiquidBronze();
    }

    public static final String POTION_ID = "LiquidBronze";
    private static final PotionStrings potionStrings;

    static 
    {
        potionStrings = CardCrawlGame.languagePack.getPotionString("LiquidBronze");
    }
}

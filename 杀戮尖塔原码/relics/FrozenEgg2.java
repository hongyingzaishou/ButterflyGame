// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FrozenEgg2.java

package com.megacrit.cardcrawl.relics;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rewards.RewardItem;
import com.megacrit.cardcrawl.screens.CombatRewardScreen;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.megacrit.cardcrawl.relics:
//            AbstractRelic

public class FrozenEgg2 extends AbstractRelic
{

    public FrozenEgg2()
    {
        super("Frozen Egg 2", "frozenEgg.png", AbstractRelic.RelicTier.UNCOMMON, AbstractRelic.LandingSound.CLINK);
    }

    public String getUpdatedDescription()
    {
        return DESCRIPTIONS[0];
    }

    public void onEquip()
    {
        Iterator iterator = AbstractDungeon.combatRewardScreen.rewards.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            RewardItem reward = (RewardItem)iterator.next();
            if(reward.cards != null)
            {
                Iterator iterator1 = reward.cards.iterator();
                while(iterator1.hasNext()) 
                {
                    AbstractCard c = (AbstractCard)iterator1.next();
                    onPreviewObtainCard(c);
                }
            }
        } while(true);
    }

    public void onPreviewObtainCard(AbstractCard c)
    {
        onObtainCard(c);
    }

    public void onObtainCard(AbstractCard c)
    {
        if(c.type == com.megacrit.cardcrawl.cards.AbstractCard.CardType.POWER && c.canUpgrade() && !c.upgraded)
            c.upgrade();
    }

    public boolean canSpawn()
    {
        return Settings.isEndless || AbstractDungeon.floorNum <= 48;
    }

    public AbstractRelic makeCopy()
    {
        return new FrozenEgg2();
    }

    public static final String ID = "Frozen Egg 2";
}

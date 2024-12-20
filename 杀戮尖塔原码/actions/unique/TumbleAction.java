// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TumbleAction.java

package com.megacrit.cardcrawl.actions.unique;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DiscardSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import java.util.ArrayList;
import java.util.Iterator;

public class TumbleAction extends AbstractGameAction
{

    public TumbleAction(AbstractCreature source, int amount)
    {
        this.source = source;
        this.amount = amount;
        duration = Settings.ACTION_DUR_FAST;
    }

    public void update()
    {
        if(duration == Settings.ACTION_DUR_FAST)
        {
            Iterator iterator = AbstractDungeon.player.hand.group.iterator();
            do
            {
                if(!iterator.hasNext())
                    break;
                AbstractCard c = (AbstractCard)iterator.next();
                if(c.type == com.megacrit.cardcrawl.cards.AbstractCard.CardType.ATTACK)
                {
                    addToTop(new GainBlockAction(source, source, amount));
                    addToTop(new DiscardSpecificCardAction(c));
                }
            } while(true);
        }
        tickDuration();
    }
}

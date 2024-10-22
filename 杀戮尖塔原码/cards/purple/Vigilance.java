// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Vigilance.java

package com.megacrit.cardcrawl.cards.purple;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.LocalizedStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.stances.CalmStance;

public class Vigilance extends AbstractCard
{

    public Vigilance()
    {
        super("Vigilance", cardStrings.NAME, "purple/skill/vigilance", 2, cardStrings.DESCRIPTION, com.megacrit.cardcrawl.cards.AbstractCard.CardType.SKILL, com.megacrit.cardcrawl.cards.AbstractCard.CardColor.PURPLE, com.megacrit.cardcrawl.cards.AbstractCard.CardRarity.BASIC, com.megacrit.cardcrawl.cards.AbstractCard.CardTarget.SELF);
        baseBlock = 8;
        block = baseBlock;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot(new GainBlockAction(p, block));
        addToBot(new ChangeStanceAction("Calm"));
    }

    public void upgrade()
    {
        if(!upgraded)
        {
            upgradeName();
            upgradeBlock(4);
        }
    }

    public AbstractCard makeCopy()
    {
        return new Vigilance();
    }

    public static final String ID = "Vigilance";
    private static final CardStrings cardStrings;

    static 
    {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Vigilance");
    }
}

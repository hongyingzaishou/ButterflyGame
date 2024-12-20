// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SnakeDagger.java

package com.megacrit.cardcrawl.monsters.beyond;

import com.badlogic.gdx.math.MathUtils;
import com.esotericsoftware.spine.AnimationState;
import com.esotericsoftware.spine.AnimationStateData;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.status.Wound;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.LocalizedStrings;
import com.megacrit.cardcrawl.localization.MonsterStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.random.Random;
import java.util.ArrayList;

public class SnakeDagger extends AbstractMonster
{

    public SnakeDagger(float x, float y)
    {
        super(NAME, "Dagger", AbstractDungeon.monsterHpRng.random(20, 25), 0.0F, -50F, 140F, 130F, null, x, y);
        firstMove = true;
        initializeAnimation();
        damage.add(new DamageInfo(this, 9));
        damage.add(new DamageInfo(this, 25));
        damage.add(new DamageInfo(this, 25, com.megacrit.cardcrawl.cards.DamageInfo.DamageType.HP_LOSS));
    }

    public void initializeAnimation()
    {
        loadAnimation("images/monsters/theForest/mage_dagger/skeleton.atlas", "images/monsters/theForest/mage_dagger/skeleton.json", 1.0F);
        com.esotericsoftware.spine.AnimationState.TrackEntry e = state.setAnimation(0, "Idle", true);
        e.setTime(e.getEndTime() * MathUtils.random());
    }

    public void takeTurn()
    {
        switch(nextMove)
        {
        case 1: // '\001'
            AbstractDungeon.actionManager.addToBottom(new ChangeStateAction(this, "ATTACK"));
            AbstractDungeon.actionManager.addToBottom(new WaitAction(0.3F));
            AbstractDungeon.actionManager.addToBottom(new DamageAction(AbstractDungeon.player, (DamageInfo)damage.get(0), com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
            AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(new Wound(), 1));
            break;

        case 2: // '\002'
            AbstractDungeon.actionManager.addToBottom(new ChangeStateAction(this, "SUICIDE"));
            AbstractDungeon.actionManager.addToBottom(new WaitAction(0.4F));
            AbstractDungeon.actionManager.addToBottom(new DamageAction(AbstractDungeon.player, (DamageInfo)damage.get(1), com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect.SLASH_HEAVY));
            AbstractDungeon.actionManager.addToBottom(new LoseHPAction(this, this, currentHealth));
            break;
        }
        AbstractDungeon.actionManager.addToBottom(new RollMoveAction(this));
    }

    public void damage(DamageInfo info)
    {
        super.damage(info);
        if(info.owner != null && info.type != com.megacrit.cardcrawl.cards.DamageInfo.DamageType.THORNS && info.output > 0)
        {
            state.setAnimation(0, "Hurt", false);
            state.addAnimation(0, "Idle", true, 0.0F);
            stateData.setMix("Hurt", "Idle", 0.1F);
            stateData.setMix("Idle", "Hurt", 0.1F);
        }
    }

    protected void getMove(int num)
    {
        if(firstMove)
        {
            firstMove = false;
            setMove((byte)1, com.megacrit.cardcrawl.monsters.AbstractMonster.Intent.ATTACK_DEBUFF, 9);
            return;
        } else
        {
            setMove((byte)2, com.megacrit.cardcrawl.monsters.AbstractMonster.Intent.ATTACK, 25);
            return;
        }
    }

    public void changeState(String key)
    {
        String s = key;
        byte byte0 = -1;
        switch(s.hashCode())
        {
        case 1941037640: 
            if(s.equals("ATTACK"))
                byte0 = 0;
            break;

        case -1143642610: 
            if(s.equals("SUICIDE"))
                byte0 = 1;
            break;
        }
        switch(byte0)
        {
        case 0: // '\0'
            state.setAnimation(0, "Attack", false);
            state.addAnimation(0, "Idle", true, 0.0F);
            break;

        case 1: // '\001'
            state.setAnimation(0, "Attack2", false);
            state.addAnimation(0, "Idle", true, 0.0F);
            break;
        }
    }

    public static final String ID = "Dagger";
    private static final MonsterStrings monsterStrings;
    public static final String NAME;
    public static final String MOVES[];
    public static final String DIALOG[];
    private static final int HP_MIN = 20;
    private static final int HP_MAX = 25;
    private static final int STAB_DMG = 9;
    private static final int SACRIFICE_DMG = 25;
    private static final byte WOUND = 1;
    private static final byte EXPLODE = 2;
    public boolean firstMove;

    static 
    {
        monsterStrings = CardCrawlGame.languagePack.getMonsterStrings("Dagger");
        NAME = monsterStrings.NAME;
        MOVES = monsterStrings.MOVES;
        DIALOG = monsterStrings.DIALOG;
    }
}

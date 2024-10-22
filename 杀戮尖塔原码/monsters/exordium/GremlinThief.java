// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GremlinThief.java

package com.megacrit.cardcrawl.monsters.exordium;

import com.badlogic.gdx.math.MathUtils;
import com.esotericsoftware.spine.AnimationState;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.actions.animations.AnimateSlowAttackAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.audio.SoundMaster;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.Hitbox;
import com.megacrit.cardcrawl.localization.LocalizedStrings;
import com.megacrit.cardcrawl.localization.MonsterStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.SpeechBubble;
import java.util.ArrayList;

public class GremlinThief extends AbstractMonster
{

    public GremlinThief(float x, float y)
    {
        super(NAME, "GremlinThief", 14, 0.0F, 0.0F, 120F, 160F, null, x, y);
        dialogY = 50F * Settings.scale;
        if(AbstractDungeon.ascensionLevel >= 7)
            setHp(11, 15);
        else
            setHp(10, 14);
        if(AbstractDungeon.ascensionLevel >= 2)
            thiefDamage = 10;
        else
            thiefDamage = 9;
        damage.add(new DamageInfo(this, thiefDamage));
        loadAnimation("images/monsters/theBottom/thiefGremlin/skeleton.atlas", "images/monsters/theBottom/thiefGremlin/skeleton.json", 1.0F);
        com.esotericsoftware.spine.AnimationState.TrackEntry e = state.setAnimation(0, "animation", true);
        e.setTime(e.getEndTime() * MathUtils.random());
    }

    public void takeTurn()
    {
        switch(nextMove)
        {
        case 1: // '\001'
            AbstractDungeon.actionManager.addToBottom(new AnimateSlowAttackAction(this));
            AbstractDungeon.actionManager.addToBottom(new DamageAction(AbstractDungeon.player, (DamageInfo)damage.get(0), com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
            if(!escapeNext)
                AbstractDungeon.actionManager.addToBottom(new SetMoveAction(this, (byte)1, com.megacrit.cardcrawl.monsters.AbstractMonster.Intent.ATTACK, thiefDamage));
            else
                AbstractDungeon.actionManager.addToBottom(new SetMoveAction(this, (byte)99, com.megacrit.cardcrawl.monsters.AbstractMonster.Intent.ESCAPE));
            break;

        case 99: // 'c'
            playSfx();
            AbstractDungeon.effectList.add(new SpeechBubble(hb.cX + dialogX, hb.cY + dialogY, 2.5F, DIALOG[1], false));
            AbstractDungeon.actionManager.addToBottom(new EscapeAction(this));
            AbstractDungeon.actionManager.addToBottom(new SetMoveAction(this, (byte)99, com.megacrit.cardcrawl.monsters.AbstractMonster.Intent.ESCAPE));
            break;
        }
    }

    private void playSfx()
    {
        int roll = MathUtils.random(1);
        if(roll == 0)
            AbstractDungeon.actionManager.addToBottom(new SFXAction("VO_GREMLINSPAZZY_1A"));
        else
            AbstractDungeon.actionManager.addToBottom(new SFXAction("VO_GREMLINSPAZZY_1B"));
    }

    private void playDeathSfx()
    {
        int roll = MathUtils.random(2);
        if(roll == 0)
            CardCrawlGame.sound.play("VO_GREMLINSPAZZY_2A");
        else
        if(roll == 1)
            CardCrawlGame.sound.play("VO_GREMLINSPAZZY_2B");
        else
            CardCrawlGame.sound.play("VO_GREMLINSPAZZY_2C");
    }

    public void die()
    {
        super.die();
        playDeathSfx();
    }

    public void escapeNext()
    {
        if(!cannotEscape && !escapeNext)
        {
            escapeNext = true;
            AbstractDungeon.effectList.add(new SpeechBubble(dialogX, dialogY, 3F, DIALOG[2], false));
        }
    }

    protected void getMove(int num)
    {
        setMove((byte)1, com.megacrit.cardcrawl.monsters.AbstractMonster.Intent.ATTACK, ((DamageInfo)damage.get(0)).base);
    }

    public void deathReact()
    {
        if(intent != com.megacrit.cardcrawl.monsters.AbstractMonster.Intent.ESCAPE && !isDying)
        {
            AbstractDungeon.effectList.add(new SpeechBubble(dialogX, dialogY, 3F, DIALOG[2], false));
            setMove((byte)99, com.megacrit.cardcrawl.monsters.AbstractMonster.Intent.ESCAPE);
            createIntent();
        }
    }

    public static final String ID = "GremlinThief";
    private static final MonsterStrings monsterStrings;
    public static final String NAME;
    public static final String MOVES[];
    public static final String DIALOG[];
    private static final int THIEF_DAMAGE = 9;
    private static final int A_2_THIEF_DAMAGE = 10;
    private static final byte PUNCTURE = 1;
    private static final int HP_MIN = 10;
    private static final int HP_MAX = 14;
    private static final int A_2_HP_MIN = 11;
    private static final int A_2_HP_MAX = 15;
    private int thiefDamage;

    static 
    {
        monsterStrings = CardCrawlGame.languagePack.getMonsterStrings("GremlinThief");
        NAME = monsterStrings.NAME;
        MOVES = monsterStrings.MOVES;
        DIALOG = monsterStrings.DIALOG;
    }
}

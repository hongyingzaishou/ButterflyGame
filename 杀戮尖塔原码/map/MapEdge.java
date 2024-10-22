// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MapEdge.java

package com.megacrit.cardcrawl.map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.vfx.MapDot;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.megacrit.cardcrawl.map:
//            MapRoomNode

public class MapEdge
    implements Comparable
{

    public MapEdge(int srcX, int srcY, int dstX, int dstY)
    {
        dots = new ArrayList();
        color = DISABLED_COLOR.cpy();
        taken = false;
        this.srcX = srcX;
        this.srcY = srcY;
        this.dstX = dstX;
        this.dstY = dstY;
    }

    public MapEdge(int srcX, int srcY, float srcOffsetX, float srcOffsetY, int dstX, int dstY, float dstOffsetX, 
            float dstOffsetY, boolean isBoss)
    {
        dots = new ArrayList();
        color = DISABLED_COLOR.cpy();
        taken = false;
        this.srcX = srcX;
        this.srcY = srcY;
        this.dstX = dstX;
        this.dstY = dstY;
        float tmpSX = getX(srcX) + srcOffsetX;
        float tmpDX = getX(dstX) + dstOffsetX;
        float tmpSY = (float)srcY * Settings.MAP_DST_Y + srcOffsetY;
        float tmpDY = (float)dstY * Settings.MAP_DST_Y + dstOffsetY;
        Vector2 vec2 = (new Vector2(tmpDX, tmpDY)).sub(new Vector2(tmpSX, tmpSY));
        float length = vec2.len();
        float START = (SPACING * MathUtils.random()) / 2.0F;
        float tmpRadius = ICON_DST_RADIUS;
        if(isBoss)
            tmpRadius = 164F * Settings.scale;
        for(float i = START + tmpRadius; i < length - ICON_SRC_RADIUS; i += SPACING)
        {
            vec2.clamp(length - i, length - i);
            if(i != START + tmpRadius && i <= length - ICON_SRC_RADIUS - SPACING)
                dots.add(new MapDot(tmpSX + vec2.x, tmpSY + vec2.y, (new Vector2(tmpSX - tmpDX, tmpSY - tmpDY)).nor().angle() + 90F, true));
            else
                dots.add(new MapDot(tmpSX + vec2.x, tmpSY + vec2.y, (new Vector2(tmpSX - tmpDX, tmpSY - tmpDY)).nor().angle() + 90F, false));
        }

    }

    private float getX(int x)
    {
        return (float)x * SPACE_X + MapRoomNode.OFFSET_X;
    }

    public String toString()
    {
        return (new StringBuilder()).append("(").append(dstX).append(",").append(dstY).append(")").toString();
    }

    public int compareTo(MapEdge e)
    {
        if(dstX > e.dstX)
            return 1;
        if(dstX < e.dstX)
            return -1;
        if(dstY > e.dstY)
            return 1;
        if(dstY < e.dstY)
            return -1;
        if(dstY == e.dstY)
            return 0;
        if(!$assertionsDisabled)
            throw new AssertionError();
        else
            return 0;
    }

    public void markAsTaken()
    {
        taken = true;
        color = MapRoomNode.AVAILABLE_COLOR;
    }

    public void render(SpriteBatch sb)
    {
        sb.setColor(color);
        MapDot d;
        for(Iterator iterator = dots.iterator(); iterator.hasNext(); d.render(sb))
            d = (MapDot)iterator.next();

    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((MapEdge)obj);
    }

    public final int dstX;
    public final int dstY;
    public final int srcX;
    public final int srcY;
    public static final float ICON_SRC_RADIUS;
    private static final float ICON_DST_RADIUS;
    private static final float SPACING;
    private ArrayList dots;
    private static final Color DISABLED_COLOR = new Color(0.0F, 0.0F, 0.0F, 0.25F);
    public Color color;
    public boolean taken;
    private static final float SPACE_X;
    static final boolean $assertionsDisabled = !com/megacrit/cardcrawl/map/MapEdge.desiredAssertionStatus();

    static 
    {
        ICON_SRC_RADIUS = 29F * Settings.scale;
        ICON_DST_RADIUS = 20F * Settings.scale;
        SPACING = Settings.isMobile ? 20F * Settings.xScale : 17F * Settings.xScale;
        SPACE_X = Settings.isMobile ? 140.8F * Settings.xScale : 128F * Settings.xScale;
    }
}

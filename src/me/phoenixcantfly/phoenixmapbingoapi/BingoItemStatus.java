package me.phoenixcantfly.phoenixmapbingoapi;

import org.bukkit.map.MapPalette;

import java.awt.*;

public enum BingoItemStatus {
    COLLECTED(MapPalette.matchColor(67, 70, 76)),
    UNCOLLECTED(MapPalette.matchColor(63, 240, 50)),// test
    UNAVAILABLE(MapPalette.matchColor(237, 40, 73)),;

    public final byte color;

    private BingoItemStatus(byte color){
        this.color = color;
    }
}

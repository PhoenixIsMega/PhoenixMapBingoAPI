package me.phoenixcantfly.phoenixmapbingoapi;

import java.awt.image.BufferedImage;

public class BingoItem {
    private final BufferedImage itemImage;
    private int x;
    private int y;
    private BingoItemStatus status;
    private int points;

    public BingoItem(BufferedImage itemImage, int x, int y, BingoItemStatus status, int points) {
        this.itemImage = itemImage;
        this.x = x;
        this.y = y;
        this.status = status;
        this.points = points;
    }

    public BufferedImage getItemImage() {
        return itemImage;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BingoItemStatus getStatus() {
        return status;
    }

    public void setStatus(BingoItemStatus status) {
        this.status = status;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

package me.phoenixcantfly.phoenixmapbingoapi;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.map.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.PixelGrabber;
import java.util.ArrayList;
import java.util.List;

public class Renderer extends MapRenderer {

    private List<BufferedImage> imagesToDraw = new ArrayList<BufferedImage>();
    private List<String> textsToDraw = new ArrayList<String>();

    private List<BingoItem> bingoItemsToDraw = new ArrayList<BingoItem>();
    @Override
    public void render(MapView mapView, MapCanvas mapCanvas, Player player) {
        for (int x = 0; x < 128; x+= 121){
            for (int y = 0; y < 128; y++) {
                for (int i = 0; i < 7; i++){
                    mapCanvas.setPixel(x+i, y, MapPalette.matchColor(54, 57, 63)); //discord colour   54, 57, 63
                }
            }
        }
        for (int y = 0; y < 128; y+= 121){
            for (int x = 0; x < 128; x++) {
                for (int i = 0; i < 7; i++){
                    mapCanvas.setPixel(x, y+i, MapPalette.matchColor(54, 57, 63)); //discord colour   54, 57, 63
                }
            }
        }
        for (int x = 5; x < 128; x+= 23){
            for (int y = 7; y < 121; y++) {
                for (int i = 0; i < 3; i++){
                    mapCanvas.setPixel(x+i, y, MapPalette.matchColor(54, 57, 63)); //discord colour   54, 57, 63
                }
            }
        }
        for (int y = 5; y < 128; y+= 23){
            for (int x = 7; x < 121; x++) {
                for (int i = 0; i < 3; i++){
                    mapCanvas.setPixel(x, y+i, MapPalette.matchColor(54, 57, 63)); //discord colour   54, 57, 63
                }
            }
        }

        for (BingoItem bingoItem : bingoItemsToDraw) {
            for (int x = 0; x < 20; x++){
                for (int y = 0; y < 20; y++){
                    mapCanvas.setPixel(8+(bingoItem.getX()*23)+x, 8+(bingoItem.getY()*23)+y, bingoItem.getStatus().color);
                }
            }
            drawImageWithTransparency(mapCanvas, bingoItem.getItemImage(), 10+(bingoItem.getX()*23), 10+(bingoItem.getY()*23));
            mapCanvas.drawText(10+8+(bingoItem.getX()*23), 10+8+(bingoItem.getY()*23), MinecraftFont.Font, ChatColor.WHITE + "§14" + String.valueOf(bingoItem.getPoints()) + "");
        }
        bingoItemsToDraw.clear();
    }

    public void addText(String text) {
        textsToDraw.add(text);
    }

    public void addImage(BufferedImage image) {
        imagesToDraw.add(image);
    }

    public void addBingoItem(BingoItem bingoItem){
        bingoItemsToDraw.add(bingoItem);
    }

    private void drawImageWithTransparency(MapCanvas canvas, BufferedImage img, int x0, int y0) {
        try {
            int width = img.getWidth();
            int height = img.getHeight();
            int[] pixels = new int[width * height];

            int i = 0;

            PixelGrabber pg = new PixelGrabber(img, 0, 0, width, height, pixels, 0, width);

            pg.grabPixels();
            byte color;
            if (pixels.length > 0) {
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        int c = pixels[i];
                        int red = (c & 0x00ff0000) >> 16;
                        int green = (c & 0x0000ff00) >> 8;
                        int blue = c & 0x000000ff;
                        /*
                        if(x == 0 && y == 0) {
                            System.out.print("  c: " + c);
                            Bukkit.broadcastMessage("  c: " + c);
                            Bukkit.broadcastMessage("HERE");
                        }*/
                        if (c != -16777216 && c != 0) {
                            color = MapPalette.matchColor(red, green, blue);
                            canvas.setPixel(x0 + x, y0 + y, color);
                        }
                        i++;
                    }
                }
            }
        } catch (InterruptedException e) {
        }
    }
}

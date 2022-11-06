package me.phoenixcantfly.phoenixmapbingoapi;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapPalette;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.map.MinecraftFont;

public class Renderer extends MapRenderer {

    public final Main plugin;

    boolean renderedGrid = false;

    public Renderer(Main plugin) {
        this.plugin = plugin;
    }

    public void render(MapView mapView, MapCanvas mapCanvas, Player player) {
        if (!(renderedGrid)) { //Should change to image, wait for artist to be free
            for (int x = 0; x < 128; x += 121) {
                for (int y = 0; y < 128; y++) {
                    for (int i = 0; i < 7; i++) {
                        mapCanvas.setPixel(x + i, y, MapPalette.matchColor(54, 57, 63));
                    }
                }
            }
            for (int y = 0; y < 128; y += 121) {
                for (int x = 0; x < 128; x++) {
                    for (int i = 0; i < 7; i++) {
                        mapCanvas.setPixel(x, y + i, MapPalette.matchColor(54, 57, 63));
                    }
                }
            }
            for (int x = 5; x < 128; x += 23) {
                for (int y = 7; y < 121; y++) {
                    for (int i = 0; i < 3; i++) {
                        mapCanvas.setPixel(x + i, y, MapPalette.matchColor(54, 57, 63));
                    }
                }
            }
            for (int y = 5; y < 128; y += 23) {
                for (int x = 7; x < 121; x++) {
                    for (int i = 0; i < 3; i++) {
                        mapCanvas.setPixel(x, y + i, MapPalette.matchColor(54, 57, 63));
                    }
                }
            }
            renderedGrid = true;
        }

        for (BingoItem bingoItem : plugin.getPlayerBingoBuffer().get(player.getUniqueId())) {
            for (int x = 0; x < 20; x++) {
                for (int y = 0; y < 20; y++) {
                    mapCanvas.setPixel(8 + bingoItem.getX() * 23 + x, 8 + bingoItem.getY() * 23 + y, bingoItem.getStatus().color);
                }
            }

            drawImageWithTransparency(mapCanvas, bingoItem.getItemImage(), 10 + bingoItem.getX() * 23, 10 + bingoItem.getY() * 23);

            if (bingoItem.getStatus().equals(BingoItemStatus.UNCOLLECTED)) {
                mapCanvas.drawText(16 + bingoItem.getX() * 23, 20 + bingoItem.getY() * 23, MinecraftFont.Font, "§34;" + String.valueOf(bingoItem.getPoints()) + "");
            }
        }
        plugin.getPlayerBingoBuffer().get(player.getUniqueId()).clear();
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

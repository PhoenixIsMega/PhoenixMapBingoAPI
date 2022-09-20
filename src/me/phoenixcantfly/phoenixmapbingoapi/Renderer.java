package me.phoenixcantfly.phoenixmapbingoapi;

import org.bukkit.entity.Player;
import org.bukkit.map.*;

public class Renderer extends MapRenderer {
    @Override
    public void render(MapView mapView, MapCanvas mapCanvas, Player player) {
        for (int x = 0; x < 128; x++) {
            for (int y = 0; y < 128; y++) {
                mapCanvas.setPixel(x, y, MapPalette.matchColor(153, 170, 181)); //discord colour   54, 57, 63
            }
        }
        for (int x = 0; x < 128; x+= 120){
            for (int y = 0; y < 128; y++) {
                for (int i = 0; i < 8; i++){
                    mapCanvas.setPixel(x+i, y, MapPalette.matchColor(54, 57, 63)); //discord colour   54, 57, 63
                }
            }
        }
        for (int y = 0; y < 128; y+= 120){
            for (int x = 0; x < 128; x++) {
                for (int i = 0; i < 8; i++){
                    mapCanvas.setPixel(x, y+i, MapPalette.matchColor(54, 57, 63)); //discord colour   54, 57, 63
                }
            }
        }
        for (int x = 6; x < 128; x+= 23){
            for (int y = 8; y < 120; y++) {
                for (int i = 0; i < 3; i++){
                    mapCanvas.setPixel(x+i, y, MapPalette.matchColor(54, 57, 63)); //discord colour   54, 57, 63
                }
            }
        }
        for (int y = 6; y < 128; y+= 23){
            for (int x = 8; x < 120; x++) {
                for (int i = 0; i < 3; i++){
                    mapCanvas.setPixel(x, y+i, MapPalette.matchColor(54, 57, 63)); //discord colour   54, 57, 63
                }
            }
        }
        mapCanvas.drawText(8, 8, MinecraftFont.Font, "123456789");
    }

    /*
    private List<String> textsToDraw = new ArrayList<String>();

  @Override
  public void render(MapView view, MapCanvas canvas, Player player) {
    for (String text : textsToDraw) {
      canvas.drawText(x, y, MinecraftFont.Font, text);
    }
    textsToDraw.clear();
  }

  public void addText(String text) {
    textsToDraw.add(text);
  }
     */

    //add error prevention, clear inv when error occurs
}

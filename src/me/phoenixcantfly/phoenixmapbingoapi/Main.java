package me.phoenixcantfly.phoenixmapbingoapi;

import me.phoenixcantfly.phoenixmapbingoapi.Renderer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.map.MapView;
import org.bukkit.plugin.java.JavaPlugin;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static javax.script.ScriptEngine.FILENAME;

public class Main extends JavaPlugin implements Listener {
    private BufferedImage icon;
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

        try {
            icon = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("apple.png"))); // Image has to be in the same package as the c
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @EventHandler
    public void onMapInitialize(MapInitializeEvent e) {
        MapView mapView = e.getMap();
        mapView.setScale(MapView.Scale.FARTHEST);
        mapView.setUnlimitedTracking(false);
        mapView.getRenderers().clear();
        Renderer renderer = new Renderer();
        mapView.addRenderer(renderer);
        //renderer.addImage(icon);
        try {
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("cake.png"))), 0, 0, BingoItemStatus.UNAVAILABLE, 0));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("coarse_dirt.png"))), 0, 1, BingoItemStatus.COLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("lava_bucket.png"))), 0, 2, BingoItemStatus.UNCOLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("sugar.png"))), 0, 3, BingoItemStatus.COLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("beehive_front.png"))), 0, 4, BingoItemStatus.UNAVAILABLE, 0));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("white_bed.png"))), 1, 0, BingoItemStatus.UNAVAILABLE, 0));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("iron_bars.png"))), 1, 1, BingoItemStatus.UNCOLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("egg.png"))), 1, 2, BingoItemStatus.COLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("bricks.png"))), 1, 3, BingoItemStatus.COLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("bell.png"))), 1, 4, BingoItemStatus.UNCOLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("jukebox_top.png"))), 2, 0, BingoItemStatus.UNCOLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("lead.png"))), 2, 1, BingoItemStatus.UNCOLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("golden_helmet.png"))), 2, 2, BingoItemStatus.UNAVAILABLE, 0));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("ender_pearl.png"))), 2, 3, BingoItemStatus.UNCOLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("ink_sac.png"))), 2, 4, BingoItemStatus.COLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("diamond_block.png"))), 3, 0, BingoItemStatus.UNCOLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("compass_12.png"))), 3, 1, BingoItemStatus.UNCOLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("firework_rocket.png"))), 3, 2, BingoItemStatus.UNAVAILABLE, 0));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("wheat.png"))), 3, 3, BingoItemStatus.COLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("barrel_side.png"))), 3, 4, BingoItemStatus.UNCOLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("lantern.png"))), 4, 0, BingoItemStatus.COLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("tnt_minecart.png"))), 4, 1, BingoItemStatus.UNAVAILABLE, 0));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("fermented_spider_eye.png"))), 4, 2, BingoItemStatus.UNAVAILABLE, 0));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("hopper.png"))), 4, 3, BingoItemStatus.COLLECTED, 45));
            renderer.addBingoItem(new BingoItem(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("sugar.png"))), 4, 4, BingoItemStatus.UNCOLLECTED, 45));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public BufferedImage getIcon() {
        return icon;
    }
}

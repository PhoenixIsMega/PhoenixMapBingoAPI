package me.phoenixcantfly.phoenixmapbingoapi;

import me.phoenixcantfly.phoenixmapbingoapi.Renderer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.map.MapView;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onMapInitialize(MapInitializeEvent e) {
        MapView mapView = e.getMap();
        mapView.setScale(MapView.Scale.FARTHEST);
        mapView.setUnlimitedTracking(false);
        mapView.getRenderers().clear();
        mapView.addRenderer(new Renderer());
    }
}

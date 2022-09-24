package me.phoenixcantfly.phoenixmapbingoapi;

import me.phoenixcantfly.phoenixmapbingoapi.Renderer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.plugin.java.JavaPlugin;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static javax.script.ScriptEngine.FILENAME;

public class Main extends JavaPlugin implements Listener {
    private HashMap<UUID, List<BingoItem>> playerBingoBuffer = new HashMap<>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        playerBingoBuffer.computeIfAbsent(e.getPlayer().getUniqueId(), k -> new ArrayList<BingoItem>());
    }

    public HashMap<UUID, List<BingoItem>> getPlayerBingoBuffer() {
        return playerBingoBuffer;
    }
}

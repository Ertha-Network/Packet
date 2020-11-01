package net.ertha.packet;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerStorage {

    private final String name;
    private final UUID uuid;
    private Player player;
    private ProxiedPlayer proxiedPlayer;

    private List<Inventory> friendsGUI;
    private int friendsGuiIndex;
    private List<String> friends = new ArrayList<>();

    public PlayerStorage(Player p){
        name = p.getName();
        uuid = p.getUniqueId();
        player = p;
    }
    public PlayerStorage(ProxiedPlayer p){
        name = p.getName();
        uuid = p.getUniqueId();
        proxiedPlayer = p;
    }

    public ProxiedPlayer getProxiedPlayer(){
        if(proxiedPlayer != null)
            return proxiedPlayer;
        if(uuid != null && ProxyServer.getInstance().getPlayer(uuid) != null)
            proxiedPlayer = ProxyServer.getInstance().getPlayer(uuid);
        if(name != null && ProxyServer.getInstance().getPlayer(name) != null)
            proxiedPlayer = ProxyServer.getInstance().getPlayer(name);
        return proxiedPlayer;
    }

    public Player getPlayer() {
        if(player != null)
            return player;
        if(uuid != null && Bukkit.getPlayer(uuid) != null)
            player = Bukkit.getPlayer(uuid);
        if(name != null && Bukkit.getPlayer(name) != null)
            player = Bukkit.getPlayer(name);
        return player;
    }

    public String getName(){
        return name;
    }

    public UUID getUuid(){
        return uuid;
    }

    public void setFriendsGUI(List<Inventory> friends){
        friendsGUI = friends;
    }

    public List<Inventory> getFriendsGUI(){
        return friendsGUI;
    }

    public Integer getGuiIndex(){
        return friendsGuiIndex;
    }

    public Inventory getGuiByIndex(int index){
        friendsGuiIndex = index;
        return friendsGUI.get(index);
    }

    public List<String> getFriends() {
        return friends;
    }

    public Boolean containsFriend(String friend){
        return friends.contains(friend);
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
}

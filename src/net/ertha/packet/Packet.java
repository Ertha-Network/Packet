package net.ertha.packet;

import java.io.Serializable;

public class Packet implements Serializable {

    private String server;
    private PlayerStorage playerStorage;

    public Packet(String serverName) {
        server = serverName;
    }
    public String getServerName() {
        return server;
    }

    public void setPlayerStorage(PlayerStorage player){
        playerStorage = player;
    }
    public PlayerStorage getPlayerStorage() {
        return playerStorage;
    }
    public Boolean hasPlayerStorage(){
        return (playerStorage != null);
    }
}


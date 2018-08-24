package com.zhangcf.model;

import java.util.UUID;

public class User {
    private String id;
    private UUID uuid;
    private String nick_name;

    public User(String id, UUID uuid, String nick_name) {
        this.id = id;
        this.uuid = uuid;
        this.nick_name = nick_name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

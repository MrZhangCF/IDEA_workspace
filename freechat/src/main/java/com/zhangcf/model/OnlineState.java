package com.zhangcf.model;

public class OnlineState {
    // 上下线的用户
    private User user;

    // 上下线状态，offline / online
    private String state;

    // 当前在线用户数
    private int users;

    public OnlineState(User user, String state, int users) {
        this.user = user;
        this.state = state;
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }
}

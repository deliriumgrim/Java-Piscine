package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class User {

    private Integer userId;

    private String login;

    private String password;

    private ArrayList<ChatRoom> roomsOwner;

    private ArrayList<ChatRoom> roomsSocial;

    public User(Integer userId, String login, String password, ArrayList<ChatRoom> roomsOwner, ArrayList<ChatRoom> roomsSocial) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.roomsOwner = roomsOwner;
        this.roomsSocial = roomsSocial;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<ChatRoom> getRoomsOwner() {
        return roomsOwner;
    }

    public void setRoomsOwner(ArrayList<ChatRoom> roomsOwner) {
        this.roomsOwner = roomsOwner;
    }

    public ArrayList<ChatRoom> getRoomsSocial() {
        return roomsSocial;
    }

    public void setRoomsSocial(ArrayList<ChatRoom> roomsSocial) {
        this.roomsSocial = roomsSocial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(roomsOwner, user.roomsOwner) && Objects.equals(roomsSocial, user.roomsSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, login, password, roomsOwner, roomsSocial);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roomsOwner=" + roomsOwner +
                ", roomsSocial=" + roomsSocial +
                '}';
    }
}
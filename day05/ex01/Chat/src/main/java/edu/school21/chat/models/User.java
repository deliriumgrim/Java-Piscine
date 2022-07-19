package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class User {

    private long userId;

    private String login;

    private String password;

    private ArrayList<ChatRoom> listOfCreatedRooms;

    private ArrayList<ChatRoom> roomsSocial;

    public User(long userId, String login, String password, ArrayList<ChatRoom> listOfCreatedRooms, ArrayList<ChatRoom> roomsSocial) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.listOfCreatedRooms = listOfCreatedRooms;
        this.roomsSocial = roomsSocial;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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

    public ArrayList<ChatRoom> getListOfCreatedRooms() {
        return listOfCreatedRooms;
    }

    public void setListOfCreatedRooms(ArrayList<ChatRoom> listOfCreatedRooms) {
        this.listOfCreatedRooms = listOfCreatedRooms;
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
        return Objects.equals(userId, user.userId) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(listOfCreatedRooms, user.listOfCreatedRooms) && Objects.equals(roomsSocial, user.roomsSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, login, password, listOfCreatedRooms, roomsSocial);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", listOfCreatedRooms=" + listOfCreatedRooms +
                ", roomsSocial=" + roomsSocial +
                '}';
    }
}
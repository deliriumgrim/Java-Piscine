package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class ChatRoom {

    private Integer roomId;

    private String roomName;

    private User owner;

    private ArrayList<Message> messages;

    public ChatRoom(Integer roomId, String roomName, User owner, ArrayList<Message> messages) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.owner = owner;
        this.messages = messages;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatRoom)) return false;
        ChatRoom chatRoom = (ChatRoom) o;
        return Objects.equals(roomId, chatRoom.roomId) && Objects.equals(roomName, chatRoom.roomName) && Objects.equals(owner, chatRoom.owner) && Objects.equals(messages, chatRoom.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, roomName, owner, messages);
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", owner=" + owner +
                ", messages=" + messages +
                '}';
    }
}

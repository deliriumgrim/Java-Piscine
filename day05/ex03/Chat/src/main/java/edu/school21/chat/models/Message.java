package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {

    private Long messageId;

    private User author;

    private ChatRoom roomMessage;

    private String text;

    private LocalDateTime time;

    public Message(Long messageId, User author, ChatRoom roomMessage, String text, LocalDateTime time) {
        this.messageId = messageId;
        this.author = author;
        this.roomMessage = roomMessage;
        this.text = text;
        this.time = time;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public ChatRoom getRoomMessage() {
        return roomMessage;
    }

    public void setRoomMessage(ChatRoom roomMessage) {
        this.roomMessage = roomMessage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equals(messageId, message.messageId) && Objects.equals(author, message.author) && Objects.equals(roomMessage, message.roomMessage) && Objects.equals(text, message.text) && Objects.equals(time, message.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, author, roomMessage, text, time);
    }

    @Override
    public String toString() {
        return "Message : {\n" +
                " messageId=" + messageId + ",\n" +
                " author=" + author + "," +
                "\n roomMessage=" + roomMessage + "," +
                "\n text='" + text + '\'' + "," +
                "\n time=" + time +
                "\n}";
    }
}

package raf.graffito.dsw.core.messageGenerator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {

    private String content;
    private String type;
    private LocalDateTime time;

    public Message(String content, String type, LocalDateTime time) {
        this.content = content;
        this.type = type;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");
        return String.format("[%s][%s] %s", type, time.format(formatter), content);
    }
}

package be.ordina.spring.domain;

/**
 * @author Ken Coenen
 */
public class Message {
    private Long id;
    private String message;
    private String recipient;

    public Message() {
    }

    public Message(Long id, String message, String recipient) {
        this.id = id;
        this.message = message;
        this.recipient = recipient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", recipient='" + recipient + '\'' +
                '}';
    }
}

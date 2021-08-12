package Notificador;

public class Notification {
    String subject;
    String body;

    public Notification(String subject, String body){
        this.subject=subject;
        this.body=body;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String toString(){
        return "["+getSubject()+"]"+getBody();
    }
}

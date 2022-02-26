package UserType;

public class GradesInfoLite {
    private static String subject;

    public GradesInfoLite(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

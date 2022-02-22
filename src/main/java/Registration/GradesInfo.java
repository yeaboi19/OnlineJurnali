package Registration;

public class GradesInfo {
    private int georgian;
    private int history;
    private int math;
    private int physics;
    private int biology;
    private int chemistry;
    private int geography;
    private int english;
    private int russian;
    private String date;


    public int getGeorgian() {
        return georgian;
    }

    public void setGeorgian(int georgian) {
        this.georgian = georgian;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getBiology() {
        return biology;
    }

    public void setBiology(int biology) {
        this.biology = biology;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public int getGeography() {
        return geography;
    }

    public void setGeography(int geography) {
        this.geography = geography;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getRussian() {
        return russian;
    }

    public void setRussian(int russian) {
        this.russian = russian;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "GradesInfo{" +
                ", georgian=" + georgian +
                ", history=" + history +
                ", math=" + math +
                ", physics=" + physics +
                ", biology=" + biology +
                ", chemistry=" + chemistry +
                ", geography=" + geography +
                ", english=" + english +
                ", russian=" + russian +
                ", date='" + date + '\'' +
                '}';
    }

    public GradesInfo(int georgian, int history, int math, int physics, int biology, int chemistry, int geography, int english, int russian, String date) {
        this.georgian = georgian;
        this.history = history;
        this.math = math;
        this.physics = physics;
        this.biology = biology;
        this.chemistry = chemistry;
        this.geography = geography;
        this.english = english;
        this.russian = russian;
        this.date = date;
    }
    public int getSubject(String subject){
        switch(subject){
            case"Georgian":
                return georgian;
            case"History":
                return history;
            case"Math":
                return math;
            case"Physics":
                return physics;
            case"Biology":
                return biology;
            case"Chemistry":
                return chemistry;
            case"English":
                return english;
            case"Russian":
                return russian;
        }
        return 0;
    }
}

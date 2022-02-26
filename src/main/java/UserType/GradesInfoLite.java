package UserType;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class GradesInfoLite {
    private final SimpleStringProperty date;
    private final SimpleIntegerProperty georgian;
    private final SimpleIntegerProperty history;
    private final SimpleIntegerProperty math;
    private final SimpleIntegerProperty physics;
    private final SimpleIntegerProperty biology;
    private final SimpleIntegerProperty chemistry;
    private final SimpleIntegerProperty geography;
    private final SimpleIntegerProperty english;
    private final SimpleIntegerProperty russian;

    public GradesInfoLite(String date, int georgian, int history, int math, int physics, int biology, int chemistry, int geography, int english, int russian) {
        this.date = new SimpleStringProperty(date);
        this.georgian = new SimpleIntegerProperty(georgian);
        this.history = new SimpleIntegerProperty(history);
        this.math = new SimpleIntegerProperty(math);
        this.physics = new SimpleIntegerProperty(physics);
        this.biology = new SimpleIntegerProperty(biology);
        this.chemistry = new SimpleIntegerProperty(chemistry);
        this.geography = new SimpleIntegerProperty(geography);
        this.english = new SimpleIntegerProperty(english);
        this.russian = new SimpleIntegerProperty(russian);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public int getGeorgian() {
        return georgian.get();
    }

    public SimpleIntegerProperty georgianProperty() {
        return georgian;
    }

    public void setGeorgian(int georgian) {
        this.georgian.set(georgian);
    }

    public int getHistory() {
        return history.get();
    }

    public SimpleIntegerProperty historyProperty() {
        return history;
    }

    public void setHistory(int history) {
        this.history.set(history);
    }

    public int getMath() {
        return math.get();
    }

    public SimpleIntegerProperty mathProperty() {
        return math;
    }

    public void setMath(int math) {
        this.math.set(math);
    }

    public int getPhysics() {
        return physics.get();
    }

    public SimpleIntegerProperty physicsProperty() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics.set(physics);
    }

    public int getBiology() {
        return biology.get();
    }

    public SimpleIntegerProperty biologyProperty() {
        return biology;
    }

    public void setBiology(int biology) {
        this.biology.set(biology);
    }

    public int getChemistry() {
        return chemistry.get();
    }

    public SimpleIntegerProperty chemistryProperty() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry.set(chemistry);
    }

    public int getGeography() {
        return geography.get();
    }

    public SimpleIntegerProperty geographyProperty() {
        return geography;
    }

    public void setGeography(int geography) {
        this.geography.set(geography);
    }

    public int getEnglish() {
        return english.get();
    }

    public SimpleIntegerProperty englishProperty() {
        return english;
    }

    public void setEnglish(int english) {
        this.english.set(english);
    }

    public int getRussian() {
        return russian.get();
    }

    public SimpleIntegerProperty russianProperty() {
        return russian;
    }

    public void setRussian(int russian) {
        this.russian.set(russian);
    }
}

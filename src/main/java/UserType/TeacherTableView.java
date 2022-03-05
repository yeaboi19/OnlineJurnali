package UserType;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public final class TeacherTableView {
    private SimpleStringProperty email;
    private SimpleStringProperty name;
    private SimpleStringProperty surname;
    private SimpleIntegerProperty grade;
    private SimpleStringProperty date;

    public TeacherTableView(String email, String name, String surname, int grade, String date) {
        this.email = new SimpleStringProperty(email);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.grade = new SimpleIntegerProperty(grade);
        this.date = new SimpleStringProperty(date);
    }

    public TeacherTableView() {}

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public int getGrade() {
        return grade.get();
    }

    public SimpleIntegerProperty gradeProperty() {
        return grade;
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public void setGrade(int grade) {
        this.grade.set(grade);
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    @Override
    public String toString() {
        return "TeacherTableView{" +
                "email=" + email +
                ", name=" + name +
                ", surname=" + surname +
                ", grade=" + grade +
                ", date=" + date +
                '}';
    }
}

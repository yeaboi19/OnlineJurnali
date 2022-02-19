package UserType;

import Registration.Entry;

public class User {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String class1; //javas ukve class radganac aaqvs class1 davarqvi
    private String subject;
    private boolean isStudent;
    private boolean isMale;

    public User(){}

    public User(String name, String lastName, String email) {
        User user = new Entry().getUser(name,lastName,email);
        this.id = user.getId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.class1 = user.getClass1();
        this.subject = user.getSubject();
        this.isStudent = user.isStudent();
        this.isMale = user.isMale();
    }

    public User(String id, String name, String lastName, String email, String class1, String subject, boolean isStudent, boolean isMale) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.class1 = class1;
        this.subject = subject;
        this.isStudent = isStudent;
        this.isMale = isMale;
    }

    public void fillNull(){
        this.id = null;
        this.name = null;
        this.lastName = null;
        this.email = null;
        this.class1 = null;
        this.subject = null;
        this.isStudent = false;
        this.isMale = false;
    }

    public boolean isNull(){
        return id==null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isStudent == user.isStudent && isMale == user.isMale && id.equals(user.id) && name.equals(user.name) && lastName.equals(user.lastName) && email.equals(user.email) && class1.equals(user.class1) && subject.equals(user.subject);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", class1='" + class1 + '\'' +
                ", subject='" + subject + '\'' +
                ", isStudent=" + isStudent +
                ", isMale=" + isMale +
                '}';
    }
}

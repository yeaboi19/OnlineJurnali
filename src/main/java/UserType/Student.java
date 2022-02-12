package UserType;

public class Student {
    private String name;
    private String lastname;
    private int ID;

    public Student(String name, String lastname, int ID) {
        this.name = name;
        this.lastname = lastname;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "UserType.Student{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", ID=" + ID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return ID == student.ID && name.equals(student.name) && lastname.equals(student.lastname);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

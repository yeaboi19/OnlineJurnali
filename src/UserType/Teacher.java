package UserType;

public class Teacher {
    private String name;
    private String lastname;
    private int ID;

    public Teacher(String name, String lastname, int ID) {
        this.name = name;
        this.lastname = lastname;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "UserType.Teacher{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", ID=" + ID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return ID == teacher.ID && name.equals(teacher.name) && lastname.equals(teacher.lastname);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

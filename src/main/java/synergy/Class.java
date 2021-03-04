package synergy;

public class Class {
    public String name;
    public String teacher;
    public String grade;

    public Class(String name, String teacher) {
        this.name = name;
        this.teacher = teacher;
        this.grade = "none";
    }

    public Class(String name, String teacher, String grade){
        this.name = name;
        this.teacher = teacher;
        this.grade = grade;
    }
}

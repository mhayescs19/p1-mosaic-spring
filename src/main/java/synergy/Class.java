package synergy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Class {
    @JsonProperty("Name")
    public String name;
    @JsonProperty("Teacher")
    public String teacher;
    @JsonProperty("Grade")
    public String grade;
    @JsonProperty("Period")
    private Integer period;
    @JsonProperty("Assignments")
    public List<Assignment> assignments;

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
    public Class()
    {

    }

}

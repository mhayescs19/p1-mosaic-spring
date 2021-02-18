package synergy;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Setter
@Getter
public class Synergy {
    public Synergy synergy;

    static public String nameKy = "Name";
    static public String yearKy = "Year";
    static public String gradeKy = "Grade";
    static public String ageKy = "Age";


    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @NotNull
    @Min(1)
    @Max(99)
    private Integer age;

    @NotNull
    private String year;

    @NotNull
    @Size(min = 1, max = 2)
    private String grade;

    public Synergy() {

    }

}
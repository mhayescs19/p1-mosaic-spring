package synergy;

import com.example.project.NewUser.NewUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;

/**
 * dto object that can be converted into something we can send off to the data base and use to map to.
 * @see com.example.project.MainController#Synergy()
 */
public class Synergy {

    static public String nameKy = "Name";
    static public String yearKy = "Year";
    static public String gradeKy = "Grade";
    static public String ageKy = "Age";
    static public String IDKy = "IDNumber";
    @JsonProperty("Name")
    private String Name;
    @JsonProperty("Age")
    private Integer Age;
    @JsonProperty("Year")
    private String Year;
    @JsonProperty("Grade")
    private String Grade;
    @JsonProperty("IdNumber")
    private String IdNumber;

    public HashMap<String,Object> toHashMap()
    {
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put(nameKy,getName()); hashMap.put(yearKy,getYear()); hashMap.put(gradeKy,getGrade());
        hashMap.put(ageKy,getAge());
        hashMap.put(IDKy,getIdNumber());
        hashMap.put("Assignments", new HashMap<>());
        return hashMap;
    }
    public Synergy() {

    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getIdNumber() {
        return IdNumber;
    }

    public void setIdNumber(String idNumber) {
        IdNumber = idNumber;
    }

}
package synergy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.management.ConstructorParameters;

@Setter
@Getter
public class Assignment {
    @JsonProperty("Date")
    private String date;
    @JsonProperty("Name")
    private String assignmentTitle;
    @JsonProperty("Score")
    private double score;
    @JsonProperty("Points")
    private double points;
    @JsonProperty("Notes")
    private String notes;
    @JsonProperty("Grade")
    private String grade;

    public Assignment(String date, String assignmentTitle, double score, double points, String notes) {
        this.date = date;
        this.assignmentTitle = assignmentTitle;
        this.score = score;
        this.points = points;
        this.notes = notes;
    }
    public Assignment() //default constructor need for jackson data binding
    {

    }

    @Override
    public String toString() {
        return "Assignment{" +
                "date='" + date + '\'' +
                ", assignmentTitle='" + assignmentTitle + '\'' +
                ", score=" + score +
                ", points=" + points +
                ", notes='" + notes + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}

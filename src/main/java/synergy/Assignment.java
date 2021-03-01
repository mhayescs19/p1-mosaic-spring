package synergy;

import lombok.Getter;
import lombok.Setter;

import javax.management.ConstructorParameters;

@Setter
@Getter
public class Assignment {
    private String date;
    private String assignmentTitle;
    private double score;
    private double points;
    private String notes;

    public Assignment(String date, String assignmentTitle, double score, double points, String notes) {
        this.date = date;
        this.assignmentTitle = assignmentTitle;
        this.score = score;
        this.points = points;
        this.notes = notes;
    }
}

package android.reserver.projectc196v5.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName="assessment_table")
public class AssessmentEntity {

    @PrimaryKey
    private int assessmentID;

    private String assessmentName;
    private String assessmentEndDate;
    private int assessmentFinal;
    private int courseID;

    @Override
    public String toString() {
        return "AssessmentEntity{" +
                "assessmentID=" + assessmentID +
                ", assessmentName='" + assessmentName + '\'' +
                ", assessmentEndDate=" + assessmentEndDate +
                ", assessmentFinal=" + assessmentFinal +
                ", courseID=" + courseID +
                '}';
    }

    public AssessmentEntity(int assessmentID, String assessmentName, String assessmentEndDate, int assessmentFinal, int courseID) {
        this.assessmentID = assessmentID;
        this.assessmentName = assessmentName;
        this.assessmentEndDate = assessmentEndDate;
        this.assessmentFinal = assessmentFinal;
        this.courseID = courseID;
    }

    public int getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public String getAssessmentEndDate() {
        return assessmentEndDate;
    }

    public void setAssessmentEndDate(String assessmentEndDate) {
        this.assessmentEndDate = assessmentEndDate;
    }

    public int getAssessmentFinal() {
        return assessmentFinal;
    }

    public void setAssessmentFinal(int assessmentFinal) {
        this.assessmentFinal = assessmentFinal;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}

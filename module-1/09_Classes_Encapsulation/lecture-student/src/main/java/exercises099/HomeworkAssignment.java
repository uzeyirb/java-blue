package exercises099;

public class HomeworkAssignment {


  private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private int getLetterGrade;


    public int getEarnedMarks() {
        return earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public HomeworkAssignment(int possibleMarks, String submitterName) {

        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }


    public String getLetterGrade () {

        if ((((double)earnedMarks / possibleMarks) * possibleMarks) >= 90) {
            return "A";
        } else if ((((double)earnedMarks/ possibleMarks) * possibleMarks) >= 80) {
            return "B";
        } else if ((((double)earnedMarks / possibleMarks) * possibleMarks) >= 70) {
            return "C";
        } else if ((((double)earnedMarks / possibleMarks) * possibleMarks) >= 60) {
            return "D";
        } else {
            return "F";
        }
    }


}

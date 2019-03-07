package io.zipcoder;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> testScores;

    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        if(examScores!=null){this.testScores = new ArrayList<Double>(Arrays.asList(examScores));}
        else{this.testScores = new ArrayList<>();}
        for (Double score : testScores) {
            if (score < 0) {
                throw new IllegalArgumentException("You must insert a positive number");
            }
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Double> getTestScores() {
        return testScores;
    }

    public Integer getNumberOfExamsTaken() {
        return testScores.size();
    }

    public String getExamScores() {
        String examScores = "Exam Scores:\n";
        Integer examNumber = 0;
        for (Double exam : testScores) {
            examNumber++;
            examScores += String.format("   Exam %d -> %.0f\n", examNumber, exam);
        }
        return examScores;
    }

    public void addExamScore(Double score) {
        if (score > 0) {
            testScores.add(score);
        } else {
            throw new IllegalArgumentException("You must enter a positive number");
        }
    }

    public void setExamScore(int examNumber, double score) {
        testScores.set(testScores.size()-1,score);

    }

    public Double getAverageExamScore() {
        Double average = 0.0;
        for (Double grade : testScores) {
            average += grade;
        }
        return average / testScores.size();
    }

    public String toString() {
        String studentRecord = String.format("Student Name: %s %s\n>Average Score: %.0f\n>%s",firstName,lastName,getAverageExamScore(),getExamScores());
        return studentRecord;
    }
}

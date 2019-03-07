package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ComparisonFailure;
import org.junit.Test;

import java.util.ArrayList;

public class StudentTest {

    @Test
    public void constructorTest(){
        //Given
        String firstName = "Joel";
        String lastName = "Embiid";
        Double[] examScores = {21.0,10.0,9.0};
        Student student = new Student(firstName, lastName, examScores);
        String expectedFirst = "Joel";
        String expectedLast = "Embiid";
        ArrayList<Double> expectedScore = new ArrayList<>();
        expectedScore.add(21.0);
        expectedScore.add(10.0);
        expectedScore.add(9.0);

        //When
        String actualFirst = student.getFirstName();
        String actualLast = student.getLastName();
        ArrayList<Double> actualScore = student.getTestScores();

        //Then
        Assert.assertEquals(expectedFirst,actualFirst);
        Assert.assertEquals(expectedLast,actualLast);
        Assert.assertEquals(expectedScore,actualScore);

    }


    @Test
    public void setFirstNameTest() {
        //Given
        String firstName = "Mark";
        String lastName = "Knoll";
        Double[] examScores = {90.0, 90.0, 100.0, 95.0};
        Student student = new Student(firstName, lastName, examScores);
        String expected = "Ben";


        //When
        student.setFirstName(expected);
        String actual = student.getFirstName();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void setLastNameTest() {
        //Given
        String firstName = "Mark";
        String lastName = "Knoll";
        Double[] examScores = {90.0, 90.0, 100.0, 95.0};
        Student student = new Student(firstName, lastName, examScores);
        String expected = "Simmons";

        //When
        student.setLastName(expected);
        String actual = student.getLastName();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getNumberOfExamsTakenTest() {
        //Given
        String firstName = "Pat";
        String lastName = "Willis";
        Double[] examScores = {90.0, 90.0, 100.0, 95.0};
        Student student = new Student(firstName, lastName, examScores);
        Integer expected = 4;

        //When
        Integer actual = student.getNumberOfExamsTaken();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void emptyArrayTest() {
        //Given
        String firstName = "Austin";
        String lastName = "Power";
        Double[] examScores = {};
        Student student = new Student(firstName, lastName, examScores);
        Integer expected = 0;

        //When
        Integer actual = student.getNumberOfExamsTaken();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeExamTest() {
        //Given
        String firstName = "Bryce";
        String lastName = "Harper";
        Double[] examScores = {-100.0, -95.0, -123.0, -96.0};
        Student student = new Student(firstName, lastName, examScores);


        //When
        Integer actual = student.getNumberOfExamsTaken();

        //Then


    }

    @Test
    public void getExamScoresTest() {
        //Given
        String firstName = "Ling";
        String lastName = "Gweenie";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student(firstName, lastName, examScores);
        String expected = "Exam Scores:\n   Exam 1 -> 100\n   Exam 2 -> 95\n   Exam 3 -> 123\n   Exam 4 -> 96\n";

        //When
        String actual = student.getExamScores();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeExamScoresTest() {
        //Given
        String firstName = "Coding";
        String lastName = "Dragon";
        Double[] examScores = {-95.0, -5.0, -123.0, -96.0};
        Student student = new Student(firstName, lastName, examScores);

        //When
        String actual = student.getExamScores();

        //Then

    }

    @Test
    public void addExamScoreTest() {
        //Given
        String firstName = "Brian";
        String lastName = "Wong";
        Double[] examScores = {};
        Student student = new Student(firstName,lastName,examScores);
        String expected = "Exam Scores:\n   Exam 1 -> 155\n";

        //When
        student.addExamScore(155.0);
        String actual = student.getExamScores();
        System.out.println(examScores.length);

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNegativeExamScoreTest() {
        //Given
        String firstName = "Brian";
        String lastName = "Wong";
        Double[] examScores = {120.0,100.0,110.0};
        Student student = new Student(firstName,lastName,examScores);
        Double expected = 100.0;

        //When
        student.addExamScore(-100.0);


        //Then

    }

    @Test
    public void setExamScoreTest(){
        //Given
        String firstName = "Jus";
        String lastName = "Sayain";
        Double[] examScores = {0.0};
        Student student = new Student(firstName,lastName,examScores);
        String expected = "Exam Scores:\n   Exam 1 -> 90\n";

        //When
        student.setExamScore(1,90.0);
        String actual = student.getExamScores();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = ComparisonFailure.class)
    public void setExamScoreforNegative() {
        //Given
        String firstName = "Yao";
        String lastName = "Lin";
        Double[] examScores = {0.0};
        Student student = new Student(firstName,lastName,examScores);
        String expected = "Exam Scores:\n   Exam 1 -> 90";

        //When
        student.setExamScore(0,90.0);
        String actual = student.getExamScores();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAverageExamScoreTest() {
        //Given
        String firstName ="Randy";
        String lastName = "Moss";
        Double[] examScores = {20.0,40.0,60.0,80.0,100.0};
        Student student = new Student(firstName,lastName,examScores);
        Double expected = 60.0;

        //When
        Double actual = student.getAverageExamScore();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getNegativeAverageExamScoreTest() {
        //Given
        String firstName ="Randy";
        String lastName = "Moss";
        Double[] examScores = {-20.0,-40.0,-60.0,-80.0,-100.0};
        Student student = new Student(firstName,lastName,examScores);
        Double expected = 60.0;

        //When
        Double actual = student.getAverageExamScore();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void toStringTest() {
        //Given
        String firstName = "Tom";
        String lastName = "Brady";
        Double[] examScores = {100.0,90.0,80.0,100.0};
        Student student = new Student(firstName,lastName,examScores);
        String expected = "Student Name: Tom Brady\n>Average Score: 93\n>Exam Scores:\n   Exam 1 -> 100\n   Exam 2 -> 90\n   Exam 3 -> 80\n   Exam 4 -> 100\n";

        //When
        String actual = student.toString();

        //Then
        Assert.assertEquals(expected,actual);
    }



}
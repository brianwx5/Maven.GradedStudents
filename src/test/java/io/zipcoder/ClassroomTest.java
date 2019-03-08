package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {

    @Test
    public void maxClassSizeConstructorTest() {
        //Given
        Classroom classroom = new Classroom(20);
        Integer expected = 20;

        //When
        Integer length = classroom.getStudents().length;

        //Then
        Assert.assertEquals(expected,length);

    }

    @Test(expected = NegativeArraySizeException.class)
    public void negativeClassSizeConstructorTest() {
        //Given
        Classroom classroom = new Classroom(-1);
        Integer expected = -1;

        //When
        Integer length = classroom.getStudents().length;

        //Then
        Assert.assertEquals(expected,length);

    }

    @Test
    public void constructorWithStudentArrayTest() {
        //Given
        Double[] array = {25.0};
        Student student = new Student("John","Paul",array);
        Student[] students = new Student[1];
        students[0] = student;
        Classroom classroom = new Classroom(students);
        Integer expected = 1;

        //When
        Integer actual = classroom.getStudents().length;

        //Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void nullaryConstructorTest() {
        //Given
        Classroom classroom = new Classroom();
        Integer expected = 30;

        //When
        Integer actual = classroom.getStudents().length;

        //Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getAverageExamScoreTest() {
        //Given
        Double[] student1Score = {120.0,130.0};
        Double[] student2Score = {20.0,230.0};
        Student student1 = new Student("Jim","Cramer",student1Score);
        Student student2 = new Student("Eric","Rowe",student2Score);
        Student[] students = new Student[]{student1,student2};
        Classroom classroom = new Classroom(students);
        Double expected = 125.0;

        //When
        Double actual = classroom.getAverageExamScore();

        //Then
        Assert.assertEquals(expected,actual);

    }

    @Test (expected = IllegalArgumentException.class)
    public void getNegativeAverageExamScoreTest() {
        //Given
        Double[] student1Score = {-1.0,-1.0};
        Double[] student2Score = {-1.0,-1.0};
        Student student1 = new Student("Jim","Cramer",student1Score);
        Student student2 = new Student("Eric","Rowe",student2Score);
        Student[] students = new Student[]{student1,student2};
        Classroom classroom = new Classroom(students);
        Double expected = -1.0;

        //When
        Double actual = classroom.getAverageExamScore();

        //Then
        Assert.assertEquals(expected,actual);

    }

    @Test (expected = NullPointerException.class)
    public void getAverageExamScoreWithNullTest() {
        //Given
        Double[] student1Score = {120.0,130.0};
        Double[] student2Score = {null,230.0};
        Student student1 = new Student("Jim","Cramer",student1Score);
        Student student2 = new Student("Eric","Rowe",student2Score);
        Student[] students = new Student[]{student1,student2};
        Classroom classroom = new Classroom(students);
        Double expected = 125.0;

        //When
        Double actual = classroom.getAverageExamScore();

        //Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void addStudentTest(){
        //Given
        int maximumNumberOfStudents = 1;
        Classroom classroom = new Classroom(maximumNumberOfStudents);
        Double[] examScores = {125.0,150.0,175.0};
        Student student = new Student("Leon","Hunter",examScores);
        String expected = student.toString();

        //When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        //Then
        String actual = postEnrollment[0].toString();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void addStudentWithNullConstructorTest(){
        //Given
        Classroom classroom = new Classroom();
        Double[] examScores = {125.0,150.0,175.0};
        Student student = new Student("Leon","Hunter",examScores);
        int maxStudentSize = 30;

        //When
        for(int i = 0; i < maxStudentSize; i++) {
            classroom.addStudent(student);
        }

        //Then
        Assert.assertEquals(maxStudentSize, classroom.getStudents().length);

    }

    @Test
    public void addStudentWithArrayTest() {
        Double[] examScores = {125.0,150.0,175.0};
        Student student = new Student("Leon","Hunter",examScores);
        Double[] examScores2 = {125.0,150.0,175.0};
        Student student2 = new Student("Leon","Hunter",examScores2);
        Student[] students = {student,student2};
        Classroom classroom= new Classroom(students);
        Integer preClassSize = students.length+1;


        //When
        Double[] examScores3 = {125.0,150.0,175.0};
        Student student3 = new Student("Leon","Hunter",examScores3);
        classroom.addStudent(student3);
        Integer postClassSize = classroom.getStudents().length;

        //Then
        Assert.assertEquals(preClassSize,postClassSize);

    }

    @Test
    public void removeStudentWithMaximumSizeTest(){
        //Given
        int maximumNumberOfStudents = 1;
        Classroom classroom2 = new Classroom(maximumNumberOfStudents);
        Double[] examScores = {125.0,150.0,170.0};
        Student student = new Student("Leon","Hunter",examScores);

        //When
        Student[] preEnrollment = classroom2.getStudents();
        for (Student students : preEnrollment) {
            System.out.println(students);
        }
        classroom2.addStudent(student);
        String firstName = "Leon";
        String lastName = "Hunter";
        classroom2.removeStudent(firstName,lastName);
        for (Student students : preEnrollment) {
            System.out.println("After remove :"+ students);
        }
        Student[] postEnrollment = classroom2.getStudents();

        //Then
        //Assert.assertEquals(preEnrollment,postEnrollment);
        Assert.assertArrayEquals(postEnrollment, preEnrollment);

    }

    @Test
    public void removeStudentWithNullaryConstructorTest(){
        //Given
        Classroom classroom2 = new Classroom();
        Double[] examScores = {125.0,150.0,170.0};
        Student student = new Student("Leon","Hunter",examScores);
        Double[] examScores2 = {125.0,150.0,180.0};
        Student student2 = new Student("Harry","Potter",examScores2);

        //When;
        classroom2.addStudent(student2);
        Student[] preEnrollment = classroom2.getStudents();
        classroom2.addStudent(student);
        String firstName = "Leon";
        String lastName = "Hunter";
        classroom2.removeStudent(firstName,lastName);
        Student[] postEnrollment = classroom2.getStudents();

        //Then
        //Assert.assertEquals(preEnrollment,postEnrollment);
        Assert.assertArrayEquals(postEnrollment, preEnrollment);

    }

    @Test
    public void removeStudentWithArrayInsertedTest() {
        //Given
        String firstName = "Leon";
        String lastName = "Hunter";

        Double[] examscore = {120.0,110.0,10.0};
        Student student = new Student(firstName,lastName, examscore);
        Double[] examScores2 = {125.0,150.0,180.0};
        Student student2 = new Student("Harry","Potter",examScores2);

        Student[] studentArray = {student,student2};
        Classroom classroom = new Classroom(studentArray);

        Student[] expectedArray = { student2, null};

        //When
        classroom.removeStudent(firstName, lastName);
        Student[] actualArray = classroom.getStudents();

        //Then
        Assert.assertArrayEquals(expectedArray,actualArray);
    }

    @Test
    public void getStudentsByScoreTest() {
        //Given
        Double[] examscore = {120.0,200.0,100.0};
        Student student1 = new Student("Larry","Potter",examscore);
        Double[] examscore2 = {120.0,110.0,80.0};
        Student student2 = new Student("Barry","Potter",examscore2);
        Double[] examscore3 = {120.0,110.0,150.0};
        Student student3 = new Student("Harry","Potter",examscore3);
        Student[] studentArray = {student1,student2,student3};
        Classroom classroom4 = new Classroom(studentArray);
        Student[] expected = {student1,student3,student2};


        //When
        Student[] actual = classroom4.getStudentsByScore();


        //Then
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void getStudentsByScoreWithNameEqualsTest() {
        //Given
        Double[] examscore = {120.0,110.0,100.0};
        Student student1 = new Student("Larry","Potter",examscore);
        Double[] examscore2 = {120.0,110.0,100.0};
        Student student2 = new Student("Barry","Potter",examscore);
        Double[] examscore3 = {120.0,110.0,100.0};
        Student student3 = new Student("Harry","Potter",examscore);
        Student[] studentArray = {student1,student2,student3};
        Classroom classroom = new Classroom(studentArray);
        Student[] expected = {student2,student3,student1};


        //When
        Student[] actual = classroom.getStudentsByScore();


        //Then
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void getGradeBookTest() {
        //Given
        Double[] testScores1 = {10.0, 10.0, 10.0, 10.0};
        Student studentOne = new Student("Cristina", "McClintock", testScores1);

        Double[] testScores2 = {20.0, 20.0, 20.0, 20.0};
        Student studentTwo = new Student("Marci", "Brahma",testScores2);

        Double[] testScores3 = {30.0, 30.0, 30.0, 30.0};
        Student studentThree = new Student("Eric", "Jefferson", testScores3);

        Double[] testScores4 = {40.0, 40.0, 40.0, 40.0};
        Student studentFour = new Student("John", "Doe", testScores4);

        Double[] testScores5 = {50.0, 50.0, 50.0, 50.0};
        Student studentFive = new Student("Jane", "Smith", testScores5);

        Double[] testScores6 = {60.0, 60.0, 60.0, 60.0};
        Student studentSix = new Student("Tom", "Hanks",testScores6);

        Double[] testScores7 = {70.0, 70.0, 70.0, 70.0};
        Student studentSeven = new Student("Ann", "Thomas", testScores7);

        Double[] testScores8 = {80.0, 80.0, 80.0, 80.0};
        Student studentEight = new Student("Brittney", "Spears", testScores8);

        Double[] testScores9 = {90.0, 90.0, 90.0, 90.0};
        Student studentNine= new Student("Jessie", "James",testScores9);

        Double[] testScores10 = {100.0, 100.0, 100.0, 100.0};
        Student studentTen = new Student("Eric", "Decker", testScores10);

        Student[] arrayOfStudents = {studentOne, studentTwo, studentThree, studentFour, studentFive,
                studentSix, studentSeven, studentEight, studentNine, studentTen};

        Classroom classroom = new Classroom(arrayOfStudents);
        String expected = "B";

        //When
        String actual = classroom.getGradeBook().get(studentNine);

        //Then
        Assert.assertEquals(expected,actual);
    }

}

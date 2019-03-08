package io.zipcoder;

import java.security.PublicKey;
import java.util.*;

class Classroom {
    private int size;
    private Student[] students;

    public Classroom(int maxSize) {
        this.students = new Student[maxSize];
    }

    public Classroom(Student[] students) {
        this.students = students;
        this.size = students.length;
    }

    public Classroom() {
        this(30);
    }

    public Student[] getStudents() {
        return this.students;
    }

    public Double getAverageExamScore() {
        double score = 0;
        for(Student student : students) {
            score += student.getAverageExamScore();
        }

        return score/students.length;
    }

    public void addStudent(Student student) {
        if(students.length == size) {
            this.students = Arrays.copyOf(students, size + 1);
        }

        students[size] = student;
        size++;
    }

    public void removeStudent(String firstName, String lastName) {
        for(int i = 0; i < students.length; i++) {
            Student student = students[i];
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                shiftStudentToTheRight(i);
                students[size-1] = null;
                break;
            }
        }


        size--;
    }

    private void shiftStudentToTheRight(int startIndex) {
        for(int i = startIndex; i < students.length - 1; i++) {
            students[i] = students[i + 1];
        }
    }

    public Student[] getStudentsByScore() {
        GradeComparator gradeComparator = new GradeComparator();
        Student[] newArray = Arrays.copyOf(students,students.length);
        Arrays.sort(newArray,gradeComparator);
        return  newArray;

    }

    public HashMap<Student,String> getGradeBook() {
        HashMap<Student,String> gradebook = new HashMap<>();
        Student[] studentsByGrade = getStudentsByScore();
        for (int i = 0; i < studentsByGrade.length ; i++) {
            double percentile = (((i+1)/(double) studentsByGrade.length)*100);
            System.out.println(percentile);
            if(percentile <= 10.0) {
                gradebook.put(studentsByGrade[i],"A");
            } else if (percentile >10.0 && percentile <= 29.0) {
                gradebook.put(studentsByGrade[i],"B");
            } else if (percentile >29.0 && percentile <= 50.0) {
                gradebook.put(studentsByGrade[i],"C");
            } else if (percentile >50.0 && percentile <= 89.0) {
                gradebook.put(studentsByGrade[i],"D");
            } else if (percentile >89.0 && percentile <= 100.0) {
                gradebook.put(studentsByGrade[i],"F");
            }
        }
        return gradebook;
    }

//
//    fun removeStudent(firstName: String, lastName: String) {
//
//        for (i in students!!.indices) {
//            if (students!![i].firstName == firstName && students!![i].lastName == lastName) {
//                if (i <= students!!.size - 2) {
//                    val temp = students!![i]
//                    students[i] = students!![i + 1]
//                    students[i + 1] = temp
//                } else if (i == students!!.size - 1) {
//                    students[i] = null
//                }
//            }
//
//        }
//
//    }


}

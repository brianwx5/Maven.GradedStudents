package io.zipcoder;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

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

    public TreeMap<Student,String> getGradeBook() {
        TreeMap<Student,String> gradebook = new TreeMap<>();
        Student[] studentsByGrade = getStudentsByScore();
        for (int i = 0; i < studentsByGrade.length ; i++) {
            Double percentile = (double) ((i+1)/studentsByGrade.length);
            if(percentile <= 10) {
                gradebook.put(studentsByGrade[i],"A");
            } else if (percentile >10 && percentile <= 29) {
                gradebook.put(studentsByGrade[i],"B");
            } else if (percentile >29 && percentile <= 50) {
                gradebook.put(studentsByGrade[i],"C");
            } else if (percentile >51 && percentile <= 89) {
                gradebook.put(studentsByGrade[i],"D");
            } else if (percentile >90 && percentile <= 100) {
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

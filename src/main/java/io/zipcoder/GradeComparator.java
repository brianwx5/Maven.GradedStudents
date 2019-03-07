package io.zipcoder;

import java.util.Comparator;

public class GradeComparator implements Comparator<Student> {

    public int compare(Student student1, Student student2) {
        int i = 0;
        int ans = (int) (student2.getAverageExamScore() - student1.getAverageExamScore());
        if( ans == 0) {
            ans = student1.getFirstName().compareTo(student2.getFirstName());
        }

        return ans;
    }
}

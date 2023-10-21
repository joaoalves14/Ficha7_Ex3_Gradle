package org.example;

import java.util.ArrayList;
import java.util.List;

public class CU {
    private String nameCU;
    private List<Mark> marks;
    private int totalStudents;

    public CU(String nameCU, int totalStudents) {
        this.nameCU = nameCU;
        this.marks = new ArrayList<>();
        this.totalStudents = totalStudents;
    }

    public void insertMarkCU(int numStudent, double mark) {
        if (marks.size() < totalStudents) {
            marks.add(new Mark(numStudent, mark));
        }
    }

    public double searchStudent(int numStudent) {
        for (Mark mark : marks) {
            if (mark.getNumStudent() == numStudent) {
                return mark.getMark();
            }
        }
        return -1;
    }

    public double averageCU() {
        if (marks.isEmpty()) {
            return 0.0;
        }

        double totalMarks = 0.0;
        for (Mark mark : marks) {
            totalMarks += mark.getMark();
        }
        return totalMarks / marks.size();
    }

    public boolean isApproved(int numStudent) {
        double studentMark = searchStudent(numStudent);
        return studentMark >= 9.5;
    }
}


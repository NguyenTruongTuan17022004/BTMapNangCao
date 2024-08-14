package NangCaoVeMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentGrades {
    private Map<String, List<String>> gradeMap;
    public StudentGrades(){
        gradeMap = new HashMap<>();
        gradeMap.put("A", new ArrayList<>());
        gradeMap.put("B", new ArrayList<>());
        gradeMap.put("C", new ArrayList<>());
        gradeMap.put("D", new ArrayList<>());
        gradeMap.put("F", new ArrayList<>());
    }
    private String getGrade(int score){
        if(score >= 86){
            return "A";
        } else if (score >= 76) {
            return "B";
        } else if (score >= 66) {
            return "C";
        } else if (score >= 51) {
            return "D";
        }else {
            return "F";
        }
    }
    //Thêm sinh viên vào hệ thống và tự động phân loại.
    public void addStundent(String name, int score){
        String grade = getGrade(score);
        gradeMap.computeIfAbsent(grade, k -> new ArrayList<>()).add(name);
    }

    // Lấy danh sách sinh viên thuộc một loại cụ thể.
    public List<String> getStudentsByGrade(String grade){
        List<String> students = gradeMap.get(grade);
        if(students == null){
            return new ArrayList<>();
        }
        return students;
    }
    // Hiển thị tất cả sinh viên phân theo loại
    public void displayAllGrades() {
        for (Map.Entry<String, List<String>> entry : gradeMap.entrySet()) {
            String grade = entry.getKey();
            List<String> students = entry.getValue();
            System.out.println("Grade " + grade + ": " + students);
        }
    }

    public static void main(String[] args) {
        StudentGrades studentGrades = new StudentGrades();
        studentGrades.addStundent("Nguyen Van A", 92);
        studentGrades.addStundent("Dinh THi B", 78);
        studentGrades.addStundent("Ho Tung C", 60);
        studentGrades.addStundent("Mai Nguyen D", 45);

        studentGrades.displayAllGrades();
    }

}

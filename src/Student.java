import java.util.ArrayList;

public class Student implements java.io.Serializable {
    private String studentName;
    private ArrayList<Subject> subjects;

    public Student(){
        this.studentName = "Unnamed student";
        this.subjects = new ArrayList<>();
    }
    //Student constructor
    public Student(String newStudentName) {
        this.studentName = newStudentName;
        this.subjects = new ArrayList<>();
    }

    public Subject addSubject(String subjectTitle){
        Subject subject = new Subject(subjectTitle);
        subjects.add(subject);
        return subject;
    }

    public void deleteSubject(int index){
        subjects.remove(index);
    }

    public void displaySubject(int index){
        System.out.println("Subject: " + getSubject(index).getSubjectName());
        getSubject(index).displayAssignments();
    }

    public void displaySubjects(){
        System.out.println("Subjects\n--------------");
        if (subjects.size() == 0){
            System.out.println("There are no subjects currently.");
        }else {
            for (int i = 0; i < subjects.size(); i++) {
                System.out.println("Subject " + (i+1) + ": " + subjects.get(i).getSubjectName() + "\n");
            }
        }
        System.out.print("\n");
    }

    public int numberOfSubjects(){
        return subjects.size();
    }

    public Subject getSubject(int index){
        return subjects.get(index);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
import java.util.ArrayList;

public class Student implements java.io.Serializable {

    // Student properties
    private String studentName;
    private ArrayList<Subject> subjects;

    // Student constructors
    public Student(){
        this.studentName = "Unnamed student";
        this.subjects = new ArrayList<>();
    }

    public Student(String newStudentName) {
        this.studentName = newStudentName;
        this.subjects = new ArrayList<>();
    }

    public Subject addSubject(String subjectTitle){ //this function takes in a subject name and uses it to create a new subject
        Subject subject = new Subject(subjectTitle); //create a new subject object with the name that was passed in
        subjects.add(subject); // add the new subject to the subject array list
        return subject; // after the subject has been added return that subject
    }

    public void deleteSubject(int index){ // this function takes in a number to reference to a subject from the array list of subjects to be deleted
        subjects.remove(index); // delete the subject at the index given from the subject array list
    }

    public void displaySubject(int index){ // function to display a single subject and the subject's assignments contained within
        System.out.println("Subject: " + getSubject(index).getSubjectName());
        getSubject(index).displayAssignments();
    }

    public void displaySubjects(){ // function to display all of a student's subjects
        System.out.println("Subjects\n--------------");
        if (subjects.size() == 0){
            System.out.println("There are no subjects currently.");
        }else { // as long as subjects exist, display them
            for (int i = 0; i < subjects.size(); i++) {
                System.out.println("Subject " + (i+1) + ": " + subjects.get(i).getSubjectName() + "\n"); // added 1 to the index for formatting output, for the subject in the array get the subject name
            }
        }
        System.out.print("\n");
    }

    public int numberOfSubjects(){ // function to get the number of subjects contained in the student's array of subjects
        return subjects.size();
    }

    public Subject getSubject(int index){ // function to return a student's subject referenced to by the index passed in
        return subjects.get(index);
    }

    public String getStudentName() { // function to return student name
        return studentName;
    }

    public void setStudentName(String studentName) { // function to set the student name
        this.studentName = studentName;
    }
}
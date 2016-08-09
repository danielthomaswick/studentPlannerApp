import java.util.ArrayList;

public class Subject{
    private String subjectName;
    private ArrayList<Assignment> assignments;

    public Subject(String newSubject){
        this.subjectName = newSubject;
        this.assignments = new ArrayList<>();
    }

    public Subject(){
        this.subjectName = "Unnamed Subject";
        this.assignments = new ArrayList<>();
    }

    public Assignment addAssignment(String assignmentName, String dueDate){
        Assignment assignment = new Assignment(assignmentName, dueDate);
        assignments.add(assignment);
        return assignment;
    }

    public void deleteAssignment(int index){
        assignments.remove(index);
    }

    public void displayAssignments(){
        System.out.println("Assignments\n-------------------");
        if (assignments.size() == 0){
            System.out.println("There are no assignments currently.");
        }else{
            for (int i = 0; i < assignments.size(); i++){
                System.out.println("Assignment " + (i+1) + ": " + assignments.get(i).getAssignmentName() + ", Due: " + assignments.get(i).getDueDate());
            }
        }
        System.out.print("\n");
    }


    public int numberOfAssignments() {
        return assignments.size();
    }

    public void displayAssignmentsWithNotes(){
        System.out.println("Assignments + Notes\n--------------------");
        if (assignments.size() == 0){
            System.out.println("There are no assignments currently.");
        }else {
            for (int i = 0; i < assignments.size(); i++) {
                System.out.println("Assignment " + (i+1) + ":" + assignments.get(i).toString() + "\n");
            }
        }
        System.out.print("\n");
    }

    public Assignment getAssignment(int index){
        return assignments.get(index);
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}

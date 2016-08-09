import java.util.ArrayList;

public class Subject{

    // Subject properties
    private String subjectName;
    private ArrayList<Assignment> assignments;

    // Subject constructors
    public Subject(String newSubject){
        this.subjectName = newSubject;
        this.assignments = new ArrayList<>();
    }

    public Subject(){
        this.subjectName = "Unnamed Subject";
        this.assignments = new ArrayList<>();
    }

    public Assignment addAssignment(String assignmentName, String dueDate){ // passes in a name and due date for creating a new assignment
        Assignment assignment = new Assignment(assignmentName, dueDate); // create a new assignment object using incoming variables
        assignments.add(assignment); // add the assignment to the array list of assignments
        return assignment; // after creating the assignment return it
    }

    public void deleteAssignment(int index){ // deletes assignment at index number being passed in
        assignments.remove(index);
    }

    public void displayAssignments(){ // function displays all the assignments for a subject, as long as they exist
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

    public int numberOfAssignments() { // return the number of assignments that are contained inside an object
        return assignments.size();
    }

    public void displayAssignmentsWithNotes(){ //displays and Assignment with its' notes
        System.out.println("Assignments + Notes\n--------------------");
        if (assignments.size() == 0){ //if there are no assignments in the array list of assignments then output a message explaining that
            System.out.println("There are no assignments currently.");
        }else {
            for (int i = 0; i < assignments.size(); i++) {
                System.out.println("Assignment " + (i+1) + ":" + assignments.get(i).toString() + "\n");
            }
        }
        System.out.print("\n");
    }

    public Assignment getAssignment(int index){ // function to return a subject's assignment
        return assignments.get(index);
    }

    public String getSubjectName() { // function to return the subject's name
        return subjectName;
    }

    public void setSubjectName(String subjectName) { // function to change the subject's name to the string being passed in
        this.subjectName = subjectName;
    }
}

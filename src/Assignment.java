import java.util.ArrayList;

public class Assignment{

    private String assignmentName;
    private String dueDate;
    private ArrayList<String> notes;

    public Assignment() {//default (empty) constructor
        this.assignmentName = "None";
        this.dueDate = "None";
        this.notes = new ArrayList<>();
    }
    public Assignment(String assignmentName, String dueDate) {//default (empty) constructor
        this.assignmentName = assignmentName;
        this.dueDate = dueDate;
        this.notes = new ArrayList<>();
    }

    public String addNote(String newNote){
        notes.add(newNote);
        return newNote;
    }

    public void deleteNote(int index){
        notes.remove(index);
    }

    public void displayNotes(){
        if (notes.size() == 0){
            System.out.println("There are no notes currently.");
        }else {
            for (int i = 0; i < notes.size(); i++) {
                System.out.println("Note " + (i+1) + ":" + notes.get(i));
            }
        }
    }

    public void changeNote(int index, String newNote){
        notes.set(index, newNote);
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int numberOfNotes(){
        return notes.size();
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        String allTheNotes = "";
        for (int i = 0; i < notes.size(); i++) {
            allTheNotes += "Note " + (i+1) + ": " + this.notes.get(i) + "\n";
        }

       return "\n" + "Name:" + assignmentName + "\nDue Date: " + dueDate + "\nYour notes: \n" + allTheNotes;
    }
}
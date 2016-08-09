import java.util.ArrayList;

public class Assignment{
    //properties
    private String assignmentName;
    private String dueDate;
    private ArrayList<String> notes;

    //constructors
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

    public String addNote(String newNote){// takes in a string and then adds it to the array list of notes
        notes.add(newNote);
        return newNote;
    }

    public void deleteNote(int index){//takes in a number and then removes that number of note from the array list
        notes.remove(index);
    }

    public void displayNotes(){//function to display all the notes stored in the note array list
        if (notes.size() == 0){
            System.out.println("There are no notes currently.");
        }else {
            for (int i = 0; i < notes.size(); i++) {
                System.out.println("Note " + (i+1) + ":" + notes.get(i));
            }
        }
    }

    public void changeNote(int index, String newNote){ //function that takes a number of note to change and the string that it should be changed to
        notes.set(index, newNote);
    }

    public String getAssignmentName() { //retrieve the name of an assignment
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) { //set the name for an assignment
        this.assignmentName = assignmentName;
    }

    public String getDueDate() { // retrieve due date for assignment
        return dueDate;
    }

    public int numberOfNotes(){  // retrieve the number of notes in the array list of notes
        return notes.size();
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() { // function to display all the notes store in the notes array list
        String allTheNotes = "";
        for (int i = 0; i < notes.size(); i++) {
            allTheNotes += "Note " + (i+1) + ": " + this.notes.get(i) + "\n";
        }

       return "\n" + "Name:" + assignmentName + "\nDue Date: " + dueDate + "\nYour notes: \n" + allTheNotes;
    }
}
import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
//        Student student = null;
//        Scanner scanner;
//        try
//        {
//            FileInputStream fileIn = new FileInputStream("/tmp/student.ser");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            student = (Student) in.readObject();
//            in.close();
//            fileIn.close();
//        }catch(IOException i)
//        {
//            scanner = new Scanner(System.in);
//            System.out.println("Please enter your name.");
//            String newStudentName = scanner.nextLine();
//            scanner.nextLine();
//            //Student does not exist so we will make a new one
//            student = new Student(newStudentName);
//        }catch(ClassNotFoundException c)
//        {
//            System.out.println("Student class not found");
//            c.printStackTrace();
//            return;
//        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name.");
           String newStudentName = scanner.nextLine();
        Student student = new Student(newStudentName);
        boolean keepGoingProgram = true;
        System.out.println("Welcome " + student.getStudentName() + "!");
        while (keepGoingProgram){
            student.displaySubjects();
            System.out.println("What would you like to do?");
            System.out.println("0) Quit Student App");
            System.out.println("1) Create a subject");
            if (student.numberOfSubjects() != 0){
                System.out.println("2) View a subject");
                System.out.println("3) Delete a subject");
            }
            String userResponse = scanner.nextLine();// this line allows the entire line of input from the user to be stored into a variable for later evaulation
            int response; // declare variable for testing exception handling
            try {
                response = Integer.parseInt(userResponse); // parse the incoming string representation of an integer into an integer
            } catch (NumberFormatException e) { // the catch outputs an error message if the user inputs something other than a number
                System.out.println("Please type 0, 1, 2, 3");
                continue;
            }
            if (response == 1){
                System.out.println("What do you want to name the subject? ");
                String newSubjectName = scanner.nextLine();
                student.addSubject(newSubjectName);
            }else if(response == 2 && student.numberOfSubjects() != 0){
                student.displaySubjects();
                System.out.println("Which subject do you want to view? ");
                String userResponseSubject = scanner.nextLine();// this line allows the entire line of input from the user to be stored into a variable for later evaulation
                int responseSubject; // declare variable for testing exception handling
                try {
                    responseSubject = Integer.parseInt(userResponseSubject) - 1; // parse the incoming string representation of an integer into an integer
                } catch (NumberFormatException e) { // the catch outputs an error message if the user inputs something other than a number
                    System.out.println("Please type a valid subject number. ");
                    continue;
                }
                boolean keepGoingSubject = true;
                while(keepGoingSubject){
                    student.displaySubject(responseSubject);
                    System.out.println("What would you like to do?");
                    System.out.println("0) Exit Subject");
                    System.out.println("1) Add Assignment");
                    if (student.getSubject(responseSubject).numberOfAssignments() != 0) {
                        System.out.println("2) View assignment notes");
                        System.out.println("3) Delete assignment");
                    }
                    String userResponseAssignment = scanner.nextLine();
                    int responseAssignment;
                    try {
                        responseAssignment = Integer.parseInt(userResponseAssignment); // parse the incoming string representation of an integer into an integer
                    } catch (NumberFormatException e) { // the catch outputs an error message if the user inputs something other than a number
                        System.out.println("Please type 0, 1, 2, 3");
                        continue;
                    }
                    if (responseAssignment == 0){
                        keepGoingSubject = false;
                    }else if (responseAssignment == 1){
                        System.out.println("What do you want to call the assignment?");
                        String newAssignment = scanner.nextLine();
                        System.out.println("When is the assignment due?");
                        String dueDate = scanner.nextLine();
                        student.getSubject(responseSubject).addAssignment(newAssignment, dueDate);
                    }else if (responseAssignment == 2 && student.getSubject(responseSubject).numberOfAssignments() != 0){
                        student.getSubject(responseSubject).displayAssignments();
                        System.out.println("Which assignment do you want to view?");
                        String userResponseAssignmentIndex = scanner.nextLine();// this line allows the entire line of input from the user to be stored into a variable for later evaulation
                        int responseAssignmentToView; // declare variable for testing exception handling
                        try {
                            responseAssignmentToView = Integer.parseInt(userResponseAssignmentIndex) - 1; // parse the incoming string representation of an integer into an integer
                        } catch (NumberFormatException e) { // the catch outputs an error message if the user inputs something other than a number
                            System.out.println("Please type a valid assignment number. ");
                            continue;
                        }
                        boolean keepGoingAssignment = true;
                        while(keepGoingAssignment){
                            student.getSubject(responseSubject).getAssignment(responseAssignmentToView).displayNotes();
                            System.out.println("What would you like to do?");
                            System.out.println("0) Exit Assignment");
                            System.out.println("1) Add Note");
                            System.out.println("2) Delete note");
                            String userResponseAssignmentTask = scanner.nextLine();
                            int assignmentTask;
                            try {
                                assignmentTask = Integer.parseInt(userResponseAssignmentTask);
                            }catch (NumberFormatException e){
                                System.out.println("Enter a valid assignment task");
                                continue;
                            }
                            if (assignmentTask == 0){
                                keepGoingAssignment = false;
                            }else if (assignmentTask == 1){
                                System.out.println("What would you like the note to say?");
                                String newNote = scanner.nextLine();
                                student.getSubject(responseSubject).getAssignment(responseAssignmentToView).addNote(newNote);
                            }else if (assignmentTask == 2 && (student.getSubject(responseSubject).getAssignment(responseAssignmentToView).numberOfNotes() != 0)){
                                student.getSubject(responseSubject).getAssignment(responseAssignmentToView).displayNotes();
                                System.out.println("Which note do you want to delete?");
                                String noteToDelete = scanner.nextLine();
                                int noteToDeleteIndex;
                                try {
                                    noteToDeleteIndex = Integer.parseInt(noteToDelete) - 1;
                                }catch (Exception e){
                                    System.out.println("Please enter a valid note index");
                                    student.getSubject(responseSubject).getAssignment(responseAssignmentToView).displayNotes();
                                    System.out.println("Which note do you want to delete?");
                                    continue;
                                }
                                student.getSubject(responseSubject).getAssignment(responseAssignmentToView).deleteNote(noteToDeleteIndex);
                            }
                        }
                    }else if (responseAssignment == 3 && student.getSubject(responseSubject).numberOfAssignments() != 0) {
                        student.getSubject(responseSubject).displayAssignments();
                        System.out.println("Which assignment would you like to delete?");
                        String assignmentToDelete = scanner.nextLine();
                        int assignmentDeleteIndex;
                        try {
                            assignmentDeleteIndex = Integer.parseInt(assignmentToDelete) - 1;
                        }catch(Exception e){
                            System.out.println("Please enter a valid assignment index");
                            student.getSubject(responseSubject).displayAssignments();
                            System.out.println("Which assignment would you like to delete?");
                            continue;
                        }
                        student.getSubject(responseSubject).deleteAssignment(assignmentDeleteIndex);
                    }else{
                        System.out.println("Invalid response");
                    }
                }
            }else if(response == 0){
                keepGoingProgram = false;
                try
                {
                    FileOutputStream fileOut =
                            new FileOutputStream("/tmp/student.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(student);
                    out.close();
                    fileOut.close();
                    System.out.printf("Student is saved in /tmp/student.ser");
                }catch(IOException i)
                {
                    i.printStackTrace();
                }
            }

        }
    }
}



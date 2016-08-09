import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        // I attempted to make the student object serializable here but did not succeed
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

        Scanner scanner = new Scanner(System.in); //declare new scanner object
        System.out.println("Please enter your name.");
        String newStudentName = scanner.nextLine();//set newStudentName variable equal to what the user enters
        Student student = new Student(newStudentName); //declare new Student with name equal to variable above
        boolean keepGoingProgram = true; // boolean variable for loop operations
        System.out.println("Welcome " + student.getStudentName() + "!");
        while (keepGoingProgram){
            student.displaySubjects(); //display the student's subjects
            System.out.println("What would you like to do?");
            System.out.println("0) Quit Student App");
            System.out.println("1) Create a subject");
            if (student.numberOfSubjects() != 0){ // display options below as long as a subject exists in this students arraylist of subjects
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
            if (response == 1){ // this if statement is used to pass a subject name into the subject constructor
                System.out.println("What do you want to name the subject? ");
                String newSubjectName = scanner.nextLine();
                student.addSubject(newSubjectName); //call to the addSubject method, passes in a subject name
            }else if(response == 2 && student.numberOfSubjects() != 0){
                student.displaySubjects();
                System.out.println("Which subject do you want to view? ");
                String userResponseSubject = scanner.nextLine();// this line allows the entire line of input from the user to be stored into a variable for later evaulation
                int responseSubject; // declare variable for testing exception handling
                try {
                    responseSubject = Integer.parseInt(userResponseSubject) - 1; // parse the incoming string representation of an integer into an integer and subtract 1 so that it will point to the correct item in the array list that starts at 0
                } catch (NumberFormatException e) { // the catch outputs an error message if the user inputs something other than a number
                    System.out.println("Please type a valid subject number. ");
                    continue;
                }
                boolean keepGoingSubject = true; // boolean variable for loop operations titled with subject to indicated that it operates the "subject" loop
                while(keepGoingSubject){
                    student.displaySubject(responseSubject); // displays the subject of the number that was chosen above
                    System.out.println("What would you like to do?");
                    System.out.println("0) Exit Subject");
                    System.out.println("1) Add Assignment");
                    if (student.getSubject(responseSubject).numberOfAssignments() != 0) { // if there are assignments in this subject then display the options below
                        System.out.println("2) View assignment notes");
                        System.out.println("3) Delete assignment");
                    }
                    String userResponseAssignment = scanner.nextLine(); // declare a string variable for the incoming menu choice
                    int responseAssignment; // declare integer variable for late use with the menu choice variable above
                    try {
                        responseAssignment = Integer.parseInt(userResponseAssignment); // parse the incoming string representation of an integer into an integer
                    } catch (NumberFormatException e) { // the catch outputs an error message if the user inputs something other than a number
                        System.out.println("Please type 0, 1, 2, 3");
                        continue;
                    }
                    if (responseAssignment == 0){ // quit the subject loop if the user enters 0
                        keepGoingSubject = false;
                    }else if (responseAssignment == 1){ // if the response is 1 then add a new assignment
                        System.out.println("What do you want to call the assignment?");
                        String newAssignment = scanner.nextLine(); // newAssignment variable holds the name of what the user passes in
                        System.out.println("When is the assignment due?");
                        String dueDate = scanner.nextLine(); // dueDate variable holds the due date that the user passes in through the scanner.nextline() function
                        student.getSubject(responseSubject).addAssignment(newAssignment, dueDate); // in this student's subject create a new assignment with the variable just created above using the user's input
                    }else if (responseAssignment == 2 && student.getSubject(responseSubject).numberOfAssignments() != 0){ //if menu choice is 2 and there are assignments in this subject then do the following
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
                        boolean keepGoingAssignment = true; // boolean variable for future operations in the "Assignment" loop
                        while(keepGoingAssignment){
                            student.getSubject(responseSubject).getAssignment(responseAssignmentToView).displayNotes(); // display the student's subject's assignment's notes
                            System.out.println("What would you like to do?");
                            System.out.println("0) Exit Assignment");
                            System.out.println("1) Add Note");
                            System.out.println("2) Delete note");
                            String userResponseAssignmentTask = scanner.nextLine(); // String variable to take in the user response for the assignment task list above
                            int assignmentTask; // declare an integer variable for future storage and of user input menu choice
                            try {
                                assignmentTask = Integer.parseInt(userResponseAssignmentTask); //if the user entered an integer then assign it to assignmentTask variable
                            }catch (NumberFormatException e){ // output the below message if the user did not enter a proper choice
                                System.out.println("Enter a valid assignment task");
                                continue;
                            }
                            if (assignmentTask == 0){ // if the user chose 0 then exit the assignment loop
                                keepGoingAssignment = false;
                            }else if (assignmentTask == 1){
                                System.out.println("What would you like the note to say?");
                                String newNote = scanner.nextLine(); // get the notes from the user and store them in a string variable
                                student.getSubject(responseSubject).getAssignment(responseAssignmentToView).addNote(newNote); // add a note to this student's subject's assignment's array list of notes using what they just input above
                            }else if (assignmentTask == 2 && (student.getSubject(responseSubject).getAssignment(responseAssignmentToView).numberOfNotes() != 0)){ // only fire this part if they have notes that can be deleted
                                student.getSubject(responseSubject).getAssignment(responseAssignmentToView).displayNotes(); // print out the student' subject's assignment's notes again
                                System.out.println("Which note do you want to delete?");
                                String noteToDelete = scanner.nextLine(); // get the user to input a note that they want to delete
                                int noteToDeleteIndex; // declare an integer variable for future comparision (error checking) and for storing the user's menu choice
                                try {
                                    noteToDeleteIndex = Integer.parseInt(noteToDelete) - 1; // if the user input an integer then subtract 1 from it and store it in the int variable that was declared above
                                }catch (Exception e){                                       // the purpose of subtracting 1 is to accurately find the note in the array list of notes that starts at the index of 0
                                    System.out.println("Please enter a valid note index"); // if the user does not enter an integer then display this error message
                                    student.getSubject(responseSubject).getAssignment(responseAssignmentToView).displayNotes(); // display the notes again
                                    System.out.println("Which note do you want to delete?");
                                    continue;
                                }
                                student.getSubject(responseSubject).getAssignment(responseAssignmentToView).deleteNote(noteToDeleteIndex); // delete the note at the given index number
                            }
                        }
                    }else if (responseAssignment == 3 && student.getSubject(responseSubject).numberOfAssignments() != 0) { // do below as long as assignments exist
                        student.getSubject(responseSubject).displayAssignments(); // display the student's subject's assignments
                        System.out.println("Which assignment would you like to delete?");
                        String assignmentToDelete = scanner.nextLine(); // put user input into a string variable
                        int assignmentDeleteIndex; // declare integer variable for storage of above input a error checking
                        try {
                            assignmentDeleteIndex = Integer.parseInt(assignmentToDelete) - 1; // store user as integer minus 1 so its put back in as a reference that will find the appropriate assignment in the array list of assignment
                        }catch(Exception e){ // if the user makes a mistake in their input then do below
                            System.out.println("Please enter a valid assignment index");
                            student.getSubject(responseSubject).displayAssignments();
                            System.out.println("Which assignment would you like to delete?");
                            continue;
                        }
                        student.getSubject(responseSubject).deleteAssignment(assignmentDeleteIndex); //delete the assignment indicated by the user above
                    }else{ // output this message if the user does not input a valid response for the subject's assignments menu
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



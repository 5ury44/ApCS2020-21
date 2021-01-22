import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Library {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        LibraryTracker libraryTracker = new LibraryTracker();
        while(true){
            try {
                System.out.println("Please Select Option. A=Add book, P=Print Available Books by Author, L=Loan Out a Book, R=Return Book, B=Print Borrowed Books, O=Print Overdue Books, D=Delete Book, T=Print Total Books in Library, S=Search for Book, Q=Quit.");
                String in = scanner.readLine();
                if (in.equals("Q")) {
                    break;
                } else if (in.equals("A")) {
                    System.out.println("Please enter the information in this format exactly 'title,author'. No spaces after commas.");
                    String[] input = scanner.readLine().split(",");
                    libraryTracker.add(input[0], input[1]);
                } else if (in.equals("L")) {
                    System.out.println("Enter in this format title,MM-DD-YYYY,your name. No spaces after commas.");
                    String[] input = scanner.readLine().split(",");
                    libraryTracker.borrow(input[1], input[0], input[2]);
                } else if ((in.equals("R"))) {
                    System.out.println("Enter the title.");
                    libraryTracker.returnBook(scanner.readLine());
                } else if ((in.equals("B"))) {
                    libraryTracker.borrowedPrint();
                } else if ((in.equals("O"))) {
                    System.out.println("Enter date MM-DD-YYYY");
                    libraryTracker.late(scanner.readLine());
                } else if ((in.equals("P"))) {
                    System.out.println("Enter the author.");
                    libraryTracker.searchAuthor(scanner.readLine());
                } else if ((in.equals("D"))) {
                    System.out.println("Enter the title.");
                    libraryTracker.delete(scanner.readLine());
                } else if ((in.equals("T"))) {
                    libraryTracker.total();
                } else {
                    System.out.println("Enter the title.");
                    libraryTracker.search(scanner.readLine());
                }
            } catch (Exception e) {System.out.println("error");}
        }
    }
}

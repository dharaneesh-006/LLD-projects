import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import controller.LibraryController;
import entity.Borrow;

public class Main {

    static private void printfunc() {
        System.out.println("1. Add book ");
        System.out.println("2. Add Member");
        System.out.println("3. Borrow Book");
        System.out.println("4. return Book");
        System.out.println("5. Report Member");
        System.out.println("6. Report Book");
        System.out.println("7. Exit");

    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean ver = true;
        LibraryController controller = new LibraryController();
        while (ver) {
            System.out.print("Enter your Choice : ");
            printfunc();
            int choice = sc.nextInt();

            switch (choice) {
                case 1:

                    String title;
                    String author;
                    int no_of_copies;
                    int available_books;
                    System.out.println("=====================================");
                    System.out.println(" Book Creation ");
                    System.out.println("=====================================");
                    System.out.print("Enter the Title of the Book : ");
                    title = sc.nextLine();
                    System.out.print("Enter the Author of the Book : ");
                    author = sc.nextLine();
                    System.out.print("Enter the No.of.Copies : ");
                    no_of_copies = sc.nextInt();
                    System.err.print("Enter the Available Books : ");
                    available_books = sc.nextInt();

                    controller.addBook(title, author, no_of_copies, available_books);
                    System.out.println("=====================================");
                    break;

                case 2:

                    String member_name;
                    System.out.println("=====================================");
                    System.out.println(" Member Creation ");
                    System.out.println("=====================================");
                    System.out.print("Enter the Member Name : ");
                    member_name = sc.nextLine();

                    controller.registerMember(member_name);

                    System.out.println("=====================================");
                    break;

                case 3:

                    System.out.println("=====================================");
                    System.out.println(" Borrow the Book ");
                    System.out.println("=====================================");

                    long member_id;
                    while (true) {
                        System.out.print("Enter the Member ID : ");
                        member_id = sc.nextInt();
                        if (!controller.checkMember(member_id)) {
                            System.out.println("Error : Enter Valid Member ID !!....");
                        } else {
                            break;
                        }
                    }

                    int number;
                    while (true) {
                        System.out.print("Enter the number of books to get : ");
                        number = sc.nextInt();
                        if (!(number <= 3 && number > 0)) {
                            System.out.println("A Member Can only Borrow only 3 Books Per-Day.....");
                        } else {
                            break;
                        }
                    }

                    List<Long> bookid_list = new ArrayList<>();

                    int i = 1;
                    while (i <= number) {

                        System.out.print("Enter Book ID : ");
                        long book_id = sc.nextInt();
                        if (!controller.checkBook(book_id)) {
                            System.out.println("Error : Enter Valid Book ID !!....");
                        } else {
                            if (controller.checkAvailability(book_id)) {
                                i++;
                            } else {
                                System.out.println("Sorry!! Book is not Available .... Check another Book");
                            }
                        }
                    }

                    LocalDate today = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");

                    String date = today.format(formatter);

                    controller.borrowBook(member_id, bookid_list, date);

                    System.out.println("=====================================");
                    break;

                case 4:

                    System.out.println("=====================================");
                    System.out.println(" Return the Book ");
                    System.out.println("=====================================");

                    long return_member_id;
                    while (true) {
                        System.out.print("Enter the Member ID : ");
                        return_member_id = sc.nextInt();
                        if (!controller.checkMember(return_member_id)) {
                            System.out.println("Error : Enter Valid Member ID !!....");
                        } else {
                            break;
                        }
                    }

                    int count;
                    List<Long> borrow_id_List = new ArrayList<>();
                    count = sc.nextInt();
                    int j = 1;
                    while ( j <= count) {

                        System.out.print("Enter Book ID : ");
                        long book_id = sc.nextInt();
                        if (!controller.checkReturned(return_member_id,book_id)) {
                            System.out.println("Error : Enter Valid Book ID !!....");
                        } else {

                            long borrow_id;

                            try {
                                borrow_id = controller.checkReturnedBorrowId(return_member_id, book_id);
                                borrow_id_List.add(borrow_id); 
                            } catch (Exception e) {
                                System.out.println("Error : " + e);
                            }

                            try {
                                
                                LocalDate return_date = LocalDate.now();
                                controller.returnBook(borrow_id_List,return_date);

                            } catch (Exception e) {
                                System.out.println("Error : "+e);
                            }
                        }
                    }

                case 7:
                    ver = false;
                    break;
                default:
                    break;
            }
        }

    }
}
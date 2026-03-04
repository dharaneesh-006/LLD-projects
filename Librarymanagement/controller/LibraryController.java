package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entity.*;
import java.util.Map;

public class LibraryController {

    Map<Long, Book> books = new HashMap<>();
    Map<Long, Member> members = new HashMap<>();
    Map<Long, Borrow> borrows = new HashMap<>();
    List<TopBorrows> topborrows = new ArrayList<>();

    public void addBook(String title, String author, int no_of_copies, int available_books) {

        try {
            Book book = new Book(title, author, no_of_copies, available_books);
            books.put(book.getBookId(), book);
            System.out.println("Book added Successfully with ID : " + book.getBookId() + " !!....");
        } catch (Exception e) {
            System.err.println("Error : " + e);
        }
    }

    public void registerMember(String member_name) {
        try {
            Member member = new Member(member_name);
            members.put(member.getMember_id(), member);
            System.out.println("Member Created Succesfully with ID : " + member.getMember_id() + " !!....");
        } catch (Exception e) {
            System.err.println("Error : " + e);
        }
    }

    public void borrowBook(long member_id,List<Long> bookid_list, String date) {

        for(long book_id : bookid_list)
        {
            try {
                Borrow borrow = new Borrow(book_id, member_id, date);
                borrows.put(borrow.getBorrow_id(), borrow);

                Book book = books.get(book_id);
                book.setAvailable_books(book.getAvailable_books()-1);

                System.out.println("Borrowing of Book : " + borrow.getBookId() + " "
                        + " was Succesfully Borrowed with ID : " + borrow.getBorrow_id() + " !!....");
            } catch (Exception e) {
                System.out.println("Error : " + e);
            }
        }
    }

    public boolean checkMember(long member_id)
    {
        return members.containsKey(member_id);
    }

    public boolean checkBook(long book_id)
    {
        if(books.containsKey(book_id))
        {
            return true;
        }
        return false;
    }

    public boolean checkAvailability(long book_id)
    {
        Book book = books.get(book_id);
        int avail_books = book.getAvailable_books();
        if (avail_books > 0) {
            return true;
        }
        return false;
    }

    public boolean checkReturned(long member_id,long book_id)
    {
        for(Map.Entry<Long,Borrow> borrow : borrows.entrySet() )
        {
            Borrow borrow_book_id = borrow.getValue();
            if(borrow.getKey() == member_id && borrow_book_id.getBookId() == book_id)
            {
                return true;
            }
        }
        return false;
    }

    public long checkReturnedBorrowId(long member_id, long book_id) {
        for (Map.Entry<Long, Borrow> borrow : borrows.entrySet()) {
            Borrow borrow_book_id = borrow.getValue();
            if (borrow.getKey() == member_id && borrow_book_id.getBookId() == book_id) {
                return borrow_book_id.getBorrow_id();
            }
        }
        return 0;
    }

    public double returnBook(List<Long> borrow_id_list,LocalDate returnDate)
    {
        double fine = 0.0;
        for(long id : borrow_id_list)
        {
            Borrow borrow = borrows.get(id);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
            LocalDate due_date = LocalDate.parse(borrow.getDueDate(), formatter);
            
            if(returnDate.minus(due_date))
            {
                fine += minusval*2;
            }
            System.out.println("Books was Returned Successfully !!.......");
            return;
        }
    }


}

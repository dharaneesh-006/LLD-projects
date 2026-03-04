package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Borrow {
    private long borrow_id = 1;
    private long member_id;
    private long bookId;
    private String borrowDate;
    private String dueDate;
    private boolean returned;

    public Borrow(long bookId,long member_id,String borrowDate)
    {
        this.borrow_id = borrow_id;
        borrow_id++;
        this.member_id =member_id;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        LocalDate date = LocalDate.parse(borrowDate, formatter);
        LocalDate due = date.plusDays(14);
        this.dueDate = due.toString();
        this.returned = false;
    }
    
    public long getBorrow_id() {
        return borrow_id;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }
    
    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public boolean getReturned()
    {
        return returned;
    }

    public String getDueDate() {
        return dueDate;
    }

    public long getMember_id() {
        return member_id;
    }

    public void setMember_id(long member_id) {
        this.member_id = member_id;
    }

    
}

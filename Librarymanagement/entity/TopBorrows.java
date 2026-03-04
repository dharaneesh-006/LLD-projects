package entity;

public class TopBorrows {
    private long member_id;
    private int no_of_book_count;

    public TopBorrows(long member_id, int no_of_book_count)
    {
        this.member_id = member_id;
        this.no_of_book_count = no_of_book_count;
    }

    public void setMember_id(long member_id) {
        this.member_id = member_id;
    }

    public long getMember_id() {
        return member_id;
    }

    public void setNo_of_book_count(int no_of_book_count) {
        this.no_of_book_count = no_of_book_count;
    }

    public int getNo_of_book_count() {
        return no_of_book_count;
    }
    
}

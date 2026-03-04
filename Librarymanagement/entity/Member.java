package entity;

public class Member {
    private long member_id = 1;
    private String member_name;

    public Member(String member_name)
    {
        this.member_name = member_name;
        this.member_id = member_id;
        member_id++;
    }

    public long getMember_id() {
        return member_id;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }
    
    public String getMember_name() {
        return member_name;
    }
}

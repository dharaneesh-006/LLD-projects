package SocialMedia.entity;
import java.util.*;


public class User {
    private String user_id;
    private String user_name;
    private int age;
    private Date DOB; 
    private String occupation;
    private String location;
    private List<String> friends;
    private List<Post> posts;
    
    private Stack<Post> feeds;

    private Stack<Notification> notifications;


    public User(String user_id ,  String user_name , int age , Date DOB , String occupation , String location){
        this.DOB = DOB;
        this.age= age ;
        this.user_id = user_id;
        this.location = location ;
        this.user_name = user_name ;
    }


}

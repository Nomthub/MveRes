package com.persons;
import java.util.concurrent.atomic.AtomicLong;

public class Users {

	private long Userid;
    private String firstname;
    private String lastName;
    private String passWord;
    private static final AtomicLong counter = new AtomicLong(100);
    
    public Users(String firstname, String lastName, String passWord, long Userid) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.passWord = passWord;   
        this.Userid = Userid;
    }
    
    public Users(String firstname, String lastName, String passWord) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.passWord = passWord;     
        this.Userid = counter.incrementAndGet();
    }
    
    public long getUId() {
        return Userid;
    }

    public void setId(long Uid) {
        this.Userid = Uid;
    }
    
    public String getFirstName() {
        return firstname;
    }

    public void setName(String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getPassW() {
        return passWord;
    }

    public void setPassW(String passW) {
        this.passWord = passW;
    }
    @Override
    public String toString() {
        return "Users{" + "id=" + Userid + ", name=" + firstname + 
                ", lastName=" + lastName + ", Password=" + passWord + '}';
    }


}

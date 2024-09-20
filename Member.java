
package member;

import library.record.Record;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Integer;
import java.util.Set;
import java.util.TreeSet;

public class Member {
    private int memberId;
    String firstName;
    String surName;

    private Set<Integer> borrowed;

    /* Follow the instructions .... */
    public Member(int memberId, String firstName, String surname){
        this.memberId = memberId;
        this.firstName = firstName;
        this.surName = surname;
        borrowed = new TreeSet<>();
    }

    public int getMemberId(){
        return memberId;
    }
    public Set<Integer> getBorrowed(){
        return borrowed;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getSurName(){
        return surName;
    }
    public Boolean hasBorrowed(int id){
        return borrowed.contains(id);
    }
    public void borrowId(int id){
        borrowed.add(id);
    }
    public void returnId(int id){
        borrowed.remove(id);
    }
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Id: ").append(memberId).append("\n").append("Member Name: ").append(firstName).append(" ").append(surName).append("\nList of borrowed items id: \n");
        for(Integer id: borrowed) {
            res.append(id).append("\n");
        }
        return res.toString();
    }

}


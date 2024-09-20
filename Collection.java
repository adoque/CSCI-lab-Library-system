
package library;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Map;
import java.util.TreeMap;
import library.record.Record;
import member.Member;

import javax.sound.midi.Soundbank;
import java.io.OutputStream;
import java.lang.String;

public class Collection {
    private Map<Integer, Record > records;
    private Map<Integer, Member > members;
    private int nextRecordId;
    private int nextMemberId;

    public Collection() {
        records = new TreeMap< Integer, Record > ();
        members = new TreeMap< Integer, Member > ( );
        nextRecordId = 100;
        nextMemberId = 100;
    }



    public int reserveRecordId( )
    {
        return nextRecordId ++ ;
    }

    public int reserveMemberId( )
    {
        return nextMemberId ++ ;
    }


/*   Add your code here. Follow the instructions.
 .............
............................
*/
    public boolean addRecord(Record rec){
        if(!records.containsKey(rec.getId())) {
            records.put(rec.getId(), rec);
            return true;
        }
        System.out.println("Id already recorded");
        return false;
    }
    public boolean addMember(Member memb){
        if(!members.containsKey(memb.getMemberId())) {
            members.put(memb.getMemberId(), memb);
            return true;
        }
        System.out.println("Member ID was already in use");
        return false;
    }
    public void printRecord(int id){
        if(records.containsKey(id)) {
            System.out.println(records.get(id).toString());
        }
        else
            System.out.println("There is no record with this id!");
    }
    public void printMember(int memberId){
        if(members.containsKey(memberId)) {
            System.out.println(members.get(memberId).toString());
        }
        else
            System.out.println("There is no member with this id!");
    }
    public boolean checkOutRecord(int memberId, int id) throws Exception {
        if(!records.containsKey(id)) {
            System.out.println("There is no record with this id");
            return false;
        }
        if(!members.containsKey(id)) {
            System.out.println("There is no member with this id");
            return false;
        }
        Member mem = members.get(memberId);
        Record rec = records.get(id);
        if(!rec.IsAvailable()){
            System.out.println("This record is not available");
            return false;
        }
        rec.CheckOut();
        mem.returnId(id);
        return false;
    }
    public boolean returnRecord( int memberId, int id){
        if(!records.containsKey(id)) {
            System.out.println("There is no record with this id");
            return false;
        }
        if(!members.containsKey(id)) {
            System.out.println("There is no member with this id");
            return false;
        }
        Member mem = members.get(memberId);
        Record rec = records.get(id);
        if(!rec.IsAvailable()){
            System.out.println("This item is not borrowed");
            return false;
        }
        rec.makeAvailable();
        mem.borrowId(id);
        return true;
    }

    public String toString( )
    {
       StringBuilder res = new StringBuilder( );
       res.append("Collection:\n\n" );

       res.append("Records:\n" );
       for(Integer id : records.keySet( ))
       {
          Record rec = records.get(id);
          if(id != rec.getId( ))
          {
             throw new java.lang.RuntimeException( 
                              "record key differs" + id + " " + rec.getId());
          }
          res.append( rec + "\n" );
       }
       res.append( "\n" );
 
       res.append( "Members:\n" );
       for(Integer id : members.keySet( ))
       {
          Member memb = members.get(id);
          if(id != memb.getMemberId( ))
          {
             throw new java.lang.RuntimeException( 
                              "member key differs" + id + " " + memb.getMemberId());
          }
          res.append(memb + "\n");
       }
       res.append("\n");
       
       res.append("next available recordId " + nextRecordId + "\n");
       res.append("next available memberId " + nextMemberId + "\n");

       return res.toString( );
    }
}


package library.record;

import java.lang.String;

public abstract class Record {
    protected int id;
    protected String title;
    protected Boolean av = true;

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public Boolean IsAvailable(){
        return av;
    }
    public void CheckOut() throws Exception{
        if(!av)
            throw new Exception("It's already checked out");
        av = false;
    }
    public void makeAvailable(){
        av = true;
    }
    public String toString(){
        return "Id: " + id + " Availability: " + av + " Title: " + title;
    }
}

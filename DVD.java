
package library.record;

public class DVD extends Record {
    private String director;
    private String genre;
    public DVD(int id, String title, String director, String genre){
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
    }
    public String getDirector(){
        return director;
    }
    public String getGenre(){
        return genre;
    }
}


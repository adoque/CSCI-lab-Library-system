
package library.record;

import java.lang.String;

public class MusicCD extends Record {
    private String artist;
    private String genre;
    public MusicCD(int id, String title, String artist, String genre){
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }
    public String getArtist(){
        return artist;
    }
    public String getGenre(){
        return genre;
    }
}


package entities;

import jakarta.persistence.*;

//import javax.persistence.*;

@Entity
@Table(name = "cds")
public class CD {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column (name = "title")
    private String title;

    @Column (name = "description")
    private String description;

    @Column (name = "year")
    private int year;

    @Column (name = "artist")
    private String artist;

    @Column (name = "price")
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CD (){
    }

    public CD (int id, String title, String desc, int year, String artist, double price){
        this.id = id;
        this.title = title;
        this.description = desc;
        this.year = year;
        this.artist = artist;
        this.price = price;
    }




}

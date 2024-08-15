package entities;

import javax.persistence.*;

@Entity
@Table(name = "cds")
public class CD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public CD (){

    }





}

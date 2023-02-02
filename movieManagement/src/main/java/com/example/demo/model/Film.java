package com.example.demo.model;
import lombok.*;
import javax.persistence.*; // import persistance library

@Entity // mark class as a database entity
@Getter // specify separatly lombok annotation instead of @Data to avoid some problems
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "films") // name of database table
public class Film{

    @Id // annotation for ID column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy for ID, here it well be ID++
    @Column(length = 11) // column size on database side definition
    private Integer id;

    @Column(name = "title", nullable = false, length = 100) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private String title;

    @Column(name = "realisator", length = 100)
    private String realisator;

    @Column(name = "type", length = 100)
    private String type;

    // private Integer author;

}
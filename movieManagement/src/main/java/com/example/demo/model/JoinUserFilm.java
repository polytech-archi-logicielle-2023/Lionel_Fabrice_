package com.example.demo.model;
import lombok.*;
import javax.persistence.*; // import persistance library

@Entity // mark class as a database entity
@Getter // specify separatly lombok annotation instead of @Data to avoid some problems
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "joinuserfilm") // name of database table
public class JoinUserFilm{

    @Id // annotation for ID column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy for ID, here it well be ID++
    @Column(length = 11) // column size on database side definition
    private Integer id;

    @Column( length = 11)
    private Integer idUser;

    @Column(length = 11)
    private Integer idFilm;

}
package com.ReactiveMusicApp.Songs.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Songs")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Song {


    @Id
    private String Id;

    @Field("Author")
    private String Artist;

    @Field("Name")
    private String Name;

    @Field("Time")
    private Double Time;

    @Field("MusicData")
    @Indexed(unique = true)
    private String MusicData;

}

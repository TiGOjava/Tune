package com.ReactiveMusicApp.Songs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "playlists")
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Playlist {

    @Id
    private String id;
    @Field("UderId")
    private String userId;
    @Field("TrackIds")
    private List<String> trackIds;
}



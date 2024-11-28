package com.servlet.test.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "indexer")
public class Indexer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "index_id")
    Long indexId;
    @NonNull
    String name;
    @NonNull
    float valueMin;
    @NonNull
    float valueMax;
    @ManyToMany(mappedBy = "indexers")
    List<Player> players;

}

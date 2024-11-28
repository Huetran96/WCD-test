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
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    Long playerId;
    @NonNull
    String name;
    @NonNull
    @Column(name = "full_name")
    String fullName;
    @NonNull
    String age;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "player_index",
        joinColumns = @JoinColumn(name = "player_id" ),
        inverseJoinColumns = @JoinColumn(name = "index_id")
    )
    List<Indexer> indexers;

}

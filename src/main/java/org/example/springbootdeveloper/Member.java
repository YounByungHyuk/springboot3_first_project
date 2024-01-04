package org.example.springbootdeveloper;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",updatable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;
}

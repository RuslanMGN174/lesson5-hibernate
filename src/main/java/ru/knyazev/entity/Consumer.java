package ru.knyazev.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "consumers")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "consumers")
    private List<Product> products;

    @OneToMany(mappedBy = "consumer")
    private List<LineItem> lineItems;

    public Consumer(String name) {
        this.name = name;
    }
}

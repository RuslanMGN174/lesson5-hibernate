package ru.knyazev.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@ToString
@NamedQueries({
        @NamedQuery(name = "productByTitle", query = "from Product p where p.title=:title"),
        @NamedQuery(name = "allProducts", query = "from Product")
})
public class Product {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(length = 128, unique = true, nullable = false)
    private String title;

    @Getter
    @Setter
    @Column(nullable = false)
    private int cost;

    public Product(String title, int cost) {
        this.title = title;
        this.cost = cost;
    }
}

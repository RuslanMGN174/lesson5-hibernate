package ru.knyazev.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@ToString
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "productByTitle", query = "from Product p where p.title=:title"),
        @NamedQuery(name = "allProducts", query = "from Product")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private BigDecimal cost;

    @ManyToMany
    private List<Consumer> consumers;

    @OneToMany(mappedBy = "product")
    private List<LineItem> lineItems;


    public Product(String title, BigDecimal cost) {
        this.title = title;
        this.cost = cost;
    }
}

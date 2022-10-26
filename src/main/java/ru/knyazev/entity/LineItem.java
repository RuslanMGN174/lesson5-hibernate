package ru.knyazev.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "line_items")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Consumer consumer;

    private BigDecimal cost;

    private Integer qty;

    public LineItem(Product product, Consumer consumer, BigDecimal cost, Integer qty) {
        this.product = product;
        this.consumer = consumer;
        this.cost = cost;
        this.qty = qty;
    }
}

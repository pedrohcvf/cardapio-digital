package com.phcfcorp.cardapio_digital.entity;

import com.phcfcorp.cardapio_digital.enums.FoodCategory;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private int price;
    @Enumerated(EnumType.STRING)
    private FoodCategory foodCategory;

}

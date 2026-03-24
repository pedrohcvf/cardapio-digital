package com.phcfcorp.cardapio_digital.dto;

import com.phcfcorp.cardapio_digital.enums.FoodCategory;

public record FoodRequestDto(String title, String image, int price, FoodCategory category) {
}

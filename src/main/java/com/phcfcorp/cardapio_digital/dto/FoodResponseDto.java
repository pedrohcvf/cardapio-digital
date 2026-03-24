package com.phcfcorp.cardapio_digital.dto;

import com.phcfcorp.cardapio_digital.enums.FoodCategory;

public record FoodResponseDto(Long id, String title, String image, int price, FoodCategory category) {
}

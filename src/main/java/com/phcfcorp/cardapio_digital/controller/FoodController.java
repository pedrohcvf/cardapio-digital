package com.phcfcorp.cardapio_digital.controller;

import com.phcfcorp.cardapio_digital.dto.FoodRequestDto;
import com.phcfcorp.cardapio_digital.dto.FoodResponseDto;
import com.phcfcorp.cardapio_digital.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {


    @Autowired
    private FoodService foodService;

    // CADASTRAR COMIDA
    @PostMapping
    public FoodResponseDto addFood(@RequestBody FoodRequestDto dto){
        return foodService.addFood(dto);
    }

    // ALTERAR COMIDA
    @PutMapping("/{id}")
    public FoodResponseDto uptadeFood(@PathVariable Long id, @RequestBody FoodRequestDto dto){
        return foodService.updateFood(id, dto);
    }

    // DELETAR COMIDA
    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id){
        foodService.deleteFood(id);
    }

    // LISTAR TODAS AS COMIDAS
    @GetMapping
    public List<FoodResponseDto> getAll(){
        return foodService.getAll();
    }

}

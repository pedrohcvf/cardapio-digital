package com.phcfcorp.cardapio_digital.service;

import com.phcfcorp.cardapio_digital.dto.FoodRequestDto;
import com.phcfcorp.cardapio_digital.dto.FoodResponseDto;
import com.phcfcorp.cardapio_digital.entity.Food;
import com.phcfcorp.cardapio_digital.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    // CONVERSÃO PARA DTO
    private FoodResponseDto toDto (Food food){
        return new FoodResponseDto(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }

    // CONVERSÃO PARA ENTIDADE
    private Food toEntity(FoodRequestDto dto){
        Food food = new Food();
        food.setTitle(dto.title());
        food.setImage(dto.image());
        food.setPrice(dto.price());
        return food;
    }

    // ADICIONAR COMIDAS
    public FoodResponseDto addFood (FoodRequestDto dto){
        Food food = toEntity(dto);
        foodRepository.save(food);
        return toDto(food);
    }

    // ALTERAR DADOS DA COMIDA
    public FoodResponseDto updateFood(Long id, FoodRequestDto dto){
        Food food = foodRepository.findById(id).orElseThrow();
        food.setTitle(dto.title());
        food.setPrice(dto.price());
        food.setImage(dto.image());
        foodRepository.save(food);
        return toDto(food);
    }

    // DELETAR COMIDA
    public void deleteFood(Long id){
        foodRepository.deleteById(id);
    }

    // LISTAR TODAS AS COMIDAS (DTO)
    public List<FoodResponseDto> getAll(){
        List<Food> foodList = foodRepository.findAll();
        return foodList.stream().map(this::toDto).toList();
    }
    
    // LISTAR COMIDAS PELO ID
    public FoodResponseDto getById(Long id){
        Food food = foodRepository.findById(id).orElseThrow();
        return toDto(food);
    }

}

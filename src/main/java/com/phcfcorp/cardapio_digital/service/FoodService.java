package com.phcfcorp.cardapio_digital.service;

import com.phcfcorp.cardapio_digital.dto.FoodRequestDto;
import com.phcfcorp.cardapio_digital.dto.FoodResponseDto;
import com.phcfcorp.cardapio_digital.entity.Food;
import com.phcfcorp.cardapio_digital.enums.FoodCategory;
import com.phcfcorp.cardapio_digital.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    // VERIFICAÇÕES
    public void verifyData(FoodRequestDto dto){
        if (dto.title().isEmpty() || dto.title().isBlank()){
            throw new RuntimeException("O campo Título não pode estar vazio.");
        } else if (dto.price() <= 0){
            throw new RuntimeException("O campo Preço não pode estar vazio.");
        } else if (dto.image().isEmpty() || dto.image().isBlank()){
            throw new RuntimeException("O campo Imagem não pode estar vazio");
        } else if (dto.category() == null) {
            throw new RuntimeException("O campo Categoria não pode estar vazio");
        }
    }

    // CONVERSÃO PARA DTO
    private FoodResponseDto toDto (Food food){
        return new FoodResponseDto(food.getId(), food.getTitle(), food.getImage(), food.getPrice(), food.getFoodCategory());
    }

    // CONVERSÃO PARA ENTIDADE
    private Food toEntity(FoodRequestDto dto){
        Food food = new Food();
        food.setFoodCategory((dto.category()));
        food.setTitle(dto.title());
        food.setImage(dto.image());
        food.setPrice(dto.price());
        return food;
    }

    // CADASTRAR COMIDAS
    public FoodResponseDto addFood (FoodRequestDto dto){
        verifyData(dto);
        Food food = toEntity(dto);
        foodRepository.save(food);
        return toDto(food);
    }

    // ALTERAR DADOS DA COMIDA
    public FoodResponseDto updateFood(Long id, FoodRequestDto dto){
        verifyData(dto);
        Food food = foodRepository.findById(id).orElseThrow();
        food.setTitle(dto.title());
        food.setPrice(dto.price());
        food.setImage(dto.image());
        foodRepository.save(food);
        return toDto(food);
    }

    // DELETAR COMIDA
    public void deleteFood(Long id){
        if (!foodRepository.existsById(id)){
            throw new RuntimeException("Não foi possível deletar: Produto com ID " + id + " não encontrado" );
        }
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

    // LISTAR COMIDAS POR CATEGORIA
    public List<FoodResponseDto> getByCategory(FoodCategory category){
        return foodRepository.findByFoodCategory(category).stream().map(this::toDto).toList();
    }

}

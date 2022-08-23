package com.can.durumcu.service.concretes;

import com.can.durumcu.core.results.Result;
import com.can.durumcu.core.results.SuccessDataResult;
import com.can.durumcu.core.results.SuccessResult;
import com.can.durumcu.entity.Ingredient;
import com.can.durumcu.repository.IngredientRepository;
import com.can.durumcu.service.abstracts.IIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService implements IIngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Override
    public Result add(Ingredient ingredient) {
        //this.ingredientRepository.insertIntegredient(ingredient.getId(), ingredient.getName());
        this.ingredientRepository.save(ingredient);
        return new SuccessResult("ingredient eklendi");
    }

    @Override
    public Result update(Ingredient ingredient) {
        this.ingredientRepository.update(ingredient.getId(), ingredient.getName());
        return new SuccessResult("Integredient updated.");
    }


    @Override
    public Result delete(Long id) {
        this.ingredientRepository.deleteById(id);
        return new SuccessResult("ıngredient deleted.");
    }

    @Override
    public SuccessDataResult<List<Ingredient>> getByName(String name) {
        return new SuccessDataResult<List<Ingredient>>(this.ingredientRepository.getByName(name),"Integredient geldi.");
    }


}

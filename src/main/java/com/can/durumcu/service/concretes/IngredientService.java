package com.can.durumcu.service.concretes;

import com.can.durumcu.core.results.DataResult;
import com.can.durumcu.core.results.Result;
import com.can.durumcu.entity.Ingredient;
import com.can.durumcu.service.abstracts.IIngredientService;
import org.springframework.stereotype.Service;

@Service
public class IngredientService implements IIngredientService {
    @Override
    public Result add(Ingredient ingredient) {
        return null;
    }

    @Override
    public Result update(Ingredient ingredient) {
        return null;
    }

    @Override
    public Result delete(Long id) {
        return null;
    }

    @Override
    public DataResult<Ingredient> getByName(String name) {
        return null;
    }
}

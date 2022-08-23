package com.can.durumcu.service.abstracts;

import com.can.durumcu.core.results.Result;
import com.can.durumcu.core.results.SuccessDataResult;
import com.can.durumcu.entity.Ingredient;

import java.util.List;

public interface IIngredientService {
    Result add(Ingredient ingredient);

    Result update(Ingredient ingredient);

    Result delete(Long id);

    SuccessDataResult<List<Ingredient>> getByName(String name);
}

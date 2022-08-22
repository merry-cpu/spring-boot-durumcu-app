package com.can.durumcu.service.abstracts;

import com.can.durumcu.core.results.DataResult;
import com.can.durumcu.core.results.Result;
import com.can.durumcu.entity.Ingredient;

public interface IIngredientService {
    Result add(Ingredient ingredient);

    Result update(Ingredient ingredient);

    Result delete(Long id);

    DataResult<Ingredient> getByName(String name);
}

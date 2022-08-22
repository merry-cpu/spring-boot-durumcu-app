package com.can.durumcu.service.abstracts;

import com.can.durumcu.core.results.Result;
import com.can.durumcu.entity.FoodOrder;

public interface IFoodOrderService {
    Result add(FoodOrder foodOrder);
}

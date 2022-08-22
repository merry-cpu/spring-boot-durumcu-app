package com.can.durumcu.service.concretes;

import com.can.durumcu.core.results.Result;
import com.can.durumcu.entity.FoodOrder;
import com.can.durumcu.service.abstracts.IFoodOrderService;
import org.springframework.stereotype.Service;

@Service
public class FoodOrderService implements IFoodOrderService {
    @Override
    public Result add(FoodOrder foodOrder) {
        return null;
    }
}

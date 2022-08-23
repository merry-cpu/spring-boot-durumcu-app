package com.can.durumcu.service.abstracts;

import com.can.durumcu.core.results.Result;
import com.can.durumcu.entity.FoodOrder;
import com.can.durumcu.repository.FoodOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface IFoodOrderService {

    Result add(FoodOrder foodOrder);
}

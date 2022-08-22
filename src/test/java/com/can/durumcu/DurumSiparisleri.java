package com.can.durumcu;

import com.can.durumcu.core.results.DataResult;
import com.can.durumcu.core.results.Result;
import com.can.durumcu.core.results.SuccessDataResult;
import com.can.durumcu.entity.Durum;
import com.can.durumcu.entity.FoodOrder;
import com.can.durumcu.entity.Ingredient;
import com.can.durumcu.repository.DurumRepository;
import com.can.durumcu.repository.FoodOrderRepository;
import com.can.durumcu.repository.IngredientRepository;
import com.can.durumcu.service.abstracts.IDurumService;
import com.can.durumcu.service.abstracts.IFoodOrderService;
import com.can.durumcu.service.abstracts.IIngredientService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class DurumSiparisleri {

	private final IIngredientService ingredientService;
	private final IDurumService durumService;
	private final IFoodOrderService foodOrderService;

	private final IngredientRepository ingredientRepository;
	private final DurumRepository durumRepository;
	private final FoodOrderRepository foodOrderRepository;

	@Autowired
	DurumSiparisleri(
			IIngredientService ingredientService,
			IDurumService durumService,
			IFoodOrderService foodOrderService,
			IngredientRepository ingredientRepository,
			DurumRepository durumRepository,
			FoodOrderRepository foodOrderRepository
	) {
		this.ingredientService = ingredientService;
		this.durumService = durumService;
		this.foodOrderService = foodOrderService;
		this.ingredientRepository = ingredientRepository;
		this.durumRepository = durumRepository;
		this.foodOrderRepository = foodOrderRepository;
	}


	@Test
	@Order(1)
	void addOneIngredient() {
		Ingredient tavuk = new Ingredient(null, "tavuk", null);
		Result result = ingredientService.add(tavuk);

		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result.isSuccess()).isEqualTo(true);

		List<Ingredient> ingredients = ingredientRepository.findAll();
		Assertions.assertThat(ingredients).isNotNull();
		Assertions.assertThat(ingredients.size()).isEqualTo(1);
		Assertions.assertThat(ingredients.get(0).getId()).isEqualTo(1);
		Assertions.assertThat(ingredients.get(0).getName()).isEqualTo("tavuk");
	}

	@Test
	@Order(2)
	void addMultipleIngredients() {
		Ingredient adana = new Ingredient(null, "adana", null);
		Ingredient domates = new Ingredient(null, "domates", null);
		Ingredient sogan = new Ingredient(null, "sogan", null);

		Result result1 = ingredientService.add(adana);
		Assertions.assertThat(result1).isNotNull();
		Assertions.assertThat(result1.isSuccess()).isEqualTo(true);

		Result result2 = ingredientService.add(domates);
		Assertions.assertThat(result2).isNotNull();
		Assertions.assertThat(result2.isSuccess()).isEqualTo(true);

		Result result3 = ingredientService.add(sogan);
		Assertions.assertThat(result3).isNotNull();
		Assertions.assertThat(result3.isSuccess()).isEqualTo(true);

		List<Ingredient> ingredients = ingredientRepository.findAll();

		Assertions.assertThat(ingredients).isNotNull();
		Assertions.assertThat(ingredients.size()).isEqualTo(4);
		Assertions.assertThat(ingredients.get(1).getId()).isEqualTo(2);
		Assertions.assertThat(ingredients.get(1).getName()).isEqualTo("adana");
	}

	@Test
	@Order(3)
	void tryToAddExistingIngredient() {
		Ingredient tavuk = new Ingredient(null, "tavuk", null);

		Result result = ingredientService.add(tavuk);
		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result.isSuccess()).isEqualTo(false);

		List<Ingredient> ingredients = ingredientRepository.findAll();

		Assertions.assertThat(ingredients).isNotNull();
		Assertions.assertThat(ingredients.size()).isEqualTo(4);
	}

	@Test
	@Order(4)
	void getIngredientByNameAndUpdateIngredientName() {
		Ingredient merul = new Ingredient(null, "merul", null);

		Result result = ingredientService.add(merul);
		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result.isSuccess()).isEqualTo(true);

		DataResult<Ingredient> merulResultFromDb = ingredientService.getByName("merul");
		Assertions.assertThat(merulResultFromDb).isNotNull();
		Assertions.assertThat(merulResultFromDb).isInstanceOf(SuccessDataResult.class);
		Assertions.assertThat(merulResultFromDb.getData().getName()).isEqualTo("merul");

		Ingredient merulFromDb = merulResultFromDb.getData();
		merulFromDb.setName("marul");

		Result result2 = ingredientService.update(merul);
		Assertions.assertThat(result2).isNotNull();
		Assertions.assertThat(result2.isSuccess()).isEqualTo(true);

		List<Ingredient> ingredients = ingredientRepository.findAll();
		Assertions.assertThat(ingredients).isNotNull();
		Assertions.assertThat(ingredients.size()).isEqualTo(5);
		Assertions.assertThat(ingredients.get(4).getName()).isEqualTo("marul");
	}

	@Test
	@Order(5)
	void deleteIngredient() {
		Result result = ingredientService.delete(5L);
		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result.isSuccess()).isEqualTo(true);

		List<Ingredient> ingredients = ingredientRepository.findAll();
		Assertions.assertThat(ingredients).isNotNull();
		Assertions.assertThat(ingredients.size()).isEqualTo(4);
	}

	@Test
	@Order(6)
	void addDurums() {
		DataResult<Ingredient> tavukResult = ingredientService.getByName("tavuk");
		Assertions.assertThat(tavukResult).isNotNull();
		Assertions.assertThat(tavukResult.isSuccess()).isEqualTo(true);

		DataResult<Ingredient> adanaResult = ingredientService.getByName("adana");
		Assertions.assertThat(adanaResult).isNotNull();
		Assertions.assertThat(adanaResult.isSuccess()).isEqualTo(true);

		DataResult<Ingredient> domatesResult = ingredientService.getByName("domates");
		Assertions.assertThat(domatesResult).isNotNull();
		Assertions.assertThat(domatesResult.isSuccess()).isEqualTo(true);

		DataResult<Ingredient> soganResult = ingredientService.getByName("sogan");
		Assertions.assertThat(soganResult).isNotNull();
		Assertions.assertThat(soganResult.isSuccess()).isEqualTo(true);


		Durum tavukSisDurum = new Durum(null, "tavuk sis durum", List.of(tavukResult.getData(), domatesResult.getData(), soganResult.getData()), null);
		Result result1 = durumService.add(tavukSisDurum);
		Assertions.assertThat(result1).isNotNull();
		Assertions.assertThat(result1.isSuccess()).isEqualTo(true);

		Durum adanaDurum = new Durum(null, "adana durum", List.of(adanaResult.getData(), domatesResult.getData(), soganResult.getData()), null);
		Result result2 = durumService.add(adanaDurum);
		Assertions.assertThat(result2).isNotNull();
		Assertions.assertThat(result2.isSuccess()).isEqualTo(true);


		List<Durum> durums = durumRepository.findAll();
		Assertions.assertThat(durums).isNotNull();
		Assertions.assertThat(durums.size()).isEqualTo(2);
		Assertions.assertThat(durums.get(0).getName()).isEqualTo("tavuk sis durum");
		Assertions.assertThat(durums.get(1).getName()).isEqualTo("adana durum");
	}

	@Test
	@Order(7)
	void placeDurumOrders() {
		DataResult<Durum> tavukSisDurum = durumService.getByName("tavuk sis durum");
		Assertions.assertThat(tavukSisDurum).isNotNull();
		Assertions.assertThat(tavukSisDurum.isSuccess()).isEqualTo(true);

		DataResult<Durum> adanaDurum = durumService.getByName("adana durum");
		Assertions.assertThat(adanaDurum).isNotNull();
		Assertions.assertThat(adanaDurum.isSuccess()).isEqualTo(true);


		FoodOrder order1 = new FoodOrder(null, tavukSisDurum.getData());
		Result order1Result = foodOrderService.add(order1);
		Assertions.assertThat(order1Result).isNotNull();
		Assertions.assertThat(order1Result.isSuccess()).isEqualTo(true);

		FoodOrder order2 = new FoodOrder(null, adanaDurum.getData());
		Result order2Result = foodOrderService.add(order2);
		Assertions.assertThat(order2Result).isNotNull();
		Assertions.assertThat(order2Result.isSuccess()).isEqualTo(true);

		List<FoodOrder> foodOrders = foodOrderRepository.findAll();
		Assertions.assertThat(foodOrders).isNotNull();
		Assertions.assertThat(foodOrders.size()).isEqualTo(2);
	}

}

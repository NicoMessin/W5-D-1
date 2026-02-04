package niccolomessina.W5_D_1;

import org.junit.jupiter.api.Test;
import niccolomessina.W5_D_1.entities.*;
import niccolomessina.W5_D_1.entities.Order;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class W5D1ApplicationTests {

	@Autowired
	private AnnotationConfigApplicationContext ctx;

	@BeforeAll
	static void initialSetup() {
		System.out.println("BEFORE ALL");
	}

	@AfterAll
	static void cleanUp() {
		System.out.println("AFTER ALL");
	}

	@BeforeEach
	void beforeEach() {
		System.out.println("BEFORE EACH");
	}

	@AfterEach
	void afterEach() {
		System.out.println("AFTER EACH");
	}

	// TEST 1 : il menu bean esiste nel context
	@Test
	void testMenuBeanExists() {
		System.out.println("TEST 1");
		MenuEffettivo menu = ctx.getBean(MenuEffettivo.class);
		assertNotNull(menu);
	}

	// TEST 2 : una Pizza con un topping aumenta prezzo e calorie
	@Test
	void testPizzaWithToppingUpdatesTotals() {
		System.out.println("TEST 2");
		Topping ham = new Topping("Ham", 35, 1.00);
		Pizza pizza = new Pizza("Test Pizza", 1000, 5.00, List.of(ham));

		assertEquals(1035, pizza.getCalorie());
		assertEquals(6.00, pizza.getPrezzo(), 0.0001);
	}

	// TEST 3: topping duplicato viene contato due volte
	@Test
	void testDoubleToppingCountedTwice() {
		System.out.println("TEST 3");
		Topping ham = new Topping("Ham", 35, 1.00);
		Pizza pizza = new Pizza("Double Ham", 1000, 5.00, List.of(ham, ham));

		assertEquals(1070, pizza.getCalorie());
		assertEquals(7.00, pizza.getPrezzo(), 0.0001);
	}

	// TEST 4 : totale ordine = somma items + coperti
	@Test
	void testOrderTotalIncludesCoverCharge() {
		System.out.println("TEST 4");
		Table table = new Table(1, 4, TableStatus.LIBERO);
		Order order = new Order(1, table, 2);

		Pizza pizza = new Pizza("Test Pizza", 1000, 5.00, List.of());
		Drink water = new Drink("Water", "0.5l", 0, 1.00);

		order.addItem(pizza);
		order.addItem(water);

		double total = order.getTotal(2.00);
		assertEquals(10.00, total, 0.0001); // 5 + 1 + (2*2)
	}

	// TEST 5 : coperti con valori diversi
	@ParameterizedTest
	@CsvSource({
			"1,2.00,2.00",
			"2,2.00,4.00",
			"4,2.50,10.00"
	})
	void testCoverChargeOnly(int seats, double coverCharge, double expectedTotal) {
		System.out.println("TEST 5 (PARAM)");
		Table table = new Table(1, 10, TableStatus.LIBERO);
		Order order = new Order(1, table, seats);

		// Nessun item: totale deve essere solo coperti
		double total = order.getTotal(coverCharge);
		assertEquals(expectedTotal, total, 0.0001);
	}
}

package it.epicode.w5d1esercizio;

import it.epicode.w5d1esercizio.bean.Menu;
import it.epicode.w5d1esercizio.bean.Pizza;
import it.epicode.w5d1esercizio.bean.Table;
import it.epicode.w5d1esercizio.bean.Toppings;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class W5d2ApplicationTests {
	static AnnotationConfigApplicationContext ctx;
	@BeforeAll
	static void accediAlContesto(){
		ctx = new AnnotationConfigApplicationContext(W5d1esercizioApplication.class);
	}

	@Test
	void testGetPizza() {
		Pizza p = ctx.getBean("p1", Pizza.class);
		Assertions.assertEquals("Margherita", p.getNome());
		Assertions.assertEquals("Pomodoro", p.getIngrediente());
		Assertions.assertEquals(10, p.getPrezzo());
		Assertions.assertEquals(200, p.getCalorie());
		Assertions.assertEquals(1, p.getToppings().size());
		Assertions.assertEquals("Formaggio", p.getToppings().get(0).getNomeTopping());
	}

	@Test
	void testGetPizza2() {
		Pizza p2 = ctx.getBean("p2", Pizza.class);
		Assertions.assertEquals("Diavola", p2.getNome());
		Assertions.assertEquals("Pomodoro", p2.getIngrediente());
		Assertions.assertEquals(12, p2.getPrezzo());
		Assertions.assertEquals(250, p2.getCalorie());
		Assertions.assertEquals(1, p2.getToppings().size());
		Assertions.assertEquals("Funghi", p2.getToppings().get(0).getNomeTopping());
	}

	@ParameterizedTest
	@CsvSource({"Formaggio", "Funghi", "Salsiccia"})
	void testToppings(String nome) {
		Toppings topping = ctx.getBean(nome.toLowerCase(), Toppings.class);
		Assertions.assertNotNull(topping);
	}

	@Test
	void testMenu() {
		Menu menu = ctx.getBean("menu", Menu.class);
		Assertions.assertNotNull(menu);
		Assertions.assertEquals(3, menu.getPizze().size());
		Assertions.assertEquals(3, menu.getBevande().size());
		Assertions.assertEquals(3, menu.getToppings().size());
	}

	@Test
	void testTavoli() {
		Table tavolo1 = ctx.getBean("tavolo1", Table.class);
		Assertions.assertNotNull(tavolo1);
		Assertions.assertEquals(1, tavolo1.getNumero());
	}

	@AfterAll
	static void chiudiContesto(){
		ctx.close();
	}

}

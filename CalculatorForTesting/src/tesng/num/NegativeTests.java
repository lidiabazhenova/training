/*
�������� ���������� ����� (��. ����������� � ����� ���� � PositiveTest.java)
*/

package tesng.num;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.testng.AssertJUnit.assertEquals;


public class NegativeTests {

	private NumberGuessBean ngb;
	private Random rg;
	
	@Before
	public void testPreparation() {
		this.ngb = new NumberGuessBean();
		this.rg = new Random();	
	}
	
	@After
	public void testFinalisation() {
		this.ngb = null;
	}
	
	@Test
	public void testInvalidInterval() {
	
		// Получаем случайное число, гарантированно лежащее ВНЕ диапазона [1, 100]
		int rand = this.rg.nextInt();
		int n;

		if (rand>=1 && rand<=100)
		{
			rand-=200;
		}

		// Проверяем левую границу (граничное условие; вне диапазона)
		n = this.ngb.getNumGuesses();
		this.ngb.setGuess("0");
		assertEquals("a number next time", this.ngb.getHint());
		assertEquals(n+1, this.ngb.getNumGuesses());

		// Проверяем правую границу (граничное условие; вне диапазона)
		n = this.ngb.getNumGuesses();
		this.ngb.setGuess("101");
		assertEquals("a number next time", this.ngb.getHint());
		assertEquals(n+1, this.ngb.getNumGuesses());

		// Проверяем реакцию на случайное число вне диапазона
		n = this.ngb.getNumGuesses();
		this.ngb.setGuess(String.valueOf(rand));
		assertEquals("a number next time", this.ngb.getHint());
		assertEquals(n+1, this.ngb.getNumGuesses());
	}


	@Test
	public void testNotAnInteger() {
		double rand = this.rg.nextDouble();
		int n;

		// Проверяем реакцию на дробь
		n = this.ngb.getNumGuesses();
		this.ngb.setGuess(String.valueOf(rand));
		assertEquals("a number next time", this.ngb.getHint());
		assertEquals(n+1, this.ngb.getNumGuesses());

		// Проверяем реакцию на букву
		n = this.ngb.getNumGuesses();
		this.ngb.setGuess("A");
		assertEquals("a number next time", this.ngb.getHint());
		assertEquals(n+1, this.ngb.getNumGuesses());

		// Проверяем реакцию на спецсимвол
		n = this.ngb.getNumGuesses();
		this.ngb.setGuess("%^#^&#%#%#$#");
		assertEquals("a number next time", this.ngb.getHint());
		assertEquals(n+1, this.ngb.getNumGuesses());
	}
	
}

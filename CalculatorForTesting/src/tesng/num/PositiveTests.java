/*
�������� ���������� �����
*/

package tesng.num;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class PositiveTests {

	private NumberGuessBean ngb;
	
	// ����� ������ ������ ������ ��������� NumberGuessBean
	@Before
	public void testPreparation() {
		this.ngb = new NumberGuessBean();
	}
	
	// ����� ������� ����� ��������� ��������� NumberGuessBean
	@After
	public void testFinalisation() {
		this.ngb = null;
	}
	
	@Test
	public void testDefaultValues() {
		// ��������� ��� ������ �������� ������ NumberGuessBean
		
		assertTrue(this.ngb.getNumGuesses() == 0);
		assertTrue(this.ngb.getSuccess() == false);
		
		 // ��������� �������� ��� ������ ������ ������ � ��������� [1,100]
		assertTrue(this.ngb.answer>=1 && this.ngb.answer<=100);
		assertTrue(this.ngb.hint==null);
	}

	@Test
	public void testLessThanAnswer() {
		// ��������� ���������� �������
		int n = this.ngb.getNumGuesses();
		
		// ���� ���������� �����
		this.ngb.answer = 50;
		
		// ���� ���������� ������� �����
		this.ngb.setGuess("49");
		
		// ��������� ���������
		assertEquals("higher", this.ngb.getHint());
		
		// ���������, ��� ���������� ������� ����������� �� 1
		assertEquals(n+1, this.ngb.getNumGuesses());
	}
	
	@Test // ��. ����������� � testLessThanAnswer()
	public void testGreaterThanAnswer() {
		int n = this.ngb.getNumGuesses();
		this.ngb.answer = 50;
		this.ngb.setGuess("51");
		assertEquals("lower", this.ngb.getHint());
		assertEquals(n+1, this.ngb.getNumGuesses());
	}
}

/*
�������� ���� ������ reset() (��. ����������� � ����� ���� � PositiveTest.java)
*/


package tesng.num;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestResetMethod {

	private NumberGuessBean ngb;
	
	@Before
	public void testPreparation() {
		this.ngb = new NumberGuessBean();
	}
	
	@After
	public void testFinalisation() {
		this.ngb = null;
	}
	
	@Test
	public void testReset()
	{
		// �������� ���� � "�� ������ ���������" (�.�. ���-�� � ��� ������, ����� � ���
		// ��������� ���������)
		
		int i;
		for (i=0; i<10; i++)
		{
			this.ngb.setGuess(String.valueOf(i));
		}
		
		// �������� ����������� �����
		this.ngb.reset();

		// ���������, ��� ����� ��������� ���������
		assertTrue(this.ngb.getNumGuesses() == 0);
		assertTrue(this.ngb.getSuccess() == false);
		assertTrue(this.ngb.answer>=1 && this.ngb.answer<=100);
	}
	
}

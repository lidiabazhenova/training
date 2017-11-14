/*
�������� ���� ����������� �������� (��. ����������� � ����� ���� � PositiveTest.java)
��������� �������������� �����
*/

package tesng.num;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestVictory {

private NumberGuessBean ngb;
	
	@Before
	public void testPreparation() {
		this.ngb = new NumberGuessBean();
	}
	
	@After
	public void testFinalisation() {
		this.ngb = null;
	}
	
	@Test(timeout=10)
	public void testOneCanWin() {
		int i;
		int border_left = 0;
		int border_right = 100;
		int delta;
		
		System.out.println("Ha-ha! We know the anser = " + this.ngb.answer);
		
		i = Math.round((border_right-border_left)/2);
		
		while(this.ngb.getSuccess()!=true){
			System.out.print("Try " + i);
			
			// ������� �������
			this.ngb.setGuess(String.valueOf(i));
			if (this.ngb.getSuccess()==true)
			{
				System.out.println("\n\nSuccess at attempt " + this.ngb.getNumGuesses() + " ; the answer was " + this.ngb.answer);
			}
			else // ���� �� �������
			{
				System.out.println(" ... fail!");
								
				// ���� ��������� ������� ����� �������, ��� �� �����, �������� �������� ����� � ����� ��� �������
				if (this.ngb.getHint().equalsIgnoreCase("lower"))
				{
					border_right = i;
					delta = (int) Math.ceil((border_right-border_left)/2.0);
					i = border_left + delta;
					System.out.println("L border_left = " + border_left + "; border_right = " + border_right + " ; delta = " + delta);
				}
				// ���� ��������� ������� ����� �������, ��� �� �����, �������� �������� ������ � ����� ��� �������
				else
				{
					border_left = i;
					delta = (int) Math.ceil((border_right-border_left)/2.0);
					i =  border_left + delta;
					System.out.println("H border_left = " + border_left + "; border_right = " + border_right + "  ; delta = " + delta);
				}
			}
		}
		
	}
	
}

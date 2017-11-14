package lidiabazhenova.com;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

	@Test
	public void testGetEquilateralTriangle() throws Exception {
		Triangle triangle = new Triangle(1, 1, 1);
		assertTrue("Triangle is equilateral", "equilateral triangle".equals(triangle.getTypeTriangle()));
	}
	
	@Test
	public void testGetIsoscelesTriangle() throws Exception {
		Triangle triangle = new Triangle(1, 3, 3);
		assertTrue("Triangle is isosceles", "isosceles triangle".equals(triangle.getTypeTriangle()));
	}
	
	@Test
	public void testGetVersatileTriangle() throws Exception {
		Triangle triangle = new Triangle(3, 2, 4);
		assertTrue("Triangle is versatile", "versatile triangle".equals(triangle.getTypeTriangle()));
	}
	
	@Test()
	public void testNotCorrectArgs() throws Exception {
		try {
			new Triangle(0, 1, 1);
			Assert.fail();
		} catch (IllegalArgumentException ex) {
			Assert.assertEquals(true, "args aren't correct".equals(ex.getMessage()));
		}

	}
	
	@Test()
	public void testNotTriangle() throws Exception {
		try {
			new Triangle(1, 1, 2);
			Assert.fail();
		} catch (Exception ex) {
			Assert.assertEquals(true, "not a triangle".equals(ex.getMessage()));
		}

	}

	
}

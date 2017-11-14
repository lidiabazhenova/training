package lidiabazhenova.com;

public class Triangle {

	private double firstSide;
	private double secondSide;
	private double thirdSide;

	public Triangle(double firstSide, double secondSide, double thirdSide) throws Exception {
		super();
		this.firstSide = firstSide;
		this.secondSide = secondSide;
		this.thirdSide = thirdSide;
		if ((firstSide<=0)||(secondSide<=0)||(thirdSide<=0)) throw new IllegalArgumentException("args aren't correct");
		else if ((firstSide+secondSide<=thirdSide)||(firstSide+thirdSide<=secondSide)|| (secondSide+thirdSide<=firstSide)) throw new Exception("not a triangle");
	}

	public double getFirstSide() {
		return firstSide;
	}

	public double getSecondSide() {
		return secondSide;
	}

	public double getThirdSide() {
		return thirdSide;
	}

	public String getTypeTriangle() {
		if (firstSide == secondSide && firstSide == thirdSide) {
			return "equilateral triangle";
		} else if (firstSide == secondSide || firstSide == thirdSide || secondSide == thirdSide) {
			return "isosceles triangle";
		} else {
			return "versatile triangle";
		}

	}
}

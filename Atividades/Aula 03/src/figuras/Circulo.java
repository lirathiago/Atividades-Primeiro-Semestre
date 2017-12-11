package figuras;
public class Circulo extends Figura{
	private double area;
	
	public Circulo() {
	}
	
	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public double area() {
		return this.getArea();
	}

	@Override
	public String toString() {
		return "Circulo [getArea()=" + getArea() + ", area()=" + area() + "]";
	}

	@Override
	public double perimetro() {
		return 0;
	}

}

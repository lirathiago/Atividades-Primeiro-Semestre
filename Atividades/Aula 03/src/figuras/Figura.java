package figuras;
public abstract class Figura {
	public abstract double area();
	
	public abstract double perimetro();

	@Override
	public String toString() {
		return "Figura [area()=" + area() + "]";
	}
}

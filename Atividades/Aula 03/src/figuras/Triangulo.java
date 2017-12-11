package figuras;

public class Triangulo extends Retangulo{
	private double m, n, p;

	public Triangulo(double base, double altura, double m, double n, double p) {
		super(base, altura);
		this.m = m;
		this.n = n;
		this.p = p;				
	}
	
	@Override
	public double diagonal() {
		return 0;
	}
	
	@Override
	public double area() {
		return super.area() / 2;
	}
	
	@Override
	public double perimetro() {
		return (m*n) + (n*p) + (p*m);
	}

}

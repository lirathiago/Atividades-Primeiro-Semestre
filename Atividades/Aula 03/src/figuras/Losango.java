package figuras;

public class Losango extends Retangulo{
	public Losango(double base, double altura) {
		super(base, altura);
	}
	
	@Override
	public double diagonal() {
		return 0;
	}
	
	@Override
	public double perimetro() {
		return 4 * getBase();
	} 
}

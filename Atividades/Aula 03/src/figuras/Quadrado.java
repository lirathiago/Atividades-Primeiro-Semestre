package figuras;
public class Quadrado extends Retangulo implements Diagonal{
	public Quadrado(double lado) {
		super(lado, lado);
	}
	
	@Override
	public double diagonal() {
		return getBase() * Math.sqrt(2);
	}
	
	@Override
	public double perimetro() {
		return 4 * getBase();
	}
}

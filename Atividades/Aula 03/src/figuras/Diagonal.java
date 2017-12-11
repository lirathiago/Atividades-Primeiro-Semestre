package figuras;

public interface Diagonal {
	double diagonal();
	
	default double diagonal(double altura) {
		return altura * Math.sqrt(2);
	}
	
	default double diagonal(double base, double altura) {
		return Math.sqrt( ( Math.pow(altura, 2) + Math.pow(base, 2) ) );
	}
}

package figuras;
import java.util.ArrayList;

import figuras.Poligono;

public class GeometriaTeste {

	public static void main(String[] args) {
		ArrayList<Figura> figuras = new ArrayList<>();
		figuras.add(new Retangulo(2, 4));
		figuras.add(new Quadrado(2));
		figuras.add(new Losango(4, 8));
		figuras.add(new Triangulo(3, 6, 1, 2, 3));
		
		Informativo inf = new Informativo();
		
		for(Figura fig:figuras) {
			System.out.println("Área " + fig.getClass() + ": " + fig.area());
			System.out.println("Perímetro: " + fig.perimetro());
			if(fig instanceof Diagonal) {
				System.out.println("Diagonal: " +  inf.diagonal( (Diagonal)fig ) );
			}
		}
		
	}

}

package inclasse.struttureDati.polinomi;

public class PolinomiTester {
	public static void main(String[] args) {
		Polynomial p = new Polynomial(new Term(-10, 0));
		p.add(new Polynomial(new Term(-1, 1)));
		p.add(new Polynomial(new Term(9, 7)));
		p.add(new Polynomial(new Term(5, 10)));

		System.out.println(p);
		System.out.println("-----------------------------");

		p.add(new Polynomial(new Term(20, 10)));
		p.add(new Polynomial(new Term(4, -10)));
		System.out.println(p);
		
		System.out.println("-----------------------------");

		p = new Polynomial(new Term(2, 2));
		p.add(new Polynomial(new Term(5, 1)));

		Polynomial p2 = new Polynomial(new Term(3, 3));
		p2.add(new Polynomial(new Term(-7, 0)));


		p.multiply(p2);

		System.out.println(p);

	}
}

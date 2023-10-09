public class Tester {
	public static void main(String[] args) {
		Aliante a1 = new Aliante("Aliante di test", 20);
		Aliante a2 = new Aliante("Secondo aliante di test", 5);

		Jet j1 = new Jet("Jet di test", 400, 5);
		Jet j2 = new Jet("Secondo jet di test", 400, 3);

		TurboElica t1 = new TurboElica("Turboelica di test", 300, 5000);
		TurboElica t2 = new TurboElica("Secondo turboelica di test", 300, 400);

		System.out.println(a1);
		System.out.println(j1);
		System.out.println(t1);
		System.out.println(a2);
		System.out.println(j2);
		System.out.println(t2);


		System.out.println(a1.piuPotenteDi(a2)); //true
		System.out.println(a2.piuPotenteDi(a1)); //false
		System.out.println(a1.piuPotenteDi(j1)); //false (diverso)

		System.out.println("\n");

		System.out.println(j1.piuPotenteDi(j2)); //true
		System.out.println(j2.piuPotenteDi(j1)); //false
		System.out.println(j1.piuPotenteDi(a1)); //false (diverso)

		System.out.println("\n");

		System.out.println(t1.piuPotenteDi(t2)); //true
		System.out.println(t2.piuPotenteDi(t1)); //false
		System.out.println(t1.piuPotenteDi(j1)); //false (diverso)
	}
}

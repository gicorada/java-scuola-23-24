package inclasse.aerei;

public class Tester {
	public static void main(String[] args) {
		Aliante a1 = new Aliante("Aliante di test", 20);
		Aliante a2 = new Aliante("Secondo aliante di test", 5);

		Jet j1 = new Jet("Jet di test", 400, 5);
		Jet j2 = new Jet("Secondo jet di test", 400, 3);

		TurboElica t1 = new TurboElica("Turboelica di test", 300, 5000);
		TurboElica t2 = new TurboElica("Secondo turboelica di test", 300, 400);

		final int TEST_OBJ = 2;

		Aeromobile aTester[] = {a1, a2, j1, t1};
		Aeromobile jTester[] = {j1, j2, a1, t1};
		Aeromobile tTester[] = {t1, t2, a1, j1};

		for(int i = 0; i < TEST_OBJ; i++) {
			for(int j = 0; j < aTester.length; j++) {
				try {
				System.out.println(aTester[i].piuPotenteDi(aTester[j])); //lancia un'eccezione
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		/*
		 * Dovrebbe essere:
		 * true
		 * false
		 * eccezione
		 * eccezione
		 * false
		 * false
		 * eccezione
		 * eccezione
		 */
		System.out.println("\n");


		
		for(int i = 0; i < TEST_OBJ; i++) {
			for(int j = 0; j < jTester.length; j++) {
				try {
				System.out.println(jTester[i].piuPotenteDi(jTester[j])); //lancia un'eccezione
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		/*
		 * Dovrebbe essere:
		 * true
		 * false
		 * eccezione
		 * eccezione
		 * false
		 * false
		 * eccezione
		 * eccezione
		 */
		System.out.println("\n");



		for(int i = 0; i < TEST_OBJ; i++) {
			for(int j = 0; j < tTester.length; j++) {
				try {
				System.out.println(tTester[i].piuPotenteDi(tTester[j])); //lancia un'eccezione
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		/*
		 * Dovrebbe essere:
		 * true
		 * false
		 * eccezione
		 * eccezione
		 * false
		 * false
		 * eccezione
		 * eccezione
		 */
	}
}

package inclasse.complessita;

public class TestExecution {
	public static void main(String[] args) {
		String[] dataO = {"1000", "2500", "10"};

		boolean[] execute = {true, true, true, true, false, false, false, false};

		if(execute.length != 8) throw new IllegalStateException("L'array execute deve avere otto elementi");
		if(execute[0] || execute[1] || execute[2] || execute[3]) {
			System.out.println("---------------------------------------------");
			System.out.println("---------------- ORDINAMENTO ----------------");
			System.out.println("---------------------------------------------");
			
			if(execute[0]) {
				System.out.println("------------------ INTEGER ------------------");
				
				AlgoritmiOrdinamento.main(dataO);
			}
			
			if(execute[1]) {
				System.out.println("------------------ STRINGA ------------------");
				
				AlgoritmiOrdinamentoString.main(dataO);
			}
			
			if (execute[2]) {
				System.out.println("------------------ PERSONA ------------------");
				
				AlgoritmiOrdinamentoPersona.main(dataO);
			}

			if(execute[3]) {
				System.out.println("------------------ GENERIC ------------------");
				
				AlgoritmiOrdinamentoGen.main(dataO);
			}
		}
		

		if(execute[4] || execute[5] || execute[6] || execute[7]) {
			String[] dataR = {"50000", "50100", "5"};
			System.out.println("");
			System.out.println("---------------------------------------------");
			System.out.println("------------------ RICERCA ------------------");
			System.out.println("---------------------------------------------");

			if(execute[4]) {
				System.out.println("------------------ INTEGER ------------------");
				
				AlgoritmiRicerca.main(dataR);
			}

			if(execute[5]) {
				System.out.println("------------------ STRINGA ------------------");
				
				AlgoritmiRicercaString.main(dataR);
			}

			if(execute[6]) {
				System.out.println("------------------ PERSONA ------------------");

				AlgoritmiRicercaPersona.main(dataR);
			}

			if(execute[7]) {
				System.out.println("------------------ GENERIC ------------------");
				
				AlgoritmiRicercaPersona.main(dataR);
			}
		}
	}
}

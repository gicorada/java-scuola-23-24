public class Formula1 {
    public static void main(String[] args) {
        Gara monza = new Gara("Monza");

        String[] nomi = {"Leclerc", "Hamilton", "Schumacher", "Alonso", "Stroll", "Verstappen", "Giovinazzi", "Bottas"};
        String[] scuderie = {"Ferrari", "Mercedes", "Haas", "Alpine", "Aston Martin", "Red Bull", "Alfa R.", "Altro"};
        int[] punti = {25, 25, 3, 14, 18, 20, 5, 0};

        monza.grigliaDiPartenza(nomi, scuderie, punti);

        System.out.println(monza.classifica());

        monza.start();
        // Giro 1
        monza.effettuaSorpasso("Alonso");
        monza.effettuaSorpasso("Stroll");
        monza.fuoriGara("Bottas");

        System.out.println(monza.classifica());


        // Giro 2
        monza.fuoriGara("Giovinazzi");
        monza.effettuaSorpasso("Hamilton");

        System.out.println(monza.classifica());


        // Giro 3


        System.out.println(monza.classifica());


        // Giro 4
        monza.fuoriGara("Hamilton");
        monza.effettuaSorpasso("Verstappen");
        monza.pitStop("Alonso");

        System.out.println(monza.classifica());


        // Giro 5
        monza.pitStop("Schumacher");


        System.out.println(monza.stop());
        monza.vincitore().vittoria();
    }
}

/**
 * Classe che rappresenta una piramide
 * @author radaelli11353
 */
public class Piramide {
    private double base;
    private double altezza;

    public Piramide(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    /**
     * Calcola la superficie della piramide
     * @return superficie della piramide
     */
    public double calcolaSuperficie() {
        double areaBase = base * base;
        double areaLaterale = ((4 * base) * Math.sqrt((base / 2) * (base / 2) + altezza * altezza)) / 2.0;
        return areaBase + areaLaterale;
    }

    /**
     * Calcola il volume della piramide
     * @return volume della piramide
     */
    public double calcolaVolume() {
        return (base * base * altezza) / 3.0;
    }

    public static void main(String[] args) {
        // Esempio di utilizzo della classe per una piramide
        Piramide piramide = new Piramide(5.0, 10.0);

        System.out.println("Superficie della piramide: " + piramide.calcolaSuperficie());
        System.out.println("Volume della piramide: " + piramide.calcolaVolume());
    }
}
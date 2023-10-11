package eserciziario.cap10.es3;

public class PrimeSequenceTester {
    public static void main(String[] args) {
        PrimeSequence ps = new PrimeSequence();
        for(int i = 0; i < 10; i++){
            System.out.println(ps.next());
        }
    }
}

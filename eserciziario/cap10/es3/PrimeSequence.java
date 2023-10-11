package eserciziario.cap10.es3;

public class PrimeSequence implements Sequence {
    private int current;

    public PrimeSequence(){
        this.current = 1;
    }

    @Override
    public int next() {
        current++;
        while(!isPrime(current)){
            current++;
        }
        return current;
    }

    public boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}

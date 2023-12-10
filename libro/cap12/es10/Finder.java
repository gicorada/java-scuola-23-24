package libro.cap12.es10;

public class Finder {
    public static boolean find(String text, String str) {
        if(text.length() < str.length()) {
            return false;
        }

        if(text.startsWith(str)) return true;
        else return find(text.substring(1), str);
    }

    public static void main(String[] args) {
        System.out.println(find("ciao", "ciao"));
        System.out.println(find("ciao", "iao"));
        System.out.println(find("ciao", "c"));
        System.out.println(find("ciao", "o"));
        System.out.println(find("ciao", "a"));
        System.out.println(find("ciao", "b"));
    }
}

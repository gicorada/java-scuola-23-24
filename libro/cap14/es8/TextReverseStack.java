package libro.cap14.es8;

import java.util.Scanner;
import java.util.Stack;

public class TextReverseStack {
    public static void main(String[] args) {
        String text = "Mary had a little lamb. Its fleece was white as snow.";
        Stack<String> stack = new Stack<>();
        Scanner s = new Scanner(text);
        String rev = "";
        s.useDelimiter("\\.");

        while (s.hasNext()) {
            Scanner s2 = new Scanner(s.next());
            s2.useDelimiter(" ");
            while (s2.hasNext()) {
                stack.push(s2.next());
            }

            boolean firstTime = true;
            while (!stack.isEmpty()) {
                if(stack.size() == 1) {
                    String last = stack.pop();
                    last = last.substring(0, 1).toLowerCase() +  last.substring(1);
                    rev += last + ". ";
                } else if(firstTime) {
                    firstTime = false;
                    String last = stack.pop();
                    last = last.substring(0, 1).toUpperCase() +  last.substring(1);
                    rev += last + " ";
                } else {
                    rev += stack.pop() + " ";
                }
            }
        }

        System.out.println(text);
        System.out.println(rev);
    }
}

package inclasse.struttureDati;

public class Tester {
	public static void main(String[] args) {
		StackArrayList<Integer> stack = new StackArrayList<>();
		QueueArrayList<Integer> queue = new QueueArrayList<>();
		CodaCircolareArrayList<Integer> codaCircolare = new CodaCircolareArrayList<>();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.pop();
		stack.pop();
		stack.pop();

		System.out.println(stack);

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();

		System.out.println(queue);


		codaCircolare.enqueue(1);
		codaCircolare.enqueue(2);
		codaCircolare.enqueue(3);
		codaCircolare.enqueue(4);
		codaCircolare.enqueue(5);
		codaCircolare.enqueue(6);
		codaCircolare.enqueue(7);
		codaCircolare.enqueue(8);
		codaCircolare.enqueue(9);
		codaCircolare.enqueue(10);
		codaCircolare.dequeue();
		codaCircolare.dequeue();
		codaCircolare.dequeue();
		codaCircolare.enqueue(12);
		codaCircolare.enqueue(13);

		System.out.println(codaCircolare);	

	}
}

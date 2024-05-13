package libro.cap14.es11;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ToDoListWithPriority {
    PriorityQueue<Task> toDoList = new PriorityQueue<>();

    ToDoListWithPriority() {
        toDoList = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return Integer.compare(t2.getPriority(), t1.getPriority());
            }
        });
    }

    public void add(String task, int priority) {
        toDoList.add(new Task(task, priority));
    }

    public Task next() {
        return toDoList.poll();
    }

    public static void main(String[] args) {
        ToDoListWithPriority toDoList = new ToDoListWithPriority();

        toDoList.add("Do laundry", 5);
        toDoList.add("Buy milk", 1);
        toDoList.add("Clean the kitchen", 7);

        System.out.println(toDoList.next());
        System.out.println(toDoList.next());
        System.out.println(toDoList.next());
    }
}

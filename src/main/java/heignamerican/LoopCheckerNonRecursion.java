package heignamerican;

import java.util.*;

public class LoopCheckerNonRecursion implements LoopChecker {
    @Override
    public boolean thereIsLoopIn(Parts parts) {
        class MyStack {
            List<Parts> parents = new ArrayList<>();
            Parts self;
            Queue<Parts> children = new LinkedList<>();
        }


        MyStack first = new MyStack();
        first.self = parts;
        first.children.addAll(parts.getParts());

        Stack<MyStack> stack = new Stack<>();
        stack.push(first);

        while (true) {
            if (stack.isEmpty()) {
                return false;
            }

            MyStack current = stack.pop();
            if (current.parents.contains(current.self))
                return true;

            Parts poll = current.children.poll();
            if (!current.children.isEmpty())
                stack.push(current);
            if (poll != null) {
                MyStack next = new MyStack();
                next.parents.addAll(current.parents);
                next.parents.add(current.self);
                next.self = poll;
                next.children.addAll(poll.getParts());
                stack.push(next);
            }
        }
    }
}

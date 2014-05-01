package heignamerican;

import java.util.*;

public class LoopCheckerNonRecursion implements LoopChecker {
    @Override
    public boolean thereIsLoopIn(Parts parts) {
        class MyStack {
            final List<Parts> parents;
            final Parts self;
            final Queue<Parts> children;

            MyStack(Parts parts) {
                parents = new ArrayList<>();
                children = new LinkedList<>();

                self = parts;
                children.addAll(parts.getParts());
            }

            MyStack createNext(Parts nextParts) {
                final MyStack stack = new MyStack(nextParts);
                stack.parents.addAll(parents);
                stack.parents.add(self);
                return stack;
            }
        }


        final Stack<MyStack> stack = new Stack<>();
        stack.push(new MyStack(parts));

        while (true) {
            if (stack.isEmpty()) {
                return false;
            }

            final MyStack current = stack.pop();
            if (current.parents.contains(current.self))
                return true;

            final Parts nextParts = current.children.poll();
            if (!current.children.isEmpty())
                stack.push(current);
            if (nextParts != null) {
                stack.push(current.createNext(nextParts));
            }
        }
    }
}

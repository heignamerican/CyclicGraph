package heignamerican;

import java.util.*;

public class LoopCheckerNonRecursion implements LoopChecker {
    @Override
    public boolean thereIsLoopIn(Parts parts) {
        class Context {
            final List<Parts> parents;
            final Parts self;
            final Queue<Parts> children;

            Context(Parts parts) {
                parents = new ArrayList<>();
                children = new LinkedList<>();

                self = parts;
                children.addAll(parts.getParts());
            }

            boolean hasLoop() {
                return parents.contains(self);
            }

            Context createNext(Parts nextParts) {
                final Context nextContext = new Context(nextParts);
                nextContext.parents.addAll(parents);
                nextContext.parents.add(self);
                return nextContext;
            }
        }


        final Stack<Context> rest = new Stack<>();
        rest.push(new Context(parts));

        while (true) {
            if (rest.isEmpty()) {
                return false;
            }

            final Context current = rest.pop();
            if (current.hasLoop())
                return true;

            final Parts nextParts = current.children.poll();
            if (!current.children.isEmpty())
                rest.push(current);
            if (nextParts != null) {
                rest.push(current.createNext(nextParts));
            }
        }
    }
}

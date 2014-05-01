package heignamerican;

import java.util.Stack;

public class LoopCheckerRecursion implements LoopChecker {
    @Override
    public boolean thereIsLoopIn(Parts parts) {
        return hasLoopIn(parts, new Stack<>());
    }

    private boolean hasLoopIn(Parts parts, Stack<Parts> parents) {
        if (parents.contains(parts))
            return true;

        for (Parts p : parts) {
            parents.push(parts);
            if (hasLoopIn(p, parents))
                return true;
            parents.pop();
        }
        return false;
    }
}

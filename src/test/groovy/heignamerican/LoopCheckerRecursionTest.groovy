package heignamerican

import org.junit.Test;

class LoopCheckerRecursionTest {
    @Test
    void testループなし() {
        final Parts a = new Parts("A")
        final Parts b = new Parts("B")
        final Parts c = new Parts("C")
        final Parts d = new Parts("D")
        a.add(b)
        a.add(c)
        b.add(d)
        c.add(d)

        assert new LoopCheckerRecursion().thereIsLoopIn(a) == false
    }

    @Test
    void testループあり() {
        final Parts a = new Parts("A")
        final Parts b = new Parts("B")
        final Parts c = new Parts("C")
        final Parts d = new Parts("D")
        a.add(b)
        a.add(c)
        b.add(d)
        c.add(d)
        d.add(b)

        assert new LoopCheckerRecursion().thereIsLoopIn(a) == true
    }
}

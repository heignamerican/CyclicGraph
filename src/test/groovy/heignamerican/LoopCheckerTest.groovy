package heignamerican

import org.junit.Test
import org.junit.Before

abstract class LoopCheckerTest {
    protected LoopChecker loopChecker

    @Before
    abstract void setUp();

    @Test
    void test単一Parts() {
        final Parts a = new Parts("A")

        assert loopChecker.thereIsLoopIn(a) == false
    }

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

        assert loopChecker.thereIsLoopIn(a) == false
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

        assert loopChecker.thereIsLoopIn(a) == true
    }
}

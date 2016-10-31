import com.stack.kata.KataStack;
import com.stack.kata.KataStackImpl;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

public class KataStackTest {

    KataStackImpl<Integer> kataStack = new KataStackImpl(5);

    @Test(expected = KataStack.KataStackOutOfBounds.class)
    public void shouldEnforceCustomInitialSize(){
        pushToStack(0, 6);
    }

    private void pushToStack(int start, int end) {
        IntStream.range(start, end).boxed().forEach(e -> kataStack.push(e));
    }

    @Test
    public void shouldAddElementToTopOfStack(){
        pushToStack(0, 2);
        assertTrue(kataStack.peek() == 1);
    }

    @Test
    public void shouldRemoveElementFromTopOfStack(){
        pushToStack(0, 2);
        kataStack.pop();
        assertTrue(kataStack.peek() == 0);
    }

    @Test
    public void shouldReturnCorrectCountOfElems(){
        pushToStack(0, 2);
        assertTrue(kataStack.count() == 2);

        kataStack.pop();
        assertTrue(kataStack.count() == 1);
    }

    @Test(expected = KataStack.KataStackEmpty.class)
    public void shouldThrowExceptionKataStackEmptyOnPeek(){
        kataStack.peek();
    }

    @Test(expected = KataStack.KataStackEmpty.class)
    public void shouldThrowExceptionKataStackEmptyOnPop(){
        kataStack.pop();
    }
}

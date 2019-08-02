package iluo.javaCoreTech.Unit6;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class LambdaTest {
    public interface IntConsumer{
        void accept(int value);
    }

    public static void repeat ( int n , BiConsumer<Integer,String> action )
    {
        for ( int i = 0; i < n ; i++ ) action.accept(i,String.valueOf(i));
    }


    public static void main(String[] args){
        repeat(10,(i,j) -> System.out.println("Countdown" + (9 - i)));
    }
}

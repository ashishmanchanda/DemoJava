package MultiThreadingPractice;
import java.util.concurrent.atomic.AtomicInteger;

 class Main
{
    public static void main(String[] args)
    {
        AtomicInteger atomicInteger = new AtomicInteger(100);

        boolean isSuccess = atomicInteger.compareAndSet(100,110); //current value 100

        System.out.println(isSuccess);    //true

        isSuccess = atomicInteger.compareAndSet(100,120);   //current value 110

        System.out.println(isSuccess);    //false

    }
}
package MultiThreadingPractice;


 class YieldExample
{
    public static void main(String[] args)
    {
        Thread YieldProducer = new YieldProducer();
        Thread YieldConsumer = new YieldConsumer();

        YieldProducer.setPriority(Thread.MIN_PRIORITY); //Min Priority
        YieldConsumer.setPriority(Thread.MAX_PRIORITY); //Max Priority

        YieldProducer.start();
        YieldConsumer.start();
    }
}

class YieldProducer extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am YieldProducer : Produced Item " + i);
            Thread.yield();
        }
    }
}

class YieldConsumer extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am YieldConsumer : Consumed Item " + i);
            Thread.yield();
        }
    }
}

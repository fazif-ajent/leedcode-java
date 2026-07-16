public class Printfoobaralt {
    private int n;
    private Semaphore foosem=new Semaphore(1);
    private Semaphore barsem=new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	foosem.acquire();
            printFoo.run();
            barsem.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	barsem.acquire();
            printBar.run();
            foosem.release();
        }
    }
}
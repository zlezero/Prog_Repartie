package MonteCarlo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Approximates PI using the Monte Carlo method.  Demonstrates
 * use of Callables, Futures, and thread pools.
 */
public class Pi 
{
  public static void main(String[] args) throws Exception 
  {
    // 10 workers, 50000 iterations each
    new Master().doRun(50000, 10);
  }
}

/**
 * Creates workers to run the Monte Carlo simulation
 * and aggregates the results.
 */
class Master {
  public double doRun(int totalCount, int numWorkers) throws InterruptedException, ExecutionException 
  {
    // Create a collection of tasks
    List<Callable<Long>> tasks = new ArrayList<Callable<Long>>();
    for (int i = 0; i < numWorkers; ++i) 
    {
      tasks.add(new Worker(totalCount));
    }
    
    // Run them and receive a collection of Futures
    ExecutorService exec = Executors.newFixedThreadPool(numWorkers);
    List<Future<Long>> results = exec.invokeAll(tasks);
    long total = 0;
    
    // Assemble the results.
    for (Future<Long> f : results)
    {
      // Call to get() is an implicit barrier.  This will block
      // until result from corresponding worker is ready.
      total += f.get();
    }
    double pi = 4.0 * total / totalCount / numWorkers;
    System.out.println("Pi : " + pi);
    exec.shutdown();
    return pi;
  }
}

/**
 * Task for running the Monte Carlo simulation.
 */
class Worker implements Callable<Long> 
{   
  private int numIterations;
  public Worker(int num) 
  { 
    this.numIterations = num; 
  }

  @Override
  public Long call() 
  {
    long circleCount = 0;
    Random prng = new Random ();
    for (int j = 0; j < numIterations; j++) 
    {
      double x = prng.nextDouble();
      double y = prng.nextDouble();
      if ((x * x + y * y) < 1)  ++circleCount;
    }
    return circleCount;
  }
}




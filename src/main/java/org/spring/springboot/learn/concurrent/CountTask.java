package org.spring.springboot.learn.concurrent;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by xli on 2017/5/2.
 */
public class CountTask extends RecursiveTask<Long> {
    
    private static final  int TASKMAXSIZE = 10000;
    
    private long start;
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean  canCompute = (end - start) < TASKMAXSIZE;
        if(canCompute){
            for(long i = start; i<= end; i++){
                sum += i;
            }
        }else {
            long segament = (end - start + 99)  /100;
            ArrayList<CountTask> subTasks = new ArrayList<CountTask>();
            long from = start;
            long to  = start;
            for(int page=1 ;page <=segament ; page++){


                if(page ==1){
                    from = start;
                }else {
                    from  = to + 1;
                }
                to = Math.min(page*100 ,end);

                CountTask sonTask = new CountTask(from,to);  
                subTasks.add(sonTask);
                sonTask.fork();
            }
            
            for(CountTask son:subTasks){
                sum += son.join();
            }
            
        }
        
        return sum;
    }

    public static void main(String[] args) {
//        long sum1 = 0;
//        for(int i=0;i<=200001;i++){
//            sum1+=i;
//        }
//        System.out.println(sum1);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(0,2000001L);
        ForkJoinTask<Long> rlt = forkJoinPool.submit(task);
        try {
           long totolSum =  rlt.get();
            System.out.printf("totolSum = " + totolSum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

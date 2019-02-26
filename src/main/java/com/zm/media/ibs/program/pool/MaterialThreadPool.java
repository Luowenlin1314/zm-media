package com.zm.media.ibs.program.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by USERA on 2019/2/18.
 * 元素线程池，用来管理下载任务
 */
public class MaterialThreadPool  extends ThreadPoolExecutor {

    /**
     *  线程池实例
     */
    private  static MaterialThreadPool materialThreadPool = new MaterialThreadPool();
    /**
     * 核心池的大小默认情况下，在创建了线程池后，线程池中的线程数为0，当有任务来之后，就会创建一个线程去执行任务，
     当线程池中的线程数目达到corePoolSize后，就会把到达的任务放到缓存队列当中；
     */
    private static int corePoolSize = 1;
    /**
     * 线程池最大线程数，它表示在线程池中最多能创建多少个线程；
     */
    private static int maximumPoolSize = 1000;
    /**
     * 表示线程没有任务执行时最多保持多久时间会终止
     */
    private static long keepAliveTime = 1l;
    /**
     * 参数keepAliveTime的时间单位，TimeUnit.SECONDS秒
     */
    private static TimeUnit timeUnit = TimeUnit.SECONDS;
    /**
     * 一个阻塞队列，用来存储等待执行的任务
     */
    private static BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();

    public MaterialThreadPool()
    {
        this(corePoolSize, maximumPoolSize, keepAliveTime, timeUnit, workQueue);
    }

    public MaterialThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    /**
     * 执行任务
     * @param runnable
     */
    public static void excuteTask(Runnable runnable){
        materialThreadPool.execute(runnable);
    }

}

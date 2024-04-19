package com.xiaopeng.speech.vui.task;

import com.xiaopeng.speech.vui.task.queue.DeDuplicationQueue;
import com.xiaopeng.speech.vui.task.queue.TaskWrapperQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class ThreadPoolProxy {
    public int mCorePoolSize;
    public ThreadPoolExecutor mExecutor;
    public int mMaximumPoolSize;
    public DeDuplicationQueue queue;

    public ThreadPoolProxy(int i, int i2) {
        this.mCorePoolSize = i;
        this.mMaximumPoolSize = i2;
    }

    private void initThreadPoolExecutor() {
        ThreadPoolExecutor threadPoolExecutor = this.mExecutor;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown() || this.mExecutor.isTerminated()) {
            synchronized (ThreadPoolProxy.class) {
                if (this.mExecutor == null || this.mExecutor.isShutdown() || this.mExecutor.isTerminated()) {
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    this.queue = new TaskWrapperQueue();
                    this.mExecutor = new ThreadPoolExecutor(this.mCorePoolSize, this.mMaximumPoolSize, 3000L, timeUnit, this.queue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
                }
            }
        }
    }

    public void execute(Runnable runnable) {
        initThreadPoolExecutor();
        this.mExecutor.execute(runnable);
    }

    public void remove(Runnable runnable) {
        initThreadPoolExecutor();
    }

    public void removeTask(String str) {
        DeDuplicationQueue deDuplicationQueue = this.queue;
        if (deDuplicationQueue != null) {
            deDuplicationQueue.removeTask(str);
        }
    }

    public Future submit(Runnable runnable) {
        initThreadPoolExecutor();
        return this.mExecutor.submit(runnable);
    }
}

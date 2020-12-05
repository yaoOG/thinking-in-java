package org.thinking.util.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Daniel:)
 * 使用 ConcurrentHashMap 来统计，Key 的范围是 10。
 * 使用最多 10 个并发，循环操作 1000 万次，每次操作累加随机的 Key。
 * 如果 Key 不存在的话，首次设置值为 1。
 */
public class MyConcurrentHashMap {

    //循环次数
    private static final int LOOP_COUNT = 10000000;

    //线程数量
    private static final int THREAD_COUNT = 10;
    //元素数量
    private static final int ITEM_COUNT = 1000;

    public static void main(String[] args) {
        ConcurrentHashMap<String, LongAdder> freqs = new ConcurrentHashMap<>(ITEM_COUNT);
        String key = "key" + System.currentTimeMillis();
        freqs.put("test", new LongAdder());
        freqs.computeIfAbsent(key, k -> new LongAdder()).increment();
        System.out.println(freqs.entrySet().toArray());
    }

    private Map<String, Long> goodUse() throws InterruptedException {
        ConcurrentHashMap<String, LongAdder> freqs = new ConcurrentHashMap<>(ITEM_COUNT);
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(() ->
                IntStream.rangeClosed(1, LOOP_COUNT)
                        .parallel()
                        .forEach(i -> {
                                    String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);
                                    //利用computeIfAbsent()方法来实例化LongAdder，然后利用LongAdder来进行线程安全计数
                                    freqs.computeIfAbsent(key, k -> new LongAdder()).increment();
                                }
                        ));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        //因为我们的Value是LongAdder而不是Long，所以需要做一次转换才能返回
        return freqs
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> e.getValue().longValue()));
    }


}

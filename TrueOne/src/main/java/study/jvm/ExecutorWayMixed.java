package study.jvm;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther Micky
 * @Date 2020-09-13 23:35
 * <p>
 * 前提：默认hotspot虚拟机
 * <p>
 * 1.java是混合执行的方式，即解释+编译（JIT，热点代码，hotspot的由来）。
 * <p>
 * 2.也可以通过VM参数指定执行模式
 * <p>
 * 1)-Xmixed 默认的混合模式模式，开始时候全部解释执行，启动速度较快，当检测到热点代码，则将其编译为本地代码（二进制       机器码，类似exe）提高执行效率。
 * <p>
 * 2)-Xint，解释模式，启动快执行慢。
 * <p>
 * 3)-Xcomp，编译模式，执行快，启动慢。
 * <p>
 * 3.热点代码如何检测
 * <p>
 * 1.多次被调用的方法，有个方法计数器，jvm有监测机制，方法执行频率大于一定次数
 * <p>
 * 2.多次被调用的循环，有个代码执行的循环计数器，检测。
 */
@Slf4j
public class ExecutorWayMixed {
    private static final int LOOP_TIMES = 20_0000;

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < LOOP_TIMES; j++) {
                testLoop();
            }
        }
        log.info("It is cost time is {}", System.currentTimeMillis() - startTime);
    }

    /**
     * 空循环，耗时
     *
     * @return void
     */
    private static void testLoop() {
        for (long i = 0; i < LOOP_TIMES; i++) {
            i++;
        }
    }

}

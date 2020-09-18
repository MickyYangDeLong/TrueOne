package study.algorithm.sort;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @Auther Micky
 * @Date 2020-09-15 21:53
 * 大港油田的项目，区域入侵需要画四边形
 * 后端穿过来的是没有顺序的。
 * 需要分左上，右上，右下，左下传给设备。
 */
public class TreeMapComparatorTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
     /*   Map<Integer,Integer> treeMap = new LinkedHashTreeMap<>();
        treeMap.put(900,90);
        treeMap.put(900,90);
        treeMap.put(900,90);
        treeMap.put(900,90);
        System.out.println(treeMap);*/
     Class.forName("java.util.Stack").getEnclosingConstructor().newInstance();
        XY[] xyArray = new XY[]{
                new XY(900, 93),
                new XY(98, 905),
                new XY(89, 909),
                new XY(901, 80)};
        System.out.println(Arrays.toString(xyArray));
        Arrays.sort(xyArray, (o1, o2) -> {
            if (o1.x > o2.x) {
                return 1;
            } else if (o1.x == o2.x && o1.y > o2.y) {
                return 1;
            } else {
                return -1;
            }
        });
        System.out.println(Arrays.toString(xyArray));

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    private static class XY{
        Integer x;
        Integer y;
    }
}

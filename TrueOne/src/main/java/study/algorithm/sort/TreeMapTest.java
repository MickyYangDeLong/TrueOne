package study.algorithm.sort;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

/**
 * @Auther Micky
 * @Date 2020-09-15 21:53
 *大港油田的项目，区域入侵需要画四边形
 * 后端穿过来的是没有顺序的。
 * 需要分左上，右上，右下，左下传给设备。
 *
 */
public class TreeMapTest {
    public static void main(String[] args) {
     /*   Map<Integer,Integer> treeMap = new LinkedHashTreeMap<>();
        treeMap.put(900,90);
        treeMap.put(900,90);
        treeMap.put(900,90);
        treeMap.put(900,90);
        System.out.println(treeMap);*/
        XY[] xyArray = new XY[]{
                new XY(89,909),
                new XY(900,93),
                new XY(98,905),
                new XY(901,80),};
        System.out.println(Arrays.toString(xyArray));
        Arrays.sort(xyArray);
        System.out.println(Arrays.toString(xyArray));

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    private static class XY implements Comparable<XY>{
        Integer x;
        Integer y ;

        @Override
        public int compareTo(XY o) {
            if (x > o.x){
                return 1;
            }else if( x == o.x && y > o.y){
                return 1;
            }else{
                return -1;
            }
        }
    }
}

package leetCode.剑指Offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

/**
 * 请实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内没有其他安排，则可以存储这个新的日程安排。
 * <p>
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，
 * 注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
 * <p>
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生重复预订。
 * <p>
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true。
 * 否则，返回 false 并且不要将该日程安排添加到日历中。
 * <p>
 * 请按照以下步骤调用 MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * ["MyCalendar","book","book","book"]
 * [[],[10,20],[15,25],[20,30]]
 * 输出: [null,true,false,true]
 * 解释:
 * MyCalendar myCalendar = new MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(15, 25); // returns false ，第二个日程安排不能添加到日历中，因为时间 15 已经被第一个日程安排预定了
 * MyCalendar.book(20, 30); // returns true ，第三个日程安排可以添加到日历中，因为第一个日程安排并不包含时间 20
 */
public class 剑指Offer_058_日程表 {
    public static void main(String[] args) {

    }

    static class MyCalendar {

        TreeMap<Integer, Integer> tree;

        public MyCalendar() {
            tree = new TreeMap<Integer, Integer>();
        }

        public boolean book(int start, int end) {
            //返回小于等于给定键的最大键；如果不存在这样的键，则返回null。
            Integer prev = tree.floorKey(start);
            //返回大于等于给定键的最小键
            Integer cur = tree.ceilingKey(start);
            //判断区间位置--在给定目标后面 或者 在给定目标前面
            //tree.get(prev)<=start 该日程表 安排在之后
            //end<=cur 该日程表 安排在之前
            if((prev==null||tree.get(prev)<=start)&&(cur==null||end<=cur)){
                tree.put(start, end);
                return true;
            }
            return false;
        }
    }
}

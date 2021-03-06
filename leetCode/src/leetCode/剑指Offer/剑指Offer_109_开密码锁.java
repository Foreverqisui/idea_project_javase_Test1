package leetCode.剑指Offer;

import java.util.*;


/**
 * 一个密码锁由 4 个环形拨轮组成，每个拨轮都有 10 个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，请给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 */
public class 剑指Offer_109_开密码锁 {
    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        Solution sol = new Solution();
        System.out.println(sol.openLock(deadends, target));
    }

    static class Solution {
        public int openLock(String[] deadends, String target) {
            //人间疾苦，解锁不易
            //边界判断
            if (target.equals("0000")) {
                return 0;
            }
            //借助哈希表 找到不让用的值 --dead
            Set<String> dead = new HashSet<>(Arrays.asList(deadends));
            if (dead.contains("0000")) {
                return -1;
            }
            //传统bfs
            Queue<String> queue = new LinkedList<>();
            //判断重复词集合
            Set<String> seen = new HashSet<>();
            //加入开始密码
            queue.offer("0000");
            seen.add("0000");
            int res =0;
            //bfs 遍历 -- 条件为：队列不为空
            while (!queue.isEmpty()) {
                //计算步数
                res++;
                //获取队列的长度
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    //拿到元素
                    String status = queue.poll();
                    //枚举旋转一次 能得到的所有结果
                    for (String nextStatus : changed (status)){
                        //判断不在死词里 && 不重复的元素
                        if (!dead.contains(nextStatus) && !seen.contains(nextStatus)) {
                            //如果和目标值相等
                            if (target.equals(nextStatus)) {
                                return res;
                            }
                            //否则 加入到队列里面 准备接着变数
                            queue.offer(nextStatus);
                            //加入重复集合里，防止重复
                            seen.add(nextStatus);
                        }
                    }
                }
            }
            return -1;
        }

        public char numPrev(char x) {
            return x == '0' ? '9' : (char) (x - 1);
        }

        public char numSucc(char x) {
            return x == '9' ? '0' : (char) (x + 1);
        }

        //枚举旋转一次能得到的所有结果
        public List<String> changed(String status) {
            List<String> ret = new ArrayList<String>();
            char[] array = status.toCharArray();
            for (int i = 0; i < 4; ++i) {
                char num = array[i];
                array[i] = numPrev(num);
                ret.add(new String(array));
                array[i] = numSucc(num);
                ret.add(new String(array));
                array[i] = num;
            }
            return ret;
        }
    }
}


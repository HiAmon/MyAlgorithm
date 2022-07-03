package leetcode.editor.cn.huawei.middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        DailyTemperature dailyTemperature = new DailyTemperature();
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperature.dailyTemperatures(temperatures);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+", ");
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] trend = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length - 1; i++) {
            stack.push(i);
            while (!stack.empty()){
                if (temperatures[stack.peek()] < temperatures[i+1]){
                    Integer top = stack.pop();
                    trend[top] = i-top+1;
                }else {
                    //trend[stack.peek()]++;
                    break;
                }
            }
        }
        return trend;
    }


}

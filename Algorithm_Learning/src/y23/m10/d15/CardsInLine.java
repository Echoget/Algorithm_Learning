package y23.m10.d15;

/**
 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线，玩家A和玩家B依次拿走每张牌，规定A先拿，B后拿，但每位玩家每次只能拿走最左或最右的牌，玩家A和B都绝顶聪明。
 * 请返回最后获胜者的分数。
 * 问题分析：
 * 递归或dp
 * 范围上尝试的模型
 */

public class CardsInLine {

    public static void main(String[] args) {

        int[] nums = new int[]{48,75,94,57,12,50,23,31,45,27,24,65,34};

        System.out.println(solution(nums));

    }

    public static int solution(int[] arr){
        if(arr.length == 0){
            return 0;
        }

        return Math.max(first(arr,0,arr.length - 1), second(arr,0,arr.length - 1));
    }

    // 先手最大分数
    public static int first(int[] arr, int L, int R){
        if(L == R){
            return arr[L];
        }
        return Math.max(second(arr,L + 1,R) + arr[L], second(arr,L,R - 1) + arr[R]);
    }

    // 后手最大分数
    public static int second(int[] arr, int L, int R){
        if(L == R){
            return 0;
        }
        return Math.min(first(arr,L + 1,R), first(arr,L,R - 1));
    }
}

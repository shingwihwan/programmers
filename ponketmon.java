import java.util.HashSet;

public class ponketmon {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 4};
        PonketmonSolve solv = new PonketmonSolve();
        solv.solution(nums);
    }
}

class PonketmonSolve {
    public int solution (int[] nums) {

        HashSet<Integer> save = new HashSet<>();

        int answer = 0;
        int ponketmonPick = (nums.length / 2);
        // System.out.println("pick : " + ponketmonPick);

        for(int i = 0; i < nums.length; i++){
           for(int j = 0; j < ponketmonPick; j++){
               System.out.println(nums[i]);
           }
            
        }
        System.out.println(nums);
        return 0;
    }
}
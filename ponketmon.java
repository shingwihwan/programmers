import java.util.ArrayList;
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

        ArrayList<Integer> save = new ArrayList<>();

        int answer = 0;
        int ponketmonPick = (nums.length / 2);

        for(int data : nums){
            if(!save.contains(data)){
                save.add(data);
            }
        }
        int cnt = save.size();
        if(ponketmonPick < cnt){
            answer = ponketmonPick;
        } else {
            answer = cnt;
        }

        System.out.println(answer);

        // for(int i = 0; i < nums.length; i++){
        //    for(int j = 0; j < ponketmonPick; j++){
        //        System.out.println(nums[i]);
        //    }
            
        // }
        // System.out.println(nums);
        return 0;
    }
}
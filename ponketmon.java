import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Ponketmon {
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
                System.out.println("nums : " + data);
                save.add(data);
            }
        }

        int cnt = save.size();
        if(ponketmonPick < cnt){
            answer = ponketmonPick;
        } else {
            answer = cnt;
        }

        return answer;
    }
}

// 다른 사람의 풀이
class Solution1 {
    public int solution(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
    }
}

class Solution2 {
    public int solution(int[] nums) {

            HashSet<Integer> hs = new HashSet<>();

            for(int i =0; i<nums.length;i++) {
                hs.add(nums[i]);
            }

            if(hs.size()>nums.length/2)
                return nums.length/2;

            return hs.size();
    }
}
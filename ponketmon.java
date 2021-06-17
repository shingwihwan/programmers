class Solution{
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        int ponketmonPick = (nums.length / 2);
        System.out.println(ponketmonPick);

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < ponketmonPick; j++){
                System.out.println(nums[i]);
            }
        }
    }
}
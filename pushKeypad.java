public class pushKeypad {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        
        PushKeypadSolve solve = new PushKeypadSolve();
        solve.solutionPush(numbers, hand);
    
    }
}

class PushKeypadSolve {

    public String solutionPush(int[] numbers, String hand){
        String answer = "";
        int leftIndex = 10;
        int rightIndex = 12;


        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7){
                answer += "L";
                leftIndex = number;
            } else if(number == 3 || number == 6 || number == 9){
                answer += "R";
                rightIndex = number;
            } else {
                int leftFinger = calC(leftIndex, number);
                int rightFinger = calC(rightIndex, number);

                if(leftFinger > rightFinger){
                    answer += 'R';
                    rightIndex = number;
                } else if(leftFinger < rightFinger){
                    answer += 'L';
                    leftIndex = number;
                } else {
                    if(hand.equals("right")){
                        answer += 'R';
                        rightIndex = number;
                    } else {
                        answer += 'L';
                        leftIndex = number;
                    }
                }

            }
        }
        return answer;
    }

    public static int calC(int location, int number) {

        if(location == 0){
            location = 11;
        }

        if(number == 0){
            number = 11;
        }

        int locationX = (location - 1) / 3;
        int locationY = (location -1) % 3;

        int numberX = (number - 1) / 3;
        int numberY = (number - 1) % 3;

        int result = Math.abs(numberX - locationX) + Math.abs(numberY - locationY);
        return result;
    }
}


class Solution {
    //        0부터 9까지 좌표 {y,x}
    int[][] numpadPos = {
            {3,1}, //0
            {0,0}, //1
            {0,1}, //2
            {0,2}, //3
            {1,0}, //4
            {1,1}, //5
            {1,2}, //6
            {2,0}, //7
            {2,1}, //8
            {2,2}  //9
    };
    //초기 위치
    int[] leftPos = {3,0};
    int[] rightPos = {3,2};
    String hand;
    public String solution(int[] numbers, String hand) {
        this.hand = (hand.equals("right")) ? "R" : "L";

        String answer = "";
        for (int num : numbers) {
            String Umji = pushNumber(num);
            answer += Umji;

            if(Umji.equals("L")) {leftPos = numpadPos[num]; continue;}
            if(Umji.equals("R")) {rightPos = numpadPos[num]; continue;}
        }
        return answer;
    }

    //num버튼을 누를 때 어디 손을 사용하는가
    private String pushNumber(int num) {
        if(num==1 || num==4 || num==7) return "L";
        if(num==3 || num==6 || num==9) return "R";

        // 2,5,8,0 일때 어디 손가락이 가까운가
        if(getDist(leftPos, num) > getDist(rightPos, num)) return "R";
        if(getDist(leftPos, num) < getDist(rightPos, num)) return "L";

        //같으면 손잡이
        return this.hand;
    }

    //해당 위치와 번호 위치의 거리
    private int getDist(int[] pos, int num) {
        return Math.abs(pos[0]-numpadPos[num][0]) + Math.abs(pos[1]-numpadPos[num][1]);
    }
}

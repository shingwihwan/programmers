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
        
        int locationX = (location - 1) / 3;
        int locationY = (location -1) % 3;

        int numberX = (number - 1) / 3;
        int numberY = (number - 1) % 3;

        int result = Math.abs(numberX - locationX) + Math.abs(numberY - locationY);
        return result;
    }
}

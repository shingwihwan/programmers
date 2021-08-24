import java.util.Arrays;

public class SortKnum {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};

        SortKnumSolve solv = new SortKnumSolve();
        solv.solution(array, commands);
    }
}

// 2~3시간을 헤매다가 해결 못해서 다른 분걸 참조함..
// if ~ switch 이것 저것 쓰면서 난리를 부림..
class SortKnumSolve{
    public int[] solution (int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] -1];
        }
        for(int j = 0; j < answer.length; j++){
            System.out.println(answer[j]);
        }
        return answer;
    }
}
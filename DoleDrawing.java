import java.util.LinkedList;
import java.util.Queue;

public class DoleDrawing{
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        SolutionDoleDrawing solv = new SolutionDoleDrawing();
        solv.solution(board, moves);
        
    }
}

class SolutionDoleDrawing {
    public String solution (int[][] board, int[] moves){
        String answer = "";
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(3);
        que.add(4);
        System.out.println(que);
        System.out.println(que.peek());
        return answer;
    }

}
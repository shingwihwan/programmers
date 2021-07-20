import java.util.HashMap;

public class completion {

    static String gacha;
    public static void main(String[] args) {
        //참가자 = participant, 완주자 = completion
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};

        HashMap<String, Integer> maps = new HashMap<>();

        //참가자가 완주자보다 항상 1이 많으므로 완주자를 HashMap에 put하기
        for(int i = 0; i < completion.length; i++){
            maps.put(completion[i], i);
        }

        //참가자 한명씩 대조해 보기
        for(int i = 0; i < participant.length; i++){
            //만약 키가 없을 시 false일 때
            if(!maps.containsKey(participant[i])){
                gacha = participant[i];
            }
        }
        System.out.println(gacha);
    }
    
}

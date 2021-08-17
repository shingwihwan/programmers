class RecommendNewId {
    
    // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
    //  만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

    public static void main(String[] args) {
        String new_id = "...!@BaT#*.. y.abcdefghijklm";
        String RecommendId = "";
        final int FIX_STR_LENGTH = 15;

        // Step1 모든 대문자를 소문자로 치환
        RecommendId = new_id.toLowerCase();
        System.out.println("step1 : " + RecommendId);  

        // Step2 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표 제외 모든 문자 제거
        // 이런식으로 해결하게 되면 중간에 빈 문자열이 있을때 공백없이 해결해버려서 문제의 요지를 벗어나는 것 같다. 다른 해결방법을 찾아야할듯.
        String id = "";
        for(int i = 0; i < RecommendId.length(); i++){
            char ch = RecommendId.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                id += String.valueOf(ch);
            } else if (ch >= '0'  && ch <= '9'){
                id += String.valueOf(ch);
            } else if (ch == '.' || ch == '_' || ch == '-'){
                id += String.valueOf(ch);
            }
        }
        RecommendId = id;

        System.out.println("step2 : " + RecommendId);

        // Step3 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        RecommendId = RecommendId.replace("..", ".");
        while(RecommendId.contains("..")){
            RecommendId = RecommendId.replace("..", ".");
        }
        System.out.println("step3 : " + RecommendId);

        // Step4 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        // 끝자리에 "."가 왔을때의 index 번호와 추천 아이디의 길이가 같거나 첫자리에 "."가 왔을때
        if(RecommendId.indexOf(".") == 0){
            RecommendId = RecommendId.substring(1, RecommendId.length());
        } else if(RecommendId.lastIndexOf(".") == RecommendId.length() - 1) {
            RecommendId = RecommendId.substring(0, RecommendId.length() - 1);
        }

        // Step5 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        // 문제를 잘못 이해했나보다. 중간에 공백이 발생했을때 a를 넣는 것이 아니라..빈 문자열이면..
        // String test = RecommendId.replaceAll(" ", "a");
        // System.out.println("step5 : " + test);
        if(RecommendId.equals("")){
            RecommendId = "a";
        }

        // Step6 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        int len = RecommendId.length();
        if(len > FIX_STR_LENGTH){
            RecommendId = RecommendId.substring(0, FIX_STR_LENGTH);
            System.out.println("step6 : " + RecommendId);
            System.out.println(RecommendId.length());
            System.out.println(RecommendId.substring(0, RecommendId.length()));
            System.out.println(RecommendId.charAt(RecommendId.length() - 1));
            if(RecommendId.substring(RecommendId.length() - 1).equals(".")){
                RecommendId = RecommendId.substring(0 , RecommendId.length() - 1);
            }
        }

        // Step7 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        // 내가 푼것..틀린식. 왜 틀렸는지 생각.
        // if(RecommendId.length() <= 2){
        //     String lastChar = RecommendId.substring(RecommendId.length() - 1);
        //     while(RecommendId.length() == 3){
        //         RecommendId.concat(lastChar);
        //     }
        // }

        if(RecommendId.length() <= 2){
            while (RecommendId.length() < 3){
                RecommendId += RecommendId.charAt(RecommendId.length() - 1);
            }
        }



        // 정규표현식으로 다른 분들이 한 것 첨부.
        String answer = new_id.toLowerCase(); // 1단계

        answer = answer.replaceAll("[^-_.a-z0-9]", ""); // 2단계
        answer = answer.replaceAll("[.]{2,}", "."); // 3단계
        answer = answer.replaceAll("^[.]|[.]$", "");    // 4단계
        
        if (answer.equals("")) {    // 5단계
            answer += "a";
        }

        if (answer.length() >= 16) {     // 6단계
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$","");
        }

        if (answer.length() <= 2) {  // 7단계
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length()-1);
            }
        }
    }
    
}
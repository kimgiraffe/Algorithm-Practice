class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String tree : skill_trees) {
            String prev = tree.replaceAll("[^" + skill + "]",""); // 선행 스킬만 남기기
            if(skill.indexOf(prev) == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
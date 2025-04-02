class Solution {
    public int solution(String skill, String[] skill_trees) {
        int l = skill.length();
        int answer = 0;
        for(String s : skill_trees){
            String s2 = s.replaceAll("[^"+skill+"]", "");
            if(skill.startsWith(s2)) answer++;
        }
        return answer;
    }
}
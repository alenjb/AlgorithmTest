class Solution {
    static boolean [] visited;
    static int result= Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        int len = words.length;
        visited = new boolean[len];
        
        DFS(begin, target, 0, words);
        if(result== Integer.MAX_VALUE) result = 0; 
        return result;
    }
    static void DFS(String begin, String target, int cnt, String[] words){
        if(begin.equals(target)){
            result = Math.min(result, cnt);
            return;
        }
        
        for(int i=0; i<words.length; i++){
            String nowWord = words[i];
            if(!nowWord.equals(begin) && !visited[i]){
                int notSame = 0;
                for(int j=0; j<words[i].length(); j++){
                    if(begin.charAt(j)!= nowWord.charAt(j)) notSame++;
                }
                if(notSame == 1){
                    visited[i] = true;
                    DFS(nowWord, target, cnt+1, words);
                    visited[i] = false;
                }
            }
        }
    }
}
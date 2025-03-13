class Solution {
    public int solution(int n, int w, int ans) {
        int answer = 0;
        int height = n % w == 0 ? n/w : n/w + 1;
        int [][] arr = new int[height][w];
        int num = 1;
        
        for(int i=0; i<height; i++){
            if(i % 2 ==0){ //짝수는 오른쪿
                for(int j=0; j<w; j++){
                    arr[i][j] = num;
                    num++;
                    if(num >n) break;
                }                
            }
            else { // 홀수는 왼쪽
                for(int j=w-1; j>=0; j--){
                    arr[i][j] = num;
                    num++;
                    if(num >n) break;
                }      
            }
        }
        
        for(int i=0; i<height; i++){
            for(int j=0; j<w; j++){
                if(arr[i][j] == ans){
                    if(arr[height-1][j] == 0) return height - 1 - i;
                    else return height - i; 
                }
            }
        }
        return 0;
    }
}
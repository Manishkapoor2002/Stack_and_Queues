package day23;
public class maximumPointsYouObtain {

    public static int maxScore(int[] cardPoints, int k) {
        int l = 0,r=(cardPoints.length-k);
        int total = 0;
        for (int i = r;i<cardPoints.length;i++){
            total += cardPoints[i];
        }

        int max = total;

        while (r<cardPoints.length){
            total = (total - cardPoints[r] + cardPoints[l]);
            max = Math.max(max,total);
            r++;
            l++;
        }

        return max;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,1};
        int k = 3;
        int ans = maxScore(arr,k);
        System.out.println(ans);
    }
}

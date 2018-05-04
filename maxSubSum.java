public class maxSubSum1{
    /**
     * 求三个数中的最大值
     **/
    private static int max3(int a,int b,int c){
        int max = a;
        if(max<b)
            max = b;
        if(max<c)
            max = c;
        return max;
    }
    /**
     * 递归求子序列的最大值
     */
    private static int maxSubRec(int[] a,int left,int right){
        //递归基
        if (left == right){
            if(a[left] > 0 )
                return a[left];
            else
                return 0;
        }
        //计算边界
        int center = (left+right)/2;
        int maxLeftSum = maxSubRec(a,left,center);
        int maxRightSum = maxSubRec(a,center+1,right);
        //计算前半部分的最大值
        int maxLeftBorderSum = 0,leftBorderSum = 0;
        for(int i = center;i>=left;i--){
            leftBorderSum += a[i];
            if(leftBorderSum>maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }
        //计算后半部分的最大值
        int maxRightBorderSum = 0, rightBorderSum= 0;
        for(int i = center+1;i<=right;i++){
            rightBorderSum += a[i];
            if(rightBorderSum>maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }
        //返回最大子序列
        return max3(maxLeftSum,maxRightSum,maxLeftBorderSum+maxRightBorderSum);
    }

    public static int maxSubSum(int[] a){
        return maxSubRec(a,0,a.length -1);
    }

    public static void main(String[] args){
        int[] arrgy = {4,-3,5,-2,-1,2,6,-2};
        int max = maxSubSum(arrgy);
        System.out.print(max);
    }
}

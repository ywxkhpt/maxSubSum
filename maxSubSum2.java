class maxSubSum2{
	public static int maxSubSum(int[] a){
		int maxSum = 0,thisSum = 0;
		for(int i=0;i<a.length;i++){
			thisSum += a[i];
			if(thisSum>maxSum)
				maxSum = thisSum;
			else if(thisSum<0)
				maxSum = thisSum;
		}
		return maxSum;
	}
	
	public static void main(String[] args){
		int[] a = {4,-3,5,-2,-1,2,6,-2};
		int max = maxSubSum(a);
		System.out.print(max);
	}
}

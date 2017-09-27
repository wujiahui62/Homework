public class groupMedian {
	public static double calMean(double[] lowerBound, double[] upperBound, double[] frequency){
		int len = lowerBound.length; 
		double[] x = new double[len];
		double[] fx = new double[len]; //fx is the product of frequency and x
		int n = 0; //total frequency
		int sumOfFx = 0;
		for(int i = 0; i < lowerBound.length; i++){
			x[i] = (lowerBound[i] + upperBound[i]) / 2;
			fx[i] = x[i] * frequency[i];
			sumOfFx += fx[i];
			n += frequency[i];
		}
		return sumOfFx * 1.0 / n;
	}
	
	public static double calMedian(double[] lowerBound, double[] upperBound, double[] frequency){
		int len = lowerBound.length; 
		double[] x = new double[len];	//average of lower and upper bound
		double[] fx = new double[len]; //fx is the product of frequency and x
		int n = 0; //total frequency
		double[] cumFre = new double[len]; //cumulative fre
		for(int i = 0; i < len; i++){
			x[i] = (lowerBound[i] + upperBound[i]) / 2;
			fx[i] = x[i] * frequency[i];
			n += frequency[i];
			cumFre[i] = frequency[i];
		}
		for(int i = 1; i < len; i++){
			cumFre[i] += cumFre[i - 1];
		}
		double middle = n / 2;
		int middleClass = 0;
		while(middle < cumFre[middleClass]){
			middleClass++;
		}
		middleClass++;
		double F = cumFre[middleClass - 1];
		double fm = frequency[middleClass];
		double Lm = (lowerBound[middleClass] + upperBound[middleClass - 1]) * 1.0 / 2;
		double i = upperBound[middleClass] - lowerBound[middleClass];
		double median = Lm + (n / 2 - F) * i / fm;
		return median;
	}
	
	public static double calVariance(double[] lowerBound, double[] upperBound, double[] frequency){
		int len = lowerBound.length; 
		double[] x = new double[len];
		double[] fx = new double[len]; //fx is the product of frequency and x
		double[] fx2 = new double[len];
		int n = 0; //total frequency
		double sumFx = 0; double sumFx2 = 0;
		for(int i = 0; i < lowerBound.length; i++){
			x[i] = (lowerBound[i] + upperBound[i]) / 2;
			fx[i] = x[i] * frequency[i];
			fx2[i] = x[i] *fx[i];
			n += frequency[i];
			sumFx += fx[i];
			sumFx2 += fx2[i];
		}
		double variance = (sumFx2 - (sumFx * sumFx) / n) / (n - 1);
		return variance;
	}
	
	public static double calSTD(double variance){
		return Math.sqrt(variance);
	}
	
	public static void main(String[] args) {
		//input for age
		double[] LowerBound = {30, 40, 50, 60, 70};
		double[] upperBound = {30, 40, 50, 60, 70};
		double[] fre = {5350, 6038, 3973, 2226 ,897};
		
		//input for yearlyIncome
//		double[] LowerBound = {0, 0.2, 0.4, 0.6, 0.8};
//		double[] upperBound = {0.2, 0.4, 0.6, 0.8, 1};
//		double[] fre = {7956, 6146, 2755, 1318, 309};

		System.out.println("For Age:");
		System.out.println("Mean is " + calMean(LowerBound, upperBound, fre));
		System.out.println("Median is " + calMedian(LowerBound, upperBound, fre));
		System.out.println("Variance is " + calVariance(LowerBound, upperBound, fre));
		System.out.println("Standand is " + calSTD(calVariance(LowerBound, upperBound, fre)));
	}

}

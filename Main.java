package sawr;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

//Syed Hussain
public class Main {

	public static CopyOnWriteArrayList<Double> rSquaredSum; 
	public static AtomicInteger N_SAW_TOT; 
	static double sumOfAverages; 
	static double rsqavg;

	public static void main(String[] args) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		boolean br = true;

		while (br) {
		System.out.println("Please enter d for dimension or p for polygon");
		String choice = input.next();
		
			if (choice.equalsIgnoreCase("d")) {
				System.out.println("Please enter 2 for 2D, 3 for 3D or 4 for 4D");
				int dimension = input.nextInt();
				System.out.println("n\tR^2\t\t\t\tF_SAW");
				
					if (dimension == 2) {
						Thread arrThreads2D[] = new Thread[Globals.N_T];
			
						for (int n = 10; n <= Globals.max_steps; n++) {
		
							rSquaredSum = new CopyOnWriteArrayList<Double>();
							N_SAW_TOT = new AtomicInteger();
							sumOfAverages = 0;
							
							for (int i=0; i<Globals.N_T; i++) {
								Thread t1 = new Thread(new Dimensions(dimension, n));
								t1.start();
								arrThreads2D[i] = t1;
							}
							for (int i = 0; i < Globals.N_T; i++) {
								arrThreads2D[i].join();
							}
							print(n);
						}
					}
					else if (dimension == 3) {
						Thread arrThreads3D[] = new Thread[Globals.N_T];
			
						for (int n = 10; n <= Globals.max_steps; n++) {
							rSquaredSum = new CopyOnWriteArrayList<Double>();
							N_SAW_TOT = new AtomicInteger();
							sumOfAverages = 0;
							
							for (int i=0; i<Globals.N_T; i++) {
								Thread t1 = new Thread(new Dimensions(dimension, n));
								t1.start();
								arrThreads3D[i] = t1;
							}
							for (int i = 0; i < Globals.N_T; i++) {
								arrThreads3D[i].join();
							}
							print(n);
						}
					}
					else if (dimension == 4) {
						Thread arrThreads4D[] = new Thread[Globals.N_T];
						
						for (int n = 10; n <= Globals.max_steps; n++) {
							rSquaredSum = new CopyOnWriteArrayList<Double>();
							N_SAW_TOT = new AtomicInteger();
							sumOfAverages = 0;
							
							for (int i=0; i<Globals.N_T; i++) {
								Thread t1 = new Thread(new Dimensions(dimension, n));
								t1.start();
								arrThreads4D[i] = t1;
							}
							for (int i = 0; i < Globals.N_T; i++) {
								arrThreads4D[i].join();
							}
							print(n);
						}
					}
			}
			else if (choice.equalsIgnoreCase("p")) {
				System.out.println("Please enter 2 for 2D Polygon, 3 for 3D Polygon or 4 for 4D Polygon");
				int dimension = input.nextInt();
				System.out.println("n\tF_SAW");
				
					if (dimension == 2) {
						Thread arrThreads5D[] = new Thread[Globals.N_T];
						
						for (int n = 2; n <= Globals.max_steps; ) {
							N_SAW_TOT = new AtomicInteger();
							sumOfAverages = 0;
							
							for (int i=0; i<Globals.N_T; i++) {
								Thread t1 = new Thread(new Polygon(dimension, n));
								t1.start();
								arrThreads5D[i] = t1;
							}
							for (int i = 0; i < Globals.N_T; i++) {
								arrThreads5D[i].join();
							}
							printPoly(n);
							n +=2;
						}
					}
					else if (dimension == 3) {
						Thread arrThreads5D[] = new Thread[Globals.N_T];
						
						for (int n = 2; n <= Globals.max_steps; ) {
							N_SAW_TOT = new AtomicInteger();
							sumOfAverages = 0;
							
							for (int i=0; i<Globals.N_T; i++) {
								Thread t1 = new Thread(new Polygon(dimension, n));
								t1.start();
								arrThreads5D[i] = t1;
							}
							for (int i = 0; i < Globals.N_T; i++) {
								arrThreads5D[i].join();
							}
							printPoly(n);
							n +=2;
						}
					}
					else if (dimension == 4) {
						Thread arrThreads5D[] = new Thread[Globals.N_T];
						
						for (int n = 2; n <= Globals.max_steps; ) {
							N_SAW_TOT = new AtomicInteger();
							sumOfAverages = 0;
							
							for (int i=0; i<Globals.N_T; i++) {
								Thread t1 = new Thread(new Polygon(dimension, n));
								t1.start();
								arrThreads5D[i] = t1;
							}
							for (int i = 0; i < Globals.N_T; i++) {
								arrThreads5D[i].join();
							}
							printPoly(n);
							n +=2;
						}
					}
			}
			System.out.println("Enter y to continue: ");
			String st = input.next();
			if (!st.equalsIgnoreCase("y")) {
				br = false;
			}
		}
		input.close();
	}

	public static void print(int n) {
		rSquaredSum.forEach(a -> sumOfAverages += a);
		rsqavg = sumOfAverages/ N_SAW_TOT.doubleValue();
		double f_SAW = N_SAW_TOT.doubleValue()/(Globals.N_T * Globals.N_W);
		if (!Double.isNaN(rsqavg)) {	
			System.out.print(n+"\t");
			System.out.print(rsqavg+"\t\t");
			System.out.println(f_SAW);
		}
	}
	
	public static void printPoly(int n) {
		double f_SAW = N_SAW_TOT.doubleValue()/(Globals.N_T * Globals.N_W);	
		System.out.print(n+"\t");
		System.out.println(f_SAW);
	}
}



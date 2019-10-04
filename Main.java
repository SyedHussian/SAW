
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

//Syed Hussain
public class Main {

	public static CopyOnWriteArrayList<Double> rSquaredSum; 
	public static AtomicInteger N_SAW_TOT; 
	public static AtomicInteger N_SAP_TOT; 
	static double sumOfAverages; 
	static double rsqavg;

	public static void main(String[] args) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		boolean br = true;

		while (br) {
		System.out.println("Please enter 2 for 2D, 3 for 3D, 4 for 4D and 5 for 2D Polygon");
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
}



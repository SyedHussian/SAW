package sawr;


public class Dimensions implements Runnable {
	
	int steps;
	int dimension;
	
	public Dimensions(int dimension, int steps) {
		this.dimension = dimension;
		this.steps = steps;
	}
	
	public void run() {
		walk(this.dimension);
	}
	
	
	public void origin(Path path, int i) {
		if (i == 2) {
			Coordinate c= new Coordinate(0, 0);
			path.addToPath(c);
		}
		else if (i == 3) {
			Coordinate c= new Coordinate(0, 0, 0);
			path.addToPath(c);
		}
		else if (i == 4) {
			Coordinate c= new Coordinate(0, 0, 0, 0);
			path.addToPath(c);
		}
	}
	
	public void walk(int i) {
		int N_SAW=0;
		double sumRsqr=0;
		for (int iwalk=0; iwalk<Globals.N_W; iwalk++) {
			Path path = new Path(this.steps);
			boolean pathInDeadEnd = false;
			boolean stopped = false;
			origin(path, i);
			for (int istep = 1; istep <= this.steps; istep++) {
				if (path.isDeadEnd(i)) {
					pathInDeadEnd = true;
					break;
				}
				boolean added = path.addNext(i);
				if (!added) {
					stopped = true;
					break;
				}
			}
			
			double Rsqr = path.getRSquare(i);
			if(!pathInDeadEnd && !stopped) {
				sumRsqr += Rsqr;
				N_SAW++;
			}
		}		

		Main.rSquaredSum.add(sumRsqr);
		Main.N_SAW_TOT.addAndGet(N_SAW);
	}
}



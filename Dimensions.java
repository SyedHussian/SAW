package sawr;


public class Dimensions implements Runnable {
	
	int steps;
	int dimension;
	
	public Dimensions(int dimension, int steps) {
		this.dimension = dimension;
		this.steps = steps;
	}
	
	public void run() {
		if (dimension == 2) {
			walk2D();
		}
		else if (dimension == 3) {
			walk3D();
		}
		else if (dimension == 4){
			walk4D();
		}
	}
	
	
	public void walk2D() {
		int N_SAW=0;
		double sumRsqr=0;
		for (int iwalk=0; iwalk<Globals.N_W; iwalk++) {
			Path path = new Path(this.steps);
			boolean pathInDeadEnd = false;
			boolean stopped = false;
			Coordinate c= new Coordinate(0, 0);
			path.addToPath(c);
			for (int istep = 1; istep <= this.steps; istep++) {
				if (path.isDeadEnd2D()) {
					pathInDeadEnd = true;
					break;
				}
				boolean added = path.addNext2D();
				if (!added) {
					stopped = true;
					break;
				}
			}
			
			double Rsqr = path.getRSquare2D();
			if(!pathInDeadEnd && !stopped) {
				sumRsqr += Rsqr;
				N_SAW++;
			}
		}		

		Main.rSquaredSum.add(sumRsqr);
		Main.N_SAW_TOT.addAndGet(N_SAW);

	}
	
	public void walk3D() {
		int N_SAW=0;
		double sumRsqr=0;
		for (int iwalk=0; iwalk<Globals.N_W; iwalk++) {
			Path path = new Path(this.steps);
			boolean pathInDeadEnd = false;
			boolean stopped = false;
			Coordinate c= new Coordinate(0, 0, 0);
			path.addToPath(c);
			for (int istep = 1; istep <= this.steps; istep++) {
				if (path.isDeadEnd3D()) {
					pathInDeadEnd = true;
					break;
				}
				boolean added = path.addNext3D();
				if (!added) {
					stopped = true;
					break;
				}
			}
			
			double Rsqr = path.getRSquare3D();
			if(!pathInDeadEnd && !stopped) {
				sumRsqr += Rsqr;
				N_SAW++;
			}
		}		

		Main.rSquaredSum.add(sumRsqr);
		Main.N_SAW_TOT.addAndGet(N_SAW);

	}
	
	
	public void walk4D() {
		int N_SAW=0;
		double sumRsqr=0;
		for (int iwalk=0; iwalk<Globals.N_W; iwalk++) {
			Path path = new Path(this.steps);
			boolean pathInDeadEnd = false;
			boolean stopped = false;
			Coordinate c= new Coordinate(0, 0, 0, 0);
			path.addToPath(c);
			for (int istep = 1; istep <= this.steps; istep++) {
				if (path.isDeadEnd4D()) {
					pathInDeadEnd = true;
					break;
				}
				boolean added = path.addNext4D();
				if (!added) {
					stopped = true;
					break;
				}
			}
			
			double Rsqr = path.getRSquare4D();
			if(!pathInDeadEnd && !stopped) {
				sumRsqr += Rsqr;
				N_SAW++;
			}
		}		

		Main.rSquaredSum.add(sumRsqr);
		Main.N_SAW_TOT.addAndGet(N_SAW);

	}
	
}



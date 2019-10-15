package sawr;

public class Polygon implements Runnable {
	int steps;
	int dimension;
	
	public Polygon(int dimension, int steps) {
		this.dimension = dimension;
		this.steps = steps;
	}
	
	public void run() {
		poly(this.dimension);
	}	
	
	public void polyOrigin(Poly_Path path, int i) {
		if (i == 2) {
			Coordinate c= new Coordinate(0, 0);
			path.addToPathPoly(c);
		}
		else if (i == 3) {
			Coordinate c= new Coordinate(0, 0, 0);
			path.addToPathPoly(c);
		}
		else if (i == 4) {
			Coordinate c= new Coordinate(0, 0, 0, 0);
			path.addToPathPoly(c);
		}
	}
	
	public void poly(int i) {
		int N_SAW=0;
		for (int iwalk=0; iwalk<Globals.N_W; iwalk++) {
			Poly_Path path = new Poly_Path(this.steps);
			boolean pathInDeadEnd = false;
			boolean stopped = false;
			polyOrigin(path, i);
			for (int istep = 1; istep <= this.steps; istep++) {
				if (path.isDeadEndPoly(i)) {
					pathInDeadEnd = true;
					break;
				}
				boolean added = path.addNextPoly(i);
				if (!added) {
					stopped = true;
					break;
				}
			}
			boolean last = path.backToOrigin(i);
			if(!pathInDeadEnd && !stopped && last) {
				N_SAW++;
			}
		}		
		Main.N_SAW_TOT.addAndGet(N_SAW);
	}
}

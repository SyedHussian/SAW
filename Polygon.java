package sawr;

public class Polygon implements Runnable {
	int steps;
	int dimension;
	
	public Polygon(int dimension, int steps) {
		this.dimension = dimension;
		this.steps = steps;
	}
	
	public void run() {
		if (dimension == 2) {
			poly2D();
		}
		else if (dimension == 3) {
			poly3D();
		}
		else if (dimension == 4) {
			poly4D();
		}

	}	
	
	public void poly2D() {
		int N_SAW=0;
		for (int iwalk=0; iwalk<Globals.N_W; iwalk++) {
			Poly_Path path = new Poly_Path(this.steps);
			boolean pathInDeadEnd = false;
			boolean stopped = false;
			Coordinate c= new Coordinate(0, 0);
			path.addToPathPoly(c);
			for (int istep = 1; istep <= this.steps; istep++) {
				if (path.isDeadEnd2DPoly()) {
					pathInDeadEnd = true;
					break;
				}
				boolean added = path.addNext2DPoly();
				if (!added) {
					stopped = true;
					break;
				}
			}
			boolean last = path.backToOrigin2D();
			if(!pathInDeadEnd && !stopped && last) {
				N_SAW++;
			}
		}		
		Main.N_SAW_TOT.addAndGet(N_SAW);
	}
	

	public void poly3D() {
		int N_SAW=0;
		for (int iwalk=0; iwalk<Globals.N_W; iwalk++) {
			Poly_Path path = new Poly_Path(this.steps);
			boolean pathInDeadEnd = false;
			boolean stopped = false;
			Coordinate c= new Coordinate(0, 0, 0);
			path.addToPathPoly(c);
			for (int istep = 1; istep <= this.steps; istep++) {
				if (path.isDeadEnd3DPoly()) {
					pathInDeadEnd = true;
					break;
				}
				boolean added = path.addNext3DPoly();
				if (!added) {
					stopped = true;
					break;
				}
			}
			boolean last = path.backToOrigin3D();
			if(!pathInDeadEnd && !stopped && last) {
				N_SAW++;
			}
		}		
		Main.N_SAW_TOT.addAndGet(N_SAW);
	}
	
	
	public void poly4D() {
		int N_SAW=0;
		for (int iwalk=0; iwalk<Globals.N_W; iwalk++) {
			Poly_Path path = new Poly_Path(this.steps);
			boolean pathInDeadEnd = false;
			boolean stopped = false;
			Coordinate c= new Coordinate(0, 0, 0, 0);
			path.addToPathPoly(c);
			for (int istep = 1; istep <= this.steps; istep++) {
				if (path.isDeadEnd4DPoly()) {
					pathInDeadEnd = true;
					break;
				}
				boolean added = path.addNext4DPoly();
				if (!added) {
					stopped = true;
					break;
				}
			}
			boolean last = path.backToOrigin3D();
			if(!pathInDeadEnd && !stopped && last) {
				N_SAW++;
			}
		}		
		Main.N_SAW_TOT.addAndGet(N_SAW);
	}

}
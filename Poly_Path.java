package sawr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Poly_Path {
	private List<Coordinate> path; // completed steps create one path

	private int size;			// no. of steps needed to complete a path
	private int length;
	
	public Poly_Path(int length) {
		this.path = new ArrayList<Coordinate>(length);
		this.size = 0;
		this.length = length;
	}
	
	public boolean addToPathPoly(Coordinate c) {

		if (this.path.contains(c) && (this.size < this.length-1)) {
			return false;
			}
		this.path.add(c);
		this.size++;
		return true;	
	}
		
	public boolean addNextPoly(int i) {
		Coordinate current = this.path.get(size - 1);
		int rand = ThreadLocalRandom.current().nextInt(i*2);
		int x = current.getX();
		int y = current.getY();
		int z = current.getZ();
		int w = current.getW();
		if (i == 2) {
			if (rand == 0){
				x+=1;				
			}
			else if (rand == 1) {
				x-=1;
			}
			else if (rand == 2) {
				y+=1;
			}
			else if (rand == 3) {
				y-=1;
			}
			Coordinate newCoord = new Coordinate(x, y);
			return this.addToPathPoly(newCoord);
		}
		else if (i == 3) {
			if (rand == 0){
				x+=1;				
			}
			else if (rand == 1) {
				x-=1;
			}
			else if (rand == 2) {
				y+=1;
			}
			else if (rand == 3) {
				y-=1;
			}
			else if (rand == 4) {
				z+=1;
			}
			else if (rand == 5) {
				z-=1;
			}		
			Coordinate newCoord = new Coordinate(x, y, z);
			return this.addToPathPoly(newCoord);
		}
		else {
			if (rand == 0){
				x+=1;				
			}
			else if (rand == 1) {
				x-=1;
			}
			else if (rand == 2) {
				y+=1;
			}
			else if (rand == 3) {
				y-=1;
			}
			else if (rand == 4) {
				z+=1;
			}
			else if (rand == 5) {
				z-=1;
			}
			else if (rand == 6) {
				w+=1;
			}
			else if (rand == 7) {
				w-=1;
			}
			Coordinate newCoord = new Coordinate(x, y, z, w);
			return this.addToPathPoly(newCoord);
		}
	}
	
	public boolean isDeadEndPoly(int i) {
		Coordinate current = this.path.get(size - 1);
		int x = current.getX();
		int y = current.getY();
		int z = current.getZ();
		int w = current.getW();
		
		if (i == 2) {
			if (this.path.contains(new Coordinate(x+1, y)) && 
					this.path.contains(new Coordinate(x-1, y)) &&
					this.path.contains(new Coordinate(x, y+1)) &&
					this.path.contains(new Coordinate(x, y-1))) {
					return true;
				}
				return false;
		}
		else if (i == 3) {
			if (this.path.contains(new Coordinate(x+1, y, z)) && 
					this.path.contains(new Coordinate(x-1, y, z)) &&
					this.path.contains(new Coordinate(x, y+1, z)) &&
					this.path.contains(new Coordinate(x, y-1, z)) &&
					this.path.contains(new Coordinate(x, y, z+1)) &&
					this.path.contains(new Coordinate(x, y, z+1)) ) {
					return true;
				}
				return false;
		}
		else {
			if (this.path.contains(new Coordinate(x+1, y, z, w)) && 
					this.path.contains(new Coordinate(x-1, y, z, w)) &&
					this.path.contains(new Coordinate(x, y+1, z, w)) &&
					this.path.contains(new Coordinate(x, y-1, z, w)) &&
					this.path.contains(new Coordinate(x, y, z+1, w)) &&
					this.path.contains(new Coordinate(x, y, z-1, w)) &&
					this.path.contains(new Coordinate(x, y, z, w+1)) &&
					this.path.contains(new Coordinate(x, y, z, w-1))) {
					return true;
				}
				return false;
		}
	}

	public boolean backToOrigin(int i) {
		Coordinate current = this.path.get(size - 1);
		int x = current.getX();
		int y = current.getY();
		int z = current.getZ();
		int w = current.getW();
		
		if (i == 2) {
			if (x == 0 && y == 0) {
				return true;
			}
			return false;
		}
		else if (i == 3) {
			if (x == 0 && y == 0 && z == 0) {
				return true;
			}
			return false;
		}
		else {
			if (x == 0 && y == 0 && z == 0 && w == 0) {
				return true;
			}
			return false;
		}
	}
}


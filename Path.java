package sawr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;



public class Path {
	private List<Coordinate> path; // completed steps create one path

	private int size;			// no. of steps needed to complete a path
	
	public Path(int length) {
		this.path = new ArrayList<Coordinate>(length);
		this.size = 0;
	}
	
	public boolean addToPath(Coordinate c) {

		boolean added = false;
		if (!this.path.contains(c)) {
			this.path.add(c);
			this.size++;
			added = true;
			}
		return added;	
	}
	
	public boolean addNext(int i) {
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
			return this.addToPath(newCoord);
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
			return this.addToPath(newCoord);
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
			return this.addToPath(newCoord);
		}
	}
		
	public boolean isDeadEnd(int i) {
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
			if	(this.path.contains(new Coordinate(x-1, y, z, w)) &&
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

	public double getRSquare(int i) {
		Coordinate current = this.path.get(size - 1);
		if (i == 2) {
			return Math.pow(current.getX(), 2) + Math.pow(current.getY(), 2);
		}
		else if (i == 3) {
			return Math.pow(current.getX(), 2) + Math.pow(current.getY(), 2) + Math.pow(current.getZ(), 2);
		}
		else {
			return Math.pow(current.getX(), 2) + Math.pow(current.getY(), 2) + Math.pow(current.getZ(), 2) + Math.pow(current.getW(), 2);
		}
	}
}


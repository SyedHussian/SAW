package sawr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;



public class Path {
	private List<Coordinate> path; // completed steps create one path

	private int size;			// no. of steps needed to complete a path
	
	public Path(int length) {
		this.path = Collections.synchronizedList(new ArrayList<Coordinate>(length));
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
		
	
	public boolean addNext2D() {
		Coordinate current = this.path.get(size - 1);
		int rand = ThreadLocalRandom.current().nextInt(4);
		int x = current.getX();
		int y = current.getY();
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
	
	
	public boolean addNext3D() {
		Coordinate current = this.path.get(size - 1);
		int rand = ThreadLocalRandom.current().nextInt(6);
		int x = current.getX();
		int y = current.getY();
		int z = current.getZ();
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
	public boolean addNext4D() {
		Coordinate current = this.path.get(size - 1);
		int rand = ThreadLocalRandom.current().nextInt(8);
		int x = current.getX();
		int y = current.getY();
		int z = current.getZ();
		int w = current.getW();
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
	public boolean isDeadEnd2D() {
		Coordinate current = this.path.get(size - 1);
		int x = current.getX();
		int y = current.getY();
		if (this.path.contains(new Coordinate(x+1, y)) && 
			this.path.contains(new Coordinate(x-1, y)) &&
			this.path.contains(new Coordinate(x, y+1)) &&
			this.path.contains(new Coordinate(x, y-1))) {
			return true;
		}
		return false;
	}
	public boolean isDeadEnd3D() {
		Coordinate current = this.path.get(size - 1);
		int x = current.getX();
		int y = current.getY();
		int z = current.getZ();
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
	public boolean isDeadEnd4D() {
		Coordinate current = this.path.get(size - 1);
		int x = current.getX();
		int y = current.getY();
		int z = current.getZ();
		int w = current.getW();
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

	public double getRSquare2D() {
		Coordinate current = this.path.get(size - 1);
		return Math.pow(current.getX(), 2) + Math.pow(current.getY(), 2);
	}
	public double getRSquare3D() {
		Coordinate current = this.path.get(size - 1);
		return Math.pow(current.getX(), 2) + Math.pow(current.getY(), 2) + Math.pow(current.getZ(), 2);
	}
	public double getRSquare4D() {
		Coordinate current = this.path.get(size - 1);
		return Math.pow(current.getX(), 2) + Math.pow(current.getY(), 2) + Math.pow(current.getZ(), 2) + Math.pow(current.getW(), 2);
	}
}


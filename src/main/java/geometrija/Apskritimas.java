package geometrija;

public class Apskritimas {
	
	protected double x;
	protected double y;
	protected double radius;
	
	public Apskritimas(double x, double y, double radius) {
		
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public Apskritimas(double x_from, double x_till, double y_from, double y_till, double radius_max) {
		
		this.x = x_from + ( x_till - x_from ) * Math.random();
		this.y = y_from + ( y_till - y_from ) * Math.random();
		this.radius = Math.random() * radius_max;	
	}
	
	public double AtstumasNuoCentroIkiKitoCentro( Apskritimas kitas ) {
		
		double atstumas_x = x - kitas.x;
		
		double atstumas_y = y - kitas.y;
		
		return Math.sqrt ( atstumas_x * atstumas_x + atstumas_y * atstumas_y );
		
	}
	
	public Boolean arPersidengia ( Apskritimas kitas ) {
		
		double atstumas = AtstumasNuoCentroIkiKitoCentro( kitas );
		return atstumas < ( radius + kitas.radius );
		
	}
	
	public double getX() {
		
		return x;
	}
	public void setX(double x) {
		
		this.x = x;
	}
	public double getY() {
		
		return y;
	}
	public void setY(double y) {
		
		this.y = y;
	}
	public double getRadius() {
		
		return radius;
	}
	public void setRadius(double radius) {
		
		this.radius = radius;
	}

	@Override
	public String toString() {
		
		return "Apskritimas [x=" + x + ", y=" + y + ", radius=" + radius + "]";
	}
	
}

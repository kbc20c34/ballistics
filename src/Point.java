
public class Point {
	Double x,y,sp,ag;
	// 時間
	Double t = 1.0;
	// 重力加速度
	Double g = 9.8;
	public Point(Double x,Double y,Double sp,Double ag) {
		this.x=x;
		this.y=y;
		this.sp=sp;
		this.ag=ag;
	}
	public void drow(MyFrame2 frame){
		frame.fillOval(60+x-5, 360-y-5, 10, 10);
	}
	public void move() {
		x+=sp*t*Math.cos(Math.toRadians(ag))/30;
		System.out.println(x);
		y+=(sp*t*Math.sin(Math.toRadians(ag))-(0.5*g*t*t))/20;
		System.out.println(y);
		t+=1;
	}
}

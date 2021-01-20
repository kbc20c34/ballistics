import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 教科書が提供するMyFrameを拡張するクラス<br>
 * 追加機能:<br>
 * drawLine 線の描画
 * setColor 既存のsetColorに対するオーバーロード。Colorクラスのインスタンスを引数にとる。
 *
 * @version 1.0
 * @author Yuya Omasa
 *
 */
public class MyFrame2 extends MyFrame {

	public MyFrame2() {
		super();
		setSize(800,600	);
		im=new BufferedImage(800,600, BufferedImage.TYPE_INT_ARGB);
	}

	/**
	 * 線の描画。座標がdouble型で指定された場合のオーバーロード。
	 * @param x1 1点目のx座標
	 * @param y1 1点目のy座標
	 * @param x2 2点目のx座標
	 * @param y2 2点目のy座標
	 */
	public synchronized void drawLine(double x1, double y1, double x2, double y2) {
		drawLine((int) x1, (int) y1, (int) x2, (int) y2);
	}

	/**
	 * 線の描画。
	 * @param x1 1点目のx座標
	 * @param y1 1点目のy座標
	 * @param x2 2点目のx座標
	 * @param y2 2点目のy座標
	 */
	public synchronized void drawLine(int x1,int y1,int x2, int y2) {
		Graphics g=im.getGraphics();
		if (g!=null) {
			g.setColor(col);
			g.drawLine(x1, y1, x2, y2);
		}
		g=getGraphics();
		if (g!=null) {
			g.setColor(col);
			g.drawLine(x1, y1, x2, y2);
		}
	}

	/**
	 * 前景色の設定。引数がColor型であった場合のオーバーロード。
	 * @param c 前景色
	 */
	public void setColor(Color c) {
		col = c;
	}

}

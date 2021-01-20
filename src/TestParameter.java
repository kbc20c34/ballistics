/**/

/**
 * シミュレーションで使用するデータを保持するクラス<br>
 * singletonパターンの設計<br>
 *  使用方法:<br>
 *<pre>
 *  TestParameter param = TestParameter.getInstance();
 * 	for( int i = 0; i &lt; param.size(); i++ ){
 * 		System.out.println(param.getAngle(i));
 * 		System.out.println(param.getSpeed(i));
 * 	}
 *</pre>
 * @version 1.0
 * @author Yuya Omasa
 *
 */
public class TestParameter {

	/** TestParameterのプログラム中唯一のインスタンス */
	private static TestParameter param = new TestParameter();

	/** 各テストの角度 */
	private int angle[] = { 30,  45,  60, 45};

	/** 各テストの射出速度 */
	private int speed[] = {100, 100, 100, 50};

	/**
	 * privateのため、クラスの外ではインスタンス化できない。
	 */
	private TestParameter() {};


	/**
	 * インスタンスの取得
	 * @return TestParameterのインスタンス
	 */
	public static TestParameter getInstance() {
		return param;
	}

	/**
	 * テスト番号(0~n)を指定した初期角度の取得
	 * @param i テスト番号
	 * @return 角度（°）
	 */
	public int getAngle(int i) {
		return angle[i];
	}

	/**
	 * テスト番号(0~n)を指定した初期速度の取得
	 * @param i テスト番号
	 * @return 速度(m/s)
	 */
	public int getSpeed(int i) {
		return speed[i];
	}

	/**
	 * テスト件数の取得
	 * @return 件数
	 */
	public int size() {
		return angle.length;
	}
}

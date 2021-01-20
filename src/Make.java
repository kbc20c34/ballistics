import java.awt.Color;


public class Make extends MyFrame2 {
	public void run(){

		/**singletonパターンを使用
		 * （TestParameterクラスの使用方法参考）*/
		TestParameter param = TestParameter.getInstance();

		Point[] point = new Point[param.size()];

		/**y軸と交わる時の時間を格納する変数*/
		int[] eachMaxTime = new int[param.size()];

		/**グラフのx-y軸を描く*/
		Line line = new Line();
		line.drow(this);



		/**各Point型のインスタンスに数値を入れる*/

		for (int i = 0; i < param.size(); i++){
			point[i] = new Point(0.0, 0.0, (double)param.getSpeed(i), (double)param.getAngle(i));
		}

		/**maxTime：プロットを打つ時間の最大値
		 * time：プロットを打つ時間のカウント*/
		int maxTime = 0;
		int time = 0;

		/**グラフ下の設定表示を描く*/
		for( int i = 0; i < param.size(); i++ ){

			switch (i) {
			case 0:
				setColor(Color.RED);
				break;
			case 1:
				setColor(Color.BLUE);
				break;
			case 2:
				setColor(Color.ORANGE);
				break;
			case 3:
				setColor(Color.MAGENTA);
				break;
			default:
				break;
			}

			drawString((i+1) + " : 仰角＝" + param.getAngle(i)+"度  発射速度＝" + param.getSpeed(i) + "m/s", 60, 400+i*20, 15);
		}

		/**各々の最大時間を計算する
		 * また、一番大きい最大時間をmaxTimeに入れる*/
		for( int j = 0; j < param.size(); j++ ){

			eachMaxTime[j] = (int)(3*param.getSpeed(j)*Math.sin(Math.toRadians(param.getAngle(j)))/9.8);

			if(maxTime<eachMaxTime[j]){
				maxTime = eachMaxTime[j];
			}
		}

		/**enterを押したらスタートする
		 * 押す前には字が書かれている*/
//		int gameState = 0;
//		Scanner scan = new Scanner(System.in);
//
//
//		while(gameState == 0){
//			setColor(Color.BLACK);
//			drawString("「enter」を押すと開始", 100, 200, 45);
//
//			String scan2 = scan.nextLine();
//			if(scan2.equals("/r/n")){
//				gameState++;
//			}
//
//		}


		/**最大時間まで点をプロットする*/
		while (time<maxTime) {

		for( int i = 0; i < param.size(); i++ ){

			System.out.println(param.getAngle(i));
			System.out.println(param.getSpeed(i));

			switch (i) {
			case 0:
				setColor(Color.RED);
				break;
			case 1:
				setColor(Color.BLUE);
				break;
			case 2:
				setColor(Color.ORANGE);
				break;
			case 3:
				setColor(Color.MAGENTA);
				break;
			default:
				break;
			}

			point[i].drow(this);

			if(time<eachMaxTime[i]){
				point[i].move();
			}
		}
		sleep(0.1);
		time+=1;
		}
	}
}

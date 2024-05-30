package Object;

import Management.KomaInformation;

public class Kin extends Koma {

	public Kin(int _y, int _x, KomaInformation komaInfor){
		super(komaInfor);
		id = 4;
		y = _y;
		x = _x;
		firstSecond = komaInfor.getFirstSecond();
		int[] kinMove = {-1,-1,-1,0,-1,1,0,-1,0,1,1,0};
		int[] kinSecondMove = {-1,0,0,-1,0,1,1,-1,1,0,1,1};
		fileNameCollection = komaInfor.getFileNameCollection();
		fileName = fileNameCollection.getKin();
		fileNameSecond = fileNameCollection.getKinSecond();
		move = kinMove;		
		moveSecond = kinSecondMove;

		//現在の動きと駒の画像を設定する
		setNowParameter();
		createKomaB(komaInfor.getMouseAdapter());

	}
}

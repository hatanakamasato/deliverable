package Object;

import Management.KomaInformation;

public class King extends Koma {

	public King(int _y, int _x, KomaInformation komaInfor){
		super(komaInfor);
		id = 1;
		y = _y;
		x = _x;
		firstSecond = komaInfor.getFirstSecond();
		fileNameCollection = komaInfor.getFileNameCollection();
		fileName = fileNameCollection.getKing();
		fileNameSecond = fileNameCollection.getKingSecond();
		int[] kingMove = {-1,-1,-1,0,-1,1,0,-1,0,1,1,-1,1,0,1,1};
		move = kingMove;
		moveSecond = kingMove;
		//現在の動きと駒の画像を設定する
		setNowParameter();
		createKomaB(komaInfor.getMouseAdapter());

	}
}

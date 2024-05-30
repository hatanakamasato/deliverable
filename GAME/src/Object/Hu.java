package Object;

import Management.KomaInformation;

public class Hu extends KomaPromoted{

	public Hu(int _y, int _x, KomaInformation komaInfor){
		super(komaInfor);
		id = 8;
		y = _y;
		x = _x;
		firstSecond = komaInfor.getFirstSecond();
		fileNameCollection = komaInfor.getFileNameCollection();
		fileName = fileNameCollection.getHu();
		fileNameSecond = fileNameCollection.getHuSecond();
		fileNamePromoted = fileNameCollection.getHuPromoted();
		fileNamePromotedSecond = fileNameCollection.getHuPromotedSecond();
		int[] huMove = {-1,0};
	    int[] huSecondMove = {1,0};
    	int[] toMove = {-1,-1,-1,0,-1,1,0,-1,0,1,1,0};
	    int[] toSecondMove = {-1,0,0,-1,0,1,1,-1,1,0,1,1};
		move = huMove;
		moveSecond = huSecondMove;
		movePromoted = toMove;
		movePromotedSecond = toSecondMove;

		//現在の動きと駒の画像を設定する
		setNowParameter();
		createKomaB(komaInfor.getMouseAdapter());

	}
}

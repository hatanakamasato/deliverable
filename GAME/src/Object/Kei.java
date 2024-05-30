package Object;

import Management.KomaInformation;

public class Kei extends KomaPromoted{

	public Kei(int _y, int _x, KomaInformation komaInfor){
		super(komaInfor);
		id = 6;
		y = _y;
		x = _x;
		
		firstSecond = komaInfor.getFirstSecond();
		fileName = fileNameCollection.getKei();
		fileNameSecond = fileNameCollection.getKeiSecond();
		fileNamePromoted = fileNameCollection.getKeiPromoted();
		fileNamePromotedSecond = fileNameCollection.getKeiPromotedSecond();
	    int[] keiMove = {-2,-1,-2,1};
	    int[] keiSecondMove = {2,-1,2,1};
     	int[] narikeiMove = {-1,-1,-1,0,-1,1,0,-1,0,1,1,0};
    	int[] narikeiSecondMove = {-1,0,0,-1,0,1,1,-1,1,0,1,1};		
		move = keiMove;
		moveSecond = keiSecondMove;
		movePromoted = narikeiMove;
		movePromotedSecond = narikeiSecondMove;

		//現在の動きと駒の画像を設定する
		setNowParameter();
		createKomaB(komaInfor.getMouseAdapter());

	}

}
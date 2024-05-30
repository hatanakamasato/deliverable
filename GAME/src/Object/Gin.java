package Object;

import Management.KomaInformation;

public class Gin extends KomaPromoted{

	public Gin(int _y, int _x, KomaInformation komaInfor){
		super(komaInfor);
		id = 5;
		y = _y;
		x = _x;
		firstSecond = komaInfor.getFirstSecond();
		int[] ginMove = {-1,-1,-1,0,-1,1,1,-1,1,1};
		int[] ginSecondMove = {1,-1,1,0,1,1,-1,-1,-1,1};
		int[] nariginMove = {-1,-1,-1,0,-1,1,0,-1,0,1,1,0};
		int[] nariginSecondMove = {-1,0,0,-1,0,1,1,-1,1,0,1,1};
		fileName = fileNameCollection.getGin();
		fileNameSecond = fileNameCollection.getGinSecond();
		fileNamePromoted = fileNameCollection.getGinPromoted();
		fileNamePromotedSecond = fileNameCollection.getGinPromotedSecond();
		move = ginMove;
		moveSecond = ginSecondMove;
		movePromoted = nariginMove;
		movePromotedSecond = nariginSecondMove;

		
		//現在の動きと駒の画像を設定する
		setNowParameter();
		createKomaB(komaInfor.getMouseAdapter());

	}

}

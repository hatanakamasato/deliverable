package Object;

import java.util.ArrayList;
import java.util.List;

import Management.KomaInformation;

public class Kyou extends KomaPromoted{
	int[] kyouMove = {-1,0,-2,0,-3,0,-4,0,-5,0,-6,0,-7,0,-8,0};
	int[] kyouSecondMove = {1,0,2,0,3,0,4,0,5,0,6,0,7,0,8,0};
	int[] narikyouMove = {-1,-1,-1,0,-1,1,0,-1,0,1,1,0};
	int[] narikyouSecondMove = {-1,0,0,-1,0,1,1,-1,1,0,1,1};
	public Kyou(int _y, int _x, KomaInformation komaInfor){
		super(komaInfor);
		id = 7;
		y = _y;
		x = _x;
		firstSecond = komaInfor.getFirstSecond();
		fileNameCollection = komaInfor.getFileNameCollection();
		fileName = fileNameCollection.getKyou();
		fileNameSecond = fileNameCollection.getKyouSecond();
		fileNamePromoted = fileNameCollection.getKyouPromoted();
		fileNamePromotedSecond = fileNameCollection.getKyouPromotedSecond();
		move = kyouMove;
		moveSecond = kyouSecondMove;
		movePromoted = narikyouMove;
		movePromotedSecond = narikyouSecondMove;

		//現在の動きと駒の画像を設定する
		setNowParameter();
		createKomaB(komaInfor.getMouseAdapter());
	}
	
	public List<Integer> showGotoBtn(Koma[][] field) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < nowMove.length; i+=2) {
			int gotoY = nowMove[i] + y;
			int gotoX = nowMove[i + 1] + x;

			int isGotoNum = isNumGotoExist(field, gotoY ,gotoX);
			if(isGotoNum == 0 || isGotoNum == 1) {
				list.add(gotoY);
				list.add(gotoX);
			}
			if(isGotoNum == 1 || isGotoNum == 2) {
				return list;
			}
		}
		return list;
	}

	public int isNumGotoExist(Koma[][] field, int gotoY, int gotoX) {
		//範囲外なら終了
		if(gotoY < 0 || gotoY > maxMasu - 1 || gotoX < 0 || gotoX > maxMasu - 1) {
			return 2;
		}
		//座標を追加
		if(field[gotoY][gotoX] == null) {
			return 0;
		}
		//相手の駒なら座標を追加して終了
		if(firstSecond != field[gotoY][gotoX].getFirstSecond()) {
			return 1;
		}
		//もし自分の駒なら終了
		if(firstSecond == field[gotoY][gotoX].getFirstSecond()) {
			return 2;
		}
		//エラー
		return 999;
	}
	
}

package Object;

import java.util.ArrayList;
import java.util.List;

import Management.KomaInformation;

public class Hisya extends KomaPromoted{

	public Hisya(int _y, int _x, KomaInformation komaInfor){
		super(komaInfor);
		id = 2;
		y = _y;
		x = _x;
		firstSecond = komaInfor.getFirstSecond();
		fileNameCollection = komaInfor.getFileNameCollection();
		fileName = fileNameCollection.getHisya();
		fileNameSecond = fileNameCollection.getHisyaSecond();
		fileNamePromoted = fileNameCollection.getHisyaPromoted();
		fileNamePromotedSecond = fileNameCollection.getHisyaPromotedSecond();
		int[] hisyaMove = {-1,0,-2,0,-3,0,-4,0,-5,0,-6,0,-7,0,-8,0,
				0,1,0,2,0,3,0,4,0,5,0,6,0,7,0,8,
				1,0,2,0,3,0,4,0,5,0,6,0,7,0,8,0,
				0,-1,0,-2,0,-3,0,-4,0,-5,0,-6,0,-7,0,-8};
		int[] ryuuMove = {-1,0,-2,0,-3,0,-4,0,-5,0,-6,0,-7,0,-8,0,
				0,1,0,2,0,3,0,4,0,5,0,6,0,7,0,8,
				1,0,2,0,3,0,4,0,5,0,6,0,7,0,8,0,
				0,-1,0,-2,0,-3,0,-4,0,-5,0,-6,0,-7,0,-8,
				-1,-1,-1,1,1,1,1,-1};
		move = hisyaMove;
		moveSecond = hisyaMove;
		movePromoted = ryuuMove;
		movePromotedSecond = ryuuMove;
		
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
			    if(i < 64) {
				    if(i > 47) {
						i = 62;
				     }else if(i > 31) {
					   	i = 46;
				    }else if(i > 15) {
			     		i = 30;
			      	}else {
			    		i = 14;
			      	}
				}
			}
		}
		return list;
	}

	public int isNumGotoExist(Koma[][] field, int gotoY, int gotoX) {
		//範囲外なら次の直線に遷移
		if(gotoY < 0 || gotoY > maxMasu - 1 || gotoX < 0 || gotoX > maxMasu - 1) {
			return 2;
		}
		//座標を追加
		if(field[gotoY][gotoX] == null) {
			return 0;
		}
		//相手の駒なら座標を追加して次の直線に遷移
		if(firstSecond != field[gotoY][gotoX].getFirstSecond()) {
			return 1;
		}
		//もし自分の駒なら次の直線に遷移
		if(firstSecond == field[gotoY][gotoX].getFirstSecond()) {
			return 2;
		}
		//エラー
		return 999;
	}

	
	
	
}

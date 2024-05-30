package Management;

import java.awt.event.MouseAdapter;

import Controller.PlayViewCont;
import Datacollection.FileNameCollection5_5;
import Datacollection.ParameterCollection5_5;
import Object.Gin;
import Object.Hisya;
import Object.Hu;
import Object.Kaku;
import Object.Kin;
import Object.King;
import Object.Koma;
import View.PlayView5_5;

public class BoardInformation5_5 extends BaseBoardInformation{
	FileNameCollection5_5 fileCollection5_5 = new FileNameCollection5_5();
	public BoardInformation5_5(PlayView5_5 _playview) {
		//駒の種類（王を除く）, 縦のマスの数
		super(5, 5, 1);
		playview = _playview;
		cont = new PlayViewCont(this);
		backMouseAdapter = cont.OnBtnBack();
		parameterCollection = new ParameterCollection5_5();
		holdinfor = new HoldingInformation5_5(cont, typeCnt, masuCntY);
		field = new Koma[masuCntY][masuCntY];
		MouseAdapter mouseAdapter = cont.OnBtnGoto();
		komaInforFirst = new KomaInformation(mouseAdapter, fileCollection5_5, parameterCollection, true);
		komaInforSecond = new KomaInformation(mouseAdapter, fileCollection5_5, parameterCollection, false);
		field[4][0] = new King(4, 0, komaInforFirst);
		field[4][1] = new Kin(4, 1, komaInforFirst);
		field[4][2] = new Gin(4, 2, komaInforFirst);
		field[4][3] = new Kaku(4, 3, komaInforFirst);
		field[4][4] = new Hisya(4, 4, komaInforFirst);
		field[3][0] = new Hu(3, 0, komaInforFirst);		
		
		field[0][4] = new King(0, 4, komaInforSecond);
		field[0][3] = new Kin(0, 3, komaInforSecond);
		field[0][2] = new Gin(0, 2, komaInforSecond);
		field[0][1] = new Kaku(0, 1, komaInforSecond);
		field[0][0] = new Hisya(0, 0, komaInforSecond);
		field[1][4] = new Hu(1, 4, komaInforSecond);

	}

	
}
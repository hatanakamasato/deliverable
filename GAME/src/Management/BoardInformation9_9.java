package Management;

import java.awt.event.MouseAdapter;

import Controller.PlayViewCont;
import Datacollection.FileNameCollection9_9;
import Datacollection.ParameterCollection9_9;
import Object.Gin;
import Object.Hisya;
import Object.Hu;
import Object.Kaku;
import Object.Kei;
import Object.Kin;
import Object.King;
import Object.Koma;
import Object.Kyou;
import View.PlayView9_9;

public class BoardInformation9_9 extends BaseBoardInformation{
	FileNameCollection9_9 fileCollection9_9 = new FileNameCollection9_9();

	public BoardInformation9_9(PlayView9_9 _playview) {
		super(7, 9, 3);
		playview = _playview;
		cont = new PlayViewCont(this);
		backMouseAdapter = cont.OnBtnBack();
		parameterCollection = new ParameterCollection9_9();
		holdinfor = new HoldingInformation9_9(cont, typeCnt, masuCntY);
		field = new Koma[masuCntY][masuCntY];
		MouseAdapter mouseAdapter = cont.OnBtnGoto();
		komaInforFirst = new KomaInformation(mouseAdapter, fileCollection9_9, parameterCollection, true);
		komaInforSecond = new KomaInformation(mouseAdapter, fileCollection9_9, parameterCollection, false);
		
		field[6][0] = new Hu(6, 0, komaInforFirst);
		field[6][1] = new Hu(6, 1, komaInforFirst);
		field[6][2] = new Hu(6, 2, komaInforFirst);
		field[6][3] = new Hu(6, 3, komaInforFirst);
		field[6][4] = new Hu(6, 4, komaInforFirst);
		field[6][5] = new Hu(6, 5, komaInforFirst);
		field[6][6] = new Hu(6, 6, komaInforFirst);
		field[6][7] = new Hu(6, 7, komaInforFirst);
		field[6][8] = new Hu(6, 8, komaInforFirst);
		field[7][1] = new Kaku(7, 1, komaInforFirst);
		field[7][7] = new Hisya(7, 7, komaInforFirst);
		field[8][0] = new Kyou(8, 0, komaInforFirst);
		field[8][1] = new Kei(8, 1, komaInforFirst);
		field[8][2] = new Gin(8, 2, komaInforFirst);
		field[8][3] = new Kin(8, 3, komaInforFirst);
		field[8][4] = new King(8, 4, komaInforFirst);
		field[8][5] = new Kin(8, 5, komaInforFirst);
		field[8][6] = new Gin(8, 6, komaInforFirst);
		field[8][7] = new Kei(8, 7, komaInforFirst);
		field[8][8] = new Kyou(8, 8, komaInforFirst);
		
		field[2][0] = new Hu(2, 0, komaInforSecond);
		field[2][1] = new Hu(2, 1, komaInforSecond);
		field[2][2] = new Hu(2, 2, komaInforSecond);
		field[2][3] = new Hu(2, 3, komaInforSecond);
		field[2][4] = new Hu(2, 4, komaInforSecond);
		field[2][5] = new Hu(2, 5, komaInforSecond);
		field[2][6] = new Hu(2, 6, komaInforSecond);
		field[2][7] = new Hu(2, 7, komaInforSecond);
		field[2][8] = new Hu(2, 8, komaInforSecond);
		field[1][1] = new Hisya(1, 1, komaInforSecond);
		field[1][7] = new Kaku(1, 7, komaInforSecond);
		field[0][0] = new Kyou(0, 0, komaInforSecond);
		field[0][1] = new Kei(0, 1, komaInforSecond);
		field[0][2] = new Gin(0, 2, komaInforSecond);
		field[0][3] = new Kin(0, 3, komaInforSecond);
		field[0][4] = new King(0, 4, komaInforSecond);
		field[0][5] = new Kin(0, 5, komaInforSecond);
		field[0][6] = new Gin(0, 6, komaInforSecond);
		field[0][7] = new Kei(0, 7, komaInforSecond);
		field[0][8] = new Kyou(0, 8, komaInforSecond);
		
		
		//field[8][0] = new Hisya(8, 0, komaInforFirst);
		
		
	}
}

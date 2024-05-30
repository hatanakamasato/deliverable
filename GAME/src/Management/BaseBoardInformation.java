package Management;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controller.PlayViewCont;
import Datacollection.BaseParameterCollection;
import Object.Gin;
import Object.Hisya;
import Object.Hu;
import Object.Kaku;
import Object.Kei;
import Object.Kin;
import Object.Koma;
import Object.KomaPromoted;
import Object.Kyou;
import View.BasePlayView;

public abstract class BaseBoardInformation {
	
	protected BasePlayView playview;
	protected PlayViewCont cont;
	protected BaseHoldingInformation holdinfor;
	
	protected BaseParameterCollection parameterCollection;
	
	KomaInformation komaInforFirst;
	KomaInformation komaInforSecond; 
	
	protected Koma[][] field;
	protected boolean nowFirstSecond = true;
	protected int clickedY;
	protected int clickedX;
	protected int clickedHoldLen;
	protected int clickedHoldId;
	protected JButton clickedKomaB;
	protected JButton[] movableSquareArr;
	protected boolean buttonClickedFlg = false;
    protected int typeCnt;
    protected int masuCntY;
    protected int promotedCnt;
    protected MouseAdapter backMouseAdapter;

	public Koma[][] getField() {return field;}
	public JButton[] getHoldInforKomaBtn() {
		return holdinfor.getHoldKomaBtn();
	}
	public JLabel[] getHoldInforKomaLbl() {
		return holdinfor.getHoldKomaLbl();
	}
	public boolean getBtnClickedFlg() {
		return buttonClickedFlg;
	}
	public void setBtnClickedFlgDown() {
		buttonClickedFlg = false;
	}
	public void setBtnClickedFlgPutUp() {
		buttonClickedFlg = true;
	}
	public MouseAdapter getBackMouseAdapter() {
		return backMouseAdapter;
	}
	
	public BaseBoardInformation(int _typeCnt, int _masuCntY, int _promotedCnt){
		typeCnt = _typeCnt;
		masuCntY = _masuCntY;
		promotedCnt = _promotedCnt;
	}
	
	//盤面にある駒をクリック
	public void checkClickedKoma(JButton _clickedKomaB, int y, int x) {
		//クリックした駒は手番か
		if(field[y][x].getFirstSecond() == nowFirstSecond) {
			//ボタンのフラグを揚げる
			buttonClickedFlg = true;
			clickedKomaB = _clickedKomaB;
		    clickedY = y;
		    clickedX = x;
		    List<Integer> list  = field[y][x].showGotoBtn(field);
		    MouseAdapter mouseAdapter = cont.OnBtnMove();
		    createMovableSquare(list, mouseAdapter);
		}
	}
	
	//盤面にある駒を動かす
	public void komaMove(int gotoY, int gotoX) {	
		boolean winFlg = false;
		//移動できるマスのボタンを消す
		movableSquareArrDelete();
		//成れるかどうか
		if(isDoQuestion(field[clickedY][clickedX], gotoY)) {
			KomaPromoted kp = (KomaPromoted)field[clickedY][clickedX];
			//動く場所がない場合成る
			if(isNotBack(kp, gotoY)) {
				kp.promotedKoma();
			}else {
				//はい0　いいえ1
	      	    int result = showYesNoDialog("成りますか?");
	      	    if(result == 0) {
	      	    	kp.promotedKoma();
	      	    }
			}
		}
		//もし移動先に駒があれば
		if(field[gotoY][gotoX] != null) {
			//取った駒が王
			if(field[gotoY][gotoX].getId() == 1) {
				winFlg = true;
			}else {
				field[gotoY][gotoX].getButton().setVisible(false);
			    holdinfor.hold(field[gotoY][gotoX].getId(), nowFirstSecond);
			}
		}
		
		field[gotoY][gotoX] = field[clickedY][clickedX];
 		field[clickedY][clickedX] = null;
 		field[gotoY][gotoX].setPoint(gotoY, gotoX);
 		clickedKomaB.setActionCommand( String.valueOf(gotoY) + String.valueOf(gotoX));
        Point newPosition = new Point(getPointX(field[gotoY][gotoX].getX()),
        		                      getPointY(field[gotoY][gotoX].getY()));
        clickedKomaB.setLocation(newPosition);
		//ボタンのフラグを降ろす
		//buttonClickedFlg = false;
        if(winFlg) {
        	winProcessing();
        }
        nowFirstSecond = !nowFirstSecond;
    }
	
	//持ち駒をクリック
	public void checkClickedHoldKoma(boolean _firstSecond, JButton b) {
		//クリックした持ち駒は手番か
		if(nowFirstSecond == _firstSecond) {
			clickedKomaB = b;
		    String holdName = b.getActionCommand();
		    int id = Integer.parseInt(holdName);
			clickedHoldId = id;
			clickedHoldLen = holdinfor.IDtoLength(id);
			int[] holdKomaCnt = getFirSedHoldKoma();
			//クリックした持ち駒が１以上あるか
			if(holdKomaCnt[clickedHoldLen] > 0) {
				//ボタンのフラグを揚げる
		    	buttonClickedFlg = true;
		    	List<Integer> list  = holdinfor.getHoldListPoint(field, nowFirstSecond, id);
		    	MouseAdapter mouseAdapter = cont.OnBtnHoldMove();			
		    	createMovableSquare(list, mouseAdapter);
			}
		}
	}
	protected int[] getFirSedHoldKoma(){
		if(nowFirstSecond) {
			return holdinfor.getHoldKomaFirstCnt();
		}else {
			return holdinfor.getHoldKomaSecondCnt();
		}
	}
	
	//持ち駒を動かす
	public void holdKomaMove(int gotoY, int gotoX) {
		//移動できるマスのボタンを消す
		movableSquareArrDelete();
		//持ち駒から指した駒をインスタンス化
		Koma koma = setInstancing(clickedHoldId, gotoY, gotoX);
		field[gotoY][gotoX] = koma;
		JButton holdMoveBtn = koma.getButton();
		holdMoveBtn.setActionCommand( String.valueOf(gotoY) + String.valueOf(gotoX));
        Point newPosition = new Point(getPointX(field[gotoY][gotoX].getX()),
        		                      getPointY(field[gotoY][gotoX].getY()));
        holdMoveBtn.setLocation(newPosition);
        //持ち駒の数を減らす
        holdinfor.holdCntReduced(nowFirstSecond, clickedHoldLen);
        //持ち駒から指した駒を表示
        playview.showButton(holdMoveBtn);       
		//ボタンのフラグを降ろす
		//buttonClickedFlg = false;
        nowFirstSecond = !nowFirstSecond;
	}
	
	//移動ボタンを表示する
	public void createMovableSquare(List<Integer> listPoint, MouseAdapter mouseAdapter){
		//もし動けるマスがないならボタンのフラグを降ろす
		if(listPoint.size() == 0) {
			buttonClickedFlg = false;
			return;
		}
	    movableSquareArr = new JButton[listPoint.size() / 2];
		int cnt = 0;
		for(int i = 0; i < listPoint.size(); i+=2){
			JButton buttonGotoMasu = new JButton();
			buttonGotoMasu.setBounds(getPointX(listPoint.get(i + 1)), getPointY(listPoint.get(i)),
					parameterCollection.getButtonHeight(), parameterCollection.getButtonHeight());
			buttonGotoMasu.setText("●");
			buttonGotoMasu.setFont(new Font("Arial", Font.BOLD, 40));
		    buttonGotoMasu.setContentAreaFilled(false);
		    buttonGotoMasu.setBorderPainted(false);
		    buttonGotoMasu.setActionCommand(String.valueOf(listPoint.get(i))
		                                  + String.valueOf(listPoint.get(i + 1)));
		    buttonGotoMasu.addMouseListener(mouseAdapter);
		    movableSquareArr[cnt++] = buttonGotoMasu;
		}
		//戻るボタン追加
		clickedKomaB.addMouseListener(backMouseAdapter);
		playview.showMovableSquare(movableSquareArr);
	}
	
	public void movableSquareArrDelete() {
		for(JButton movableSquare : movableSquareArr) {
			movableSquare.setVisible(false);  
		}
		buttonClickedFlg = false;
		clickedKomaB.removeMouseListener(backMouseAdapter);
	}
	
	protected  boolean isDoQuestion(Koma k, int gotoY) {
		//王の場合成れない
		if(k.getId() == 1) {return false;}
		
		//金の場合成れない
		if(k.getId() == 4) {return false;}
		
		//もともと成っている
		KomaPromoted kp = (KomaPromoted) k;
		if(kp.getIsPromoted()) {return false;}
		
		//敵陣じゃない場合成れない
		if(k.getFirstSecond()) {
			if(clickedY <= promotedCnt - 1) {
				return true;
			}
			if(gotoY <= promotedCnt - 1) {
				return true;
			}
		}else {
			if(clickedY >= masuCntY - promotedCnt) {
				return true;
			}
			if(gotoY >= masuCntY - promotedCnt) {
				return true;
			}
		}
		return false;
	}
	
	protected boolean isNotBack(KomaPromoted kp, int gotoY) {
		//歩と香車の場合
		if(kp.getId() == 8 || kp.getId() == 7) {
			if(isForcingPromotedHuKyou(gotoY)) {
				return true;
			}
		}
		//桂馬の場合
		if(kp.getId() == 6) {
			if(isForcingPromotedKei(gotoY)) {
				return true;
			}
		}
		return false;		
	}
	
	protected boolean isForcingPromotedHuKyou(int gotoY) {
		if(nowFirstSecond) {
			//先手で一番奥のマスの場合
			if(gotoY == 0) {
				return true;
			}
		}else {
			//後手で一番奥のマスの場合
			if(gotoY == masuCntY - 1) {
				return true;
			}
		}
		return false;
	}
	protected boolean isForcingPromotedKei(int gotoY) {
		if(nowFirstSecond) {
			//先手の駒が　Y 0 又は1 に移動しようとしたら
			if(gotoY <= 1) {
				return true;
			}
		}else {
			//後手の駒が　Y 7又は8 に移動しようとしたら
			if(gotoY >= masuCntY - 2) {
				return true;
			}
		}
		return false;
	}
	
	
	protected Koma setInstancing(int id, int gotoY, int gotoX){
		KomaInformation komaInfor;
		if(nowFirstSecond) {
			komaInfor = komaInforFirst;
		}else {
			komaInfor = komaInforSecond;
		}
		switch(id){
		case 2:
			return new Hisya(gotoY, gotoX, komaInfor);
		case 3:
			return new Kaku(gotoY, gotoX, komaInfor);
		case 4:
			return new Kin(gotoY, gotoX, komaInfor);
		case 5:
			return new Gin(gotoY, gotoX, komaInfor);
	    case 6:
			return new Kei(gotoY, gotoX, komaInfor);
		case 7:
			return new Kyou(gotoY, gotoX, komaInfor);
		case 8:
			return new Hu(gotoY, gotoX, komaInfor);
		}
		System.out.println("持ち駒から指した駒がエラー");
		return null;
	}
	protected  void winProcessing() {
    	String firSecStg = nowFirstSecond ? "先手":"後手";
    	int num = showEndDialog(firSecStg + "の勝利です");
    	if(num == 0) {
    		playview.dispose();
    	}
	}
	protected int getPointY(int y) {
		return parameterCollection.getCntPointY() * y + parameterCollection.getSegmentPointY();
	}
	protected int getPointX(int x) {
		return parameterCollection.getCntPointX() * x + parameterCollection.getSegmentPointX();
	}
	protected  int showYesNoDialog(String message) {
		return JOptionPane.showOptionDialog(
				null,
				message,
				"Confirmation",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				new Object[]{"はい", "いいえ"},
				"Yes");
	}
	protected  int showEndDialog(String endmessage) {
		return JOptionPane.showOptionDialog(
				null,
				endmessage,
				"Confirmation",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				new Object[]{"終わる", "終了図に戻る"},
				"Yes");
	}
}
	

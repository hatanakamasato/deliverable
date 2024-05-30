package Management;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import Controller.PlayViewCont;
import Datacollection.BaseFileNameCollection;
import Object.Koma;

public abstract class BaseHoldingInformation {
	protected BaseFileNameCollection fileNameColl;
	protected PlayViewCont cont;
	protected JButton[] holdKomaButton;
	protected JLabel[] holdKomaLabel;
	protected int[] holdKomaFirstCnt;
	protected int[] holdKomaSecondCnt;
	protected int second_label_len;
    protected int typeCnt;
    protected int masuCntY;

	public JButton[] getHoldKomaBtn() {return holdKomaButton;}
	public JLabel[] getHoldKomaLbl() {return holdKomaLabel;}
	public int[] getHoldKomaFirstCnt() {return holdKomaFirstCnt;}
	public int[] getHoldKomaSecondCnt() {return holdKomaSecondCnt;}
	
	public BaseHoldingInformation(int _typeCnt, int _masuCntY) {
		typeCnt = _typeCnt;
		masuCntY = _masuCntY;
		holdKomaButton = new JButton[typeCnt * 2];
		holdKomaLabel = new JLabel[typeCnt * 2];
		holdKomaFirstCnt = new int[typeCnt];
		holdKomaSecondCnt = new int[typeCnt];
	}
	public void hold(int id, boolean nowFirstSecond) {
		int len = IDtoLength(id);
		if(nowFirstSecond) {
			holdKomaFirstCnt[len]++;
			String stgLen = String.valueOf(holdKomaFirstCnt[len]);
			holdKomaLabel[len].setText(stgLen);
		}else {
			holdKomaSecondCnt[len]++;
			String stgLen = String.valueOf(holdKomaSecondCnt[len]);
			holdKomaLabel[len + typeCnt].setText(stgLen);
		}
	}
	
	public List<Integer> getHoldListPoint(Koma[][] field, boolean firstSecond, int id){
		List<Integer> listPoint = new ArrayList<Integer>();
		List<Integer> listNotMoveY  = new ArrayList<Integer>();
		List<Integer> list2HuPointX = new ArrayList<Integer>();
		//歩香車桂馬以外は-1		
		int notBack = isNotBack(id);
		//後ろに下がれない駒が持ち駒から打てない場所をリストに入れる
		if(notBack != -1) {
			listNotMoveY = getNotMoveListY(id, firstSecond);
		}
		//２歩になるx座標をリストに入れる
		if(id == 8) {
			list2HuPointX = get2HuPointX(field, firstSecond);
		}
		
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				boolean flg = true;
				//駒がある場合は指せない
				if(field[i][j] != null) {
					continue;
				}
				//駒を打てないY座標がある場合はfalse
                if(isMoveY(listNotMoveY, i)) {
					flg = false;
				}
                //2歩になるY座標がある場合はfalse
                if(isMove2Hu(list2HuPointX, j)) {
					flg = false;
				}
                if(flg) {
					listPoint.add(i);
					listPoint.add(j);       	
                }
			}
		}
		return listPoint;
	}
	
	protected int isNotBack(int id) {
		//桂馬
		if(id == 6) {
			return 6;
		}
		//香車
		if(id == 7) {
			return 7;
		}
		//歩
		if(id == 8) {
			return 8;
		}
		return -1;
	}
	
	protected List<Integer> getNotMoveListY(int id, boolean firstSecond){
		List<Integer> listNotMoveY  = new ArrayList<Integer>();
		if(firstSecond) {
			listNotMoveY.add(0);
			//桂馬の場合は２マス分置けない
		    if(id == 6) {
			    listNotMoveY.add(1);
		    }
		}else {
			listNotMoveY.add(masuCntY - 1);
		    if(id == 6) {
			    listNotMoveY.add(masuCntY - 2);
		    }
		}
		return listNotMoveY;
	}
	
	protected List<Integer> get2HuPointX(Koma[][] field, boolean firstSecond){
		List<Integer> list2HuPointX = new ArrayList<Integer>();
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				//自分の手番の歩がある場合、そのX座標には置けない
				if(isSameHu(field[i][j], firstSecond)) {
					list2HuPointX.add(j);
				}
			}
		}
		return list2HuPointX;
	}
	
	protected boolean isSameHu(Koma koma, boolean firstSecond) {
		if(koma == null) {
			return false;
		}
		if(koma.getId() != 8) {
			return false;
		}
		if(koma.getFirstSecond() != firstSecond) {
			return false;
		}
		return true;
	}
	
	protected boolean isMoveY(List<Integer> listNotMoveY, int i) {		
		for(int notMoveY : listNotMoveY) {
			if(notMoveY == i) {
				return true;
			}
		}
		return false;
	}
	protected boolean isMove2Hu(List<Integer> list2HuPointX, int j) {		
		for(int huPointX : list2HuPointX) {
			if(huPointX == j) {
				return true;
			}
		}
		return false;
	}

	
	
	public void holdCntReduced(boolean nowFirstSecond, int clickedHoldLen) {
		if(nowFirstSecond) {
			holdKomaFirstCnt[clickedHoldLen]--;
			String stgLen = String.valueOf(holdKomaFirstCnt[clickedHoldLen]);
			holdKomaLabel[clickedHoldLen].setText(stgLen);
		}else {
			holdKomaSecondCnt[clickedHoldLen]--;
			String stgLen = String.valueOf(holdKomaSecondCnt[clickedHoldLen]);
			holdKomaLabel[clickedHoldLen + typeCnt].setText(stgLen);
		}
		
	}

	
	public abstract int IDtoLength(int id);
	
	public abstract int LengthtoID(int holdLen);

	protected abstract int getHoldPointY(int holdCnt, boolean firstSecond);
	
	protected abstract int getHoldPointX(int holdCnt, boolean firstSecond); 	
	
}

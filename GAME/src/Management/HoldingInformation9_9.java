package Management;

import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Controller.PlayViewCont;
import Datacollection.FileNameCollection5_5;

public class HoldingInformation9_9  extends BaseHoldingInformation{
	public HoldingInformation9_9(PlayViewCont _cont, int typeCnt, int masuCntY) {
		super(typeCnt, masuCntY);
		cont = _cont;
		second_label_len = -20;
		fileNameColl = new FileNameCollection5_5();
		String[] holdFileNameArr = {
				fileNameColl.getHisya(), fileNameColl.getKaku(),
				fileNameColl.getKin(),fileNameColl.getGin(),
				fileNameColl.getKei(),fileNameColl.getKyou(),
				fileNameColl.getHu(),
				fileNameColl.getHisyaSecond(), fileNameColl.getKakuSecond(),
				fileNameColl.getKinSecond(),fileNameColl.getGinSecond(),
				fileNameColl.getKeiSecond(),fileNameColl.getKyouSecond(),
				fileNameColl.getHuSecond()};
		int labelPointX = 45;
		int labelPointY = 66;
		int len = 0;
		boolean First0_4Second5_10 = true;
		MouseAdapter mouseAdapter = cont.OnBtnHoldFirst();
		for(int i = 0; i < typeCnt * 2; i++) {
			JButton holdBtn = new JButton();
			JLabel holdLbl = new JLabel();
			int x = getHoldPointX(len, First0_4Second5_10);
			int y = getHoldPointY(len, First0_4Second5_10);
			holdBtn.setBounds(x, y, 100,100);
			holdLbl.setBounds(x + labelPointX, y + labelPointY, 50, 50);
			holdLbl.setText("0");
			ImageIcon imageIcon = new ImageIcon(holdFileNameArr[i]);
			holdBtn.setIcon(imageIcon);
			holdBtn.setContentAreaFilled(false);
			holdBtn.setBorderPainted(false);
			holdBtn.addMouseListener(mouseAdapter);
    		holdBtn.setActionCommand(String.valueOf(LengthtoID(len)));
			holdKomaButton[i] = holdBtn;
			holdKomaLabel[i] = holdLbl;
			len++;
			if(len == typeCnt) {
				len = 0;
				First0_4Second5_10 = !First0_4Second5_10;
				mouseAdapter = cont.OnBtnHoldSecond();
				labelPointY = second_label_len;
			}
		}
	}
	public int IDtoLength(int id) {
		switch(id) {
		case 2:
			return 0;
		case 3:
			return 1;
		case 4:
			return 2;
		case 5:
			return 3;
		case 6:
			return 4;
		case 7:
			return 5;
		case 8:
			return 6;
		}
		//エラー
		System.out.println("持ち駒エラーidtolen");
		return -9999999;
	}
	public int LengthtoID(int holdLen) {
		switch(holdLen) {
		case 0:
			return 2;
		case 1:
			return 3;
		case 2:
			return 4;
		case 3:
			return 5;
		case 4:
			return 6;
		case 5:
			return 7;
		case 6:
			return 8;
		}
		//エラー
		System.out.println("持ち駒エラーlentoid");
		return -9999999;
	}

	protected int getHoldPointY(int holdCnt, boolean firstSecond) {
		if(firstSecond) {
			int pointCntY = holdCnt / 2;
		    return 105 * pointCntY + 190;
		}else {
			int pointCntY = holdCnt / 2;
		    return 105 * pointCntY + 20;
		}
		
	}
	protected int getHoldPointX(int holdCnt, boolean firstSecond) {
		if(firstSecond) {
			return 70 * (holdCnt % 2) + 720;
		}else {
			return 70 * (holdCnt % 2);
		}
		
	}

}

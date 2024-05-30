package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import View.KomaIntroductionView;

public class KomaIntroductionViewCont {
	
	KomaIntroductionView komaIntroView;
	public KomaIntroductionViewCont(KomaIntroductionView komaIntroductionView) {
		komaIntroView = komaIntroductionView;
	}

	public MouseAdapter HoverBtn() {
		
		MouseAdapter e = new MouseAdapter() {
			// マウスが乗ったときの設定
            @Override
            public void mouseEntered(MouseEvent e) {
            	if(!komaIntroView.getBtnRockFlg()) {
            	    JButton btn = (JButton)e.getSource();
            	    komaIntroView.selectKomaBtn(btn);
            	}
            }
             // マウスが外れたとき
            @Override
            public void mouseExited(MouseEvent e) {
            	if(!komaIntroView.getBtnRockFlg()) {
                	JButton btn = (JButton)e.getSource();
                	btn.setBorderPainted(false);
            	}
            }
		};
		return e;
	}
	
	public MouseAdapter OnBtnRock() {
		MouseAdapter e = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				JButton btn = (JButton)e.getSource();
				//ボタンをロックしてない場合
				if(!komaIntroView.getBtnRockFlg()) {
					//ボタンをセレクト
					komaIntroView.selectKomaBtn(btn);
					//ボタンをロックする
					komaIntroView.setBtnRockFlg(true);
					return;
				}
				
				//ボタンをロックしてた場合
				if(komaIntroView.getBtnRockFlg()) {
                    //ロックされているボタンを押したか
					if(komaIntroView.isSelectBtnClicked(btn)) {
						//ロックされているボタンを押した場合を解除
						komaIntroView.setBtnRockFlg(false);
					}else {
						//現在ロックしていたボタンのセレクトを解除
						komaIntroView.deselectSelectKomaBtn();
						//新しいボタンをセレクト
						komaIntroView.selectKomaBtn(btn);
					}
				}
			}
		};
		return e;
	}
	
	public MouseAdapter OnBtnBack() {
		MouseAdapter e = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				komaIntroView.setVisible(false);
			}
		};
		return e;
	}
	
	
	
	
}

package Controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import View.KomaIntroductionView;
import View.PlayView5_5;
import View.PlayView9_9;

public class StartViewCont {
	public MouseAdapter OnBtnShowPlayView5_5() {
		
		MouseAdapter e = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PlayView5_5 form5_5 = new PlayView5_5();
				form5_5.show();
			}
		};
		return e;
	}
	
	public MouseAdapter OnBtnShowPlayView9_9() {
		
		MouseAdapter e = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PlayView9_9 form9_9 = new PlayView9_9();
				form9_9.show();
			}
		};
		return e;
	}
	
	public MouseAdapter OnBtnShowKomaIntroductionView() {
		
		MouseAdapter e = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KomaIntroductionView komaIntroduction = new KomaIntroductionView();
				komaIntroduction.show();
			}
		};
		return e;
	}
	
	
	public MouseAdapter HoverBtn() {
		
		MouseAdapter e = new MouseAdapter() {
			// マウスが乗ったときの背景色を設定
            @Override
            public void mouseEntered(MouseEvent e) {
            	JButton btn = (JButton)e.getSource();
            	btn.setBackground(new Color(10, 10, 10)); 
            }
             // マウスが外れたときの背景色
            @Override
            public void mouseExited(MouseEvent e) {
            	JButton btn = (JButton)e.getSource();
            	btn.setBackground(new Color(100, 100, 100));
            }
		};
		return e;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

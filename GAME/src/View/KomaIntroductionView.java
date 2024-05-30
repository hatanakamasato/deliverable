package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.KomaIntroductionViewCont;
import Datacollection.FileNameCollection5_5;

public class KomaIntroductionView extends JFrame {

	private JPanel contentPane;
	private FileNameCollection5_5 fileName = new FileNameCollection5_5();
	private KomaIntroductionViewCont cont = new KomaIntroductionViewCont(this);
	
	private String[] komaFileName = {"ou.png", "hisya.png", "kaku.png", "kin.png",
			                 "gin.png", "keima.png", "kyousya.png", "hu.png"};
	private JButton[] btnArr = new JButton[8];
	private JLabel lblMove;
	private JLabel lblMainKoma;
	private boolean btnRockFlg = false;
	private int selectBtnNum;
	
	
	public boolean getBtnRockFlg() {
		return btnRockFlg;
	}
	public void setBtnRockFlg(boolean _btnRockFlg) {
		btnRockFlg = _btnRockFlg;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KomaIntroductionView frame = new KomaIntroductionView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KomaIntroductionView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 0, 872, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 838, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("将棋の駒の動き紹介");
		lblNewLabel.setForeground(new Color(247, 190, 72));
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 43));
		lblNewLabel.setBounds(10, 5, 402, 49);
		panel.add(lblNewLabel);
		
		ImageIcon s = new ImageIcon("./picture/komaShoukai/koma/" + komaFileName[0]);
		lblMainKoma = new JLabel(s);
		lblMainKoma.setBounds(90, 121, 257, 242);
		contentPane.add(lblMainKoma);
		
		ImageIcon sho = new ImageIcon("./picture/komaShoukai/" + komaFileName[0]);
		lblMove = new JLabel(sho);
		lblMove.setBounds(461, 152, 320, 195);
		contentPane.add(lblMove);
		
		ImageIcon backIcon = new ImageIcon("./picture/komaShoukai/back.png");
		JButton btnBack = new JButton(backIcon);
		btnBack.setBounds(797, 499, 50, 50);
		btnBack.addMouseListener(cont.OnBtnBack());
		contentPane.add(btnBack);
		/*
		ImageIcon back = new ImageIcon("./picture/komaShoukai/backg.jpg");
		JLabel labelBack = new JLabel(back);
		labelBack.setBounds(0, 0, 300, 300);
		contentPane.setLayout(null);
		contentPane.add(labelBack, 0);
		*/	
		
		String[] fileNameArr = {
				 fileName.getKing(), fileName.getHisya(),
				 fileName.getKaku(), fileName.getKin(),
				 fileName.getGin(),  fileName.getKei(),
				 fileName.getKyou(), fileName.getHu()
				 };
				
		int pointX = 30;
		for(int i = 0; i < fileNameArr.length; i++) {
			ImageIcon imageIcon = new ImageIcon(fileNameArr[i]);
			JButton btn = new JButton(imageIcon);
			btnArr[i] = btn;
			btn.setActionCommand(String.valueOf(i));
			btn.setContentAreaFilled(false);
			btn.setBorderPainted(false);
			btn.setBorder(BorderFactory.createLineBorder(Color.black, 4));
			btn.addMouseListener(cont.HoverBtn());
			btn.addMouseListener(cont.OnBtnRock());
			btn.setBounds(pointX, 400, 75, 90);
			pointX += 105;
			contentPane.add(btn);			
		}
	}
	

	public void selectKomaBtn(JButton btn) {
		btn.setBorderPainted(true);	
	    int id = Integer.parseInt(btn.getActionCommand());
	    selectBtnNum = id;
	    showKomaSetumei(id);
	}
	public void deselectSelectKomaBtn() {
	    btnArr[selectBtnNum].setBorderPainted(false);
	}
	public void showKomaSetumei(int id) {
		ImageIcon icon = new ImageIcon("./picture/komaShoukai/" + komaFileName[id]);
		lblMove.setIcon(icon);
		ImageIcon iconMain = new ImageIcon("./picture/komaShoukai/koma/" + komaFileName[id]);
		lblMainKoma.setIcon(iconMain);
	}
	public boolean isSelectBtnClicked(JButton btn) {
		int id = Integer.parseInt(btn.getActionCommand());
		if(id == selectBtnNum) {
			return true;
		}
		return false;
	}	
}

package View;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Management.BoardInformation9_9;
import Object.Koma;

public class PlayView9_9 extends BasePlayView {

	private JPanel contentPane;
	private BoardInformation9_9 boardinfor = new BoardInformation9_9(this);
	
	public void showMovableSquare(JButton[] movableSquareArr ) {
		for(JButton movableSquare : movableSquareArr) {
		    contentPane.add(movableSquare, 0); 
		}
		setContentPane(contentPane);
	}
	public void showButton(JButton komaButton) {
		contentPane.add(komaButton, 0);  
		setContentPane(contentPane);
	}
	/**
	 * Create the frame.
	 */
	public PlayView9_9() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(160, 0, 910, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		JLabel labelTatami = new JLabel();
		labelTatami.setBounds(0, 0, 1000, 660);
		ImageIcon tatami = new ImageIcon("./picture/tatami3.png");
		contentPane.setLayout(null);
		labelTatami.setIcon(tatami);
		contentPane.add(labelTatami, 0);		
		
		
		JLabel labelField = new JLabel();
		labelField.setBounds(200, 0, 600, 600);
		ImageIcon imageIconsbn = new ImageIcon("./picture/sbn9_9.jpg");
		contentPane.setLayout(null);
		labelField.setIcon(imageIconsbn);
		contentPane.add(labelField, 0);
		

	    Koma[][] field = boardinfor.getField();
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				if(field[i][j] != null) {
					contentPane.add(field[i][j].getButton(), 0);
				}
			}
		}
		JButton[] holdBtnArr = boardinfor.getHoldInforKomaBtn();
		JLabel[] holdLblArr = boardinfor.getHoldInforKomaLbl();
		for(int i = 0; i < holdBtnArr.length; i++) {
			contentPane.add(holdBtnArr[i], 0);
			contentPane.add(holdLblArr[i], 0);
		}
		
		setContentPane(contentPane);
	}
	
}
package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import Controller.StartViewCont;
import Design.RoundedButton;


public class StartView extends JFrame {

	private JPanel contentPane;
	private StartViewCont cont = new StartViewCont();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartView frame = new StartView();
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
	public StartView() {
		setTitle("将棋アプリ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 0, 363, 589);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247, 190, 72));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 0, 0));
		panel.setToolTipText("");
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 64, 0), new Color(128, 64, 0), new Color(128, 64, 0), new Color(128, 64, 0)));
		panel.setBounds(10, 127, 329, 403);
		contentPane.add(panel);
		panel.setLayout(null);
		
		RoundedButton btn5_5 = new RoundedButton("5×5将棋", 20);
		btn5_5.setText("  5×5将棋");
		btn5_5.setVerticalAlignment(SwingConstants.TOP);
		btn5_5.setBounds(90, 43, 156, 50);
		btn5_5.setForeground(new Color(255, 255, 255));
		btn5_5.setBackground(new Color(100, 100, 100));
		btn5_5.setBorderPainted(false);
		btn5_5.addMouseListener(cont.OnBtnShowPlayView5_5());
		btn5_5.addMouseListener(cont.HoverBtn());
		panel.add(btn5_5);
		btn5_5.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		
		RoundedButton btn9_9 = new RoundedButton("9×9将棋", 20);
		btn9_9.setText("  9×9将棋");
		btn9_9.setVerticalAlignment(SwingConstants.TOP);
		btn9_9.setBounds(90, 144, 156, 50);
		btn9_9.setForeground(new Color(255, 255, 255));
		btn9_9.setBackground(new Color(100, 100, 100));
		btn9_9.setBorderPainted(false);
		btn9_9.addMouseListener(cont.OnBtnShowPlayView9_9());
		btn9_9.addMouseListener(cont.HoverBtn());
		panel.add(btn9_9);
		btn9_9.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		
		RoundedButton btnKoma = new RoundedButton("  駒の動き方", 20);
		btnKoma.setText("駒の動き方");
		btnKoma.setVerticalAlignment(SwingConstants.TOP);
		btnKoma.setBounds(90, 244, 156, 50);
		btnKoma.setForeground(new Color(255, 255, 255));
		btnKoma.setBackground(new Color(100, 100, 100));
		btnKoma.setBorderPainted(false);
		btnKoma.addMouseListener(cont.OnBtnShowKomaIntroductionView());
		btnKoma.addMouseListener(cont.HoverBtn());
		panel.add(btnKoma);
		btnKoma.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1 = new JLabel("将棋アプリ");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(90, 36, 172, 41);
		contentPane.add(lblNewLabel_1);
	}
}










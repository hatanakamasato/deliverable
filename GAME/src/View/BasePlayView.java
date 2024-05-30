package View;

import javax.swing.JButton;
import javax.swing.JFrame;

public abstract class BasePlayView extends JFrame {

	public abstract void showMovableSquare(JButton[] movableSquareArr );
	public abstract void showButton(JButton komaButton);

}

package Object;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Datacollection.BaseFileNameCollection;
import Datacollection.BaseParameterCollection;
import Management.KomaInformation;

abstract public class Koma {
	protected BaseFileNameCollection fileNameCollection;
	protected BaseParameterCollection parameterCollection;
	protected int id;
	protected JButton b;
	protected int y;
	protected int x;
	protected int maxMasu;
	protected boolean firstSecond;
	protected String nowFileName;
	protected String fileName;
	protected String fileNameSecond;
	protected int[] nowMove;
	protected int[] move;
	protected int[] moveSecond;
	
	public Koma(KomaInformation komaInfor) {
		fileNameCollection = komaInfor.getFileNameCollection();
		parameterCollection = komaInfor.getPointCollection();
		maxMasu = parameterCollection.getMaxMasu();
	}
	public int getId() {return id;}
	public JButton getButton(){return b;}
	public int getY() {return y;}
	public int getX() {return x;}
	public void setButton(JButton _b) {b = _b;}
	public void setPoint(int y, int x) {
		this.y = y;
		this.x = x;
	}
	public void setNowFileName(String fileName) {nowFileName = fileName;}
	public String getNowFileName() {return nowFileName;}
	public String getFileName() {return fileName;}
	public String getFileNameSecond() {return fileNameSecond;}
	public boolean getFirstSecond() {return firstSecond;}

	
	//最初の現在の駒の状態
	public void setNowParameter() {
		if(firstSecond) {
			nowFileName = fileName;
			nowMove = move;

		}else {
			nowFileName = fileNameSecond;
			nowMove = moveSecond;
		}
	}	
	
	public void createKomaB(MouseAdapter mouseAdapter) {
		b = new JButton();
		b.setBounds(getPointX(x), getPointY(y), 
				parameterCollection.getButtonHeight(), parameterCollection.getButtonHeight());
		ImageIcon imageIcon = new ImageIcon(nowFileName);
		b.setIcon(imageIcon);
		
		//背景を透明化
		b.setContentAreaFilled(false);
		//枠線を消す
		b.setBorderPainted(false);
		b.setActionCommand( String.valueOf(y) + String.valueOf(x));
		b.addMouseListener(mouseAdapter);
		
	}

	
	//駒の移動先のボタンの座標を取得する
	public List<Integer> showGotoBtn(Koma[][] field) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < nowMove.length; i+=2) {
			int gotoY = nowMove[i] + y;
			int gotoX = nowMove[i + 1] + x;
			//盤の範囲内か
			if(gotoY >= 0 && gotoY <= maxMasu - 1 && gotoX >= 0 && gotoX <= maxMasu - 1) {
				//移動先に駒がないか
				if(isGotoExist(field, gotoY ,gotoX)) {
					list.add(gotoY);
					list.add(gotoX);
				}
			}
		}
		return list;
	}
	
	private boolean isGotoExist(Koma[][] field, int gotoY, int gotoX) {
		
		if(field[gotoY][gotoX] == null) {
			return true;
		}
		if(firstSecond ^ field[gotoY][gotoX].getFirstSecond()) {
			return true;
		}
		return false;
	}
	
	protected int getPointY(int y) {
		return parameterCollection.getCntPointY() * y + parameterCollection.getSegmentPointY();
	}
	protected int getPointX(int x) {
		return parameterCollection.getCntPointX() * x + parameterCollection.getSegmentPointX();
	}
	
	
	
}

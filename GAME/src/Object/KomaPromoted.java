package Object;

import javax.swing.ImageIcon;

import Management.KomaInformation;

abstract public class KomaPromoted extends Koma {
	protected boolean isPromoted = false;
	protected String fileNamePromoted;
	protected String fileNamePromotedSecond;
	protected int[] movePromoted;
	protected int[] movePromotedSecond;

	public KomaPromoted(KomaInformation komaInfor) {
		super(komaInfor);
	}

	public boolean getIsPromoted() {return isPromoted;}
	
	//駒の動きを初期化
	public void initializeMove(String moveStg, String moveSecondStg,
			                   String movePromotedStg, String movePromotedSecondStg){
		int moveNum = moveStg.length();
		move = new int[moveNum / 2];
		for(int i = 0, cnt = 0; i < moveNum; i += 2, cnt++) {
			move[cnt] = Integer.parseInt(moveStg.substring(i, i + 2));
		}
		
		int moveSecondNum = moveSecondStg.length();
		moveSecond = new int[moveSecondNum / 2];
		for(int i = 0, cnt = 0; i < moveSecondNum; i += 2, cnt++) {
			moveSecond[cnt] = Integer.parseInt(moveSecondStg.substring(i, i + 2));
		}
		
		int movePromotedNum = movePromotedStg.length();
		movePromoted = new int[movePromotedNum / 2];
		for(int i = 0, cnt = 0; i < movePromotedNum; i += 2, cnt++) {
			movePromoted[cnt] = Integer.parseInt(movePromotedStg.substring(i, i + 2));
		}
		
		int movePromotedSecondNum = movePromotedSecondStg.length();
		movePromotedSecond = new int[movePromotedSecondNum / 2];
		for(int i = 0, cnt = 0; i < movePromotedSecondNum; i += 2, cnt++) {
			movePromotedSecond[cnt] = Integer.parseInt(movePromotedSecondStg.substring(i, i + 2));
		}
	}	
	
	public void promotedKoma() {
		if(firstSecond) {
			nowFileName	= fileNamePromoted;
			nowMove = movePromoted;
		}else {
			nowFileName	= fileNamePromotedSecond;
			nowMove = movePromotedSecond;
		}
		ImageIcon imageIcon = new ImageIcon(nowFileName);
        b.setIcon(imageIcon);
        isPromoted = !isPromoted;
		
	}

	
	
	
	
	
	
	
	
	
	
}

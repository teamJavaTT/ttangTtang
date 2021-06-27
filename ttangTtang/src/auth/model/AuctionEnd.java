package auth.model;

public class AuctionEnd {

	private String ino;
	private int cnt;
	
	public AuctionEnd(String ino, int cnt) {
		
		this.ino = ino;
		this.cnt = cnt;
	}
	
	public String getIno() {
		return ino;
	}
	public int getCnt() {
		return cnt;
	}
}

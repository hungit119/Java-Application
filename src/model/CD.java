package model;

public class CD {
	private int maSoCD;
	private String tuaCD;
	private String caSi;
	private int soBaiHat;
	private float  giaThanh;
	public CD(int maSoCD, String tuaCD, String caSi, int soBaiHat, float giaThanh) {
		super();
		this.maSoCD = maSoCD;
		this.tuaCD = tuaCD;
		this.caSi = caSi;
		this.soBaiHat = soBaiHat;
		this.giaThanh = giaThanh;
	}
	public boolean kiemtra () {
		return true;
	}
	public CD(int maSoCD) {
		super();
		this.maSoCD = maSoCD;
	}
	public CD (){}
	public int getMaSoCD() {
		return maSoCD;
	}
	public void setMaSoCD(int maSoCD) {
		this.maSoCD = maSoCD;
	}
	public String getTuaCD() {
		return tuaCD;
	}
	public void setTuaCD(String tuaCD) {
		this.tuaCD = tuaCD;
	}
	public String getCaSi() {
		return caSi;
	}
	public void setCaSi(String caSi) {
		this.caSi = caSi;
	}
	public int getSoBaiHat() {
		return soBaiHat;
	}
	public void setSoBaiHat(int soBaiHat) {
		this.soBaiHat = soBaiHat;
	}
	public float getGiaThanh() {
		return giaThanh;
	}
	public void setGiaThanh(float giaThanh) {
		this.giaThanh = giaThanh;
	}
	
	public boolean equals(CD cd2) {
		// TODO Auto-generated method stub
		if(this.getMaSoCD() == cd2.getMaSoCD() ) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "CD [Mã số =" + maSoCD + ", Tựa CD =" + tuaCD + ", Ca sĩ =" + caSi + ", Số bài hát =" + soBaiHat + ", Gía Thành ="
				+ giaThanh + "]";
	}
	
}


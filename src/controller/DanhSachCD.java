package controller;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.*;


public class DanhSachCD {
	private ArrayList<CD> listCD ;
	private int tongSoCD = 0;
	private int CDcu = 0;
	
	public DanhSachCD() {
		this.listCD = new ArrayList<CD>();
	}
	
	public void setListCD(ArrayList<CD> listCD ) {
		this.listCD = listCD;
	}
	
	public ArrayList<CD> getListCD() {
		return listCD;
	}
	
	public void addCD(CD cd) {
		this.listCD.add(cd);
		tongSoCD ++;
	}
	public CD getCD (int n) {
		return this.listCD.get(n);
	}
	public void deleteCD (int n) {
		for(int i = 0 ; i < this.listCD.size() ; i ++) {
			if(this.listCD.get(i).getMaSoCD() == n) {
				this.listCD.remove(i);
				tongSoCD --;
			}
		}
	}
	public CD timKiemCD (int n) {
		for(int i = 0 ; i < this.listCD.size(); i ++) {
			if(this.listCD.get(i).getMaSoCD() == n) {
				return this.listCD.get(i);
			}
		}
		return null;
	}
	public void CapNhatThongTinCD(int n, String tuaCD , String caSi , int SoBaiHat,float giaThanh ) {
		for(int i = 0 ; i < this.listCD.size() ; i ++) {
			if(this.listCD.get(i).getMaSoCD() == n) {
				this.listCD.get(i).setTuaCD(tuaCD);
				this.listCD.get(i).setCaSi(caSi);
				this.listCD.get(i).setSoBaiHat(SoBaiHat);
				this.listCD.get(i).setGiaThanh(giaThanh);
			}
		}
	}
	public int tongSoCD () {
		return tongSoCD;
	}
	public void setTongCD (int n) {
		this.tongSoCD = n;
	}

	public int getCDcu() {
		return CDcu;
	}

	public void setCDcu(int cDcu) {
		CDcu = cDcu;
	}
}
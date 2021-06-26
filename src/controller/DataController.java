package controller;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import model.CD;

public class DataController {
	private CD cd;
	private FileWriter fileWriter;
	private PrintWriter printWriter;
	private Scanner scanner;
	private DanhSachCD danhSachCD;
	
	public void ghiDuLieuVaoFile(String filename,CD cd) {
		try {
			fileWriter = new FileWriter(filename,true);
			printWriter = new PrintWriter(fileWriter);
			printWriter.println(cd.getMaSoCD()+"|"+cd.getTuaCD()+"|"+cd.getCaSi()+"|"+cd.getSoBaiHat()+"|"+cd.getGiaThanh());
			printWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public ArrayList<CD> docDuLieuTuFile(String filename){
		try {
			scanner = new Scanner(Paths.get(filename));
		} catch (Exception e) {
			// TODO: handle exception
		}
		ArrayList<CD> Cds = new ArrayList<>();
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				CD cd = creatCDFromFile(line);
				Cds.add(cd);
			}
			scanner.close();
			return Cds;
	}
	private CD creatCDFromFile(String line) {
		// TODO Auto-generated method stub
		String [] datas = line.split("\\|");
		
		//int maSoCD, String tuaCD, String caSi, int soBàiHat, float giaThanh
		
		CD cd = new CD(Integer.parseInt(datas[0]),datas[1],datas[2],Integer.parseInt(datas[3]),Float.parseFloat(datas[4]));
		
		return cd;
	}
}

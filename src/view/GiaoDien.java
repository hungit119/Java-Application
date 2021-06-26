package view;
import model.*;
import controller.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class GiaoDien extends JFrame{
	private File file;
	private String filename = "cd.txt";
	private DataController dataController;
	public DanhSachCD danhSachCD;
	private final int HEIGTH = 650;
	private final int WIDTH = 960;
	
	private JPanel topPanel;
	private JPanel labelPanel;
	private JLabel topLabel;
	private JPanel maSoPanel,tuaDePanel,caSiPanel,soBaiHatPanel,giaThanhPanel,buttonPanel;
	private JLabel lbMasO,lbTuaDe,lbCaSi,lbSoBaiHat,lbGiaThanh;
	private JTextField txtMaSo,txtTuaDe,txtCaSi,txtSoBaiHat,txtGiaThanh;
	private JButton btnThem,btnClear,btnLuu,btnXoa,btnSua,btnTim;
	
	private JPanel belowPanel;
	private JScrollPane scrollPane;
	private JList<String> JlistCD;
	private DefaultListModel<String> Listmodel;
	
	
	public GiaoDien(){
		danhSachCD = new DanhSachCD();
		dataController = new DataController();
		setTitle("Chương trình quản lí CD");
		setSize(WIDTH,HEIGTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		labelPanel = new JPanel();
		topLabel = new JLabel("THÔNG TIN CD");
		labelPanel.add(topLabel);
		
		Listmodel = new DefaultListModel<>();
		buildTopPanel();
		buildBelowPanel();
		
		add(labelPanel,BorderLayout.NORTH);
		add(topPanel,BorderLayout.CENTER);
		add(belowPanel,BorderLayout.SOUTH);
		setVisible(true);
		docDuLieuTuTep();
	}
	private void buildBelowPanel() {
		// TODO Auto-generated method stub
		belowPanel = new JPanel();
		belowPanel.setLayout(new BorderLayout());
		
		JPanel listPanel = new JPanel();
		listPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED, 2), "Danh sách CD"));
		
		JlistCD = new JList<String>(Listmodel);
		JlistCD.setVisibleRowCount(15);
		JlistCD.setFixedCellWidth(930);
		JlistCD.setFixedCellHeight(21);
		JlistCD.addListSelectionListener(new SelectionListListener());
		listPanel.add(JlistCD);

		scrollPane = new JScrollPane(JlistCD);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        listPanel.add(scrollPane);
		belowPanel.add(listPanel,BorderLayout.CENTER);
		
	}
	private void buildTopPanel() {
		// TODO Auto-generated method stub
		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(7,1));
		//
		maSoPanel = new JPanel();
		
		maSoPanel.setLayout(new BorderLayout());
		
		JPanel maSo = new JPanel();
		JPanel txtmS = new JPanel();
		lbMasO = new JLabel("Mã số: ");
		txtMaSo = new JTextField(75);
		
		maSo.add(lbMasO);
		txtmS.add(txtMaSo);
		maSoPanel.add(maSo,BorderLayout.WEST);
		maSoPanel.add(txtmS,BorderLayout.EAST);
		//
		tuaDePanel = new JPanel();

		tuaDePanel.setLayout(new BorderLayout());
		
		JPanel tuaDe = new JPanel();
		JPanel tTuaDe = new JPanel();
		
		lbTuaDe = new JLabel("Tựa đề: ");
		txtTuaDe = new JTextField(75);
		
		tuaDe.add(lbTuaDe);
		tTuaDe.add(txtTuaDe);
		
		tuaDePanel.add(tuaDe,BorderLayout.WEST);
		tuaDePanel.add(tTuaDe,BorderLayout.EAST);
		//
		caSiPanel = new JPanel();
		caSiPanel.setLayout(new BorderLayout());
		
		
		JPanel caSiP = new JPanel();
		JPanel caSiT = new JPanel();
		lbCaSi = new JLabel("Ca sĩ: ");
		txtCaSi = new JTextField(75);
		
		caSiP.add(lbCaSi);
		caSiT.add(txtCaSi);
		
		caSiPanel.add(caSiP,BorderLayout.WEST);
		caSiPanel.add(caSiT,BorderLayout.EAST);
		//
		soBaiHatPanel = new JPanel();
		soBaiHatPanel.setLayout(new BorderLayout());
		
		JPanel soBaiHatP = new JPanel();
		JPanel soBaiHatT = new JPanel();
		
		lbSoBaiHat = new JLabel("Số bài hát: ");
		txtSoBaiHat = new JTextField(75);
		
		soBaiHatP.add(lbSoBaiHat);
		soBaiHatT.add(txtSoBaiHat);
		
		soBaiHatPanel.add(soBaiHatP,BorderLayout.WEST);
		soBaiHatPanel.add(soBaiHatT,BorderLayout.EAST);
		//
		giaThanhPanel = new JPanel();
		giaThanhPanel.setLayout(new BorderLayout());
		
		JPanel giaThanhP = new JPanel();
		JPanel giaThanhT = new JPanel();
		
		lbGiaThanh = new JLabel("Giá thành: ");
		txtGiaThanh = new JTextField(75);
		
		giaThanhP.add(lbGiaThanh);
		giaThanhT.add(txtGiaThanh);
		
		giaThanhPanel.add(giaThanhP,BorderLayout.WEST);
		giaThanhPanel.add(giaThanhT,BorderLayout.EAST);
		//
		buttonPanel = new JPanel();
		
		btnThem = new JButton("Thêm");
		btnClear = new JButton("Clear");
		btnLuu = new JButton("Lưu");
		btnXoa = new JButton("Xóa");
		btnSua = new JButton("Sửa");
		btnTim = new JButton("Tìm");
		
		btnThem.addActionListener(new BtnThem());
		btnClear.addActionListener(new BtnClear());
		btnLuu.addActionListener(new BtnLuu());
		btnXoa.addActionListener(new BtnXoa());
		btnSua.addActionListener(new BtnSua());
		btnTim.addActionListener(new BtnTim());
		
		buttonPanel.add(btnThem);
		buttonPanel.add(btnClear);
		buttonPanel.add(btnLuu);
		buttonPanel.add(btnXoa);
		buttonPanel.add(btnSua);
		buttonPanel.add(btnTim);
		
		
		topPanel.add(maSoPanel);
		topPanel.add(tuaDePanel);
		topPanel.add(caSiPanel);
		topPanel.add(soBaiHatPanel);
		topPanel.add(giaThanhPanel);
		topPanel.add(buttonPanel);
		
	}
	private void docDuLieuTuTep() {
		// TODO Auto-generated method stub
		int count = 0 ;
		JOptionPane.showMessageDialog(null,"Đã đọc file: "+filename+" Thành công !!!");
		danhSachCD.setListCD(dataController.docDuLieuTuFile(filename));
		JlistCD.setModel(Listmodel);
		for (CD cd : danhSachCD.getListCD()) {
			Listmodel.addElement(cd.toString());
			count += 1;
		}
		danhSachCD.setTongCD(count);
		danhSachCD.setCDcu(count);
	}
	public class BtnThem implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			CD cd = new CD();
				if(txtMaSo.getText()==""||txtTuaDe.getText()==""||txtCaSi.getText()==""
						||txtSoBaiHat.getText()==""||txtGiaThanh.getText()==""||
						!isSo(txtSoBaiHat.getText())||!isSo(txtGiaThanh.getText())) {
					JOptionPane.showMessageDialog(null, "Đầu vào không hợp lệ!!");
				}
				else 
				{
				
				cd.setMaSoCD(Integer.parseInt(txtMaSo.getText()));
				cd.setTuaCD(txtTuaDe.getText());
				cd.setCaSi(txtCaSi.getText());
				cd.setSoBaiHat(Integer.parseInt(txtSoBaiHat.getText()));
				cd.setGiaThanh(Float.parseFloat(txtGiaThanh.getText()));
				
					if (danhSachCD.tongSoCD() == 0) {
						danhSachCD.addCD(cd);
						Listmodel.addElement(cd.toString());
					}else {
						boolean a = true;
						for (int i = 0; i < danhSachCD.tongSoCD(); i++) {
							if(danhSachCD.getListCD().get(i).equals(cd)== false) {
								a = false;
							}
						}
						if(a == true) {
							danhSachCD.addCD(cd);
							Listmodel.addElement(cd.toString());
						}else {
							JOptionPane.showMessageDialog(null,"Trùng mã CD!!");
					}
				}
			}
		}
	}
	public boolean isSo(String str) {

		for(int i = 0 ; i < str.length();i++) {
			if(Character.isDigit(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	public class BtnClear implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			txtMaSo.setText("");
			txtTuaDe.setText("");
			txtCaSi.setText("");
			txtSoBaiHat.setText("");
			txtGiaThanh.setText("");
		}
	}
	public class BtnLuu implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int n = danhSachCD.getCDcu();
			for (int i = n; i < danhSachCD.tongSoCD(); i++) {
				dataController.ghiDuLieuVaoFile(filename, danhSachCD.getCD(i));
			}
			JOptionPane.showMessageDialog(null, "Đã lưu thành công!!");
		}
	}
	public class BtnXoa implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Nhập ID CD muốn xóa :"));
			int click = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn xóa CD này ?");
			if(click == JOptionPane.YES_OPTION) {
				danhSachCD.deleteCD(id);
				Listmodel.remove(id-1);
				file = new File(filename);
				file.delete();
				for (int i = 0; i < danhSachCD.tongSoCD(); i++) {
					dataController.ghiDuLieuVaoFile(filename, danhSachCD.getCD(i));
				}
			}
			else if (click == JOptionPane.NO_OPTION){
				System.out.println("Quay lại");
			}
			else if (click == JOptionPane.CANCEL_OPTION) {
				System.out.println("Quay lại");
			}
		}
	}
	public class BtnSua implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean test = false;
			int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Nhập id CD cần sửa:"));
			for (int i = 0; i < danhSachCD.tongSoCD(); i++) {
				if(danhSachCD.getCD(i).getMaSoCD() == id) {
					test = true;
					danhSachCD.getCD(i).setTuaCD(JOptionPane.showInputDialog(null,"Nhập Tựa CD:"));
					danhSachCD.getCD(i).setCaSi(JOptionPane.showInputDialog(null,"Nhập tên ca sĩ CD:"));
					danhSachCD.getCD(i).setSoBaiHat(Integer.parseInt(JOptionPane.showInputDialog(null,"Nhập số bài hát CD:")));
					danhSachCD.getCD(i).setGiaThanh(Float.parseFloat(JOptionPane.showInputDialog(null,"Nhập giá CD:")));
					Listmodel.remove(i);
					Listmodel.add(i, danhSachCD.getCD(i).toString());
					file = new File(filename);
					file = new File(filename);
					file.delete();
						for (int j = 0; j < danhSachCD.tongSoCD(); j++) {
							dataController.ghiDuLieuVaoFile(filename, danhSachCD.getCD(j));
					}
				}
			}
			if(test == false) {
				System.out.println("Id không tồn tại");
			}
		}
	}
	public class BtnTim implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean test = false;
			int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Nhập id CD cần tìm"));
			for(int i = 0 ; i < danhSachCD.tongSoCD(); i ++) {
				if(danhSachCD.getCD(i).getMaSoCD() == id) {
					txtMaSo.setText(Integer.toString(danhSachCD.getCD(i).getMaSoCD()));
					txtTuaDe.setText(danhSachCD.getCD(i).getTuaCD());
					txtCaSi.setText(danhSachCD.getCD(i).getCaSi());
					txtSoBaiHat.setText(Integer.toString(danhSachCD.getCD(i).getSoBaiHat()));
					txtGiaThanh.setText(Float.toString(danhSachCD.getCD(i).getGiaThanh()));
					test = true;
				}
			}
			if(test == false) {
				JOptionPane.showMessageDialog(null, "Không tồn tại CD");
			}
		}
	}
	public class SelectionListListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			int index = JlistCD.getSelectedIndex();
			txtMaSo.setText(Integer.toString(danhSachCD.getCD(index).getMaSoCD()));
			txtTuaDe.setText(danhSachCD.getCD(index).getTuaCD());
			txtCaSi.setText(danhSachCD.getCD(index).getCaSi());
			txtSoBaiHat.setText(Integer.toString(danhSachCD.getCD(index).getSoBaiHat()));
			txtGiaThanh.setText(Float.toString(danhSachCD.getCD(index).getGiaThanh()));
		}	
	}
	public static void main(String[] args) {
		new GiaoDien();

	}
}

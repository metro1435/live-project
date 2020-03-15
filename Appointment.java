package initial_interface;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
//import function.Select_Function1;
import javax.swing.*;

public class Appointment extends Frame {
	// 杩欎釜鐨勮瘽杩樻槸涓�涓狥rame鐨�
	// 杩欏洖杩欎釜鎴戜滑灏变笉鐢ㄧ敾鍥炬潵澶勭悊浜嗭紝鏄惧緱
	Button begin_appointment=new Button("开始预约");
	Button end_appointment=new Button("结束预约");
	Frame frame;
	
	public Appointment(Frame frame) {
		this.frame=frame;
		setTitle("预约管理界面");
		setSize(300, 250);
		setLayout(null);
		setResizable(false);
		setBackground(Color.GRAY);
		
		begin_appointment.setBounds(50, 100, 50, 20);
		begin_appointment.setSize(100, 50);
		
		end_appointment.setBounds(160, 100, 50, 20);
		end_appointment.setSize(100, 50);
		
		add(begin_appointment);
		add(end_appointment);
		
		begin_appointment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowMain.registration.setEnabled(true);
			}
			
		});
		end_appointment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowMain.registration.setEnabled(false);
				
			}
			
		});
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.setEnabled(true);
				dispose();
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
		setAlwaysOnTop(true);
		
	}
}

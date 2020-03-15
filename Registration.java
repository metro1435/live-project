package initial_interface;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
//import function.Select_Function1;
import javax.swing.*;

import com.mysql.cj.xdevapi.ColumnDefinition.StaticColumnDefinition;

public class Registration extends Frame {
	Toolkit tool = getToolkit();
	String url = "registration.jpg";
	Image img = tool.getImage(url);

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0,700,500, this);
	}
	
	Label information=new Label("涓汉淇℃伅",Label.CENTER);
	Label name=new Label("姓名",Label.CENTER);
	Label id=new Label("身份证号码",Label.CENTER);
	Label phone_num=new Label("电话号码",Label.CENTER);
	Label registration_num=new Label("预约口罩数量",Label.CENTER);
	TextField name_field=new TextField(25);
	TextField id_field=new TextField(25);
	TextField phone_num_field=new TextField(25);
	TextField registration_num_field=new TextField(25);
	Button confirm=new Button("确认");
	Frame frame=new Frame();
	
	public Registration(Frame frame) {
		this.frame=frame;
		setTitle("登记界面");
		setSize(700, 500);
		setLayout(null);
		setResizable(false);
		setBackground(Color.white);
		
		information.setFont(new Font("宋体", Font.BOLD, 30));
		information.setBounds(280, 100, 200, 50);
		add(information);
		
		name.setFont(new Font("宋体",Font.BOLD,20));
		name.setBounds(180,180,150,30);
		add(name);
		name_field.setFont(new Font("宋体",Font.BOLD,20));
		name_field.setBounds(350,180,250,30);
		add(name_field);
		
		id.setFont(new Font("宋体",Font.BOLD,20));
		id.setBounds(180,230,150,30);
		add(id);
		id_field.setFont(new Font("宋体",Font.BOLD,20));
		id_field.setBounds(350,230,250,30);
		add(id_field);
		
		phone_num.setFont(new Font("宋体",Font.BOLD,20));
		phone_num.setBounds(180,280,150,30);
		add(phone_num);
		phone_num_field.setFont(new Font("宋体",Font.BOLD,20));
		phone_num_field.setBounds(350,280,250,30);
		add(phone_num_field);
		
		registration_num.setFont(new Font("宋体",Font.BOLD,20));
		registration_num.setBounds(180,330,150,30);
		add(registration_num);
		registration_num_field.setFont(new Font("宋体",Font.BOLD,20));
		registration_num_field.setBounds(350,330,250,30);
		add(registration_num_field);
		
		confirm.setBounds(230, 410, 300, 50);
		add(confirm);
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				User user=new User();
				user.setName(name_field.getText());
				user.setIdNum(id_field.getText());
				user.setPhoneNum(phone_num_field.getText());
				user.setFirst(2);
				user.setSecond(2);
				user.setThird(2);
				user.setToday(0);
				UserDAO.add(user);
				JOptionPane.showMessageDialog(null, "您的预约编号是"+"2");
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
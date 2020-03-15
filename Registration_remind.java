package initial_interface;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
//import function.Select_Function1;
import javax.swing.*;

public class Registration_remind extends Frame {
	Panel tip = new Panel(new BorderLayout());  
	Label tip1=new Label("1.市民须以实名进行登记预约，按要求如实填写相关信息；");
	Label tip2=new Label("2.每名用户可同时为3人进行登记预约（重复登记无效）；");
	Label tip3=new Label("3.市民只需登记一次，系统每天自动对所有近5天内未中签者进行抽签；");
	Label tip4=new Label("4.4.每轮中签的市民可在中签后的5天内，自行或委托他人携带中签者的有效证件原件，前往登记预约的东莞国药门店购买口罩5个（一包），普通口罩价格每个1.5元，KN95口罩价格每个6元；");
	Label tip5=new Label("5.中签市民在中签后的5天内不再参与抽签，5天后将自动进入下一轮抽签，无需重复提交申请；");
	Label tip6=new Label("6.每天下午5时抽签后，市民可以通过口罩预约系统的“结果查询”页面，查询自己的中签情况。");
	Button begin_button=new Button("开始登记");
	Frame frame;
	
	public Registration_remind(Frame frame) {
		
		this.frame=frame;
		setTitle("");
		setSize(840, 300);
		setLayout(null);
		setResizable(false);
		setBackground(Color.white);
		
		tip.add(new Label("宋体",Label.CENTER),BorderLayout.CENTER); 
	    tip.setBounds(0, 20, 840, 40);
	    tip.setFont(new Font("宋体", Font.BOLD, 20));
	    add(tip);
		
	    tip1.setFont(new Font("宋体", Font.BOLD, 20));
	    tip1.setBounds(0, 60, 840, 40);
	    add(tip1);
	    
	    tip2.setFont(new Font("宋体", Font.BOLD, 20));
	    tip2.setBounds(0, 90, 840, 40);
	    add(tip2);
	    
	    tip3.setFont(new Font("宋体", Font.BOLD, 20));
	    tip3.setBounds(0, 120, 840, 40);
	    add(tip3);
	    
	    tip4.setFont(new Font("宋体", Font.BOLD, 20));
	    tip4.setBounds(0, 150, 840, 40);
	    add(tip4);
	   
	    tip5.setFont(new Font("宋体", Font.BOLD, 20));
	    tip5.setBounds(0, 180, 840, 40);
	    add(tip5);
	    
	    tip6.setFont(new Font("宋体", Font.BOLD, 20));
	    tip6.setBounds(0, 210, 840, 40);
	    add(tip6);
	    
	    begin_button.setBounds(370, 250, 100, 40);
	    add(begin_button);
		
	    begin_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Registration(frame);
			}
		});
	    
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setLocationRelativeTo(null);
		setVisible(true);	
	}
}

package initial_interface;

import java.awt.*;
import java.util.List;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Query extends Frame {
	Button query=new Button("查询");
	TextField registration_id_field=new TextField();
	Label tip=new Label("预约编号",Label.CENTER);
	Label declaration=new Label("查询界面",Label.CENTER);
	Frame frame=new Frame();
	
	public boolean IsSelected(String orderID){
	       try {
	           List<Order> orderList= OrderDAO.get();
	           for(Order order:orderList)
	           {
	                if(order.getOrderID().equals(orderID))
	                {
	                    if(order.getBallot()==1){
	                        return true;

	                    }
	                    else return false;
	                }

	           }


	       }
	       catch (Exception e) {
	           e.printStackTrace();
	       }
	       finally {
	           return false;
	       }
	    }
	
	public Query(Frame frame) {
		this.frame=frame;
		setTitle("查询界面");
		setSize(400, 300);
		setLayout(null);
		setResizable(false);
		setBackground(Color.GRAY);
		
		declaration.setBounds(150,50,130,50);
		declaration.setFont(new Font("宋体",Font.BOLD,30));
		add(declaration);
		
		tip.setBounds(70, 130, 100, 30);
		tip.setFont(new Font("宋体",Font.BOLD,20));
		add(tip);
		
		registration_id_field.setBounds(200, 130, 150, 30);
		add(registration_id_field);
		
		query.setBounds(150, 200, 120, 30);
		add(query);
		
		query.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,IsSelected(registration_id_field.getText()));
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

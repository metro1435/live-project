package initial_interface;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

//import function.Select_Function1;
public class ShowMain extends Frame {
	Toolkit tool = getToolkit();
	String url = "mainbk.jpg";
	Image img = tool.getImage(url);

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
		g.setFont(new Font("宋体", Font.BOLD, 40));
		g.setColor(Color.BLACK);
		g.drawString("欢迎使用口罩预约系统", 280, 330);
	}

	Button appointment = new Button("预约");
	static Button registration = new Button("登入");
	Button query = new Button("查询");
	Frame frame=this;
	
	public ShowMain() {
		setTitle("口罩预约系统");
		setSize(940, 880);
		setLayout(null);
		setResizable(false);
		
		appointment.setBounds(390, 380, 100, 30);
		appointment.setSize(200, 50);
		add(appointment);
		
		registration.setBounds(390, 450, 100, 30);
		registration.setSize(200, 50);
		registration.setEnabled(false);
		add(registration);
		
		query.setBounds(390, 520, 100, 30);
		query.setSize(200, 50);
		add(query);
		
		appointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setEnabled(false);
				new Appointment(frame);
			}
		});
		registration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setEnabled(false);
				new Registration_remind(frame);
			}
		});
		query.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setEnabled(false);
				new Query(frame);
			}
		});
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String args[]) {
		new ShowMain();
	}
}
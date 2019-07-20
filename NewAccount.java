import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class NewAccount extends Frame implements ActionListener
{
	Label l1,l2,l3,l4,l5,l6,l7,l8;
	TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
	Button b1;
	String s1,s2,s3,s4,s5,s6,s7,s8,str;
	JFrame frame;
	public static void main(String s[])
	{
		NewAccount mf=new NewAccount();
		mf.job();
	}
	public NewAccount()
	{
		l1=new Label("Account No:");
		l2=new Label("Name");
		l3=new Label("Opening Date");
		l4=new Label("Opening Amount");
		l5=new Label("Address");
		l6=new Label("Phone No:");
		l7=new Label("Email-Id");
		l8=new Label("Proposer's Acc No:");
		tf1=new TextField(20);
		tf2=new TextField(20);
		tf3=new TextField (20);
		tf4=new TextField (20);
		tf5=new TextField (20);
		tf6=new TextField (20);
		tf7=new TextField (20);
		tf8=new TextField (30);
		b1=new Button("CREATE");
		frame=new JFrame();

	}
	public void job()
	{
		setTitle("CREATE NEW ACCOUNT");
		setSize(500,600);
		setLayout(null);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		});
		
		l1.setBounds(40,40,75,25);
		add(l1);
		l2.setBounds(40,90,75,25);
		add(l2);
	        l3.setBounds(40,140,80,25);
		add(l3);		
		l4.setBounds(40,190,95,25);
		add(l4);
		l5.setBounds(40,250,75,25);
		add(l5);
		l6.setBounds(40,300,75,25);
		add(l6);
		l7.setBounds(40,350,75,25);
		add(l7);
		l8.setBounds(40,400,105,25);
		add(l8);
		tf1.setBounds(220,40,125,25);
		add(tf1);
		tf2.setBounds(220,90,125,25);
		add(tf2);
		tf3.setBounds(220,140,125,25);
		add(tf3);
		tf4.setBounds(220,190,125,25);
		add(tf4);
		tf5.setBounds(220,250,125,25);
		add(tf5);
		tf6.setBounds(220,300,125,25);
		add(tf6);
		tf7.setBounds(220,350,125,25);
		add(tf7);
		tf8.setBounds(220,400,125,25);
		add(tf8);
		b1.setBounds(220,500,100,25);
		add(b1);
		b1.addActionListener(this);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
	                	s1=tf1.getText();
				s2=tf2.getText();
				s3=tf3.getText();
				s4=tf4.getText();
				s5=tf5.getText();
				s6=tf6.getText();
				s7=tf7.getText();
				s8=tf8.getText();
				if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")||s7.equals("")||s8.equals(""))
				{
					JOptionPane.showMessageDialog(frame,"Sorry!All fields are mandatory", "Error!", JOptionPane.ERROR_MESSAGE);		
				}
				else
				{
				str="insert into accounts values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
				Statement st=conn.createStatement();
				
				if(ae.getSource()==b1)
				{
					st.executeUpdate(str);
					{
						JOptionPane.showMessageDialog(frame,"Thank you!Your account has been created successfully", "Information", JOptionPane.INFORMATION_MESSAGE);		
					}
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
					tf4.setText("");
					tf5.setText("");
					tf6.setText("");
					tf7.setText("");
					tf8.setText("");
				}
			
				}
			}
			catch(Exception e)
			{System.out.println(e);}
			
	}
}
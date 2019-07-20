import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Withdraw extends Frame implements ActionListener
{
	Label l1,l2,l3,l4;
	TextField tf1,tf2,tf3,tf4;
	Button b1,b2;
	String s1,s2,s3,s4,s5,str;
	JFrame frame;

	public static void main(String s[])
	{
		Withdraw wd=new Withdraw();
		wd.job();
	}
	public Withdraw()
	{
		l1=new Label("Account No:");
		l2=new Label("Name");
		l3=new Label("Balance");
		l4=new Label("Witndrawl Amount");
		tf1=new TextField(20);
		tf2=new TextField(20);
		tf3=new TextField (20);
		tf4=new TextField (20);
		tf2.setEnabled(false);
		tf3.setEnabled(false);
		tf4.setEnabled(false);
		b1=new Button("OK");
		b2=new Button("WITHDRAW");
		frame=new JFrame();
		

	}
	public void job()
	{
		setTitle("WITHDRAWL AMOUNT");
		setSize(400,400);
		setLayout(null);
		l1.setBounds(40,40,75,25);
		add(l1);
		l2.setBounds(40,90,75,25);
		add(l2);
	        l3.setBounds(40,140,75,25);
		add(l3);
		l4.setBounds(40,190,105,25);
		add(l4);		
		tf1.setBounds(180,40,125,25);
		add(tf1);
		tf2.setBounds(180,90,125,25);
		add(tf2);
		tf3.setBounds(180,140,125,25);
		add(tf3);
		tf4.setBounds(180,190,125,25);
		add(tf4);
		b1.setBounds(60,270,100,25);
		add(b1);
		b2.setBounds(180,270,100,25);
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		addWindowListener(new WindowAdapter()	
		{
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		}
	);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			s1=tf1.getText();
			str="select * from accounts";
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement st=conn.createStatement();
			int amt=0;
			int flag=0;
			ResultSet rs;
			rs=st.executeQuery(str);
			while(rs.next())
			{
				if(rs.getString("Account_no").equals(s1))
				{
					s2=rs.getString("Name");
					s3=rs.getString("Deposit_amount");
					flag=1;
					amt=Integer.parseInt(rs.getString("Deposit_amount"));
					break;
				}
			}
			if(flag==0)
			{
				JOptionPane.showMessageDialog(frame,"Entered Account number doesn't exist", "Error!", JOptionPane.WARNING_MESSAGE);
			}
			if(ae.getSource()==b1)
			{
				tf2.setEnabled(true);
				tf3.setEnabled(true);
				tf4.setEnabled(true);
				tf2.setText(s2);
				tf3.setText(s3);
			}
			if(ae.getSource()==b2)
			{
				s4=tf4.getText();
				if(Integer.parseInt(s3)<Integer.parseInt(s4))
				{
					JOptionPane.showMessageDialog(frame,"Sorry,no sufficient balance", "Error!", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
				amt=amt-Integer.parseInt(s4);
				s5=""+amt;
				str="update accounts set Deposit_amount='"+s5+"' where account_no='"+s1+"'";
				st.executeUpdate(str);
				ConfirmationMsg1 cm=new ConfirmationMsg1(s1);
				cm.job();
				}
				
			}
		}
		catch(Exception e)
		{System.out.println(e);}
	}
}
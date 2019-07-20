import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class BalanceEnquiry extends Frame implements ActionListener
{
	Label l1,l2,l3;
	TextField tf1,tf2,tf3;
	Button b1;
	String s1,s2,s3,str;
	JFrame frame;
	public static void main(String s[])
	{
		BalanceEnquiry be=new BalanceEnquiry();
		be.job();
	}
	public BalanceEnquiry()
	{
		l1=new Label("Account No:");
		l2=new Label("Name");
		l3=new Label("Current Balance");
		tf1=new TextField(20);
		tf2=new TextField(20);
		tf3=new TextField (20);
		tf2.setEnabled(false);
		tf3.setEnabled(false);
		b1=new Button("OK");
		frame=new JFrame();

	}
	public void job()
	{
		setTitle("BALANCE ENQUIRY");
		setSize(400,400);
		setLayout(null);
		l1.setBounds(40,40,75,25);
		add(l1);
		l2.setBounds(40,90,75,25);
		add(l2);
	        l3.setBounds(40,140,90,25);
		add(l3);
		tf1.setBounds(180,40,125,25);
		add(tf1);
		tf2.setBounds(180,90,125,25);
		add(tf2);
		tf3.setBounds(180,140,125,25);
		add(tf3);
		b1.setBounds(160,270,100,25);
		add(b1);
		
		b1.addActionListener(this);

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
	public void actionPerformed (ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==b1)
				tf2.setEnabled(true);
			{
				s1=tf1.getText();
				str="select * from accounts";
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
				Statement st=conn.createStatement();
				int flag=0;
				ResultSet rs;
				rs=st.executeQuery(str);
				while(rs.next())
				{
					if(rs.getString("Account_no").equals(s1))
					{
						flag=1;
						s2=rs.getString("Name");
						s3=rs.getString("Deposit_amount");
						tf2.setText(s2);
						tf3.setText(s3);
					
			
					}
				}
				if(flag==0)
				{
					JOptionPane.showMessageDialog(frame,"Entered Account number doesn't exist", "Error!", JOptionPane.WARNING_MESSAGE);

					
				}
			}
		}
		catch(Exception e)
		{System.out.println(e);}
	}
}
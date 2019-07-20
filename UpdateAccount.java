import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class UpdateAccount extends Frame implements ActionListener
{
	Label l1;
	TextField tf1;
	Button b1;
	String s1,s2,s3,s4,s5,s6,s7,s8,str;
	JFrame frame;
	public static void main(String s[])
	{
		UpdateAccount u1=new UpdateAccount();
		u1.job();
	}
	public UpdateAccount()
	{
		l1=new Label("Enter Account No:");
		tf1=new TextField(20);
		b1=new Button("UPDATE");
		frame=new JFrame();

	}
	public void job()
	{
		setTitle("UPDATE ACCOUNT");
		setSize(325,300);
		setLayout(null);
		
		l1.setBounds(40,40,100,40);
		add(l1);
		tf1.setBounds(160,40,125,25);
		add(tf1);
		b1.setBounds(80,100,125,25);
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
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==b1)
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
						s2=rs.getString("Name");
						s3=rs.getString("Date_of_opening");
						s4=rs.getString("Deposit_amount");
						s5=rs.getString("address");
						s6=rs.getString("mob_no");
						s7=rs.getString("email");
						s8=rs.getString("Proposers_acc_no");
						flag=1;
						UpNewAccount ua=new UpNewAccount(s1,s2,s3,s4,s5,s6,s7,s8);
						ua.job();
						dispose();
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
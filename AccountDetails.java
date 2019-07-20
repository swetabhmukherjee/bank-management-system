import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class AccountDetails extends Frame  implements ItemListener,ActionListener
{
	Label l1,l2,l3,l4;
	TextField tf2,tf3,tf4;
	Button b1;
	Checkbox c1,c2,c3;
	CheckboxGroup cbg;
	String s11,s1,s2,s3,s4,s5,s6,s7,s8,str;
	JFrame frame;
	public static void main(String s[])
	{
		AccountDetails ad=new AccountDetails();
		ad.job();
	}
	public AccountDetails()
	{
		l1=new Label("On the basis of-");
		l2=new Label("Account No.");
		l3=new Label("Name");
		l4=new Label("Mobile No.");
		cbg=new CheckboxGroup();
		c1=new Checkbox("Account No.",false,cbg);
		c2=new Checkbox("Name",false,cbg);
		c3=new Checkbox("Mobile No.",false,cbg);
		tf2=new TextField(20);
		tf3=new TextField(20);
		tf4=new TextField(20);
		tf2.setEnabled(false);
		tf3.setEnabled(false);
		tf4.setEnabled(false);
		b1=new Button("SEARCH");
		frame=new JFrame();
		
	}
	public void job()
	{
		setTitle("ACCOUNT DETAILS");
		setSize(500,300);
		setLayout(null);
		l1.setBounds(40,40,90,25);
		add(l1);
		c1.setBounds(150,40,80,30);
		add(c1);
		c2.setBounds(250,40,80,30);
		add(c2);
		c3.setBounds(350,40,80,30);
		add(c3);
		l2.setBounds(40,90,75,25);
		add(l2);
	        l3.setBounds(40,140,105,25);
		add(l3);
		l4.setBounds(40,190,105,25);
		add(l4);		
		tf2.setBounds(180,90,125,25);
		add(tf2);
		tf3.setBounds(180,140,125,25);
		add(tf3);
		tf4.setBounds(180,190,125,25);
		add(tf4);
		b1.setBounds(190,240,100,25);
		add(b1);
		
		b1.addActionListener(this);
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
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
	public void itemStateChanged(ItemEvent ie)
	{
		if(cbg.getSelectedCheckbox()==c1)
		{
			tf2.setEnabled(true);
			tf3.setEnabled(false);
			tf4.setEnabled(false);
		}
		if(cbg.getSelectedCheckbox()==c2)
		{
			tf2.setEnabled(false);
			tf3.setEnabled(true);
			tf4.setEnabled(false);
		}
		if(cbg.getSelectedCheckbox()==c3)
		{
			tf2.setEnabled(false);
			tf3.setEnabled(false);
			tf4.setEnabled(true);
		}

		
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			int i=0;
			if(c1.getState())
			{
				s11=tf2.getText();
				str="select * from accounts";
				i=1;
			}
			else
			if(c2.getState())
			{
				s11=tf3.getText();
				str="select * from accounts";
				i=2;
			}
			else
			if(c3.getState())
			{
				s11=tf4.getText();
				str="select * from accounts";
				i=6;
			}
			
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement st=conn.createStatement();
			int flag=0;
			ResultSet rs;
			rs=st.executeQuery(str);
			while(rs.next())
			if(ae.getSource()==b1)
			{
				if(rs.getString(i).equals(s11))
				{
					s1=rs.getString("Account_no");
					s2=rs.getString("Name");
					s3=rs.getString("Date_of_opening");
					s4=rs.getString("Deposit_amount");
					s5=rs.getString("address");
					s6=rs.getString("mob_no");
					s7=rs.getString("email");
					s8=rs.getString("Proposers_acc_no");
					flag=1;
					AccountInformation ai=new AccountInformation(s1,s2,s3,s4,s5,s6,s7,s8);
					ai.job();
					dispose();
				}
			}
			if(flag==0)
			{
				JOptionPane.showMessageDialog(frame,"Entered Account number doesn't exist", "Error!", JOptionPane.WARNING_MESSAGE);
			}
		}
		catch(Exception e)
		{System.out.println(e);}
	}
}
		
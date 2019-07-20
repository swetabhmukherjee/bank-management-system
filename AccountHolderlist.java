import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class AccountHolderlist extends Frame implements ActionListener,ItemListener
{
	Label l1;
	Checkbox c1,c2;
	CheckboxGroup cbg;
	Button b1;
	JTable t1;
	String str;
	public static void main(String s[])
	{
		AccountHolderlist ah=new AccountHolderlist();
		ah.job();
	}
	public AccountHolderlist()
	{
		l1=new Label("On the basis of-");
		cbg=new CheckboxGroup();
		c1=new Checkbox("List all",false,cbg);
		c2=new Checkbox("List a/c holders having amount less than min. balance",false,cbg);
		b1=new Button("Ok");
		t1=new JTable(8,8);
	}
	public void job()
	{
		setTitle("ACCOUNT HOLDER'S LIST");
		setSize(700,600);
		setLayout(new FlowLayout());
		l1.setBounds(40,40,75,25);
		add(l1);
		add(c1);
		add(c2);
		b1.setBounds(90,140,75,25);
		add(b1);
		t1.setBounds(70,70,100,100);
		add(t1);
		b1.addActionListener(this);
		c1.addItemListener(this);
		c2.addItemListener(this);
	
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
		try
		{
			if(cbg.getSelectedCheckbox()==c1)
			{
	
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
				Statement st=conn.createStatement();
				ResultSet rs;
				rs = st.executeQuery("select * from Accounts");
				int i=0;
				while(rs.next())
				{
				t1.setValueAt(rs.getString(1),i,0);	
				t1.setValueAt(rs.getString(2),i,1);
				t1.setValueAt(rs.getString(3),i,2);
				t1.setValueAt(rs.getString(4),i,3);
				t1.setValueAt(rs.getString(5),i,4);
				t1.setValueAt(rs.getString(6),i,5);
				t1.setValueAt(rs.getString(7),i,6);
				t1.setValueAt(rs.getString(8),i,7);
				i++;
			}
		}
		else
		if(cbg.getSelectedCheckbox()==c2)
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement st=conn.createStatement();
			ResultSet rs;
			rs = st.executeQuery("select * from Accounts where Deposit_amount<1000");
			int i=0;
			while(rs.next())
			{
				t1.setValueAt(rs.getString(1),i,0);	
				t1.setValueAt(rs.getString(2),i,1);
				t1.setValueAt(rs.getString(3),i,2);
				t1.setValueAt(rs.getString(4),i,3);
				t1.setValueAt(rs.getString(5),i,4);
				t1.setValueAt(rs.getString(6),i,5);
				t1.setValueAt(rs.getString(7),i,6);
				t1.setValueAt(rs.getString(8),i,7);
				i++;
			}
		}
		}
		catch(Exception e)
		{System.out.println(e);}
	}
	public void actionPerformed(ActionEvent ae)
	{
	}
}
		
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ConfirmationDialogbox extends Frame implements ActionListener
{
	Label l1;
	Button b1,b2;
	String s1,str;
	public static void main(String s[])
	{
		/*ConfirmationDialogbox cb=new ConfirmationDialogbox();
		cb.job();*/
	}
	public ConfirmationDialogbox(String s1)
	{
		this.s1=s1;
		l1=new Label("Are you sure you want to delete your account?");
		b1=new Button("YES");
		b2=new Button("NO");

	}
	public void job()
	{
		setTitle("ConfirmationDialogbox");
		setSize(400,300);
		setLayout(null);
		
		l1.setBounds(70,40,250,50);
		add(l1);
		b1.setBounds(60,100,125,25);
		add(b1);
		b2.setBounds(200,100,125,25);
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
	public void actionPerformed (ActionEvent ae)
	{
		try
		{
			ResultSet rs;
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement st=conn.createStatement();
			if (ae.getSource()==b1)
			{
			str="delete from accounts where Account_no='"+s1+"'";
			rs=st.executeQuery(str);
			dispose();
			}
			if (ae.getSource()==b2)
			this.dispose();	
		}
			catch(Exception e)
			{System.out.println(e);}
			
	}

}

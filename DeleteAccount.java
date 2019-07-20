import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class DeleteAccount extends Frame implements ActionListener
{
	Label l1;
	TextField tf1;
	Button b1;
	String s1,str;
	JFrame frame;
	
	public static void main(String s[])
	{
		DeleteAccount da=new DeleteAccount();
		da.job();
	}
	public DeleteAccount()
	{
		l1=new Label("Enter Account No:");
		tf1=new TextField(20);
		b1=new Button("DELETE");
		frame=new JFrame();

	}
	public void job()
	{
		setTitle("DELETE ACCOUNT");
		setSize(300,300);
		setLayout(null);
		
		l1.setBounds(40,40,80,25);
		add(l1);
		tf1.setBounds(140,40,125,25);
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
						
						flag=1;
						ConfirmationDialogbox cb=new ConfirmationDialogbox(s1);
						cb.job();
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
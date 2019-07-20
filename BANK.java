import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BANK extends Frame implements ActionListener
{
	MenuBar mb;
	Menu m1,m2,m3,m4;
	MenuItem m11,m12,m13,m21,m22,m23,m31,m32,m41;
	JLabel l1;
	ImageIcon i1;
		
	public static void main(String s[])
	{
		BANK bn=new BANK();
		bn.job();
	}
	public BANK()
	{
		mb=new MenuBar();
		m1=new Menu("ACCOUNT");
		m2=new Menu("TRANSACTION");
		m3=new Menu("SHOW");
		m4=new Menu("HELP");

		m11=new MenuItem("NEW ACCOUNT");
		m12=new MenuItem("UPDATE ACCOUNT");
		m13=new MenuItem("DELETE ACCOUNT");
		m21=new MenuItem("DEPOSIT");
		m22=new MenuItem("WITHDRAWL");
		m23=new MenuItem("BALANCE ENQUIRY");
		m31=new MenuItem("ACCOUNT DETAIL");
		m32=new MenuItem("ACCOUNT HOLDER'S LIST");
		m41=new MenuItem("HELP");
		
		i1=new ImageIcon("bank.jpg");
		l1=new JLabel(i1);
		
	}
	public void job()
	{
		setSize(520,350);
		setTitle("BANK");
		setLayout(new FlowLayout());
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		m1.add(m11);
		m1.add(m12);
		m1.add(m13);
		m2.add(m21);
		m2.add(m22);
		m2.add(m23);
		m3.add(m31);
		m3.add(m32);
		m4.add(m41);
		
		m11.addActionListener(this);
		m12.addActionListener(this);
		m13.addActionListener(this);
		m21.addActionListener(this);
		m22.addActionListener(this);
		m23.addActionListener(this);
		m31.addActionListener(this);
		m32.addActionListener(this);
		m41.addActionListener(this);
		addWindowListener(new AA());
		setMenuBar(mb);
		add(l1);
		setVisible(true);
	}
	class AA extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==m11)
		{
			NewAccount na=new NewAccount();
			na.job();
		}
		else
		if(ae.getSource()==m12)
		{
			UpdateAccount ua=new UpdateAccount();
			ua.job();
		}
		else
		if(ae.getSource()==m13)
		{
			DeleteAccount da=new DeleteAccount();
			da.job();
		}
		else
		if(ae.getSource()==m21)
		{
			Deposit dp=new Deposit();
			dp.job();
		}
		else
		if(ae.getSource()==m22)
		{
			Withdraw wd=new Withdraw();
			wd.job();
		}
		else
		if(ae.getSource()==m23)
		{
			BalanceEnquiry be=new BalanceEnquiry();
			be.job();
		}
		else
		if(ae.getSource()==m31)
		{
			AccountDetails ad=new AccountDetails();
			ad.job();
		}
		else
		if(ae.getSource()==m32)
		{
			AccountHolderlist ah=new AccountHolderlist();
			ah.job();
		}
		else
		if(ae.getSource()==m41)
		{
			try
			{
				Process p=Runtime.getRuntime().exec("cmd /c Help.txt");
				p.waitFor();
				System.out.println(p.exitValue());
			}
			catch(Exception e)
			{System.out.println(e);}
		}
	}
}


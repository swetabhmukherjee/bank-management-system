import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AccountInformation extends Frame
{
	Label l1,l2,l3,l4,l5,l6,l7,l8;
	TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
	String s1,s2,s3,s4,s5,s6,s7,s8,str;
	public static void main(String s[])
	{
		/*AccountInformation ai=new AccountInformation();
		ai.job();*/
	}
	public AccountInformation(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8)
	{
		this.s1=s1;
		this.s2=s2;
		this.s3=s3;
		this.s4=s4;
		this.s5=s5;
		this.s6=s6;
		this.s7=s7;
		this.s8=s8;

		l1=new Label("Account No:");
		l2=new Label("Name");
		l3=new Label("Opening Date");
		l4=new Label("Current Amount");
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
		
		
		
	}
	public void job()
	{
		setTitle("ACCOUNT INFORMATION");
		setSize(500,600);
		setLayout(null);
		
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

		tf1.setText(s1);
		tf2.setText(s2);
		tf3.setText(s3);
		tf4.setText(s4);
		tf5.setText(s5);
		tf6.setText(s6);
		tf7.setText(s7);
		tf8.setText(s8);
		
		
		
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
	
			
}
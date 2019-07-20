import java.awt.*;
import java.awt.event.*;
public class ConfirmationMsg1 extends Frame 
{
	Label l1;
	
	String s1;
	public static void main(String s[])
	{
		/*ConfirmationMsg1 cm=new ConfirmationMsg1();
		cm.job();*/
	}
	public ConfirmationMsg1(String s1)
	{
		this.s1=s1;
		l1=new Label("Amount Withdrawn Successfully..!!");
		this.dispose();

	}
	public void job()
	{
		setTitle("ConfirmationMsg1");
		setSize(350,200);
		setLayout(null);
		
		l1.setBounds(60,60,200,25);
		add(l1);
		
		setVisible(true);
	}
}
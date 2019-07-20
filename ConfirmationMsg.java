import java.awt.*;
import java.awt.event.*;
public class ConfirmationMsg extends Frame 
{
	Label l1;
	String s1;
	
	public static void main(String s[])
	{
		/*ConfirmationMsg cm=new ConfirmationMsg();
		cm.job();*/
	}
	public ConfirmationMsg(String s1)
	{
		l1=new Label("Amount deposited successfully..!!");
		this.dispose();
	}
	public void job()
	{
		setTitle("ConfirmationMsg");
		setSize(350,200);
		setLayout(null);
		
		l1.setBounds(60,60,200,25);
		add(l1);
		
		setVisible(true);
	}

}
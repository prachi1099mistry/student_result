import java.awt.Frame;					//import the necessary packages
import java.awt.GridLayout;					//import the necessary packages
import java.awt.TextField;					//import the necessary packages
import java.awt.Label;					//import the necessary packages
import java.awt.Button;					//import the necessary packages
import java.awt.event.ActionEvent;					//import the necessary packages
import java.awt.event.ActionListener;					//import the necessary packages

class StudentInfo extends Frame implements ActionListener	//creating a class for record
{
	String name;			//variables to store the information
	int rollno;			//variables to store the information
	int[] mks;			//variables to store the information
	TextField[] t;			//creating the containers for the frames.
	Label[] l;			//creating the containers for the frames.
	Button b1;			//creating the containers for the frames.
	Button b2;			//creating the containers for the frames.
	StudentInfo()			//the constructor
	{
		mks=new int[5];			//array of mks
		int i;
		t=new TextField[7];			//array of textfield
		l=new Label[7];			//array of labels
		String[] s={"NAME","ROLL_NO","CJ","CGA","COST","IES","SE"};
		setLayout(new GridLayout(8,2));			//setting the layout of the frames
		for(i=0;i<7;i++)
		{
			t[i]=new TextField(10);			//creating the text field
			l[i]=new Label(s[i]);			//creating the labels
			add(l[i]);						// placing the labels on the frames
			add(t[i]);						// placing the text field on the frames
		}
		b1=new Button("See Result");		//creating buttons
		b2=new Button("Clear");				//creating buttons
		add(b1);						// placing the buttons on the frames
		add(b2);						// placing the buttons on the frames
		b1.addActionListener(this);		//adding events to the buttons.
		b2.addActionListener(this);		//adding events to the buttons.
		setTitle("Result");				//title for the frame
		setVisible(true);				//setting the visibility
		setSize(400,200);				//setting the size
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)			//check which button is clicked
		{
			int i=0,percent=0;
			name=t[0].getText();
			rollno=Integer.parseInt(t[1].getText());
			System.out.println("Result is:");			//printing the information
			System.out.println("Name="+name);			//printing the information
			System.out.println("Roll_no="+rollno);		//printing the information
			System.out.println("MKS=");					//printing the information
			for(int j=2;j<7;j++)						//calculating the percentage
			{
				mks[i]=Integer.parseInt(t[j].getText());
				System.out.print(mks[i]+"\t");
				i++;
			}
			percent=100*(mks[0]+mks[1]+mks[2]+mks[3]+mks[4])/500;
			System.out.println("\nPercentage="+percent+"%");
		}
		else if(ae.getSource()==b2)
		{
			for(int i=0;i<7;i++)
			{
				t[i].setText(" ");			//clearing the textfield
			}
		}			
	}
}

class StudDemo
{
	public static void main(String[] args)		//main method
	{
		new StudentInfo();					//object creation
	}
}
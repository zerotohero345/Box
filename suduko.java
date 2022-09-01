import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class suduko extends Frame implements ActionListener
{
int r,grow=0,gcol=0,d2;
String s=new String();
Random rand;
Label l1;
TextField txt[][]=new TextField[9][9];
Button b1,b2,b3;

suduko()
{
super("SUDUKO");
setSize(800,650);
setVisible(true);
Color clr1=new Color(232,200,10);
setBackground(clr1);
setLayout(null);
//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
try
{
b1=new Button("Start");                                b1.setFont(new Font("Serif",Font.BOLD,40));
b2=new Button("check");                               b2.setFont(new Font("Serif",Font.BOLD,40));
b3=new Button("Go to Next Level ");             b3.setFont(new Font("Serif",Font.BOLD,40));
add(b1);   add(b2);  add(b3);


l1=new Label("  Level 1  ");                           l1.setFont(new Font("Serif",Font.BOLD,40));
add(l1);
add(new Button("SUBMIT"));

Panel pan1=new Panel();
pan1.setSize(150,150);
pan1.setVisible(true);
pan1.setLayout(new GridLayout(9,9,5,5));
Color clr=new Color(232,100,10);
pan1.setBackground(clr);
pan1.setForeground(Color.black);
add(pan1);

l1.setBounds(50,30,150,30);
pan1.setBounds(40,80,400,400);
b1.setBounds(500,240,150,50);
b2.setBounds(500,300,150,50);
b3.setBounds(500,360,300,50);

for(int i=0;i<9;i++)
{
for(int j=0;j<9;j++)
{
txt[i][j]=new TextField();
int num=0;
txt[i][j].setText(String.valueOf(num));              txt[i][j].setFont(new Font("Arial",Font.BOLD,20));
pan1.add(txt[i][j]);
}
}

}
catch(Exception e)
{

}


        //logic
rand=new Random();
r=rand.nextInt(10);
s=String.valueOf(r);

for(int i=0;i<9;i++)
{
int h=gcol;
while(h<9)
{
int d1=FUNCTION1(txt,r,h);

int k=0;
if(d1==2 )
{



while(k<h)
{
int  d=FUNCTION2(txt,r,k);
if(d==2  )
{


txt[i][h].setText(s);
h++;
}
else
{
rand=new Random();
r=rand.nextInt(10);
s=String.valueOf(r);
}

}




}
else
{
rand=new Random();
r=rand.nextInt(10);
s=String.valueOf(r);
}
 
}
gcol++;
}


/*
for(int i=0;i<9;i++)
{
int k=grow;
while(k<9)
{
int  d=FUNCTION2(txt,r,k);
if(d==2  )
{
txt[k][i].setText(s);
k++;
}
else
{
rand=new Random();
r=rand.nextInt(10);
s=String.valueOf(r);
}

}
grow++;
}
*/
     //For loop closing

 
}         //constructor closing

int FUNCTION1(TextField b[][],int rnd,int h)
{
int c=1,g,l,r,s,n=0,v=1;

n=rnd;
if(n!=0)
{
for(g=0;  g<=h;  g++)
{
if(n==Integer.parseInt(b[gcol][g].getText()))
c=2;
}
}
if( n!=0 && c==1)
v=2;
return v;
}

int FUNCTION2(TextField b[][],int rad,int t)
{
int j=1, c=0,m,r,s,g=0,n=0,v=1;
n=rad;
if(n!=0 )
{
for(m=0;  m<=t;  m++)
{
if(n==Integer.parseInt(b[m][grow].getText() ))
j++;
}
}

if( n!=0 && j==1)
v=2;
return v;
}


int FUNCTION(TextField b[][],int r,int s,int t,int u)
{
int q[]=new int[9];
int l=-1,d=1,i,j,n,v=1;
for(i=r;i<s;i++)
{
for(j=t;j<u;j++)
q[++l]=Integer.parseInt(b[i][j].getText());
}      
for(i=0;i<9;i++)
{
n=q[i];
if(n==1||n==2||n==3||n==4||n==5||n==6||n==7||n==8||n==9)
{
for(j=0;j<i;j++)
{
if(q[i]==q[j])
d=2;
}}}
if(d==1)
v=2;
return v;
 }



public void actionPerformed(ActionEvent p)
{

}
public static void main(String args[])
{
new suduko();
}
}
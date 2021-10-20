import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class dt extends Frame implements ActionListener
{
private static final String url="jdbc:mysql://localhost/athul?SSL=false";
private static final String user="root";
private static final String pass="password";

private static Connection con;
private static Statement stmt;
private static ResultSet rs;

Label Name,Age,Ph,Id;
 TextField Tname,Tage,Tph,Tid;
Button add,del,view,edit;
TextArea T;

String id,name,age,ph;

dt()
{
Name=new Label("Name");
Name.setBounds(30,50,50,20);
Tname=new TextField();                     
Tname.setBounds(100,50,100,20);

Age=new Label("Age");
Age.setBounds(30,100,50,20);
Tage=new TextField();                     
Tage.setBounds(100,100,100,20);


Ph=new Label("Phone");
Ph.setBounds(30,150,50,20);
Tph=new TextField();                     
Tph.setBounds(100,150,100,20);


Id=new Label("Id");
Id.setBounds(30,200,50,20);
Tid=new TextField();                     
Tid.setBounds(100,200,100,20);


add=new Button("ADD");
add.setBounds(30,250,50,40);

edit=new Button("EDIT");
edit.setBounds(80,250,50,40);

view=new Button("VIEW");
view.setBounds(130,250,50,40);

del=new Button("DELETE");
del.setBounds(180,250,50,40);

T=new TextArea();                     
T.setBounds(30,300,500,300);

this.setVisible(true);
this.setLayout(null);
this.setSize(700,700);
Name.setVisible(true);
Tname.setVisible(true);
Age.setVisible(true);
Tage.setVisible(true);
Ph.setVisible(true);
Tph.setVisible(true);
Id.setVisible(true);
Tid.setVisible(true);
add.setVisible(true);
edit.setVisible(true);
view.setVisible(true);
del.setVisible(true);

T.setVisible(true);


this.add(Name);
this.add(Tname);

this.add(Age);
this.add(Tage);

this.add(Ph);
this.add(Tph);

this.add(Id);
this.add(Tid);
this.add(add);
this.add(view);
this.add(del);
this.add(edit);
this.add(T);

add.addActionListener(this);
edit.addActionListener(this);
del.addActionListener(this);
view.addActionListener(this);

}

public void actionPerformed(ActionEvent e)
{
name=Tname.getText();
age=Tage.getText();
ph=Tph.getText();
id=Tid.getText();

if(e.getSource()==add)
{
try
{
con=DriverManager.getConnection(url,user,pass);
stmt=con.createStatement();
stmt.executeUpdate("insert into tb (id,name,age,ph)values ('"+id+"','"+name+"','"+age+"','"+ph+"');");
con.close();
System.out.println("inserted sucessfully");

}
catch(Exception ex)
{}

}



if(e.getSource()==view)
{

try
{
con=DriverManager.getConnection(url,user,pass);
stmt=con.createStatement();
rs=stmt.executeQuery("select * from tb;");
while(rs.next())
{
T.append(rs.getString(1)+"    ");
T.append(rs.getString(2)+"    ");
T.append(rs.getString(3)+"    ");
T.append(rs.getString(4)+"    "+"\n");

}
con.close();
System.out.println("viewed sucessfully");

}
catch(Exception ex)
{}

}

if(e.getSource()==edit)
{
try
{
con=DriverManager.getConnection(url,user,pass);
stmt=con.createStatement();
stmt.executeUpdate("update tb set name='"+name+"',age='"+age+"',ph='"+ph+"' where id='"+id+"';");
con.close();
System.out.println("updated sucessfully");

}
catch(Exception ex)
{}

}
if(e.getSource()==del)
{
try
{
con=DriverManager.getConnection(url,user,pass);
stmt=con.createStatement();
stmt.executeUpdate("delete from tb  where id='"+id+"';");
con.close();
System.out.println("deleted sucessfully");

}
catch(Exception ex)
{}

}

}
public static void main(String args[])
{

dt d=new dt();

}

}

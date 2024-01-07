package Q5_Shopping;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class ShoppingCartApp implements ActionListener {	
	JLabel label1= new JLabel("Customer Phone ");
	JTextField phone=new JTextField(10);
	JLabel label2= new JLabel("Enter customer id");
	JTextField cid=new JTextField(10);
	JButton check=new JButton("Check cid ");
	JLabel label3= new JLabel("#1  APPLE 150rs/Kg   #2 Orange 60rs/kg");
	JLabel label4= new JLabel("Enter item Number u to purchase ");
	JTextField item_no= new JTextField(5);
	JLabel label5= new JLabel("Quantity kg ");
	JTextField kg= new JTextField(5);
	JRadioButton rb1=new JRadioButton("Discount 30%");
	JButton Bill=new JButton("Bill");
	JTextField am=new JTextField(20);
	JTextArea jt1=new JTextArea("");
	HashMap<String,Integer> hm=new HashMap<String,Integer>();
	HashMap<Integer,Double>	item= new HashMap<Integer,Double>();
	public static int nextCid=124;
	void add_coll()
	{
		hm.put("9741278570",121);
		hm.put("9900726035",122);
		hm.put("9900001111",123);
	}
	void add_item()
	{
		item.put(1,150.0);
		item.put(2,60.0);
		//hm.put("BANANA",40);
	}
	ShoppingCartApp()
	{
		JFrame f1=new JFrame("CUSTOMER INFORMATION");
		String uname=JOptionPane.showInputDialog(null,"Enter USERNAME=");
		String psw=JOptionPane.showInputDialog(null,"Enter PASSWORD=");
		add_coll();
		add_item();
		if(uname.equals("msrit123")&& psw.equals("ise123"))
		{
			
			JOptionPane.showMessageDialog(null, "LOGIN VALID");
			f1.setSize(200,200);
			f1.setVisible(true);
			f1.setLayout(new FlowLayout());
			f1.add(label1);
			f1.add(phone);
			f1.add(check);
			f1.add(label2);
			f1.add(cid);
			check.addActionListener(this);
			f1.add(label3);
			f1.add(jt1);
			jt1.setEditable(false);
			f1.add(label4);
			f1.add(item_no);
			f1.add(label5);
			f1.add(kg);
			f1.add(rb1);
			f1.add(Bill);
			Bill.addActionListener(this);
			f1.add(am);
			
			
						
		}
		else
		{
			JOptionPane.showMessageDialog(null, "LOGIN INVALID");
		}
		
	}

	public static void main(String[] args) {
		ShoppingCartApp ob=new ShoppingCartApp();	

	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==check)
		{
			String p1=phone.getText();
			if(hm.containsKey(p1))
			{
				JOptionPane.showMessageDialog(null, "UR OLD CUSTEMER ID"+hm.get(p1));
				cid.setText(Integer.toString(hm.get(p1)));
			}
			else
			{
				hm.put(p1,nextCid++);
				JOptionPane.showMessageDialog(null, "NEW CUSTOMER new id="+(nextCid-1));
				cid.setText(Integer.toString(hm.get(p1)));
			}
		}
		else if(e.getSource()==Bill)
		{
			double totalPrice;
			int it1=Integer.parseInt(item_no.getText());
			if(!item.containsKey(it1))
			{
				double price1=Double.parseDouble(JOptionPane.showInputDialog("Enter Price per kg"));
				item.put(it1, price1);
				jt1.append("#"+it1+" "+price1+" perkg ");
				
			}
			else
			{
				double amount=item.get(Integer.parseInt(item_no.getText()));
				int quantity=Integer.parseInt(kg.getText());
				if(!rb1.isSelected()) {
					totalPrice=amount*quantity;
				}
				else {
					totalPrice=amount*quantity-amount*quantity*0.3;
				}
				am.setText("Total Cost="+totalPrice);
			}
		}
	}
}
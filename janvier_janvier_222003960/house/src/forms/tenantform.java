package forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class tenantform implements ActionListener {

	
	    JFrame frame;
	    JLabel tenant_id_label = new JLabel("ID");
	    JLabel names_label = new JLabel("Names");
	    JLabel contact_label = new JLabel("contact");
	    JLabel lease_start_date_label = new JLabel("start date");
	    JLabel monthly_rent_payment_label = new JLabel("monthly rent");

	    JTextField tenant_id_TextField = new JTextField();
	    JTextField names_TextField = new JTextField();
	    JTextField contact_TextField = new JTextField();
	    JTextField lease_start_date_TextField = new JTextField();
	    JTextField monthly_rent_payment_textField = new JTextField();

	    JButton insertButton = new JButton("Insert");
	    JButton readButton = new JButton("Read");
	    JButton updateButton = new JButton("Update");
	    JButton deleteButton = new JButton("Delete");

	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	    public tenantform() {
			 createForm();
	    }

	    private void createForm() {
	        frame = new JFrame();
	        frame.setTitle("TENANT FORM");
	        frame.setBounds(300, 120, 500, 325);
	        frame.getContentPane().setLayout(null);
	        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setResizable(true);
	        setLocationAndSize();
	    }

	    private void setLocationAndSize() {
	        tenant_id_label.setBounds(10, 10, 150, 30);
	        names_label.setBounds(10, 50, 150, 30);
	        contact_label.setBounds(10, 90, 150, 30);
	        lease_start_date_label.setBounds(10, 130, 150, 30);
	       monthly_rent_payment_label.setBounds(10, 170, 150, 30);

	       tenant_id_TextField.setBounds(230, 10, 200, 30);
	        names_TextField.setBounds(230, 50, 200, 30);
	        contact_TextField.setBounds(230, 90, 200, 30);
	        lease_start_date_TextField.setBounds(230, 130, 200, 30);	
	       monthly_rent_payment_textField.setBounds(230, 170, 200, 30);

	        insertButton.setBounds(10, 250, 85, 30);
	        readButton.setBounds(100, 250, 85, 30);
	        updateButton.setBounds(190, 250, 85, 30);
	        deleteButton.setBounds(280, 250, 85, 30);
	        setFontForAll();
	        addComponentsForFrame();
	    }

	    private void setFontForAll() {
	        Font font = new Font("Georgia", Font.BOLD, 18);

	        tenant_id_label.setFont(font);
	        names_label.setFont(font);
	       contact_label.setFont(font);
	       lease_start_date_label.setFont(font);
	        monthly_rent_payment_label.setFont(font);

	        tenant_id_TextField.setFont(font);
	        names_TextField.setFont(font);
	        contact_TextField.setFont(font);
	        lease_start_date_TextField.setFont(font);
	        monthly_rent_payment_textField.setFont(font);

	        Font italicFont = new Font("Georgia", Font.ITALIC, 12);

	        insertButton.setFont(italicFont);
	        readButton.setFont(italicFont);
	        updateButton.setFont(italicFont);
	        deleteButton.setFont(italicFont);
	    }

	    private void addComponentsForFrame() {
	        frame.add(tenant_id_label);
	        frame.add(names_label);
	        frame.add(contact_label);
	        frame.add(lease_start_date_label);
	        frame.add(monthly_rent_payment_label);

	        frame.add(tenant_id_TextField);
	        frame.add(names_TextField);
	        frame.add(contact_TextField);
	        frame.add(lease_start_date_TextField);
	        frame.add(monthly_rent_payment_textField);

	        frame.add(insertButton);
	        frame.add(readButton);
	        frame.add(updateButton);
	        frame.add(deleteButton);

	        insertButton.addActionListener((ActionListener) this);
	insertButton.addActionListener(new ActionListener() {
				  
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");	
						Connection connection=DriverManager
								.getConnection("jdbc:mysql://localhost:3306/braver","root","");
						String query="INSERT INTO tenant VALUES(?,?,?,?,?)";
						PreparedStatement pStatement=connection.prepareStatement(query);
						pStatement.setInt(1,Integer.parseInt(tenant_id_TextField.getText()));
						pStatement.setString(2, names_TextField.getText());
						pStatement.setString(3, contact_TextField.getText());
						pStatement.setString(4, lease_start_date_TextField.getText());
						pStatement.setString(5, monthly_rent_payment_textField.getText());
						pStatement.executeUpdate();
						JOptionPane.showMessageDialog(insertButton, "data inserted well");
						pStatement.close();
						connection.close();	
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
					}
					
				}
			});	
	         readButton.addActionListener((ActionListener) this);
	         updateButton.addActionListener((ActionListener) this);
	         updateButton.addActionListener(new ActionListener() {

	         	public void actionPerformed(java.awt.event.ActionEvent e) {
	         			try {
	         				Class.forName("com.mysql.cj.jdbc.Driver");	
	         				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/braver","root","");
	         				String sql="UPDATE tenant SET  names=?,contact=?,lease_start_date=?, lease_end_date=?,monthly_rent_payment=?  WHERE id=?";
	         				PreparedStatement stm=connection.prepareStatement(sql);
	         			
	         				stm.setString(1, names_TextField.getText());
	         				stm.setString(2, contact_TextField.getText());
	         				stm.setString(3, lease_start_date_TextField.getText());
	         				stm.setString(4, monthly_rent_payment_textField.getText());
	         				stm.setInt(5,Integer.parseInt(tenant_id_TextField.getText()));
	         				
	         				
	         				stm.executeUpdate();
	         				
	         				JOptionPane.showMessageDialog(updateButton, "update data!");
	         				stm.close();
	         				connection.close();	
	         			} catch (Exception e2) {
	         				System.out.println(e2.getMessage());
	         			}
	         			
	         		}
	         				});
	        deleteButton.addActionListener((ActionListener) this);
	deleteButton.addActionListener(new ActionListener() {
	        	
	        	
	        	public void actionPerformed(java.awt.event.ActionEvent e) {
	        		try {
	        			Class.forName("com.mysql.cj.jdbc.Driver");	
	        			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/braver","root","");
	        			String sql="DELETE FROM tenant  WHERE id=?";
	        			int brtxf=Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete:"));
	        			
	        			
	        			PreparedStatement stm=connection.prepareStatement(sql);
	        			
	        			
	        			
	        			
	        			stm.setInt(1,brtxf);
	        			
	        			JOptionPane.showMessageDialog(deleteButton, "recorded out!!!!!!!!!");
	        			//Component delete;
	        			stm.executeUpdate();
	        			stm.close();
	        			
	        			connection.close();	
	        		} catch (Exception e2) {
	        			System.out.println(e2.getMessage());
	        		}
	        		
	        	}
	        });
	    }

	    public static void main(String[] args) {
	        new tenantform();
	    }

	    public void actionPerformed(ActionEvent e) {
	       
	    }
}

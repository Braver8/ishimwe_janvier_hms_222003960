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

public class landlordform implements ActionListener {

	
	    JFrame frame;
	    JLabel landlord_id_label = new JLabel("ID");
	    JLabel names_label = new JLabel("Names");
	    JLabel identity_number_label = new JLabel("Identity Number");
	    JLabel contact_label = new JLabel("Contact");
	    JLabel bank_account_label = new JLabel("Bank Account");

	    JTextField landlord_id_TextField = new JTextField();
	    JTextField names_TextField = new JTextField();
	    JTextField identity_number_TextField = new JTextField();
	    JTextField contact_TextField = new JTextField();
	    JTextField bank_account_TextField = new JTextField();

	    JButton insertButton = new JButton("Insert");
	    JButton readButton = new JButton("Read");
	    JButton updateButton = new JButton("Update");
	    JButton deleteButton = new JButton("Delete");

	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	    public landlordform() {
			 createForm();
	    }

	    private void createForm() {
	        frame = new JFrame();
	        frame.setTitle("LANDLORD FORM");
	        frame.setBounds(300, 120, 500, 325);
	        frame.getContentPane().setLayout(null);
	        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setResizable(true);
	        setLocationAndSize();
	    }

	    private void setLocationAndSize() {
	        landlord_id_label.setBounds(10, 10, 150, 30);
	        names_label.setBounds(10, 50, 150, 30);
	        identity_number_label.setBounds(10, 90, 150, 30);
	        contact_label.setBounds(10, 130, 150, 30);
	        bank_account_label.setBounds(10, 170, 150, 30);

	        landlord_id_TextField.setBounds(230, 10, 200, 30);
	        names_TextField.setBounds(230, 50, 200, 30);
	        identity_number_TextField.setBounds(230, 90, 200, 30);
	        contact_TextField.setBounds(230, 130, 200, 30);
	        bank_account_TextField.setBounds(230, 170, 200, 30);

	        insertButton.setBounds(10, 250, 85, 30);
	        readButton.setBounds(100, 250, 85, 30);
	        updateButton.setBounds(190, 250, 85, 30);
	        deleteButton.setBounds(280, 250, 85, 30);
	        setFontForAll();
	        addComponentsForFrame();
	    }

	    private void setFontForAll() {
	        Font font = new Font("Georgia", Font.BOLD, 18);

	        landlord_id_label.setFont(font);
	        names_label.setFont(font);
	        identity_number_label.setFont(font);
	        contact_label.setFont(font);
	        bank_account_label.setFont(font);

	        landlord_id_TextField.setFont(font);
	        names_TextField.setFont(font);
	        identity_number_TextField.setFont(font);
	        contact_TextField.setFont(font);
	        bank_account_TextField.setFont(font);

	        Font italicFont = new Font("Georgia", Font.ITALIC, 12);

	        insertButton.setFont(italicFont);
	        readButton.setFont(italicFont);
	        updateButton.setFont(italicFont);
	        deleteButton.setFont(italicFont);
	    }

	    private void addComponentsForFrame() {
	        frame.add(landlord_id_label);
	        frame.add(names_label);
	        frame.add(identity_number_label);
	        frame.add(contact_label);
	        frame.add(bank_account_label);

	        frame.add(landlord_id_TextField);
	        frame.add(names_TextField);
	        frame.add(identity_number_TextField);
	        frame.add(contact_TextField);
	        frame.add(bank_account_TextField);

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
						String query="INSERT INTO landlord VALUES(?,?,?,?,?)";
						PreparedStatement pStatement=connection.prepareStatement(query);
						pStatement.setInt(1,Integer.parseInt(landlord_id_TextField.getText()));
						pStatement.setString(2, names_TextField.getText());
						pStatement.setString(3, identity_number_TextField.getText());
						pStatement.setString(4, contact_TextField.getText());
						pStatement.setString(5, bank_account_TextField.getText());
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
	         				String sql="UPDATE landlord SET  names=?,identity_number=?,contact=?, bank_account=?  WHERE id=?";
	         				PreparedStatement stm=connection.prepareStatement(sql);
	         			
	         				stm.setString(1, names_TextField.getText());
	         				stm.setString(2, identity_number_TextField.getText());
	         				stm.setString(3, contact_TextField.getText());
	         				stm.setString(4, bank_account_TextField.getText());
	         				stm.setInt(5,Integer.parseInt(landlord_id_TextField.getText()));
	         				
	         				
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
	        			String sql="DELETE FROM landlord  WHERE id=?";
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
	        new landlordform();
	    }

	    public void actionPerformed(ActionEvent e) {
	       
	    }
}

package classs;

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

public class propertyform implements ActionListener {

	
	    JFrame frame;
	    JLabel property_id_label = new JLabel("ID");
	    JLabel adress_label = new JLabel("adress");
	    JLabel type_label = new JLabel("type");
	    JLabel bedroom_number_label = new JLabel("number of bedrooms");
	    JLabel availability_status_label = new JLabel("availability status");

	    JTextField property_id_TextField = new JTextField();
	    JTextField adress_TextField = new JTextField();
	    JTextField type_TextField = new JTextField();
	    JTextField bedroom_number_TextField = new JTextField();
	    JTextField availability_status_textField = new JTextField();

	    JButton insertButton = new JButton("Insert");
	    JButton readButton = new JButton("Read");
	    JButton updateButton = new JButton("Update");
	    JButton deleteButton = new JButton("Delete");

	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	    public propertyform() {
			 createForm();
	    }

	    private void createForm() {
	        frame = new JFrame();
	        frame.setTitle("PROPERTY FORM");
	        frame.setBounds(300, 120, 500, 325);
	        frame.getContentPane().setLayout(null);
	        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setResizable(true);
	        setLocationAndSize();
	    }

	    private void setLocationAndSize() {
	        property_id_label.setBounds(10, 10, 150, 30);
	        adress_label.setBounds(10, 50, 150, 30);
	        type_label.setBounds(10, 90, 150, 30);
	        bedroom_number_label.setBounds(10, 130, 150, 30);
	       availability_status_label.setBounds(10, 170, 150, 30);

	       property_id_TextField.setBounds(230, 10, 200, 30);
	        adress_TextField.setBounds(230, 50, 200, 30);
	        type_TextField.setBounds(230, 90, 200, 30);
	        bedroom_number_TextField.setBounds(230, 130, 200, 30);
	       availability_status_textField.setBounds(230, 170, 200, 30);

	        insertButton.setBounds(10, 250, 85, 30);
	        readButton.setBounds(100, 250, 85, 30);
	        updateButton.setBounds(190, 250, 85, 30);
	        deleteButton.setBounds(280, 250, 85, 30);
	        setFontForAll();
	        addComponentsForFrame();
	    }

	    private void setFontForAll() {
	        Font font = new Font("Georgia", Font.BOLD, 18);

	        property_id_label.setFont(font);
	        adress_label.setFont(font);
	       type_label.setFont(font);
	       bedroom_number_label.setFont(font);
	        availability_status_label.setFont(font);

	        property_id_TextField.setFont(font);
	        adress_TextField.setFont(font);
	        type_TextField.setFont(font);
	        bedroom_number_TextField.setFont(font);
	        availability_status_textField.setFont(font);

	        Font italicFont = new Font("Georgia", Font.ITALIC, 12);

	        insertButton.setFont(italicFont);
	        readButton.setFont(italicFont);
	        updateButton.setFont(italicFont);
	        deleteButton.setFont(italicFont);
	    }

	    private void addComponentsForFrame() {
	        frame.add(property_id_label);
	        frame.add(adress_label);
	        frame.add(type_label);
	        frame.add(bedroom_number_label);
	        frame.add(availability_status_label);

	        frame.add(property_id_TextField);
	        frame.add(adress_TextField);
	        frame.add(type_TextField);
	        frame.add(bedroom_number_TextField);
	        frame.add(availability_status_textField);

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
						String query="INSERT INTO property VALUES(?,?,?,?,?)";
						PreparedStatement pStatement=connection.prepareStatement(query);
						pStatement.setInt(1,Integer.parseInt(property_id_TextField.getText()));
						pStatement.setString(2, adress_TextField.getText());
						pStatement.setString(3, type_TextField.getText());
						pStatement.setString(4, bedroom_number_TextField.getText());
						pStatement.setString(5, availability_status_textField.getText());
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
	         				String sql="UPDATE property SET  adress=?,type=?,bedroom_number=?, monthly_payment=?,availability_status=?  WHERE id=?";
	         				PreparedStatement stm=connection.prepareStatement(sql);
	         			
	         				stm.setString(1, adress_TextField.getText());
	         				stm.setString(2, type_TextField.getText());
	         				stm.setString(3, bedroom_number_TextField.getText());
	         				stm.setString(4, availability_status_textField.getText());
	         				stm.setInt(5,Integer.parseInt(property_id_TextField.getText()));
	         				
	         				
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
	        			String sql="DELETE FROM property  WHERE id=?";
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
	        new propertyform();
	    }

	    public void actionPerformed(ActionEvent e) {
	       
	    }
}

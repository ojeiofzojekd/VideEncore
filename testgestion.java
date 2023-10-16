package work;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class testgestion extends JFrame implements ActionListener {
	static JFrame fenetre = new JFrame("Nouveau projet");
	static JButton button;
	static JButton delete_but;
	static JButton update_but;
	static int id_sav;
	static String nom;
	static String pren;
	static String tel;
	static String date;
	static String num_tic;
	static String etat_tic;
	static String decla;
	static DefaultTableModel newmodel = new DefaultTableModel(); 
    static JTable table = new JTable(newmodel);
    static JTextField a; 
    static JTextField b;
    static JTextField c;
    static JTextField d;
    static String[] ticket_choices;
    static JComboBox<String> tc;
 
    
    public static void delete() {
    	
    delete_but = new JButton();
    
    delete_but.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==delete_but) {
				{
		    		String url = "jdbc:mysql://localhost:8889/iPomme";
		    		String username = "new";
		    		String password= "new";
		    		int idRow = table.getSelectedRow();
		            int idUser = (int) table.getValueAt(idRow, 0);
		        	try
		        	
		            {

			        System.out.println(idRow);
			        System.out.println(idUser);
		     	
			                
		            Class.forName("com.mysql.cj.jdbc.Driver"); 
		            Connection conn = DriverManager.getConnection(url, username, password);
		            PreparedStatement st = conn.prepareStatement("DELETE FROM SAV WHERE ID_Sav =" + idUser);
		            
		            st.executeUpdate();
		            
		            

		            
		              conn.close();
		            }
		        	
		        	catch (Exception e1) {
		        		System.out.println(e1);
		        	}
		        	};
			}
			
		}

	});
    
	delete_but.setText("GOKU");
	delete_but.setBounds(40, 20 ,20,20);
	delete_but.setVisible(true);
    delete_but.setForeground(Color.BLUE);
    delete_but.setBackground(Color.BLUE);
    
    fenetre.add(delete_but);

    }
	
	public static void add() {
		
		Random rand = new Random(); 
	    int rand_tic = rand.nextInt(1000);
		button = new JButton();
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==button) {
					{
			    		String url = "jdbc:mysql://localhost:8889/iPomme";
			    		String username = "new";
			    		String password= "new";
			    		
			        	try
			        	
			            {
			        		
			        		String prenomField = a.getText();
				            String nomField = b.getText();
				            String numField = c.getText();
				            String dateField = d.getText();
				           
							String choiceField = (String)tc.getSelectedItem();
				            
				        
				            System.out.println(nomField);
				            System.out.println(prenomField);
				            System.out.println(numField);
				            System.out.println(dateField);
				            System.out.println(choiceField);
				            
				                
			            Class.forName("com.mysql.cj.jdbc.Driver"); 
			            Connection conn = DriverManager.getConnection(url, username, password);
			            Statement stmt = conn.createStatement();
			            String sql = "INSERT INTO SAV (ID_SAV, Prenom, Nom, Telephone, Date, Num_ticket, Etat_tic, Declaration) VALUES (NULL,'" + prenomField +  "', '"+ nomField + "','" + numField + "','" + dateField + "', "+ rand_tic + ", '"+ choiceField +"', 'RETOUR');";
			            stmt.executeUpdate(sql);
			            
			            

			            
			              conn.close();
			            }
			        	
			        	catch (Exception e1) {
			        		System.out.println(e1);
			        	}
			        	};
				}
				
			}

		});
		button.setText("Ajoutez Ticket");
		button.setBounds(2, 20 ,20,20);
		button.setVisible(true);
        button.setForeground(Color.BLUE);
        button.setBackground(Color.BLUE);
        
        fenetre.add(button);
         
         
	}

	public static void update() {
		
		update_but = new JButton();
	     
	    update_but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==update_but) {
					{
			    		String url = "jdbc:mysql://localhost:8889/iPomme";
			    		String username = "new";
			    		String password= "new";
			    		
			    		
			    		int idRow = table.getSelectedRow();
			            int idUser = (int) table.getValueAt(idRow, 0);
			            
			            String prenRow = (String) table.getValueAt(idRow, 1);
			            String nomRow = (String) table.getValueAt(idRow, 2);
			            String telRow = (String) table.getValueAt(idRow, 3);
			            String dateRow = (String) table.getValueAt(idRow, 4);
			           
			          
			        	try
			        	
			            {
		
				                	
			            Class.forName("com.mysql.cj.jdbc.Driver"); 
			            Connection conn = DriverManager.getConnection(url, username, password);
			            PreparedStatement st = conn.prepareStatement("UPDATE SAV SET Prenom = '"+ prenRow + "', Nom = '" + nomRow + "', Telephone = '" + telRow + "', Date = '" + dateRow + "' WHERE ID_Sav =" + idUser);
			            
			            st.executeUpdate();
			            
			            System.out.println(prenRow);
			            System.out.println(idRow);
			            System.out.println(idUser);
			            
			            
			              conn.close();
			            }
			        	
			        	catch (Exception e1) {
			        		System.out.println(e1);
			        	}
			        	};
				}
				
			}

		});
	    
		update_but.setText("GOKU");
		update_but.setBounds(80, 20 ,20,20);
		update_but.setVisible(true);
	    update_but.setForeground(Color.BLUE);
	    update_but.setBackground(Color.BLUE);
	    
	    fenetre.add(update_but);

	}
    private static final long serialVersionUID = 1L;

	public static void main(String[] agrs) {
		

		table.setBounds(30, 360, 800, 100);
	    newmodel.addColumn("ID");
	    newmodel.addColumn("Nom"); 
	    newmodel.addColumn("Prénom"); 
	    newmodel.addColumn("Téléphone"); 
	    newmodel.addColumn("Numéro de ticket"); 
	    newmodel.addColumn("Date"); 
	    newmodel.addColumn("Etat du ticket"); 
	    newmodel.addColumn("Declaration");
	    
	  
	    
	    {
     		String url = "jdbc:mysql://localhost:8889/iPomme";
     		String username = "new";
     		String password= "new";
     		
         	try
         	
             {
             Class.forName("com.mysql.cj.jdbc.Driver"); 
             Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet res = stmt.executeQuery("SELECT * FROM SAV");
             
             while(res.next()) {
             	id_sav = res.getInt(1);
             	nom = res.getString(2);
             	pren = res.getString(3);
             	tel = res.getString(4);
                 date = res.getString(5);
                 num_tic = res.getString(6);
                 etat_tic = res.getString(7);
                 decla = res.getString(8);
                 
 				newmodel.addRow(new Object[]{id_sav, nom, pren, tel, date, num_tic, etat_tic, decla});
                 
                 
             }
               conn.close();
             }
         	
         	catch (Exception e1) {
         		System.out.println(e1);
         	}
         	};
	
		add();
		delete();
		update();
	

        JButton btn = new JButton("Cliquez ici");
        JButton delete_button = new JButton("Supprimez");
        JLabel nom = new JLabel("Prenom");
        nom.setBounds(30,40,200,30);

        a = new JTextField("");
        a.setBounds(130,40,200,25);

        JLabel prenom = new JLabel("Nom");
                prenom.setBounds(30,80,200,30);

                b = new JTextField("");
                b.setBounds(130,80,200,25);

                JLabel tel = new JLabel("Téléphone");
                tel.setBounds(30,120,200,30);

                c = new JTextField("");
                c.setBounds(130,120,200,25);
               
                JLabel date = new JLabel("Date :");
                date.setBounds(30,160,200,30);
                
                d = new JTextField("");
                d.setBounds(130,160,200,25);
                
                JLabel ticket = new JLabel("Numéro de ticket :");
                ticket.setBounds(30,200,200,30);
                
                JTextField e = new JTextField("");
                e.setBounds(150,200,200,25);
                
                JLabel etat_ticket = new JLabel("État du ticket :");
                etat_ticket.setBounds(30,240,160,30);
                
                String[] ticket_choices = { "NOUVEAU","EN COURS", "FERMER"};
                System.out.println(ticket_choices.length);
        	    

                tc = new JComboBox<String>(ticket_choices);
                tc.setVisible(true);    
                tc.setBounds(120,240,240,30);
                
                JLabel deroulant = new JLabel("Déclaration : ");
                deroulant.setBounds(30,280,200,30);
                deroulant.setVisible(true);

                String[] choices = { "RETOUR","MAINTENANCE", "RÉPARATION"};

                final JComboBox<String> cb = new JComboBox<String>(choices);
                cb.setVisible(true);    
                cb.setBounds(120,280,240,30);
     


                btn.setBounds(30, 320,200,30);
                btn.setForeground(Color.BLUE);
                btn.setBackground(Color.BLUE);
                delete_button.setBounds(300, 320,200,30);
                delete_button.setForeground(Color.RED);
                delete_button.setBackground(Color.RED);
              
                JScrollPane scroll = new JScrollPane(table);
                table.setFillsViewportHeight(true);
                

                fenetre.add(nom);
                fenetre.add(prenom);
                fenetre.add(tel);
                fenetre.add(date);
                fenetre.add(ticket);
                fenetre.add(etat_ticket);
                fenetre.add(btn);
                fenetre.add(delete_button);
                fenetre.add(a);
                fenetre.add(b);
                fenetre.add(c);
                fenetre.add(d);
                fenetre.add(e);
                fenetre.getContentPane().add(scroll);
                fenetre.add(table);
                fenetre.add(deroulant);
                fenetre.add(cb);
                fenetre.add(tc);
                
             
                

                fenetre.setSize(500, 500);
                fenetre.setLayout(null);
                fenetre.setVisible(true);
                scroll.setVisible(true);
                
               

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}


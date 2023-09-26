package work;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.sql.*;


import java.awt.*;


public class testgestion extends JFrame {
    
    
    private static final long serialVersionUID = 1L;

	public static void main(String[] agrs) {
                JFrame fenetre = new JFrame("Nouveau projet");
                JButton btn = new JButton("Cliquez ici");
                JButton delete_button = new JButton("Supprimez");
                System.out.println("Ok");
                {
            		String url = "jdbc:mysql://localhost:8889/iPomme";
            		String username = "new";
            		String password="new";
            		
                	try
                	
                    {
                    Class.forName("com.mysql.cj.jdbc.Driver"); 
                    Connection conn = DriverManager.getConnection(url, username, password);
                    Statement stmt = conn.createStatement();
                    ResultSet res = stmt.executeQuery("SELECT * FROM User");
                    
                    while(res.next()) {
                        System.out.println(res.getInt(1)+"  "+res.getString(2)
                        +"  "+res.getString(3));
                    }
                      conn.close();
                    }
                	
                	catch (Exception e) {
                		System.out.println(e);
                	}
                	}


                String[] colonne = new String[] {
                    "Nom", 
                    "Prenom", 
                    "Telephone"
                };

                    Object[][] data = new Object[][] {
                        {"Nom", "Prénom", "Numéro"}
                    };
                    
            
                
                JTable table = new JTable (data, colonne);
                table.setBounds(30, 360, 500, 100);

                JLabel nom = new JLabel("Nom");
                nom.setBounds(30,40,200,30);

                JTextField a = new JTextField("");
                a.setBounds(130,40,200,25);

                JLabel prenom = new JLabel("Prénom");
                prenom.setBounds(30,80,200,30);

                JTextField b = new JTextField("");
                b.setBounds(130,80,200,25);

                JLabel tel = new JLabel("Téléphone");
                tel.setBounds(30,120,200,30);

                JTextField c = new JTextField("");
                c.setBounds(130,120,200,25);
               
                JLabel date = new JLabel("Date :");
                date.setBounds(30,160,200,30);
                
                JTextField d = new JTextField("");
                d.setBounds(130,160,200,25);
                
                JLabel ticket = new JLabel("Numéro de ticket :");
                ticket.setBounds(30,200,200,30);
                
                JTextField e = new JTextField("");
                e.setBounds(150,200,200,25);
                
                JLabel etat_ticket = new JLabel("État du ticket :");
                etat_ticket.setBounds(30,240,160,30);
                
                String[] ticket_choices = { "NOUVEAU","EN COURS", "FERMER"};

                final JComboBox<String> tc = new JComboBox<String>(ticket_choices);
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
	

}


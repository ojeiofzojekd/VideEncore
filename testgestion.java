package work;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import work.bjrorv.*;
import work.myButton.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class testgestion extends JFrame implements ActionListener {
	static JFrame fenetre = new JFrame("Nouveau projet");
	static JButton button;
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
    
	
	public static void test() {
	
		button = new JButton();
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==button) {
					
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
	
		test();
		bjrorv goku = new bjrorv();
		goku.Aurevoir();
		
		myButton button = new myButton();
		button.test();
	
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
                
                System.out.println(decla);
            }
              conn.close();
            }
        	
        	catch (Exception e1) {
        		System.out.println(e1);
        	}
        	};
		
		
		
                
                JButton btn = new JButton("Cliquez ici");
                JButton delete_button = new JButton("Supprimez");
                System.out.println("Ok");
                
             
               
             
                
                
                
                

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}


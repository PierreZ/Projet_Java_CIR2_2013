import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Arrays;

public class identification  extends JFrame{
	 private JTextField textloginbdd=new JTextField("conges");
	 private JPasswordField textmdpbdd=new JPasswordField("conges");
 	 private JTextField texturl= new JTextField("127.0.0.1/conges");
	 private JTextField textLogin = new JTextField(20);
	 private JPasswordField textmdp = new JPasswordField(20); 
	 public String login="";
	 public String url="";
	 public String mdp="";
	 public String loginbdd="";
	 public String mdpbdd="";
	 public JButton connexion;
	 public int solde;
	 
	public identification(){
		super ("Login");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//On dit à l'application de se fermer lors du clic sur la croix
		setSize(400,200); 
		setResizable(false);; //On interdit la redimensionnement de la fenêtre
		setLocationRelativeTo(null);//On centre la fenêtre sur l'écran
		
		JPanel nord = new JPanel();
	    add(nord, BorderLayout.NORTH);	
	    JPanel labels = new JPanel();
	    nord.setLayout(new BorderLayout());
	    nord.add(labels, BorderLayout.WEST);
	    
	    labels.setLayout(new GridLayout(6, 0));
	    labels.add(new JLabel("Nom de login :"));
	    labels.add(new JLabel("Mot de passe :"));
	    labels.add(new JLabel("Url de la bdd :"));
	    labels.add(new JLabel("Login de la bdd :"));
	    labels.add(new JLabel("Passe de la bdd :"));
	    
	    JPanel saisies = new JPanel();
	    nord.add(saisies, BorderLayout.CENTER);
	    
	    saisies.setLayout(new GridLayout(6, 0));
	    saisies.add(textLogin);
	    saisies.add(textmdp);
	    saisies.add(texturl);
	    saisies.add(textloginbdd);
	    saisies.add(textmdpbdd);
	    
	    JButton connexion = new JButton("Connexion");
	    nord.add(connexion, BorderLayout.SOUTH);
	    connexion.addActionListener(new BoutonListener());
	    setVisible(true);


	}

	/*public String getLogin(){
		
		//login = String.parseString(textLogin.getText()) ; 
		this.connexion.addActionListener();		
	
		
	return login;	
	}
	
		*/	


class BoutonListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		mdp=textmdp.getText();
		login=textLogin.getText();
		url=texturl.getText();
		loginbdd=textloginbdd.getText();
		mdpbdd=textmdpbdd.getText();
		System.out.println(mdp);
		System.out.println(login);
		System.out.println(url);
		System.out.println("*********************************************************************");
		jdbc jdbc =new jdbc();
		jdbc.url=url;
		jdbc.user=loginbdd;
		jdbc.passwd=mdpbdd;
		if(jdbc.testconnexion(login, mdp)==true){
			setVisible(false);
			solde=jdbc.retourSolde(login);
			JFrame f =new JFrame();
			DatePicker cal=new DatePicker(f,login,solde);

									
		}
	}
}

}


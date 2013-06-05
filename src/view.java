import javax.swing.JFrame;
import javax.swing.JPanel;



public class view extends JFrame {

	public view() {
		super();
		 
		build();
	}
	private void build(){
		
		setTitle("Mon calendrier");
		setSize(1500,800); 
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix		
		JFrame f =new JFrame();
		DatePicker cal=new DatePicker(f);
		//Cal cal = new Cal();
		
		
		
	}
	
	
}

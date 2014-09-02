import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;












public class Keyboard extends JPanel implements MouseListener {
	
    static BufferedReader in;
    static PrintWriter out;
    private static final int PORT = 9001;
    private static final String SERVER_ADDRESS = "10.0.0.16";
    static Socket socket;
    
	private String[] layer3b={"!","@","#","$","%","^","&","*","(",")"};
	private String[] layer3={"1","2","3","4","5","6","7","8","9","0"};
	private String[] layer2={"q","w","e","r","t","y","u","i","o","p"};
	private String[] layer1={"a","s","d","f","g","h","j","k","l"};
	private String[] layer0={"z","x","c","v","b","n","m","shift"};
	private String[] layer_1={"backspace","space","enter","clear"};
	ArrayList<JButton> buttonlist = new ArrayList();
	JButton pressed_key=null;
	static TextField keyboard_entry;
	Timer timer;

	private static String key_pressed="";
	static int time_delay = 800;
	
	
	
	public Keyboard(){
		
		String[][] layers ={layer3,layer2,layer1,layer0,layer_1};
		GridLayout experimentLayout =new GridLayout(layers.length+1,1);
		this.setLayout(experimentLayout);
		keyboard_entry= new TextField("", 20);
		//keyboard_entry.addMouseListener(this);
		this.add(keyboard_entry);
		
		for(int i = 0; i<layers.length;i++){
			JPanel layer_panel = createLayerPanel(layers[i]);
			this.add(layer_panel);
			
		}
		timer = new Timer(time_delay, taskPerformer);
		 
		
	}
	  
	private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("Keyboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        Keyboard newContentPane = new Keyboard();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
        
    }
	
	public static void createSocket() throws UnknownHostException, IOException{
        //String serverAddress = getServerAddress();
        socket = new Socket(SERVER_ADDRESS, PORT);
        //in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        out.println("keyboard");
        while (true) {
            String line = in.readLine();
            if (line.startsWith("NAMEACCEPTED")) {
            	keyboard_entry.setEditable(true);
            	break;
            } 
        }
		
	}
	
    
    public JPanel createLayerPanel(String [] keys){
    	JPanel layer1_panel = new JPanel();
    	layer1_panel.setLayout(new GridLayout(1,keys.length));
    	
    	for(int i =0;i<keys.length;i++){
    		String key = keys[i];
    		JButton button = new JButton(key);
    		button.addMouseListener(this);
    		//button.addActionListener(this);
    		layer1_panel.add(button);
    		buttonlist.add(button);
    	}
    	
		return layer1_panel;
    	
    }
    




	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		for(int i =0;i<buttonlist.size();i++){
			JButton button = buttonlist.get(i);
			
			button.setEnabled(true);
			if(button==arg0.getSource()){
			
			
			key_pressed=button.getText();
			
			//timer.start();
			
			
			}
		}
		timer.restart();
		/*
		 timer = new Timer(speed, this);
		timer.setInitialDelay(pause);
		timer.start(); 
		 * */
	}
	
	ActionListener taskPerformer = new ActionListener() {
	      public void actionPerformed(ActionEvent evt) {
	          //...Perform a task...
	    	  //System.out.print(key_pressed);
	    	  for(int i =0;i<buttonlist.size();i++){
		  			JButton button = buttonlist.get(i);
		  			if(button.getText()==key_pressed){
		  				button.setEnabled(false);
		  			
		  			
		  			//key_pressed=button.getText();
		  			
		  			//timer.start();
		  			//timer.restart();
		  			
		  			}
		  		}
	    	  
	    	  String text_string = keyboard_entry.getText();
	    	  if(key_pressed.equalsIgnoreCase("clear")){
	    		  keyboard_entry.setText("");
	    		  
	    	  } else if(key_pressed.equalsIgnoreCase("backspace")){
	    		  text_string=text_string.substring(0,Math.max(0,text_string.length()-1 ) );
	    		  keyboard_entry.setText(text_string);
	    		  
	    	  }else if(key_pressed.equalsIgnoreCase("space")){
	    		  text_string=text_string+" ";
	    		  keyboard_entry.setText(text_string);
	    		  
	    	  }else if(key_pressed.equalsIgnoreCase("shift")){

	    		  
	    	  }else if(key_pressed.equalsIgnoreCase("enter")){

	                out.println(keyboard_entry.getText()+"\n");
	                keyboard_entry.setText("");
	    	  } else{
	    	  
	    	  text_string=text_string+key_pressed;
	    	  keyboard_entry.setText(text_string);
	    	  
	    	  }
	    	  keyboard_entry.setCaretPosition(text_string.length());
	    	  timer.stop();
	    	  //System.out.println("taskperformer");
	    	  //timer = new Timer(time_delay, taskPerformer);
	      }
	  };

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		key_pressed="";
		timer.stop();
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		//System.out.print("highlighted");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
                try {
					createSocket();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
            }
        });
    }
}
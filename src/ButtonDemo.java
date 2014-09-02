/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 



import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/* 
 * ButtonDemo.java requires the following files:
 *   images/right.gif
 *   images/middle.gif
 *   images/left.gif
 */
public class ButtonDemo extends JPanel
                        implements ActionListener {
    //protected JButton b1, b2, b3;
    protected JButton[] letter_keys;
    protected String[] layer0={"Backspace","Enter","Clear"};
    protected String[] layer1a={".com","!","@","#","_","(",")",",","."};
    protected char[] layer1={'q','w','e','r','t','y','u','i','o','p'};
    protected char[] layer2={'a','s','d','f','g','h','j','k','l'};
    protected char[] layer3={'z','x','c','v','b','n','m'};
    protected String[] layer4={"Space"};
    //protected String[] layer0={"Backspace","Enter","Clear"};
    //protected char[] layer1={'k','w','b','t','e','n','o','l','q'};
    //protected char[] layer2={'y','d','a','s','c','i','f','j','x'};
    //protected char[] layer3={'v','g','m', 'p' ,'h','r','u','z'};
    TextField keyboard_entry;
    public ButtonDemo() {
    	
    	 // a blank text field
    	keyboard_entry= new TextField("    ", 20);
    	GridLayout experimentLayout =new GridLayout(5,1);
    	this.setLayout(experimentLayout);
    	//this.setLayout(new BorderLayout());
    	//this.setMaximumSize( this.getPreferredSize() );
    	//letter_keys=new JButton[26];
    	
    	int index = 0;
    	JPanel layer1_panel = new JPanel();
    	layer1_panel.setLayout(new GridLayout(1,layer1.length));
    	//layer1_panel.setMaximumSize(this.getPreferredSize());
    	for(int i = 0; i<layer1.length;i++){
    		char c = layer1[i];
    		JButton button = new JButton(""+Character.toUpperCase(c));
    		//button.setMaximumSize(this.getSize());
    		//button.setMaximumSize(button.getPreferredSize());
        	button.addActionListener(this);
    		//letter_keys[index]=button;
    		layer1_panel.add(button);
    		index = index +1;
    	}
    	
    	JPanel layer1a_panel = new JPanel();
    	layer1_panel.setLayout(new GridLayout(1,layer1a.length));
    	//layer1_panel.setMaximumSize(this.getPreferredSize());
    	for(int i = 0; i<layer1a.length;i++){
    		String c = layer1a[i];
    		JButton button = new JButton(c.toUpperCase());
    		//button.setMaximumSize(this.getSize());
    		//button.setMaximumSize(button.getPreferredSize());
        	button.addActionListener(this);
    		//letter_keys[index]=button;
    		layer1a_panel.add(button);
    		index = index +1;
    	}
    	
    	JPanel layer2_panel = new JPanel();
    	layer2_panel.setLayout(new GridLayout(1,layer2.length));
    	for(int i = 0; i<layer2.length;i++){
    		char c = layer2[i];
    		JButton button = new JButton(""+Character.toUpperCase(c));
        	button.addActionListener(this);
    		//letter_keys[index]=button;
    		layer2_panel.add(button);
    		index = index +1;
    	}
    	
    	JPanel layer3_panel = new JPanel();
    	layer3_panel.setLayout(new GridLayout(1,layer3.length));
    	for(int i = 0; i<layer3.length;i++){
    		char c = layer3[i];
    		JButton button = new JButton(""+Character.toUpperCase(c));
        	button.addActionListener(this);
    		//letter_keys[index]=button;
    		layer3_panel.add(button);
    		index = index +1;
    	}
    	this.add(keyboard_entry);
    	this.add(layer1a_panel);
    	this.add(layer1_panel);
    	this.add(layer2_panel);
    	this.add(layer3_panel);
    }

    public void actionPerformed(ActionEvent e) {

    }


    /**
     * Create the GUI and show it.  For thread safety, 
     * this method should be invoked from the 
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("ButtonDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        ButtonDemo newContentPane = new ButtonDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        //frame.add(newContentPane);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }
}

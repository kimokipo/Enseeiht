
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Destination;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.IllegalStateException;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Irc {
	public static TextArea		text;
	public static TextField		data;
	public static Frame 		frame;

	public static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	public static String subject = "MyQueue";

	public static Vector<String> users;
	public static String myName;

	public static ConnectionFactory	connectionFactory;
	public static Connection       	connection;
	public static Session		session;
	public static MessageConsumer	consumer;
	public static MessageProducer	producer;
	public static Destination	destination;
	public static Topic		topic;

	public static void main(String argv[]) {
        
		if (argv.length != 1) {
			System.out.println("java Irc <name>");
			return;
		}
		myName = argv[0];

		// creation of the GUI 
		frame=new Frame();
		frame.setLayout(new FlowLayout());

		text=new TextArea(10,55);
		text.setEditable(false);
		text.setForeground(Color.red);
		frame.add(text);

		data=new TextField(55);
		frame.add(data);

		Button write_button = new Button("write");
		write_button.addActionListener(new writeListener());
		frame.add(write_button);

		Button connect_button = new Button("connect");
		connect_button.addActionListener(new connectListener());
		frame.add(connect_button);

		Button who_button = new Button("who");
		who_button.addActionListener(new whoListener());
		frame.add(who_button);

		Button leave_button = new Button("leave");
		leave_button.addActionListener(new leaveListener());
		frame.add(leave_button);

		frame.setSize(470,300);
		text.setBackground(Color.black); 
		frame.setVisible(true);
		
		   
		
	}

	/* allow to print something in the window */
	public static void print(String msg) {
		try {
			text.append(msg+"\n");
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}
}

class Listener implements MessageListener {
    
    public void onMessage(Message msg) {
            			try {
            			    StreamMessage smsg = (StreamMessage)msg;
		                    String entete = smsg.readString();
                            if (entete.equals("afficher")){
                                String textmsg = smsg.readString();
                                String nom = textmsg.split(" ")[0];
                                if (!Irc.users.contains(nom)){
                                    Irc.users.add(nom);
                                }
        				        Irc.print(textmsg);
        				    }else if (entete.equals("connecter")){
                                String textmsg = smsg.readString();
                                String nom = textmsg.split(" ")[0];
                                if (!Irc.users.contains(nom)){
                                    Irc.users.add(nom);
                                }
                                StreamMessage message = Irc.session.createStreamMessage();
		                        message.writeString("ajouter");
	                            message.writeString(Irc.myName+" .");
		                        Irc.producer.send(message);
		                        Thread.sleep(1000);
        				        Irc.print(textmsg);
        				    }else if (entete.equals("qui")){
                                String nom = smsg.readString();
                                String textmsg = smsg.readString();
                                if (nom.equals(Irc.myName)){
                                    Irc.print(textmsg);
                                }
        				    }else if (entete.equals("quitter")){
                                String textmsg = smsg.readString();
                                String nom = textmsg.split(" ")[0];
                                if (Irc.users.contains(nom)){
                                    Irc.users.remove(nom);
                                }
        				        Irc.print(textmsg);
        				    }else if (entete.equals("ajouter")){
                                String textmsg = smsg.readString();
                                String nom = textmsg.split(" ")[0];
                                if (!Irc.users.contains(nom)){
                                    Irc.users.add(nom);
                                }
        				    }
        			} catch (Exception ex) {
        				ex.printStackTrace();
        			}
            		}
}

// action invoked when the "write" button is clicked
class writeListener implements ActionListener {
	public void actionPerformed (ActionEvent ae) {
		try {
		    try{
		        StreamMessage message = Irc.session.createStreamMessage();
		        message.writeString("afficher");
	            message.writeString(Irc.myName+" : "+Irc.data.getText());
		        Irc.producer.send(message);
		        Thread.sleep(1000);
		     }catch (IllegalStateException | NullPointerException e){
		     }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

// action invoked when the "connect" button is clicked
class connectListener implements ActionListener {
	public void actionPerformed (ActionEvent ae) {
		try {  
		    try{
		       String nop = Irc.connection.toString();
		    } catch (NullPointerException e){
		         System.out.println("avant try");
		        try {
		            System.out.println("apres try");
		            Irc.connectionFactory = new ActiveMQConnectionFactory(Irc.url);
		            
		            System.out.println("apres connectionFactory");
		            Irc.connection = Irc.connectionFactory.createConnection();
		            System.out.println("apres create connection");
		            Irc.connection.start();
		            System.out.println("apres connection start");
		            
		            Irc.session = Irc.connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		            System.out.println("apres create session");
		            
		            Irc.destination = Irc.session.createTopic(Irc.subject);
		            System.out.println("apres creat Topic");
		            
		            Irc.producer = Irc.session.createProducer(Irc.destination);
		            System.out.println("apres create producer");
		            Irc.consumer = Irc.session.createConsumer(Irc.destination);
		            System.out.println("Pret");
		            
		           } catch (Exception ex) {
		           
		            System.out.println("exception");
		        ex.printStackTrace();
		        return;
	            }
	        }
		    Listener listener = new Listener();
		    try{
		        boolean faux = Irc.users.contains("nop");
		    } catch (NullPointerException e){
		        Irc.users = new Vector<String>();
		    }
		    if (!Irc.users.contains(Irc.myName)){
		        Irc.consumer.setMessageListener(listener);
		        StreamMessage message = Irc.session.createStreamMessage();
		        message.writeString("connecter");
	            message.writeString(Irc.myName+" a rejoint la conversation");
	            Irc.users.add(Irc.myName);
		        Irc.producer.send(message);
	        }
		    Thread.sleep(1000);
		   
			System.out.println("connect button pressed");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}  



// action invoked when the "who" button is clicked
class whoListener implements ActionListener {
	public void actionPerformed (ActionEvent ae) {
		try {
		    try{
		    StreamMessage message = Irc.session.createStreamMessage();
		    message.writeString("qui");
		    message.writeString(Irc.myName);
		    String msg = "Users : \n";
		    for (String u : Irc.users){
		        msg = msg + "    "+u + "\n";
	        }
	          
	        message.writeString(msg);
		    Irc.producer.send(message);
		    Thread.sleep(1000);
		    
		     }catch (IllegalStateException | NullPointerException e){
		     }
		
			System.out.println("who button pressed");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}


// action invoked when the "leave" button is clicked
class leaveListener implements ActionListener {
	public void actionPerformed (ActionEvent ae) {
		try {
		    try{
		    Listener listener = new Listener();
		    try{
		        boolean faux = Irc.users.contains("nop");
		    } catch (NullPointerException e){
		        Irc.users = new Vector<String>();
		    }
		    if (Irc.users.contains(Irc.myName)){
		        Irc.consumer.setMessageListener(listener);
		        StreamMessage message = Irc.session.createStreamMessage();
		        message.writeString("quitter");
	            message.writeString(Irc.myName+" a quitté la conversation");
	            Irc.users.remove(Irc.myName);
		        Irc.producer.send(message);
		        Thread.sleep(1000);
			    Irc.connection.close();
			    Irc.connection = null;
	        }
	        
		     }catch (IllegalStateException | NullPointerException e){
		     }
			    System.out.println("leave button pressed");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}


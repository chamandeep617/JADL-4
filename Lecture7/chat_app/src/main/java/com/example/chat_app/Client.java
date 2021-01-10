package com.example.chat_app;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Client extends JFrame implements ActionListener {

    String username;
    PrintWriter pw;
    BufferedReader br;
    JTextArea  chatmsg;
    JTextField chatip;
    JButton send, exit;
    Socket chatusers;

    public Client(String uname,String servername) throws Exception {
        super(uname);
        this.username = uname;
        chatusers  = new Socket(servername,8080);
        br = new BufferedReader( new InputStreamReader( chatusers.getInputStream()) ) ;
        pw = new PrintWriter(chatusers.getOutputStream(),true);
        pw.println(uname);
        buildInterface();
        new MessagesThread().start();
    }

    public void buildInterface() throws SQLException {
        send = new JButton("Send");
        exit = new JButton("Exit");
        chatmsg = new JTextArea();
        chatmsg.setRows(30);
        chatmsg.setColumns(50);
        chatmsg.setEditable(false);
        chatip  = new JTextField(50);
        JScrollPane sp = new JScrollPane(chatmsg, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(sp,"Center");
        JPanel bp = new JPanel( new FlowLayout());
        bp.add(chatip);

        bp.add(send);
        bp.add(exit);
        bp.setBackground(Color.RED);
        bp.setName("Instant Messenger");
        add(bp,"North");
        send.addActionListener(this);
        exit.addActionListener(this);
        setSize(500,300);
        setVisible(true);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if ( evt.getSource() == exit ) {
            pw.println("end");
            System.exit(0);
        }else {
            pw.println(chatip.getText());
            chatip.setText(null);
        }
    }

    class  MessagesThread extends Thread {
        @Override
        public void run() {
            String line;
            try {
                while(true) {
                    line = br.readLine();
                    chatmsg.append(line + "\n");
                }
            } catch(Exception ex) {}
        }
    }

    public static void main(String[] args) {
        String userName = JOptionPane.showInputDialog(null,"Please enter your name to begin:", "Instant Chat Application",
                JOptionPane.PLAIN_MESSAGE);
        String servername = "localhost";
        try {
            new Client( userName ,servername);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}


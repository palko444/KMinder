package kMinder;

import java.net.Socket;

import com.jcraft.jsch.JSchException;

import net.sourceforge.argparse4j.inf.Namespace;

public class Main {

    public static void main(String[] args) throws InterruptedException, JSchException {
	// TODO Auto-generated method stub
	Namespace ns = ArgParser.parse(args);
	Ssh.connect(443, 5910, "holly", "/home/pala/.ssh/kopcany");
	testPortForward("localhost", 5910);
	System.out.println("Local port forwarding successfull.");
	Thread.sleep(5000);
	Ssh.disconnect();
    }

    public static boolean testPortForward(String hostname, int port) {

	try {
	    Socket socket = new Socket(hostname, port);
	    socket.close();
	    return true;
	} catch (Exception e) {
	    System.out.println("Port forwarding is probably not working for " + hostname
		    + " . Error : " + e.getMessage());
	    System.exit(1);
	    return false;
	}
    }

}
package kMinder;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class Ssh {

    static JSch ssh = new JSch();
    static Session sshSession = null;

    public static void connect(int lport, int rport, String host, String rsaFile)
	    throws JSchException {

	ssh.addIdentity(rsaFile);
	sshSession = ssh.getSession(host);
	sshSession.setConfig("StrictHostKeyChecking", "no");
	sshSession.connect();
	sshSession.setPortForwardingL(rport, host, lport);
    }

    public static void disconnect() {
	if (sshSession.isConnected()) {
	    sshSession.disconnect();
	}
    }
}

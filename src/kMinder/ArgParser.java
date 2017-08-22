package kMinder;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.internal.HelpScreenException;

public class ArgParser {

    public static Namespace parse(String[] args) {
	ArgumentParser parser = ArgumentParsers.newArgumentParser("Kminder").description("Kminder")
		.version("00.01");
	parser.addArgument("-v", "--version").help("print version of Kminder")
		.action(Arguments.version());
	parser.addArgument("-t", "--timeout").help("Timeout for password retrieval, default 50s")
		.type(Integer.class).setDefault(new Integer(50));
	// parser.addArgument("-p", "--port").help("Test defined port(s)").type(Integer.class)
	// .nargs("+").setDefault(new ArrayList<Integer>()).required(true);
	// parser.addArgument("-c", "--csv").help("Print csv output").action(Arguments.storeTrue())
	// .setDefault(false);
	parser.addArgument("-c", "--config_file").help("Path to config file").type(String.class);
	parser.addArgument("-k", "--rsa_key_file").help("Path to rsa key file").type(String.class);

	try {
	    return parser.parseArgs(args);
	} catch (HelpScreenException e) {
	    // e.getParser().printHelp();
	    System.exit(1);
	    return null;
	} catch (ArgumentParserException e) {
	    System.out.println(e.getMessage());
	    e.getParser().printHelp();
	    System.exit(1);
	    return null;
	}
    }

}

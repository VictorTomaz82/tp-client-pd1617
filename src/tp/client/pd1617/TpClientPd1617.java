package tp.client.pd1617;

import java.util.Properties;
import java.util.Scanner;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import tpserver.*;

public class TpClientPd1617 {

    static ConciergeRemote concierge;
    static PatronRemote patron;
    static ButlerRemote butler;

    static void obtemReferenciaConcierge() {
        InitialContext ctx = null;
        Properties prop = new Properties();

        prop.setProperty("java.naming.factory.initial",
                "com.sun.enterprise.naming.SerialInitContextFactory");
        prop.setProperty("java.naming.factory.url.pkgs",
                "com.sun.enterprise.naming");
        prop.setProperty("java.naming.factory.state",
                "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        prop.setProperty("org.omg.CORBA.ORBInitialHost", "192.168.56.175");
        prop.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

        try {
            ctx = new InitialContext(prop);
        } catch (NamingException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        //System.out.println("InitialContext Criado");

        String class_name
                = "java:global/tp-ea-pd1617/tp-ea-pd1617-ejb/Concierge!tpserver.ConciergeRemote";

        try {
            //System.out.println("A conectar ao servidor. Aguarde por favor...");
            Object x = ctx.lookup(class_name);
            concierge = (ConciergeRemote) x;
        } catch (NamingException e) {
            System.out.println(e.getMessage());
            System.exit(2);
        }
       // System.out.print("...JNDI lookup concluido\n");

    }

    static void obtemReferenciaPatron() {
        InitialContext ctx = null;
        Properties prop = new Properties();

        prop.setProperty("java.naming.factory.initial",
                "com.sun.enterprise.naming.SerialInitContextFactory");
        prop.setProperty("java.naming.factory.url.pkgs",
                "com.sun.enterprise.naming");
        prop.setProperty("java.naming.factory.state",
                "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        prop.setProperty("org.omg.CORBA.ORBInitialHost", "192.168.56.175");
        prop.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

        try {
            ctx = new InitialContext(prop);
        } catch (NamingException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        //System.out.println("InitialContext Criado");

        String class_name
                = "java:global/tp-ea-pd1617/tp-ea-pd1617-ejb/Patron!tpserver.PatronRemote";

        try {
            //System.out.println("A conectar ao servidor. Aguarde por favor...");
            Object x = ctx.lookup(class_name);
            patron = (PatronRemote) x;
        } catch (NamingException e) {
            System.out.println(e.getMessage());
            System.exit(2);
        }
        //System.out.print("...JNDI lookup concluido\n");

    }

    static void obtemReferenciaButler() {
        InitialContext ctx = null;
        Properties prop = new Properties();

        prop.setProperty("java.naming.factory.initial",
                "com.sun.enterprise.naming.SerialInitContextFactory");
        prop.setProperty("java.naming.factory.url.pkgs",
                "com.sun.enterprise.naming");
        prop.setProperty("java.naming.factory.state",
                "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        prop.setProperty("org.omg.CORBA.ORBInitialHost", "192.168.56.175");
        prop.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

        try {
            ctx = new InitialContext(prop);
        } catch (NamingException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        //System.out.println("InitialContext Criado");

        String class_name
                = "java:global/tp-ea-pd1617/tp-ea-pd1617-ejb/Butler!tpserver.ButlerRemote";

        try {
            //System.out.println("A conectar ao servidor. Aguarde por favor...");
            Object x = ctx.lookup(class_name);
            butler = (ButlerRemote) x;
        } catch (NamingException e) {
            System.out.println(e.getMessage());
            System.exit(2);
        }
        //System.out.print("...JNDI lookup concluido\n");

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);

        System.out.println("A conectar ao servidor. Aguarde por favor...");
        obtemReferenciaConcierge();
        obtemReferenciaPatron();
        obtemReferenciaButler();
        System.out.print("...JNDI lookup concluido\n");

        System.out.println("------------------------------------");
        System.out.println("-          Casa do Povo            -");
        System.out.println("------------------------------------");

        System.out.println("concierge: "+concierge.teste()+"; butler: "+butler.teste()+"; patron: "+patron.teste());

//
//        do {
//            System.out.println("- Jogador: " + jogador.getNome() + "\t\t\t-");
//            System.out.println("------------------------------------");
//            System.out.println("1 - Sugerir numero");
//            System.out.println("2 - Obter pontuacao individual");
//            System.out.println("3 - Obter tentativas utilizadas");
//            System.out.println("4 - Obter pontuacao global");
//            System.out.println("\n0 - Sair");
//            System.out.println("-----------------------------------\n");
//
//            System.out.print("Opcao -> ");
//            s = sc.nextLine();
//
//            switch (s) {
//                case "1":
//                    System.out.print("\nInsira palpite (1-100): ");
//                    jogador.setPalpite((int) sc.nextInt());
//                    System.out.println(jogador.joga() + "\n");
//                    break;
//
//                case "2":
//                    System.out.println("Pontuação individual: " + jogador.getPontuacao() + "\n");
//
//                    break;
//                case "3":
//                    System.out.println("Tentativas utilizadas: " + jogador.getTentativas() + "\n");
//                    break;
//                case "4":
//                    System.out.println(jogador.getLista() + "\n");
//                    break;
//            }
//        } while (!s.equals("0"));
//    }
    }

}

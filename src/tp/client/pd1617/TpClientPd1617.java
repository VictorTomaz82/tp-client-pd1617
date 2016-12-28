package tp.client.pd1617;

import java.util.Properties;
import java.util.Scanner;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import tpserver.*;

public class TpClientPd1617 {

//    static ConciergeRemote concierge;
//    static PatronRemote patron;
    static ButlerRemote butler;

//    static void obtemReferenciaConcierge() {
//        InitialContext ctx = null;
//        Properties prop = new Properties();
//
//        prop.setProperty("java.naming.factory.initial",
//                "com.sun.enterprise.naming.SerialInitContextFactory");
//        prop.setProperty("java.naming.factory.url.pkgs",
//                "com.sun.enterprise.naming");
//        prop.setProperty("java.naming.factory.state",
//                "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
//        prop.setProperty("org.omg.CORBA.ORBInitialHost", "192.168.56.175");
//        prop.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
//
//        try {
//            ctx = new InitialContext(prop);
//        } catch (NamingException e) {
//            System.out.println(e.getMessage());
//            System.exit(1);
//        }
//        //System.out.println("InitialContext Criado");
//
//        String class_name
//                = "java:global/tp-ea-pd1617/tp-ea-pd1617-ejb/Concierge!tpserver.ConciergeRemote";
//
//        try {
//            //System.out.println("A conectar ao servidor. Aguarde por favor...");
//            Object x = ctx.lookup(class_name);
//            concierge = (ConciergeRemote) x;
//        } catch (NamingException e) {
//            System.out.println(e.getMessage());
//            System.exit(2);
//        }
//        // System.out.print("...JNDI lookup concluido\n");
//
//    }
//
//    static void obtemReferenciaPatron() {
//        InitialContext ctx = null;
//        Properties prop = new Properties();
//
//        prop.setProperty("java.naming.factory.initial",
//                "com.sun.enterprise.naming.SerialInitContextFactory");
//        prop.setProperty("java.naming.factory.url.pkgs",
//                "com.sun.enterprise.naming");
//        prop.setProperty("java.naming.factory.state",
//                "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
//        prop.setProperty("org.omg.CORBA.ORBInitialHost", "192.168.56.175");
//        prop.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
//
//        try {
//            ctx = new InitialContext(prop);
//        } catch (NamingException e) {
//            System.out.println(e.getMessage());
//            System.exit(1);
//        }
//        //System.out.println("InitialContext Criado");
//
//        String class_name
//                = "java:global/tp-ea-pd1617/tp-ea-pd1617-ejb/Patron!tpserver.PatronRemote";
//
//        try {
//            //System.out.println("A conectar ao servidor. Aguarde por favor...");
//            Object x = ctx.lookup(class_name);
//            patron = (PatronRemote) x;
//        } catch (NamingException e) {
//            System.out.println(e.getMessage());
//            System.exit(2);
//        }
//        //System.out.print("...JNDI lookup concluido\n");
//
//    }

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
//        obtemReferenciaConcierge();
//        obtemReferenciaPatron();
        obtemReferenciaButler();
        System.out.print("...JNDI lookup concluido\n");

        System.out.println("------------------------------------");
        System.out.println("-          Casa do Povo            -");
        System.out.println("------------------------------------");

        // --- debug (begin) ---
        System.out.println("butler: " + butler.teste());
        // --- debug (end) ---

        do {
            System.out.println("1 - Ver Newsletter");
            System.out.println("2 - Ver ultimas 3 vendas");
            System.out.println("3 - Pedir acesso");
            System.out.println("4 - Pedir reactivação de conta");
            System.out.println("5 - Login");
            System.out.println("------------------------------------");
            System.out.println("6 - Mudar password");
            System.out.println("7 - Enviar mensagem a utilizador");
            System.out.println("8 - Criar venda");
            System.out.println("9 - Seguir item");
            System.out.println("10 - Fazer licitação");
            System.out.println("11 - Denunciar item ou user");
            System.out.println("12 - Adicionar fundos");
            System.out.println("13 - Pagar item");
            System.out.println("14 - Pedir suspensao");
            System.out.println("15 - Desactivar conta");
            System.out.println("------------------------------------");
            System.out.println("16 - Suspender utilizador");
            System.out.println("17 - Reactivar utilizador");
            System.out.println("18 - Ver utilizador");
            System.out.println("19 - Ver item");
            System.out.println("20 - Adicionar categoria");
            System.out.println("21 - Alterar categoria");
            System.out.println("\n0 - Sair");
            System.out.println("-----------------------------------\n");

            System.out.print("Opcao -> ");
            s = sc.nextLine();

            switch (s) {
                case "1":
System.out.print("\n\t-Newsletter- ");
                    System.out.println(butler.seeNews());
                    break;
                case "2":
System.out.print("\n\t-Ultimas 3 vendas- ");
                    System.out.println(butler.seeLastThree());
                    break;
                case "3":

                    //ToDo ask input from user
                     System.out.print("\n\t-Pedido de acesso- ");
                     String username;
                    String password;
                    String confirmPassword;
                     do{ 
                    System.out.print("\nUsername: ");
                    username=(String) sc.nextLine();
                    System.out.print("\nPassword: ");
                    password=(String) sc.nextLine();
                    System.out.print("\nConfirme Password: ");
                    confirmPassword=(String) sc.nextLine();
                    if(!password.equals(confirmPassword)) System.out.print("\nErro! Password e Confirmacao nao sao iguais!");
            }while(!password.equals(confirmPassword));                  
        butler.askAccess(username, password);
                    break;
                case "4":
System.out.print("\n\t-Pedido de Reactivacao de Conta- ");
                    //ToDo ask input from user
//    butler.askReactivation(String username, String password);
                    break;
                case "5":
System.out.print("\n\t-Login- ");
                    //ToDo ask input from user
//    butler.login(String username, String password);
                    break;
                case "6":
System.out.print("\n\t-Mudar Password- ");
                    //ToDo ask input from user
//    butler.changePassword(String username, String password, String confirmPassword);
                    break;
                case "7":
System.out.print("\n\t-Envio de Mensagem- ");
                    //ToDo ask input from user
//    butler.messageUser(String senderId, String recipientId, String title, Date time);
                    break;
                case "8":
System.out.print("\n\t-Criacao de Venda- ");
                    //ToDo ask input from user
//    butler.doSale(String itemId);
                    break;

                case "9":
System.out.print("\n\t-Seguir Item- ");
                    //ToDo ask input from user
//    butler.follow(String itemId);
                    break;
                case "10":
System.out.print("\n\t-Fazer Licitacao- ");
                    //ToDo ask input from user
//    butler.doBid(String itemId);
                    break;
                case "11":
System.out.print("\n\t-Denunciar Utilizador ou Item- ");
                    //ToDo ask input from user
//    butler.denunce(String userId, String itemId, String motive);
                    break;

                case "12":
System.out.print("\n\t-Adicionar Saldo- ");
                    //ToDo ask input from user
//    butler.addBalance(int money);
                    break;
                case "13":
System.out.print("\n\t-Pagar Item- ");
                    //ToDo ask input from user
//    butler.payItem(String itemId);
                    break;

                case "14":
System.out.print("\n\t-Pedir Suspensao- ");
                    //ToDo ask input from user
//    butler.askSuspension(String userId, String motive);
                    break;
                case "15":
System.out.print("\n\t-Desactivar Conta- ");
                    //ToDo ask input from user
//    butler.unactivate(String userId);
                    break;
                case "16":
System.out.print("\n\t-Suspender Utilizador- ");
                    //ToDo ask input from user
//    butler.suspendUser(String userId, String motive);
                    break;

                case "17":
System.out.print("\n\t-Reactivar Utilizador- ");
                    //ToDo ask input from user
//    butler.reactivateUser(String userId);
                    break;

                case "18":
System.out.print("\n\t-Pesquisar Utilizador- ");
                    //ToDo ask input from user
//    butler.seeUser(String userId);
                    break;

                case "19":
System.out.print("\n\t-Pesquisar Item- ");
                    //ToDo ask input from user
//    butler.seeItem(String itemId);
                    break;

                case "20":
System.out.print("\n\t-Adicionar Categoria- ");
                    //ToDo ask input from user
//butler.addCategory(String name, String description);
                    break;

                case "21":
System.out.print("\n\t-Alterar Categoria- ");
                    //ToDo ask input from user
//butler.changeCategory(String name, String newName, String description);
                    break;

            }
        } while (!s.equals("0"));
    }
}

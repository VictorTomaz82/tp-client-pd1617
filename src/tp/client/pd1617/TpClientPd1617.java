package tp.client.pd1617;

import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import tpserver.*;

public class TpClientPd1617 {

//    static ConciergeRemote concierge;
//    static PatronRemote patron;
    static ButlerRemote butler;

//    static void callConcierge() {
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
//    static void callPatron() {
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
    static void callButler() {
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

        String class_name
                = "java:global/tp-ea-pd1617/tp-ea-pd1617-ejb/Butler!tpserver.ButlerRemote";

        try {
            System.out.println("A conectar ao servidor. Aguarde por favor...");
            Object x = ctx.lookup(class_name);
            butler = (ButlerRemote) x;
        } catch (NamingException e) {
            System.out.println(e.getMessage());
            System.exit(2);
        }
        System.out.print("...JNDI lookup concluido\n");

    }

    public static void main(String[] args) {
        // --- not optimized for memory use! ---
        String username;
        String password;
        String confirmPassword;
        String name;
        String address;
        int money;
        String newPassword;

        String messageId;
        String sender;
        String recipient;
        String title;
        String body;
        Date time;

        String itemId;
        int bid;

        String motive;

        String itemName;
        String description;
        int startPrice;
        int buyout;

        String newName;

        //---------------------------------------
        String opcao;
        Scanner sc = new Scanner(System.in);

//        callConcierge();
//        callPatron();
        //JNDI Lookup Function
        callButler();

        // --- debug (begin) ---
//        System.out.println("butler: " + butler.teste());
        // --- debug (end) ---
        do {
            System.out.println("------------------------------------");
            System.out.println("-          Casa do Povo            -");
            System.out.println("------------------------------------");
            System.out.println("\t Bem vindo " + butler.getCurrentUsername() + "\n");

            switch (butler.getCurrentUsername()) {
                case "Visitante":
                    System.out.println("1 - Ver Newsletter");
                    System.out.println("2 - Ver ultimas 3 vendas");
                    System.out.println("3 - Pedir acesso");
                    System.out.println("4 - Pedir reactivação de conta");
                    System.out.println("5 - Login");
                    System.out.println("\n0 - Sair");
                    System.out.println("------------------------------------");
                    break;
                case "Admin":
                    System.out.println("1 - Ver Newsletter");
                    System.out.println("2 - Ver ultimas 3 vendas");
                    System.out.println("6 - Ver Denuncias");
                    System.out.println("7 - Suspender utilizador");
                    System.out.println("8 - Remover Item");
                    System.out.println("9 - Activar/Reactivar utilizador");
                    System.out.println("10 - Ver lista de utilizadores");
                    System.out.println("11 - Ver informacao de utilizador");
                    System.out.println("12 - Ver lista de items");
                    System.out.println("13 - Ver informacao de item");
                    System.out.println("14 - Ver lista de categorias");
                    System.out.println("15 - Adicionar categoria");
                    System.out.println("16 - Alterar categoria");
                    System.out.println("36 - Logout");
                    System.out.println("\n0 - Sair");
                    System.out.println("------------------------------------");
                    break;
                default:
                    System.out.println("1 - Ver Newsletter");
                    System.out.println("2 - Ver ultimas 3 vendas");
                    System.out.println("17 - Mudar password");
                    System.out.println("18 - Alterar informacoes do utilizador");
                    System.out.println("19 - Ver lista de mensagens");
                    System.out.println("20 - Ver mensagen");
                    System.out.println("21 - Enviar mensagem a utilizador");
                    System.out.println("22- Criar venda");
                    System.out.println("23 - Ver os meus items");
                    System.out.println("24 - Ver items a venda");
                    System.out.println("25 - Ver items licitados");
                    System.out.println("26 - Ver items ganhos");
                    System.out.println("27 - Ver items seguidos");
                    System.out.println("28 - Seguir item");
                    System.out.println("29 - Fazer licitação");
                    System.out.println("30 - Denunciar item");
                    System.out.println("31 - Denunciar user");
                    System.out.println("32 - Ver saldo");
                    System.out.println("33 - Adicionar fundos");
                    System.out.println("34 - Pagar item");
                    System.out.println("35 - Pedir suspensao");
                    System.out.println("36 - Logout");
                    System.out.println("\n0 - Sair");
                  //System.out.println("16 - Desactivar conta");
                    System.out.println("------------------------------------");
                    break;
            }

            System.out.print("\nOpcao -> ");
            opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("\n\t-Newsletter-");
                    System.out.println(butler.seeNews());
                    break;

                case "2":
                    System.out.print("\n\t-Ultimas 3 vendas-");
                    System.out.println(butler.seeLastThree());
                    break;

                case "3":
                    System.out.print("\n\t-Pedido de acesso-");
                    do {
                        System.out.print("\nUsername: ");
                        username = (String) sc.nextLine();
                        System.out.print("\nPassword: ");
                        password = (String) sc.nextLine();
                        System.out.print("\nConfirme Password: ");
                        confirmPassword = (String) sc.nextLine();
                        System.out.print("\nNome: ");
                        name = (String) sc.nextLine();
                        System.out.print("\nMorada: ");
                        address = (String) sc.nextLine();
                        if (!password.equals(confirmPassword)) {
                            System.out.print("\nErro! Password e Confirmacao nao sao iguais!");
                        }
                    } while (!password.equals(confirmPassword));
                    System.out.println(butler.askAccess(username, password, name, address));
                    break;

                case "4":
                    System.out.print("\n\t-Pedido de Reactivacao de Conta-");
                    System.out.print("\nUsername: ");
                    username = (String) sc.nextLine();
                    System.out.print("\nPassword: ");
                    password = (String) sc.nextLine();
                    System.out.println(butler.askReactivation(username, password));
                    break;

                case "5":
                    System.out.print("\n\t-Login-");
                    System.out.print("\nUsername: ");
                    username = (String) sc.nextLine();
                    System.out.print("\nPassword: ");
                    password = (String) sc.nextLine();
                    System.out.println(butler.login(username, password));
                    break;
                    
                case "6":
                    System.out.print("\n\t-Lista de Denuncias-");
                    System.out.println(butler.viewDenunceList());
                    break;
                    
                case "7":
                    System.out.print("\n\t-Suspender Utilizador-");
                    System.out.print("\nUsername: ");
                    username = (String) sc.nextLine();
                    System.out.print("\nMotivo: ");
                    motive = (String) sc.nextLine();
                    System.out.println(butler.suspendUser(username, motive));
                    break;

                case "8":
                    System.out.print("\n\t-Remover Item-");
                    System.out.print("\nItemId: ");
                    itemId = (String) sc.nextLine();
                    System.out.println(butler.itemRemove(itemId));
                    break;
                    
                case "9":
                    System.out.print("\n\t-Reactivar Utilizador-");
                    System.out.print("\nUsername: ");
                    username = (String) sc.nextLine();
                    System.out.println(butler.reactivateUser(username));
                    break;
                    
                case "10":
                    System.out.print("\n\t-Lista de Utilizadores-");
                    System.out.println(butler.viewUserList());
                    break;
                    
                case "11":
                    System.out.print("\n\t-Pesquisar Utilizador-");
                    System.out.print("\nUsername: ");
                    username = (String) sc.nextLine();
                    System.out.println(butler.seeUser(username));
                    break;

                case "12":
                    System.out.print("\n\t-Lista de Items-");
                    System.out.println(butler.viewItemList());
                    break;

                case "13":
                    System.out.print("\n\t-Pesquisar Item-");
                    System.out.print("\nItemId: ");
                    itemId = (String) sc.nextLine();
                    System.out.println(butler.seeItem(itemId));
                    break;
                                       
                case "14":
                    System.out.print("\n\t-Lista de Categorias-");
                    System.out.println(butler.viewCategoryList());
                    break;

                case "15":
                    System.out.print("\n\t-Adicionar Categoria-");
                    System.out.print("\nNome da Categoria: ");
                    name = (String) sc.nextLine();
                    System.out.print("\nDescricao: ");
                    description = (String) sc.nextLine();
                    System.out.println(butler.addCategory(name, description));
                    break;

                case "16":
                    System.out.print("\n\t-Alterar Categoria-");
                    System.out.print("\nNome da Categoria a alterar: ");
                    name = (String) sc.nextLine();
                    System.out.print("\nNovo Nome da Categoria: ");
                    newName = (String) sc.nextLine();
                    System.out.print("\nNova Descricao: ");
                    description = (String) sc.nextLine();
                    System.out.println(butler.changeCategory(name, newName, description));
                    break;

                case "17":
                    System.out.print("\n\t-Mudar Password-");
                    do {
                        username = butler.getCurrentUsername();
                        System.out.print("\nPassword: ");
                        password = (String) sc.nextLine();
                        System.out.print("\nNova Password: ");
                        newPassword = (String) sc.nextLine();
                        System.out.print("\nConfirme Nova Password: ");
                        confirmPassword = (String) sc.nextLine();
                        if (!newPassword.equals(confirmPassword)) {
                            System.out.print("\nErro! Nova Password e Confirmacao nao sao iguais!");
                        }
                    } while (!newPassword.equals(confirmPassword));
                    System.out.println(butler.changePassword(username, password, newPassword, confirmPassword));
                    break;

                    
                case "18":
                    System.out.print("\n\t-Alterar dados do utilizador-");
                        System.out.print("\nNome: ");
                        name = (String) sc.nextLine();
                        System.out.print("\nMorada: ");
                        address = (String) sc.nextLine();
                    System.out.println(butler.changeUserInformation(name, address));
                    break;
                    
                case "19":
                    System.out.print("\n\t-Lista de Mensagens-");
                    System.out.println(butler.viewMessageList());
                    break;
                    
                case "20":
                    System.out.print("\n\t-Ver Mensagem-");
                    System.out.print("\nMessageId: ");
                    messageId = (String) sc.nextLine();
                    System.out.println(butler.viewMessage(messageId));
                    break;
                    
                case "21":
                    System.out.print("\n\t-Envio de Mensagem-");
                    sender = butler.getCurrentUsername();
                    System.out.print("\nDestinatario: ");
                    recipient = (String) sc.nextLine();
                    System.out.print("\nTitulo: ");
                    title = (String) sc.nextLine();
                    System.out.print("\nCorpo: ");
                    body = (String) sc.nextLine();

                    //check this!
                    time = new Date();

                    System.out.println(butler.messageUser(sender, recipient, title, body, time));
                    break;

                case "22":
                    System.out.print("\n\t-Criacao de Venda-");
                    username = butler.getCurrentUsername();
                    System.out.print("\nNome do item: ");
                    itemName = (String) sc.nextLine();
                    System.out.print("\nDescricao do item: ");
                    description = (String) sc.nextLine();
                    System.out.print("\nPreco inicial: ");
                    startPrice = (int) sc.nextInt();
                    System.out.print("\nPreco buyout: ");
                    buyout = (int) sc.nextInt();
                    System.out.println(butler.doSale(username, itemName, description, startPrice, buyout));
                    break;

                case "23":
                    System.out.print("\n\t-Meus Items-");
                    System.out.println(butler.viewUserItemsList());
                    break;
                    
                case "24":
                    System.out.print("\n\t-Items a Venda-");
                    System.out.println(butler.viewSellingItemList());
                    break;
                    
                case "25":
                    System.out.print("\n\t-Items Licitados-");
                    System.out.println(butler.viewBiddedItemList());
                    break;
                    
                case "26":
                    System.out.print("\n\t-Items Ganhos-");
                    System.out.println(butler.viewWonItemList());
                    break;
                    
                case "27":
                    System.out.print("\n\t-Items Seguidos-");
                    System.out.println(butler.viewFollowedItemList());
                    break;
                    
                case "28":
                    System.out.print("\n\t-Seguir Item-");
                    System.out.print("\nItemId: ");
                    itemId = (String) sc.nextLine();
                    System.out.println(butler.follow(itemId));
                    break;

                case "29":
                    System.out.print("\n\t-Fazer Licitacao-");
                    System.out.print("\nItemId: ");
                    itemId = (String) sc.nextLine();
                    System.out.print("\nValor: ");
                    bid = (int) sc.nextInt();
                    System.out.println(butler.doBid(itemId, bid));
                    break;

                case "30":
                    System.out.print("\n\t-Denunciar Item-");
                    System.out.print("\nItemId: ");
                    itemId = (String) sc.nextLine();
                    System.out.print("\nMotivo: ");
                    motive = (String) sc.nextLine();
                    System.out.println(butler.denunceItem(itemId, motive));
                    break;

                case "31":
                    System.out.print("\n\t-Denunciar Utilizador-");
                    System.out.print("\nUsername: ");
                    username = (String) sc.nextLine();
                    System.out.print("\nMotivo: ");
                    motive = (String) sc.nextLine();
                    System.out.println(butler.denunceUser(username, motive));
                    break;

                case "32":
                    System.out.print("\n\t-Saldo-");
                    System.out.println(butler.viewUserBalance());
                    break;
                    
                case "33":
                    System.out.print("\n\t-Adicionar Saldo-");
                    username = butler.getCurrentUsername();
                    System.out.print("\nValor: ");
                    money = (int) sc.nextInt();
                    System.out.println(butler.addBalance(username, money));
                    break;

                case "34":
                    System.out.print("\n\t-Pagar Item-");
                    System.out.print("\nItemId: ");
                    itemId = (String) sc.nextLine();
                    System.out.println(butler.payItem(itemId));
                    break;

                case "35":
                    System.out.print("\n\t-Pedir Suspensao-");
                    username = butler.getCurrentUsername();
                    System.out.print("\nMotivo: ");
                    motive = (String) sc.nextLine();
                    System.out.println(butler.askSuspension(username, motive));
                    break;

                case "36":
                    System.out.print("\n\t-Logout-\n");
                    butler.logout();
                    break;

//                case "16":
//                    System.out.print("\n\t-Desactivar Conta- ");
                //ToDo ask input from user
//    butler.unactivate(String userId);
//                    break;
            }
        } while (!opcao.equals("0"));
    }
}

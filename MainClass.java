import java.util.Scanner;

public class MainClass {

    static WifiNetwork[] availableNetworks = new WifiNetwork[3];
    static Router[] availableWifiConnections = new Router[10];

    public static void main(String[] args) {

        String[] sonyGames = {"Snake 3d" , "SpaceShuttle" , "Sonic"};


        availableNetworks[0] = new WifiNetwork("DreamNet" , new String[]{"karachi" });
        availableNetworks[1] = new WifiNetwork("Stormfiber" , new String[]{ "lahore" , "karachi" , "islamabad"});
        availableNetworks[2] = new WifiNetwork("PTCL" , new String[]{"islamabad" , "rawalpindi"});

        Router c11  = new Router("sharyar" , "dreamwifi11" , "sha12345" , "karachi");
        Router c112  = new Router("shazar" , "dreamwifi112" , "pakistan123" , "karachi");
        Router c3 = new Router("unaizah" , "wifistar" , "12345" , "karachi");
        Router d9 = new Router("zubair" , "d-9" , "0000" , "karachi");

        System.out.println(c11.routerName);
        System.out.println(c11.routerPassword);
        c11.setUpConnection(availableNetworks[0]) ;
        c3.setUpConnection(availableNetworks[0]) ;
        d9.setUpConnection(availableNetworks[0]) ;
        c112.setUpConnection(availableNetworks[0]);
        System.out.println(availableNetworks[0].connectedRouters[0].routerName);
        System.out.println(availableNetworks[0].currentCustomers);

        SmartTv appleTv = new SmartTv("apple" , "PK2014" , 1080);
        System.out.println("\n\nApple TV:\n");
        System.out.println( appleTv.maxChannels );
        appleTv.getTvInfo();
        appleTv.getWifiInfo();
        appleTv.connectToInternet(c112);
        appleTv.getWifiInfo();

        SmartTv samsungTv = new SmartTv("samsung" , "sg2019" , 4096);
        System.out.println("\n\nSamsung TV:\n");
        System.out.println( samsungTv.maxChannels );
        samsungTv.getTvInfo();
        samsungTv.connectToInternet(c112);
        samsungTv.getWifiInfo();

    }

}

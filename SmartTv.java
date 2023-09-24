import java.util.Scanner;

public class SmartTv extends Tv implements SmartTvRemote {

         protected int maxChannels;
         protected boolean networkStatus;
         protected Router tpLink;
         boolean isHD;
         boolean is4k;
         boolean hdmiOn;
         Router myConnectedRouter;

         public SmartTv(String company , String modelNum , int resolution ){

             super(company , modelNum , resolution);
             if( resolution >= 1080){
                 isHD = true;
             }
             if( resolution >= 4096){
                 is4k = true;
             }

         }
         @Override
        public void checkInternetConnection(){
             if( networkStatus){
                 System.out.println("You are connected to " + myConnectedRouter.routerName);
             }
             else{
                 System.out.println("You are offline.");
             }
         }

         @Override
        public void connectToInternet(Router newConnection){

               if( newConnection.connectToThisRouter(newConnection.routerName) ){
                   myConnectedRouter = newConnection;
                   networkStatus = true;
                   System.out.println("We just connected to " + myConnectedRouter.routerName + "wifi");
               }
               else{
                   System.out.println("Can't connect to this Network!");
               }

         }
         @Override
        public void  getWifiInfo(){
             if( myConnectedRouter != null){
                 System.out.println("To view Wifi details . Enter our wifi password:");
                 Scanner sc = new Scanner(System.in);
                 String userInput = sc.next();
                 if( myConnectedRouter.routerPassword.equals( userInput) ){
                     System.out.println("Wifi Company name : " + myConnectedRouter.company.companyName);
                     System.out.println("Company total customers : " + myConnectedRouter.company.currentCustomers);
                     System.out.println("Customer name : " + myConnectedRouter.customerName);
                     System.out.println("Router name : " + myConnectedRouter.routerName);
                     System.out.println("Connected Devices : " + myConnectedRouter.connectedDevices);
                     System.out.println("Signal Strength : " );
                     myConnectedRouter.checkSignals();
                 }
             }
             else{
                 System.out.println("Not connected to any Router.");
             }

         }
        @Override
        public void getTvInfo(){
            System.out.println("Tv company: " + this.company);
            System.out.println("ModelNum : " + this.modelNum);
            System.out.println("Max Resolution : " + this.resolution);
            System.out.println("HD : " + this.isHD);
        }




}

import java.util.Scanner;

public class WifiNetwork {

     String companyName;
     String[] areasCovered;
     String[] customers = new String[10];
     Router[] connectedRouters = new Router[10];
     int currentCustomers = 0;

     public WifiNetwork(){

     }

    public WifiNetwork(String name , String[] areasCovered  ){
                this.companyName = name;
                this.areasCovered = areasCovered;
    }

    public boolean setUpConnection(String area , String customerName , Router r){
        for( int i =0 ; i < areasCovered.length ; i++){
            if(areasCovered[i].equals(area)){
                this.customers[currentCustomers] = customerName;
                this.connectedRouters[currentCustomers] = r;
//                System.out.println(this.connectedRouters[currentCustomers].routerName);
                currentCustomers++;
                System.out.println("Thank you for choosing us. We will be there shortly!");
                return true;
            }
            else{
                System.out.println("Sorry" + this.companyName + "'s Internet service is not avaialble in your area.");
                return false;
            }
        }
        return false;
    }

}

class Router  {

    WifiNetwork company ;
    String IPAddress;
    String area;
    String customerName;
    String routerName;
    String routerPassword;
    int connectedDevices;
    int signals = 5;

    public Router ( String customerName ,  String routerName , String password ,String area){

        this.customerName = customerName;
        this.routerName = routerName;
        this.routerPassword= password;
        this.area = area;
    }

    public void setUpConnection(WifiNetwork company){
            this.company = company;
            if(this.company.setUpConnection(   this.area , this.customerName , this) ) {
                MainClass.availableWifiConnections[MainClass.availableWifiConnections.length-1] = this;
            }

    }

    public void showAvailableCompanies(){
        for( int i =0 ; i < MainClass.availableNetworks.length ; i++ ){
            System.out.println(MainClass.availableNetworks[i].companyName);
        }
    }
    public void showAvailableNetworks(){
        for( int i=0 ; i< MainClass.availableWifiConnections.length ; i++){
            System.out.println(MainClass.availableWifiConnections[i].routerName);
        }
    }

    public boolean connectToThisRouter(String name){
        Scanner sc = new Scanner(System.in);

        if( this.routerName.equals(name) && this.company != null){
            System.out.println("Enter password:");
            String userInput = sc.next();
            if( this.routerPassword.equals(userInput)){
                this.connectedDevices++;
                this.signals--;
                return true;
            }
        }
        else{
            System.out.println("Either this router isnt connected to any ISP/ Wrong name or Password. Cannot connect to this Network");
            return false;
        }

        return false;
    }

    public void checkSignals(){

            System.out.println(this.signals);

    }


}

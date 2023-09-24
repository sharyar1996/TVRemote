import java.util.Scanner;

public interface SmartTvRemote extends TvRemote{

    int MAX_CHANNEL = 9999;

    @Override
    default void enterMenu(){
        TvRemote.super.enterMenu();
        System.out.println("4. for Tv device Information");
        System.out.println("5. for checkingInternetConnection");

        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        if(userInput == 4){
            getTvInfo();
        }
        else {
            checkInternetConnection();
        }
    }
    void getTvInfo();
    void checkInternetConnection();
    void connectToInternet(Router tpLink);
//    void changeLanguage();
//    void switchHDMI();
//    void sleep(int minutes);
     void getWifiInfo();
}

import java.util.Scanner;

class ChannelLimitExceeded extends Exception{
    @Override
    public String toString() {
        return "Invalid channel number input";
    }
}
public interface TvRemote {
        int MAX_CHANNEL = 100;

        void setCableConnection(String company , int channelLimit);
        void setTvOnOff();
        void incrementChannel();
        void decrementChannel();
        void increaseVolume(int vol);
        void decreaseVolume(int vol);
        void jumpToChannel(int channel) throws ChannelLimitExceeded;

        void gameMode();

        default void enterMenu(){
            Scanner sc = new Scanner(System.in);

            System.out.println("\nWelcome to the MAIN MENU:\n");
            System.out.println("Select any option:( option number)");
            System.out.println("1. Reset Channels");
            System.out.println("2. Change Brightness");
            System.out.println("3.Enter GameMode");
            int userInput = sc.nextInt();
            if( userInput == 1){
                resetChannels();
            }
            else if (userInput == 2){
                System.out.println("Enter new brightness level:");
                int newBrightness = sc.nextInt();
                changeBrightness(newBrightness);
            }
            else{
                gameMode();
            }
        }
        private void resetChannels(){
            System.out.println("Resetting the channels. It will take a few minutes...");
            System.out.println("Please don't turn off the TV.");
        }
        void changeBrightness(int brightness);
}



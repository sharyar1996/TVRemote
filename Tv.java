import java.util.Scanner;

public class Tv implements TvRemote{

    //FIELDS

    protected String cableCompany;
    protected int maxChannels;
    protected String company;
    protected String modelNum;
    protected int resolution ;
    protected int currentBrightness =15;
    protected int currentChannel = 1;
    protected int currentVolume = 10;
    protected boolean tvOn ;
    protected String[] gamesList;

    //CONSTRUCTOR

    public Tv(String company , String modelNum , int resolution ){
        this.company = company;
        this.modelNum = modelNum;
        this.resolution = resolution;
    }
    public Tv(String company , String modelNum , int resolution , String[] gameList){
        this.company = company;
        this.modelNum = modelNum;
        this.resolution = resolution;
        this.gamesList = gameList;
    }
    //METHODS
    @Override
    public void setCableConnection(String company , int maxChannels){
        this.cableCompany = company;
        this.maxChannels = maxChannels;
    }
    public void setTvOnOff(){
        this.tvOn = tvOn ? false : true;
    }
    @Override
    public void incrementChannel(){
        if( this.currentChannel == 100){
            this.currentChannel = 1;
            System.out.println("Incremented channel by 1 . Current channel = " + this.currentChannel);
            return;
        }
        this.currentChannel++;
        System.out.println("Incremented channel by 1 . Current channel = " + this.currentChannel);
    }
    public void incrementChannel(int addition){
        int userRequestedChannel = this.currentChannel + addition;
        if( userRequestedChannel > 100){
            this.currentChannel = userRequestedChannel - 100;
            System.out.println("Your current channel is now = " + this.currentChannel );
        }
        else{
            this.currentChannel = userRequestedChannel;
            System.out.println("Your current channel is now = " + this.currentChannel );
        }
    }
    @Override
    public void decrementChannel(){
        if( this.currentChannel == 1){
            this.currentChannel = 100;
            System.out.println("Decremented channel by 1 . Current channel = " + this.currentChannel);
            return;
        }
        this.currentChannel--;
        System.out.println("Decremented channel by 1 . Current channel = " + this.currentChannel);
    }
    public void decrementChannel(int subtraction){
        int userRequestedChannel = this.currentChannel -subtraction;
        if(userRequestedChannel < 1){
            this.currentChannel = 100 - Math.abs(userRequestedChannel);
            System.out.println("Your current channel is now = " + this.currentChannel );
        }
        else{
            this.currentChannel -= subtraction;
            System.out.println("Your current channel is now = " + this.currentChannel );
        }
    }
    @Override
    public void increaseVolume(int increment){
        int newVolume = this.currentVolume += increment;
        if(newVolume > 100){
            this.currentVolume = 100;
        }
        else{
            this.currentVolume  += increment;
        }

    }
    @Override
    public void decreaseVolume(int decrement){
        int newVolume = this.currentVolume -= decrement;
        if(newVolume < 0){
            this.currentVolume = 0;
        }
        else{
            this.currentVolume  -= decrement;
        }
    }
    @Override
    public void jumpToChannel(int channel) throws ChannelLimitExceeded{
        if( channel <= 100 && channel >= 1){
            System.out.println("Switching to Channel # " + channel);
            this.currentChannel = channel;
        }
        else{
            throw new ChannelLimitExceeded();
        }
    }
    @Override
    public void changeBrightness(int newBrightness){
        if( newBrightness >= 0 && newBrightness <= 100){
            System.out.println("Your previous brightness was " + this.currentBrightness);
            this.currentBrightness = newBrightness;
            System.out.println("Your new brightness is " + this.currentBrightness);
        }
    }
    @Override
    public void gameMode(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the GAME-MODE!");
        System.out.println("Which game would u like to play?");
        for( int i =0; i< gamesList.length ; i++){
            System.out.println(i + ".  " + gamesList[i]);
        }
        int userInput = sc.nextInt();
        System.out.println("Welcome to " + gamesList[userInput] + " ! . Enjoy!");
    }


}

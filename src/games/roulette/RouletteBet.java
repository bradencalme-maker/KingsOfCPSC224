package games.roulette;
import java.util.ArrayList;


public class RouletteBet {
    private int betAmount;
    private int winAmount;
    private ArrayList<String> numbersPresent = new ArrayList<>();
    private boolean oneToTwelve = false;
    private boolean thirteenToTwentyfour = false;
    private boolean twentyFiveToThirtySix = false;
    private boolean oneToEighteen = false;
    private boolean nineteenToThirtySix = false;
    private boolean even = false;
    private boolean odd = false;
    private boolean red = false;
    private boolean black = false;

    public void setNumbersPresent(int[] nums){
        for(int i = 0; i < nums.length; i++){
            numbersPresent.add(String.valueOf(nums[i]));
        }
        switch (numbersPresent.size()) {
            case 4:
                winAmount = 9 * betAmount;
                break;
            case 3:
                winAmount = 12 * betAmount;
                break;
            case 2:
                winAmount = 18 * betAmount;
                break;
            default:
                winAmount = 36 * betAmount;
                break;
        }
    }

    public void setOneToTwelve(){
        oneToTwelve = true;
        winAmount = 3 * betAmount;
    }

    public void setThirteenToTwentyFour(){
        thirteenToTwentyfour = true;
        winAmount = 3 * betAmount;
    }

    public void setBet(int bet){
        betAmount = bet;
    }

    public int getWinAmount(){
        return winAmount;
    }
  

}

package games.roulette;
import java.util.Random;


public class RouletteGame {
    private char color;
    private String number;
    private int black[] = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
    private int red[] =   {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36}; 

    public void spin(){
        int spunNumber = new Random().nextInt(38);

        for (int i = 0; i < black.length; i++){
            if (spunNumber == black[i]){
                color = 'b';
                number = String.valueOf(black[i]);
            } else if(spunNumber == red[i]){
                color = 'r';
                number = String.valueOf(red[i]);
            }else{
                color = 'g';
                if(spunNumber == 0){
                    number = "0";
                }else {
                    number = "00";
                }
            }
        }
    }

    public int getNumber(){
        return Integer.parseInt(number);
    }
}

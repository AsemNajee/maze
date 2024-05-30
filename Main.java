import java.util.Scanner;

public class Main {
    static int positionX;
    static int positionY;
    static boolean win;
    static String message = "《《 Go To Star 》》";
    static char [][] array= new char[][]{
            {'□','■','■','■','■','■'},
            {'□','□','■','□','□','■'},
            {'■','□','□','□','■','☆'},
            {'■','□','■','■','■','□'},
            {'■','□','□','□','□','□'}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        do{
            printArray();
            print("    2");print();
            print("4       6");print();
            print("    8");print();
            print("Enter your Choose: ");
            char choose = in.next().charAt(0);
            switch(choose){
                case '2':{
                    int x,y;
                    if(isEmpty( x = positionX-1, y = positionY))
                    move(x,y);
                }break;
                case '4':{
                    int x,y;
                    if(isEmpty( x = positionX, y = positionY-1))
                    move(x,y);
                }break;
                case '6':{
                    int x,y;
                    if(isEmpty( x = positionX, y = positionY+1))
                    move(x,y);
                }break;
                case '8':{
                    int x,y;
                    if(isEmpty( x = positionX+1, y = positionY))
                    move(x,y);
                }break;
                default:
                message = "《《 Invaled choose 》》";
            }
        }while(!win);
        clear();
        print("Congratulations, you won \nand entered the raffle\n for the Prado.");
    }
    
    static boolean isEmpty(int x,int y){
        boolean is = (x != -1 && y != -1 && x < array.length && y < array[0].length ? array[x][y] != '■' : false);
        if(x == -1 || y == -1)
            message = "《《 Out of Game 》》";
        else if(x > array.length || y >  array[0].length)
            message = "《《 Out of Game 》》";
        else if(array[x][y] == '■')
            message = "《《 Wall !! 》》";
        else
            message = "《《 Go To Star 》》";
        
        return is;
    }
    
    static void move(int x,int y){
        positionX = x;
        positionY = y;
        win = (array[x][y] == '☆');
    }
    
    static void printArray(){
        clear();
        print(message);
        print();
        for(int i=0;i<array.length;i++){
            for(int j =0;j<array[i].length;j++){
                if(positionX == i && positionY == j)
                    print("● ");
                else
                    print(array[i][j]+" ");
            }
            print();
        }
    }
    
    static void clear(){
        print("\033[H\033[2J");
        System.out.flush();
    }
    
    static void print(){
        System.out.println();
    }
    static void print(Object txt){
        System.out.print(txt);
    }
}

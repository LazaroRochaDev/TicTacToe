import java.util.Scanner;




public class Game {

    Player playerX;
    Player playerO;
    Player currentPlayer;
    Player nextPlayer;
    Board board;





    public Game(Player playerX, Player playerO){

        this.playerX = playerX;
        this.playerO = playerO;
        this.currentPlayer = playerX;
        this.nextPlayer = playerO;
        board = new Board();

    }





    public void printGame(){

        System.out.println("\n\n\n");
        board.printBoard();

    }





    public void makeMove(char positionAsked){
        
        int actualPositionInSystem = (Integer.parseInt(String.valueOf(positionAsked)) - 1);
        
        board.setPieceInPosition(actualPositionInSystem, currentPlayer);

    }






    public void changeCurrentPlayer(){

        Player auxiliarPlayer = currentPlayer;
        currentPlayer = nextPlayer;
        nextPlayer = auxiliarPlayer;

    }





    public boolean verifyDraw(){

        boolean draw = false;
        int numberOfPositionsPlayed = 0;

        for(int i = 0; i < 9; i++){
            if(board.positions[i] != ' ')
                numberOfPositionsPlayed++;
        }

        if(numberOfPositionsPlayed == 9 && verifyWin() == false){
            draw = true;
        }        
            
        return draw;

    }




    public boolean verifyWin(){

        boolean victory = false;

        //Verifies win in the rows
        for(int a = 0; a < 9; a = a + 3){
            if( board.positions[a] != ' ' && 
                board.positions[a] == board.positions[a+1] && 
                board.positions[a] == board.positions[a+2])
                victory = true;
        }
                
        //Verifies win in the columns
        for(int b = 0; b < 3; b++){
            if( board.positions[b] != ' ' && 
                board.positions[b] == board.positions[b+3] && 
                board.positions[b] == board.positions[b+6])
                victory = true;
        }

        //Verifies win in the diagonals
            if( board.positions[0] != ' ' && 
                board.positions[0] == board.positions[4] && 
                board.positions[0] == board.positions[8])
                victory = true;

            if( board.positions[2] != ' ' && 
                board.positions[2] == board.positions[4] && 
                board.positions[2] == board.positions[6])
                victory = true;

        return victory;

    }






    public void restartGame(){
        board.clearBoard();
        currentPlayer = playerX;
    }





    public void askToResetGame(boolean itIsAWin){

        if(itIsAWin){
            printGame();
            System.out.println("\nParabéns, " + currentPlayer.name + "!!! Você ganhou!!!");
            System.out.println("Pressione a tecla Enter para jogar novamente.");
            Scanner keyboard = new Scanner(System.in);
            keyboard.nextLine();
            restartGame();
        }
        else{
            Player containerPlayer = currentPlayer;
            currentPlayer = nextPlayer;
            nextPlayer = containerPlayer;

            printGame();
            System.out.println("\n\n" + currentPlayer.name + ", digite a posição da sua jogada.\n");
        }

    }





}

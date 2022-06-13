import java.util.Scanner;





public class Screen {

    Game game;
    Scanner keyboard;
    String playerCorrection;



    public Screen(){
    
        keyboard = new Scanner(System.in);
        
        Player[] players = askForPlayerNames();

        game = new Game(players[0], players[1]);

        playerCorrection = "";

    }




    public Player[] askForPlayerNames(){

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.print("Digite o nome do Jogador 1: ");
        String namePlayerX = keyboard.nextLine();

        System.out.print("Digite o nome do Jogador 2: ");
        String namePlayerO = keyboard.nextLine();

        Player playerX = new Player(namePlayerX, 'X');
        Player playerO = new Player(namePlayerO, 'O'); 

        Player[] players = {playerX, playerO};

        return players;

    }





    public Game getGame(){
        return game;
    }





    public Scanner getKeyboard(){
        return keyboard;
    }





    public int messageAskingForPlayerMove(){

        int userAskedPosition = keyboard.nextInt();

        return userAskedPosition;

    }





    public void printAskForPlayerMove(){

        System.out.println("\n" + playerCorrection);
        System.out.println(game.currentPlayer.name + ", digite a posição da sua jogada.\n");

    }





    public void askForPlayerMove(){

        game.printGame();

        if(playerCorrection != "")
            System.out.print("\n" + playerCorrection);
        System.out.println("\n" + game.currentPlayer.name + ", digite a posição da sua jogada.\n");

        
        int userAskedPosition = keyboard.nextInt();
        char userAskedPositionChar = (char) (userAskedPosition + 48);
        
        //Invalid input
        //The user has typed a number out of the game's bounds.
        if(getGame().board.positionIsValid(userAskedPosition) == 0)
            playerCorrection = "As posições vão apenas de 1 a 9!";
        

        //Invalid move
        //The user has typed a position that is already ocupied.
        if(getGame().board.positionIsValid(userAskedPosition) == 1)
            playerCorrection = "Essa posição já está ocupada!";
        

        //Valid move
        //The user has typed a valid position for his move.
        if(getGame().board.positionIsValid(userAskedPosition) == 2){

            game.makeMove(userAskedPositionChar);

            if(!game.verifyWin() && !game.verifyDraw()){
                game.changeCurrentPlayer();
                playerCorrection = "";
            }

        }

    }






    public void restartScreen(){

        if(game.verifyDraw()){
            game.printGame();
            System.out.println("\nFoi um empate!");
            System.out.println("Precione Enter para reiniciar o jogo.");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            scanner.close();
        }
        else {
            game.printGame();
            System.out.println("\nParabéns, " + game.currentPlayer.name + "!!! Você venceu!");
            System.out.println("Precione Enter para reiniciar o jogo.");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            scanner.close();
        }

        game.restartGame();

    }






}


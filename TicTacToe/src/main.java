



class Main {
    public static void main(String args[]){
        
        Screen screen = new Screen();
        screen.askForPlayerMove();

        while(true){

            while(!screen.getGame().verifyWin() && !screen.getGame().verifyDraw()){
                screen.askForPlayerMove();
            }

                screen.restartScreen();    

        }

    }

}

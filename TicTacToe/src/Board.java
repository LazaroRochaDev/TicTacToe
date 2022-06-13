





public class Board {
    
    char[] positions = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};



    public Board(){}



    //places a piece in the position asked based on current player if the game
    //returns: true if the play is valid        false if the play is not valid
    public void setPieceInPosition(int position, Player player){

            positions[position] = player.type;

    }





    public int positionIsValid(int position){

        int actualPositionInSystem = position - 1;

        if(position < 1 || position > 9)
            return 0;

        if(positionIsEmpty(actualPositionInSystem) == false)
            return 1;

        return 2;

    }





    //returns: true if the play is valid        false if the play is not valid
    public boolean positionIsEmpty(int position){

        if( positions[position] == ' ' )
            return true;
        else
            return false;

    }






    public void printBoard(){
        
        for(int i = 0; i < 9; i = i + 3){

            System.out.print(" " + positions[i] + " | " + positions[i+1] + " | "  + positions[i+2]);
            String auxiliarTable = (char)(i+1+48) + " | " + (char)(i+2+48) + " | " + (char)(i+3+48) + '\n';
            System.out.print("           " + auxiliarTable);        
            if(i <= 3 ) 
                System.out.print("-----------         -----------\n");   

        }
        
        System.out.println();

    }





    public void clearBoard(){
        for(int i = 0; i < 9; i++){
            positions[i] = ' ';
        }
    }





}

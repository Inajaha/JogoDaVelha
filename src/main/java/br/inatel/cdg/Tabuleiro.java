package br.inatel.cdg;

public class Tabuleiro {

    int coluna;
    int linha[];

    private int[][] Tabuleiro= new int[3][3];

    public Tabuleiro(){
        zerarTabuleiro();
    }

    public void zerarTabuleiro(){
        for(int linha=0 ; linha<3 ; linha++)
            for(int coluna=0 ; coluna<3 ; coluna++)
                Tabuleiro[linha][coluna]=0;
    }

    public void exibeTabuleiro(){
        System.out.println();
        for(int linha=0 ; linha<3 ; linha++){

            for(int coluna=0 ; coluna<3 ; coluna++){

                if(Tabuleiro[linha][coluna]==-1){
                    System.out.print(" X ");
                }
                if(Tabuleiro[linha][coluna]==1){
                    System.out.print(" O ");
                }
                if(Tabuleiro[linha][coluna]==0){
                    System.out.print("   ");
                }

                if(coluna==0 || coluna==1)
                    System.out.print("|");
            }
            System.out.println();
        }

    }

    public int getPosicao(int[] tentativa){
        return Tabuleiro[tentativa[0]][tentativa[1]];
    }

    public void setPosicao(int[] tentativa, int jogador){
        if(jogador == 1)
            Tabuleiro[tentativa[0]][tentativa[1]] = -1;
        else
            Tabuleiro[tentativa[0]][tentativa[1]] = 1;

        exibeTabuleiro();
    }

    public int checaLinhas(){
        for(int linha=0 ; linha<3 ; linha++){

            if( (Tabuleiro[linha][0] + Tabuleiro[linha][1] + Tabuleiro[linha][2]) == -3)
                return -1;
            if( (Tabuleiro[linha][0] + Tabuleiro[linha][1] + Tabuleiro[linha][2]) == 3)
                return 1;
        }

        return 0;

    }

    public int checaColunas(){
        for(int coluna=0 ; coluna<3 ; coluna++){

            if( (Tabuleiro[0][coluna] + Tabuleiro[1][coluna] + Tabuleiro[2][coluna]) == -3)
                return -1;
            if( (Tabuleiro[0][coluna] + Tabuleiro[1][coluna] + Tabuleiro[2][coluna]) == 3)
                return 1;
        }

        return 0;

    }

    public int checaDiagonais(){
        if( (Tabuleiro[0][0] + Tabuleiro[1][1] + Tabuleiro[2][2]) == -3)
            return -1;
        if( (Tabuleiro[0][0] + Tabuleiro[1][1] + Tabuleiro[2][2]) == 3)
            return 1;
        if( (Tabuleiro[0][2] + Tabuleiro[1][1] + Tabuleiro[2][0]) == -3)
            return -1;
        if( (Tabuleiro[0][2] + Tabuleiro[1][1] + Tabuleiro[2][0]) == 3)
            return 1;

        return 0;
    }

    public boolean tabuleiroCompleto(){
        for(int linha=0 ; linha<3 ; linha++)
            for(int coluna=0 ; coluna<3 ; coluna++)
                if( Tabuleiro[linha][coluna]==0 )
                    return false;
        return true;
    }
}



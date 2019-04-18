package hashMapExample;

import java.util.*;

class Checker implements Comparator<PlayerComparator> {
    @Override
    public int compare(final PlayerComparator a, final PlayerComparator b) {
        return Comparator.comparing((PlayerComparator p) -> p.score)
            .reversed()
            .thenComparing((PlayerComparator p) -> p.name)
            .compare(a, b);
    }
}

class PlayerComparator{
    String name;
    int score;
    
    PlayerComparator(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        PlayerComparator[] player = new PlayerComparator[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new PlayerComparator(scan.next(), scan.nextInt());
        }
        scan.close();
     
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
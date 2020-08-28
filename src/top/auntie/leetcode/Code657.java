package top.auntie.leetcode;

/**
 * @author rg6130
 */
public class Code657 {

    public boolean judgeCircle1(String moves) {
        int[] point = {0,0};
        for (char c: moves.toCharArray()) {
            switch (c){
                case 'U':
                    point[0]+=1;
                    break;
                case 'D':
                    point[0]-=1;
                    break;
                case 'R':
                    point[1]+=1;
                    break;
                case 'L':
                    point[1]-=1;
                    break;
                default:
                    break;
            }
        }
        return point[0] == 0 && point[1] == 0;
    }

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i=0; i<moves.length(); i++) {
            switch (moves.charAt(i)){
                case 'U':
                    x++;
                    break;
                case 'D':
                    x--;
                    break;
                case 'R':
                    y++;
                    break;
                case 'L':
                    y--;
                    break;
                default:
                    break;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        new Code657().judgeCircle("UDRL");
    }

}

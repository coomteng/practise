import java.util.*;

/**
 * Created by zhouti8 on 2/6/17.
 */
public class MazeII {
    // d: 0 up 1 down 2 left 3 right
    private static int[][][] shDist; // store shortest distance to target from x,y, with direction d
    private static int[] source;
    private static int[] target;
    // init mazArr
    private static int[][] mazArr = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1},
    };

    public static void main(String[] args) {
        source = new int[]{5, 4};
        target = new int[]{1, 2};
        int lenMaz = mazArr.length;
        shDist = new int[lenMaz][lenMaz][4]; // store shortest distance to target from x,y, with direction d
        // init shDist to -1
        for (int i=0; i<lenMaz; i++){
            for (int j=0; j<lenMaz; j++){
                for (int k=0; k<4; k++){
                    shDist[i][j][k] = -1;
                }
            }
        }
        // the distance from the target to the target is 0 from 4 directions
        set4Value(shDist, target[0], target[1], 0);

        int minD = ShortestDist(new int[] {source[0], source[1], 0});
        for (int i=1; i<4; i++){
            minD = Math.min(minD, ShortestDist(new int[] {source[0], source[1], i}));
        }
        System.out.println(minD);

    }

    private static void set4Value(int[][][] s, int x, int y, int v){
        for (int i=0; i<4; i++){
            s[x][y][i] = v;
        }
    }

    private static int ShortestDist(int[] s){
        // s = [x,y,d]
        int x=s[0], y=s[1], d=s[2];
        if (shDist[x][y][d] >= 0){
            return shDist[x][y][d];
        }

        int currDist = 99999; // a big value
        int lenMaz = mazArr.length;
        if (x>=lenMaz || y>=lenMaz){
            return currDist;
        }
        if(mazArr[x][y]==1){
            set4Value(shDist, x, y, currDist);
            return currDist;
        }

        int[] nextP = new int[] {x,y};
        switch (d){
            case 0:{
                nextP[1]++;
                break;
            }
            case 1:{
                nextP[1]--;
                break;
            }
            case 2:{
                nextP[0]--;
                break;
            }
            case 3:{
                nextP[0]++;
                break;
            }
        }
        if(mazArr[nextP[0]][nextP[1]]==1){
            currDist = Math.min(
                    Math.min(ShortestDist(new int[]{x,y+1,0}), ShortestDist(new int[]{x,y-1,1})),
                    Math.min(ShortestDist(new int[]{x-1,y,2}), ShortestDist(new int[]{x+1,y,3}))
            ) + 1;
        }
        else{
            // there is a way
            currDist = ShortestDist(new int[]{nextP[0], nextP[1], d}) + 1;
        }

        shDist[x][y][d] = currDist;

        return currDist;

    }
}


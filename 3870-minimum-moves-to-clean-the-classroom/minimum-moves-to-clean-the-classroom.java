import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startR = -1, startC = -1;
        int litterCount = 0;
        int[][] litterId = new int[m][n];
        
        for (int r = 0; r < m; r++) {
            Arrays.fill(litterId[r], -1);
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    startR = r;
                    startC = c;
                } else if (ch == 'L') {
                    litterId[r][c] = litterCount++;
                }
            }
        }
        
        // If there is no litter to collect, 0 moves needed
        if (litterCount == 0) return 0;
        
        int fullMask = (1 << litterCount) - 1;
        
        // Track the max remaining energy for each (row, col, mask)
        int[][][] bestEnergy = new int[m][n][1 << litterCount];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(bestEnergy[i][j], -1);
            }
        }
        
        // Queue state: {r, c, mask, current_energy}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC, 0, energy});
        bestEnergy[startR][startC][0] = energy;
        
        int steps = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];
                int remEnergy = curr[3];
                
                if (mask == fullMask) {
                    return steps;
                }
                
                // Out of energy to make the next step
                if (remEnergy == 0) continue;
                
                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        char cell = classroom[nr].charAt(nc);
                        if (cell == 'X') continue;
                        
                        int nextEnergy = remEnergy - 1;
                        if (cell == 'R') {
                            nextEnergy = energy; // Restore to max energy
                        }
                        
                        int nextMask = mask;
                        if (cell == 'L') {
                            nextMask |= (1 << litterId[nr][nc]);
                        }
                        
                        // Prune state if we reach with less/equal energy than seen before
                        if (nextEnergy > bestEnergy[nr][nc][nextMask]) {
                            bestEnergy[nr][nc][nextMask] = nextEnergy;
                            queue.offer(new int[]{nr, nc, nextMask, nextEnergy});
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}
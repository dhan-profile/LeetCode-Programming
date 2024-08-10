class Solution {
    public int regionsBySlashes(String[] grid) {
        int width = grid.length * 3;
        int[][] newGraph = new int[width][width];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (Character.toString(grid[i].charAt(j)).equals(" ")) {
                    continue;
                } else if (grid[i].charAt(j) == '/') {
                    newGraph[i * 3][j * 3 + 2] = 1;
                    newGraph[i * 3 + 1][j * 3 + 1] = 1;
                    newGraph[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    newGraph[i * 3][j * 3] = 1;
                    newGraph[i * 3 + 1][j * 3 + 1] = 1;
                    newGraph[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        int rows = newGraph.length;
        int cols = newGraph[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int componentCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (newGraph[i][j] == 0 && !visited[i][j]) {
                    dfs(newGraph, visited, i, j, rows, cols);
                    componentCount++;
                }
            }
        }
        return componentCount;

    }

    private static void dfs(int[][] grid, boolean[][] visited, int i, int j, int rows, int cols) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j] || grid[i][j] != 0) {
            return;
        }

        visited[i][j] = true;

        dfs(grid, visited, i - 1, j, rows, cols); // up
        dfs(grid, visited, i + 1, j, rows, cols); // down
        dfs(grid, visited, i, j - 1, rows, cols); // left
        dfs(grid, visited, i, j + 1, rows, cols); // right
    }
}
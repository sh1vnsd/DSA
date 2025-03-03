class FloydWarshall {
    public void shortestDistance(int[][] mat) {
        int n = mat.length;
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
                //Mat[i][j] == -1 means it is not reachable
        //         if (mat[i][j] == -1) {
        //             mat[i][j] = (int) (1e9);
        //         }
                    ////Diagonal
        //         if (i == j) {
        //             mat[i][j] = 0;
        //         }
        //     }
        // }
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                }
            }
        }

        //Revert the changes you made in first loop
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (mat[i][j] == (int) (1e9)) {
        //             mat[i][j] = -1;
        //         }
        //     }
        // }
    }

    public static void main(String[] args) {
        int[][] mat = {
            {0, 1, 43},
            {1, 0, 6},
            {-1, -1, 0}
        };

        FloydWarshall solution = new FloydWarshall();
        solution.shortestDistance(mat);

        System.out.println("Shortest distances between all pairs:");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

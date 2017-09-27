public class Exercise08_10{
    public static void main(String[] args){
        int[][] matrix = new int[4][4];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = (int)(Math.random()*2);
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        largestRow(matrix);
        largestColumn(matrix);  
    }
    
    public static void largestRow(int[][] matrix){
        int currentMax = 0;
        int currentMaxIndex = 0;
        for(int i = 0; i < matrix[0].length; i++){
            currentMax += matrix[0][i];
        }
        
        for(int j = 1; j < matrix.length; j++){
            int sumRow = 0;
            for(int k = 0; k < matrix[0].length; k++){
                sumRow += matrix[j][k];
                if(sumRow > currentMax){
                currentMax = sumRow;
                currentMaxIndex = j;
                }
            }
        }
        System.out.println("The largest row index: " + currentMaxIndex);
    }

    public static void largestColumn(int[][] matrix){
        int currentMax = 0;
        int currentMaxIndex = 0;
        for(int i = 0; i < matrix.length; i++){
            currentMax += matrix[i][0];
        }
        
        for(int j = 1; j < matrix[0].length; j++){
            int sumColumn = 0;
            for(int k = 0; k < matrix.length; k++){
                sumColumn += matrix[k][j];
                if(sumColumn > currentMax){
                currentMax = sumColumn;
                currentMaxIndex = j;
                }
            }
        }
        System.out.println("The largest column index: " + currentMaxIndex);
    }
    
    
}
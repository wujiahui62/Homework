public class Location{

 public int row;
 public int column;
 public double maxValue;
  
 Location(double[][] a){
  maxValue = a[0][0];
  row = 0;
  column = 0;
  for(int i = 0; i < a.length; i++){
   for(int j = 0; j < a[0].length; j++){
    if(a[i][j] > maxValue){
     maxValue = a[i][j];
     row = i;
     column = j;
    }
   }
  }
 }
}
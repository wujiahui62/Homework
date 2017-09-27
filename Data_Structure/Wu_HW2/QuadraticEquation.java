public class QuadraticEquation{
 private double a;
 private double b;
 private double c;
 
 QuadraticEquation(double a, double b, double c){
  this.a = a;
  this.b = b;
  this.c = c;
 }
 
 public double getA(){
  return a;
 }

 public double getB(){
  return b;
 }

 public double getC(){
  return c;
 }
 
 public double getDiscriminant(){
  return b * b - 4 * a * c;
 }

 public double getRoot1(){
  return getDiscriminant() < 0 ? 0 : (- b + Math.sqrt(getDiscriminant())) / (2 * a);
 }

 public double getRoot2(){
  return getDiscriminant() < 0 ? 0 : (- b - Math.sqrt(getDiscriminant())) / (2 * a);
 }
}
public class MyString1{
 
 private char[] chars;
 
 public MyString1(char[] chars){
  this.chars = new char[chars.length];
  for(int i = 0; i < chars.length; i++){
   this.chars[i] = chars[i];
  }
 }
 
 public char charAt(int index){
  return chars[index];
 }
 
 public int length(){
  return chars.length;
 }
 
 public MyString1 substring(int begin, int end){
  char[] sub = new char[end - begin];
  for(int i = begin, j = 0; i < end; i++, j++){
   sub[j] =chars[i];
  }
  return new MyString1(sub);
 }
  
 public MyString1 toLowerCase(){
  char[] ch = new char[chars.length];
  for(int i = 0; i < chars.length; i++){
   if(chars[i] >= 'A' && chars[i] <= 'Z')
    ch[i] = (char)(chars[i] + 32);
   else
    ch[i] = chars[i];
  }
  return new MyString1(ch);
 }
 
 public boolean equals(MyString1 s){
  if(s.length() != chars.length)
   return false;
  for(int i = 0; i < s.length(); i++){
   if(s.charAt(i) != chars[i])
    return false;
  }
  return true;
 }
 
 public static MyString1 valueOf(int i){
  int length = 0;
  int a = i;
  while(a >= 1){
   a = a / 10;
   length++;
  }
  
  char[] ch = new char[length];
  
  for(int j = 0, k = (int)Math.pow(10, length - 1); j < length; j++, k = k / 10){
   ch[j] = (char)(i / k + '0');
   i = i % k;
  }
  return new MyString1(ch);
 }
}
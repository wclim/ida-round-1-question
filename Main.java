import java.util.Scanner;
import java.util.LinkedList;

public class Main { 
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Integer numTest = scanner.nextInt();
    Integer n=0;
    for (int i=0; i<numTest; i++){
      n = scanner.nextInt();
      LinkedList<Integer> seq = new LinkedList<Integer>();
      if (n>0){
        for (int j=0; j<n; j++){
          seq.offer(scanner.nextInt());
        }
        processSeq(seq);
      }
    }
    scanner.close();
  }

  static void processSeq(LinkedList<Integer> seq){

    Integer matchedSeqSize = 0;
    LinkedList<Integer> mostMatchedSeqFound = new LinkedList<Integer>();
    mostMatchedSeqFound.addAll(seq);
    Integer mostMatchedSeqSize = 0;
    for (int i=0; i<= seq.size(); i++){
      matchedSeqSize = findMatch(seq);
      if (mostMatchedSeqSize < matchedSeqSize){
       mostMatchedSeqFound = new LinkedList<Integer>();
       mostMatchedSeqFound.addAll(seq);
       mostMatchedSeqSize = matchedSeqSize;
      }
      seq.offer(seq.poll());
    }
    printSeq(mostMatchedSeqFound);
  }
   
 static Integer findMatch(LinkedList<Integer> seq){
   Integer match = 0;
   for (int i=0; i<seq.size(); i++){
     if (i+1 == seq.get(i)){
       match++;
     }
   }
   return match;
 }
 
 static void printSeq(LinkedList<Integer> seq){
   for (int i=0; i<seq.size(); i++){
     System.out.print(seq.get(i));
     if (i<seq.size()-1){
       System.out.print(" ");
     }else{
       System.out.println();
     }
   }
 }
}
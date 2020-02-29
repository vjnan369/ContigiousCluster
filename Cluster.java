import java.io.*;
public class Cluster{
  public static void main(String args[])throws Exception{
    //In a given apartment area 1's showing as parking area and 0's are for residence area.
    //1's which are showing contigiously(resides to left/right/top/bottom but not diagonal) makes a single cluster.
    // We need to identify count of clusters which are used for parking.
    int[][] apartment = {
      {1, 0, 0, 1, 1},
      {1, 1, 0, 0, 1},
      {0, 0, 1, 0, 0},
      {0, 0, 0, 1, 0},
      {0, 0, 0, 0, 1}
    };//answer will be 5 clusters

    boolean[][] isVisited = {
      {false, false, false, false, false},
      {false, false, false, false, false},
      {false, false, false, false, false},
      {false, false, false, false, false},
      {false, false, false, false, false}
    };

    int clusterCount = 0;
    for(int row=0; row<apartment.length; row++){
      for(int column=0;  column<apartment[row].length; column++){
        if(!isVisited[row][column]){
          isVisited[row][column] = true;
          if(apartment[row][column] == 1){
            clusterCount++;
            iterate(row+1, column, apartment, isVisited, apartment.length, apartment[row].length);
            iterate(row-1, column, apartment, isVisited, apartment.length, apartment[row].length);
            iterate(row, column+1, apartment, isVisited, apartment.length, apartment[row].length);
            iterate(row, column-1, apartment, isVisited, apartment.length, apartment[row].length);
          }
        }
      }
    }
    System.out.println(clusterCount);
  }

  public static boolean iterate(int row, int column, int[][] apartment, boolean[][] isVisited, int rowlength, int columnlength){
    if (row>=rowlength || column >= columnlength || row<0 || column < 0){
      return true;
    }
    if (isVisited[row][column] == false && apartment[row][column] == 1){
      isVisited[row][column] = true;
      iterate(row+1, column, apartment, isVisited, apartment.length, apartment[row].length);
      iterate(row-1, column, apartment, isVisited, apartment.length, apartment[row].length);
      iterate(row, column+1, apartment, isVisited, apartment.length, apartment[row].length);
      iterate(row, column-1, apartment, isVisited, apartment.length, apartment[row].length);
      return true;
    }
    return true;
  }
}

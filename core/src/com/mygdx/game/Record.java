package com.mygdx.game;

import java.io.*;


public class Record {

    private String str = "D:\\downloads\\YandexDisk\\prog\\java\\GameBall\\assets\\record.txt";

     public void writerRecord(int count) {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str));
            bufferedWriter.write(Integer.toString(count));
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException err) {
            err.getStackTrace();
        }
    }

    public int readerRecord() {
        int i;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
             i=Integer.parseInt (bufferedReader.readLine());
           return  i ;
        } catch (IOException err) {
            err.getStackTrace();
        }
        return -1;
    }


}

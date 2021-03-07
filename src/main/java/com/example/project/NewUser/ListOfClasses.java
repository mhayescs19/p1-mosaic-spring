package com.example.project.NewUser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public class ListOfClasses {
   public static List TeacherAndClassList;
   static {
      try {
         TeacherAndClassList = createList();
      } catch (IOException e) {
         e.printStackTrace();
         try {
            TeacherAndClassList = createList();
         } catch (IOException ioException) {
            ioException.printStackTrace();
            System.exit(-1);
         }
      }
   }
   public static List<String> subjects = List.of("MathA","MathB","English1","English2","Bio","Physics","Art","Computer Science");
   public static List<String> grades = List.of("C+","B-","B+","A-","A","A+");
   /**
    *
    * @return a list of lists of strings
    * @throws IOException not good lets hope that this does not happen
    */
   private static List createList() throws IOException {
      BufferedReader bufferedReader = new BufferedReader
              (new InputStreamReader
                      (Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Abstractdata/Results.json"))));

      String lines;
      StringBuilder jsonfile = new StringBuilder();
      while ((lines=bufferedReader.readLine())!=null)
      {
         jsonfile.append(lines);
      }
      return new ObjectMapper().readValue(jsonfile.toString(),List.class);
   }


}

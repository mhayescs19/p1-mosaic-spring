package com.example.project.NewUser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
@Service
@Repository("ClassListData")
public class ListOfClasses {
   public static List TeacherAndClassList;
   public static List<String> subjects = List.of("MathA","MathB","English1","English2","Bio","Physics","Art","Computer Science");
   public static List<String> grades = List.of("C+","B-","B","B+","A-","A","A+");

   public ListOfClasses() throws IOException {
      BufferedReader reader= new BufferedReader(new InputStreamReader(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("Abstractdata/Results.json"))));
      String lines;
      StringBuilder jsonfile = new StringBuilder();
      while ((lines=reader.readLine())!=null)
      {
         jsonfile.append(lines);
      }
      TeacherAndClassList = new ObjectMapper().readValue(jsonfile.toString(),List.class);
   }

   /**
    * @deprecated
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

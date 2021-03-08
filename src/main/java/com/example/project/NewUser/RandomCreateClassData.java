package com.example.project.NewUser;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import synergy.Assignment;
import synergy.Class;
import com.example.project.NewUser.ListOfClasses;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.project.NewUser.ListOfClasses.TeacherAndClassList;
import static com.example.project.NewUser.ListOfClasses.subjects;
import static com.example.project.NewUser.ListOfClasses.grades;

@Service
@Repository("CreateClassData")
public class RandomCreateClassData {
    public List<String> nameOfAssignemtns;
    /* Assignment data Outline
            date
            Name
            Score
            Points
            Notes
            Grade
     */
    /*
            Class Data Outline
            Name
            Teacher
            Grade
            Period
            Assignments(line 9)
     */


    public RandomCreateClassData()
    {
        nameOfAssignemtns = new ArrayList<>();
        for (int i=1; i<26; i++)
        {
            nameOfAssignemtns.add("Hw "+i);
        }
        for (int i=1; i<6; i++)
        {
            nameOfAssignemtns.add("Quiz "+ i);
        }
        for (int i =1; i<4; i++)
        {
            nameOfAssignemtns.add("Test " + i);
        }
    }
    /**
     *
     * @return the list of classes that new user will have
     */
    public List<Class> createClassesData()
    {
        ArrayList<Integer> teachsNums = new ArrayList<>();
        ArrayList<Integer> subjectsNums = new ArrayList<>();
        List<Class> classList = new ArrayList<>(5);
        for (int i=1; i<=5; i++)
        {
            classList.add(createClassData(teachsNums,subjectsNums,i));
        }

        return classList;
    }
    private Class createClassData(ArrayList<Integer> teachNums, ArrayList<Integer> subjectsNums,int period)
    {

        Random random = new Random();
        if (teachNums.isEmpty()) {
            teachNums.add(random.nextInt(TeacherAndClassList.size()));
        }
        else
        {
            while (true)
            {
                Integer temp = random.nextInt(TeacherAndClassList.size());
                if (!teachNums.contains(temp))
                {
                   teachNums.add(temp);
                   break;
                }
            }

        }
        if (subjectsNums.isEmpty())
        {
            subjectsNums.add(random.nextInt(subjects.size()));
        }
        else
        {
            while (true)
            {
                Integer temp = random.nextInt(subjects.size());
                if (!subjectsNums.contains(temp))
                {
                    subjectsNums.add(temp);
                    break;
                }
            }
        }
        ArrayList listOfNames = (ArrayList) TeacherAndClassList.get(teachNums.get(teachNums.size()-1));
        StringBuilder teacher = new StringBuilder();
        int counter =0;
        for (Object obj:listOfNames) {
            teacher.append(obj.toString());
            if(counter%2==0)
            {
                teacher.append(" ");
            }
            counter++;

        }
        String name = subjects.get(subjectsNums.get(subjectsNums.size()-1));
        String grade="empty";
        Class temp= new Class(name,teacher.toString(),grade);
        temp.setAssignments(createListOfAssignments());
        List<Assignment> findGrade = temp.getAssignments();
        Double points = findGrade.stream().mapToDouble(Assignment::getPoints).sum();
        Double score = findGrade.stream().mapToDouble(Assignment::getScore).sum();
        temp.setGrade(findGrade(score/points));
        temp.setPeriod(period);
        return temp;


    }
    private String findGrade(double value)
    {
        if (value <.70)
        {
            return "D";
        }
        if (value<.73)
        {
            return "C-";
        }
        if (value<.77)
        {
            return "C";
        }
        if (value<.80)
        {
            return "C+";
        }
        if (value<.83)
        {
            return "B-";
        }
        if (value<.87)
        {
            return "B";
        }
        if (value<.90)
        {
            return "B+";
        }
        if (value<.93)
        {
            return "A-";
        }
        if (value<.97)
        {
            return "A";
        }
        if (value <=1.0) {
            return "A+";
        }
        return "Can not calculate grade";
    }


    /**
     * Called In order to create a list of Assignments for each class
     * @return list of Assignments for each class
     */
    private List<Assignment> createListOfAssignments()
    {
        ArrayList<Integer> numbersUsed = new ArrayList<>();
        List<Assignment> assignmentArrayList = new ArrayList<>();
        createAssignment(numbersUsed,assignmentArrayList); //undefine number of returns, returns are between 1-9 inclusive

        return assignmentArrayList;
    }

    /**
     *
     * @param numbers numbers not to use
     * @param assignmentList list of Assignments to be used for each class
     */
    private void createAssignment(ArrayList<Integer> numbers,List<Assignment> assignmentList)
    {
        final String year = "2021";
        /*
        dates im thinking 01/10/2021 - 02/28/2021
         */
        String date = "0";
        Random random =new Random();
        int temp = random.nextInt(2)+1;
        if (temp==1)
        {
            date+=temp+"/";
            temp = random.nextInt(31)+1;
            date+= temp+"/"+year;

        }
        else
        {
            date+=temp+"/";
            temp = random.nextInt(28)+1;
            date+=temp+"/"+year;
        }
        if (numbers.isEmpty())
        {
            numbers.add(random.nextInt(nameOfAssignemtns.size()));
        }
        else
        {
            while (true)
            {
                temp = random.nextInt(nameOfAssignemtns.size());
                if (!numbers.contains(temp))
                {
                    numbers.add(temp);
                    break;
                }
            }
        }
        Assignment local = new Assignment();
        local.setDate(date);
        local.setAssignmentTitle(nameOfAssignemtns.get(numbers.get(numbers.size()-1)));
        local.setGrade(grades.get(random.nextInt(grades.size())));
        String localGrade = local.getGrade();
        double lowerBound;
        double UpperBound;
        switch (localGrade) {
            case "C+" -> {
                lowerBound = .78;
                UpperBound = .80;
            }
            case "B-" -> {
                lowerBound = .80;
                UpperBound = .83;
            }
            case "B" ->
                    {
                        lowerBound=.83;
                        UpperBound=.87;
                    }
            case "B+" -> {
                lowerBound = .87;
                UpperBound = .90;
            }
            case "A-" -> {
                lowerBound = .90;
                UpperBound = .93;
            }
            case "A" -> {
                lowerBound = .94;
                UpperBound = .97;
            }
            case "A+" -> {
                lowerBound = .97;
                UpperBound = 1.0;
            }
            default -> {
                lowerBound = .80;
                UpperBound = .95;
            }
        }
        int points = random.nextInt(41)+10;
        double score = (points* random.doubles(1,lowerBound,UpperBound).sum()); // points * percent
        score = Math.round(score*Math.pow(10,3))/Math.pow(10,3); //rounding to 3 decimal percent
        local.setScore(score);
        local.setPoints(points);
        local.setNotes("This was procedurally generated, this is not an accurate representation of how grading works.");
        assignmentList.add(local);
        if (random.nextBoolean() && numbers.size()<10) // limits recursion to max of 10 loops
        {
            createAssignment(numbers, assignmentList);
        }

    }





}

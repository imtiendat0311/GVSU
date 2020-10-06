package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GVdate {
    private int day;
    private int month;
    private int year;
    public GVdate(){
    int month = 10;
    int day=12;
    int year = 2020;
    }

    public GVdate(String date ){
        List<Integer> dateList = Arrays.stream(date.split("/"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        month= dateList.get(0);
        day= dateList.get(1);
        year= dateList.get(2);
        if(!isDateValid(month,day,year)){
            month=10;
            day=12;
            year=2020;
            }
        }


    public static boolean isLeapYear(int y){
        if(y>=1 && y<=9999){
            if(y%4==0){
                if(y%100==0){
                    if(y%400==0){
                        return true;
                    }//end if year%400==0
                    else //else of year%400==0
                    {
                        return false;
                    }//end else of year%400==0
                }//end if year%100==0
                else //else of year%100==0
                {
                    return true;
                }//end else of year%100==0
            }//end of if year%4==0
            else //else of year%4==0
            {
                return false;
            }//end else of year%4==0
        }//end first if
        return false;
    }//end method
    private int getLastDayOfMonth(int m,int y){
        if(m==2){
            if(isLeapYear(y)){
                return 29;
            }
            else{
                return 28;
            }
        }
        else if(m==1 || m==3 || m ==5 || m==7 || m==8 || m==10 || m==12){
            return 31;
        }
        else{return 30;}
    }
    private boolean isDateValid(int m,int d,int y){
        if(m<=12 && m>=1 && y>=0 && d>0 && getLastDayOfMonth(m,y)>=d){
                return true;
        }
        return false;
        }//end method
        //setter method
        public void setDay(int day){
        if(!isDateValid(this.month, day, this.year)){
            System.out.println("setDay() day will create a wrong date");
        }
        else{ this.day=day; }
        }

        public void setMonth(int month){
        if(!isDateValid(month,this.day,this.year)){
            System.out.println("invalid month");
        }
        else{this.month=month;}
        }

        public void setYear(int year){
        if(!isDateValid(this.month,this.day,year)){
            System.out.println("invalid year");
        }
        else{this.year=year;}
        }

        //getter method
        public int getDay(){
        return day;
        }
        public int getMonth(){
        return month;
        }
        public int getYear(){
        return year;
        }

    @Override
    public String toString() {
        return month+"/"+day+"/"+year;
    }
}//end class

package com.company;
import java.text.DecimalFormat;
public class phaseThree {
    private int month;
    private int day;
    private int year;
    /////////////////////////////////////////////////
    /* FOR TESTING PURPOSE 
    public static void main (String args[]){
        System.out.println("randome day:");

        phaseThree date = new phaseThree(11,3,1999); //random
   System.out.println(date.formatDate(1));
        System.out.println(date.formatDate(2));
        System.out.println(date.formatDate(3));
        System.out.println(date.formatDate(4));
        System.out.println("First of bound :");
    phaseThree dataFirst = new phaseThree(1,31,1999);

        System.out.println(dataFirst.formatDate(1));
        System.out.println(dataFirst.formatDate(2));
        System.out.println(dataFirst.formatDate(3));
        System.out.println(dataFirst.formatDate(4));
        dataFirst.nextDay();
        System.out.println(dataFirst.formatDate(1));
        System.out.println("End of bound :");
    phaseThree dataLast = new phaseThree(12,31,1999);
        System.out.println(dataLast.formatDate(1));
        System.out.println(dataLast.formatDate(2));
        System.out.println(dataLast.formatDate(3));
        System.out.println(dataLast.formatDate(4));
        dataLast.nextDay();
        System.out.println(dataLast.formatDate(1)); 
        //check skip ahead
        phaseThree dateSkip=new phaseThree(12,25,1999);
        dateSkip.skipAHead(7);
        System.out.println(dateSkip.formatDate(1));

        //check equal
        GVdate otherDate = new GVdate("11/3/1999");
        phaseThree datecheckcorrect=new phaseThree(11,3,1999);
        System.out.println(datecheckcorrect.equal(otherDate)); //must be true
        phaseThree datecheckfalse=new phaseThree(12,3,1999);
        System.out.println(datecheckfalse.equal(otherDate));//must be false
    }
    */
    /////////////////////////////////////////////////
    public phaseThree(int month,int day,int year) {
        this.month=month;
        this.day=day;
        this.year=year;
    }
    public String formatDate(int format){
        if(format==1){
            return Integer.toString(month)+"/"+Integer.toString(day)+"/"+Integer.toString(year);
        }
        else if(format==2){
        DecimalFormat   dF=new DecimalFormat("00");
        String monthFormat = dF.format(month);
        String dayFormat = dF.format(day);
        return monthFormat+"/"+dayFormat+"/"+year;
        }
        else if(format==3){
        String allMonth="JanFebMarAprMayJunJulAugSepOctNovDec";
        int endIndex=month*3;
        return allMonth.substring((month*3)-3,month*3)+"/"+Integer.toString(day)+"/"+Integer.toString(year);
        }
        else if(format==4){
            switch(month){
                case 1:
                    return "January "+Integer.toString(day)+","+Integer.toString(year);
                case 2:
                    return "Febuary "+Integer.toString(day)+","+Integer.toString(year);
                case 3:
                    return "March "+Integer.toString(day)+","+Integer.toString(year);
                case 4:
                    return "April "+Integer.toString(day)+","+Integer.toString(year);
                case 5:
                    return "May "+Integer.toString(day)+","+Integer.toString(year);
                case 6:
                    return "June "+Integer.toString(day)+","+Integer.toString(year);
                case 7:
                    return "July "+Integer.toString(day)+","+Integer.toString(year);
                case 8:
                    return "August "+Integer.toString(day)+","+Integer.toString(year);
                case 9:
                    return "September "+Integer.toString(day)+","+Integer.toString(year);
                case 10:
                    return "October "+Integer.toString(day)+","+Integer.toString(year);
                case 11:
                    return "November "+Integer.toString(day)+","+Integer.toString(year);
                case 12:
                    return "December "+Integer.toString(day)+","+Integer.toString(year);
            }

        }
        return "0";
    }

    public void nextDay(){
        if(day==getLastDayOfMonth(month,year)){
            day=1;
            if(month==12){
                month=1;
                year=year+1;
            }
            else{
                month=month+1;
            }
        }
        else{
            day=day+1;
        }
    }

    //import code from previous work of mine
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
    private void skipAHead(int numDays){
        if(numDays>=0){
            day=numDays+day;
            if(day>getLastDayOfMonth(month,year)){
                day=day-getLastDayOfMonth(month,year);
                month=month+1;
                if(month>12){
                    month=month-11;
                    year=year+1;
                }
                else{
                    month=month-11;
                }
            }
        }
    }
    public boolean equal(GVdate otherDate){
        if(otherDate.getDay()==this.day&&otherDate.getMonth()==this.month&&otherDate.getYear()==this.year){
            return true;
        }

        return false;
    }


}

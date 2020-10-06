package com.company;


import static org.junit.Assert.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.*;
    /**************************************************
     * The test class GVdate.
     *
     * @author  Scott Grissom
     * @version (1.0.0)
     * @version (1.0.1) - Ana Posada
     * To include:
     * 1. contructor GVdate (String date) testing
     * 2. invalid date testing for constructors and setDate
     * 3. invalid date testing for setMonth, setDay and setYear
     ****************************************************/
    public class GVdateTestPhase2{
        private GVdate d;

        /*********************************************************
         *  Test Date Constructor3 GVdate (String date)
         ********************************************************/
        @Test
        public void testConstructor3(){
            d = new GVdate("4/2/1963");
            Assert.assertEquals("Constructor3 - month not set correctly",
                    4, d.getMonth());
            Assert.assertEquals("Constructor3 - day not set correctly",
                    2, d.getDay());
            Assert.assertEquals("Constructor3 - year not set correctly",
                    1963, d.getYear());
            d = new GVdate("11/20/1963");
            Assert.assertEquals("Constructor3 - month not set correctly",
                    11, d.getMonth());
            Assert.assertEquals("Constructor3 - day not set correctly",
                    20, d.getDay());
            Assert.assertEquals("Constructor3 - year not set correctly",
                    1963, d.getYear());
            d = new GVdate("11/2/1963");
            Assert.assertEquals("Constructor3 - month not set correctly",
                    11, d.getMonth());
            Assert.assertEquals("Constructor3 - day not set correctly",
                    2, d.getDay());
            Assert.assertEquals("Constructor3 - year not set correctly",
                    1963, d.getYear());
            d = new GVdate("1/12/1963");
            Assert.assertEquals("Constructor3 - month not set correctly",
                    1, d.getMonth());
            Assert.assertEquals("Constructor3 - day not set correctly",
                    12, d.getDay());
            Assert.assertEquals("Constructor3 - year not set correctly",
                    1963, d.getYear());
        }



        @Test
        public void testInvalidDateConstructor3(){
            testInvalidMonth1("constructor3");
            testInvalidNegativeMonth("constructor3");
            testInvalidNegativeDay("constructor3");
            testInvalidNegativeYear("constructor3");
            testInvalidDayUpperBound("constructor3");
        }

        /*********************************************************
         * Test setMonth
         ********************************************************/
        @Test
        public void testSetMonth(){
            d = new GVdate("4/20/1963");
            d.setMonth(12);
            Assert.assertEquals("setMonth() month not set to input parameter",
                    12, d.getMonth());
        }
        /*********************************************************
         * Test setYear
         ********************************************************/
        @Test
        public void testSetYear(){
            d = new GVdate("4/20/1963");
            d.setYear(2013);
            Assert.assertEquals("setYear() year not set to input parameter",
                    2013, d.getYear());
        }
        /*********************************************************
         * Test setDay
         ********************************************************/
        @Test
        public void testSetDay(){
            d = new GVdate("4/20/1963");
            d.setDay(28);
            Assert.assertEquals("setDay() day not set to input parameter",
                    28, d.getDay());

            d.setDay(29);
            Assert.assertEquals("setDay() day not set to input parameter",
                    29, d.getDay());
        }
        /*********************************************************
         * Test InvalidDaysetDay
         ********************************************************/
        @Test
        public void testInvalidDaySetDay(){
            d = new GVdate("4/20/1963");
            d.setDay(31);
            Assert.assertEquals("setDay() day will create a wrong date" +
                    "- date should not change", 20, d.getDay());
            testInvalidNegativeDay("setDay");
            testInvalidDayUpperBound("setDay");
        }
        /*********************************************************
         * Test invalid month setMonth
         ********************************************************/
        @Test
        public void testInvalidMonthSetMonth() {
            d = new GVdate("1/31/1960");
            d.setMonth(6);
            Assert.assertEquals("setMonth() month will create a wrong date" +
                    "- date should not change", 1, d.getMonth());
            testInvalidMonth1("setMonth");
            testInvalidNegativeMonth("setMonth");
        }
        /*********************************************************
         * Test setYear
         ********************************************************/
        @Test
        public void testInvalidYearSetYear(){
            d = new GVdate("1/31/1960");
            d.setYear(-1);
            Assert.assertEquals("setYear() year will create a wrong date"+"- date should not change",1960,d.getYear());
            testInvalidNegativeYear("setYear");
        }
        /*********************************************************
         * Test Leap Year
         ********************************************************/
        @Test
        public void testLeapYear(){
            d = new GVdate ("4/20/1963");

            Assert.assertTrue("1963 is NOT a leap year",
                    !d.isLeapYear(1963));
            d=new GVdate("4/20/1600");
            Assert.assertTrue("1600 is a leap year",
                    d.isLeapYear(1600));
            d=new GVdate("4/20/2000");
            Assert.assertTrue("2000 is a leap year",
                    d.isLeapYear(2000));
            d=new GVdate("4/20/2004");
            Assert.assertTrue("2004 is a leap year",
                    d.isLeapYear(2004));
            d=new GVdate("4/20/1900");
            Assert.assertTrue("1900 is NOT a leap year",
                    !d.isLeapYear(1900));
        }
        /*********************************************************
         * Test invalid month1 - testing value 13
         * @param - method that calls this method
         ********************************************************/
        private void testInvalidMonth1(String method){
            d = new GVdate();
            switch (method){
                case "constructor3":
                    d = new GVdate("13/20/1963");
                    Assert.assertEquals("invalid month - date should not change or " +
                            "constructors should create the default date" ,"10/12/2020", d.toString());
                    break;
                case "setMonth":
                    d = new GVdate("12/20/1963");
                    d.setMonth(13);
                    Assert.assertEquals("invalid month - date should not change or " +
                            "constructors should create the default date" ,12, d.getMonth());
            }

        }
        /*********************************************************
         * Test invalid month2 - testing value 0
         * @param - method that calls this method
         ********************************************************/
        private void testInvalidNegativeMonth(String method){
            d = new GVdate();
            switch (method){

                case "constructor3":
                    d = new GVdate("-1/20/1963");
                    Assert.assertEquals("invalid month - date should not change or " +
                            "constructors should create the default date", "10/12/2020", d.toString());
                    break;

                case "setMonth":
                    d = new GVdate("1/20/1963");
                    d.setMonth(-1);
                    Assert.assertEquals("invalid month - date should not change or " +
                            "constructors should create the default date", 1, d.getMonth());
            }

        }
        /*********************************************************
         * Test invalid month3 - testing negative day
         * @param - method that calls this method
         ********************************************************/
        private void testInvalidNegativeDay(String method){
            d = new GVdate();
            switch (method){
                case "constructor3":
                    d = new GVdate("1/-20/1963");
                    Assert.assertEquals("invalid day - date should not change or " +
                            "constructors should create the default date","10/12/2020", d.toString());
                    break;
                case "setDay":
                    d = new GVdate("1/20/1963");
                    d.setDay (-20);
                    Assert.assertEquals("invalid day - date should not change or " +
                            "constructors should create the default date",20, d.getDay());

            }

        }
        /*********************************************************
         * Test invalid month1 - testing value 13
         * @param - method that calls this method
         ********************************************************/
        private void testInvalidNegativeYear(String method){
            d = new GVdate();
            switch (method){
                case "constructor3":
                    d = new GVdate("4/20/-4");
                    Assert.assertEquals("invalid Year - date should not change or " +
                            "constructors should create the defaul date", "10/12/2020", d.toString());
                    break;
                case "setYear":
                    d = new GVdate("4/20/2010");
                    d.setYear(-4);
                    Assert.assertEquals("invalid Year - date should not change or " +
                            "constructors should create the defaul date", 2010, d.getYear());
                    break;
            }

        }
        /*********************************************************
         * Test invalid day - testing upper bound for each month
         * @param - method that calls this method
         ********************************************************/
        private void testInvalidDayUpperBound(String method){
            int[ ] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
            for (int i = 0 ; i <= 11 ; i++) {
                d = new GVdate ();
                if (i == 1) {
                    // checking february for a NOT leap year
                    d = new GVdate("2/29/2021");
                    Assert.assertEquals("invalid day for month -" +
                            "constructor should create the default date","10/12/2020", d.toString());
                    d = new GVdate("2/29/2021");
                    Assert.assertEquals(" invalid day for month - " +
                            "constructor should create the default date","10/12/2020", d.toString());
                    d = new GVdate("2/27/2021");
                    d.setDay(29);
                    Assert.assertEquals(" invalid day for month - date should not change",
                            "2/27/2021", d.toString());
                }
                else {
                    switch (method){
                        case "constructor3":
                            d = new GVdate ((i + 1) + "/" + (monthDays [i] + 1) +
                                    "/" + "2020");
                            Assert.assertEquals(" invalid day for month - " +
                                    "constructor should create the default date","10/12/2020", d.toString());
                            break;
                        case "setDay" :
                            d = new GVdate("2/27/2021");
                            d.setDay(monthDays [i] + 1);
                            Assert.assertEquals("invalid day for month - date should not change",
                                    27, d.getDay());
                    }
                }
            }
        }
    }


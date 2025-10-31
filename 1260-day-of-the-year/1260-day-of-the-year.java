class Solution {

    private int dayinMonth(int month){

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) return 31;

        if (month == 2) return 28;

        return 30;
    }

    private boolean checkLeapYear(int year){
        if (year % 400 == 0) return true;

        if (year % 100 == 0) return false;

        if (year % 4 == 0) return true;

        return false;
    }

    public int dayOfYear(String date) {
        int month = Integer.parseInt(date.substring(5, 7));
        int dt = Integer.parseInt(date.substring(8));
        int year = Integer.parseInt(date.substring(0, 4));

        boolean leapYear = false;

        if (checkLeapYear(year)){
            leapYear = true;
        }

        int days = 0;

        for (int i = 1; i < month; i++){
             days += dayinMonth(i);
        }

        days += dt;

        if (leapYear && month > 2) days ++;

        return days;

    }
}
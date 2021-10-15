package com.company;

import java.util.Scanner;

public class ComputeWage {

    private String name;
    private double gtotal;
    private int hours;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGtotal() {
        return gtotal;
    }

    public void setGtotal(double gtotal) {
        this.gtotal = gtotal;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }



    public void acceptData(){

        boolean inputValid=true;

        Scanner key = new Scanner(System.in);

        System.out.println("Enter the name ");

        this.name = key.nextLine();

        while(inputValid){
            System.out.println("Enter the hours ");
            String input = key.next();

            try {
                hours = Integer.parseInt(input);
                inputValid=false;


            } catch(NumberFormatException e){
                System.out.println("You did not enter a valid number ");
            }




        }



    }


    public double computeWage(){

        if(this.hours>40){

            this.gtotal = (40 * 15) + (16.5 *(this.hours-40));
        } else {
            this.gtotal = this.hours * 15;
        }

        return this.gtotal;
    }

    public void display(){

        System.out.println("The total wage of " + this.name + " is " + this.gtotal);
    }

}

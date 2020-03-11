package proj0.src;

import org.jetbrains.annotations.NotNull;

public class Planet {

    /* Basic properties of Planet */
    // Its current x position
    public double xxPos;
    // Its current y position
    public double yyPos;
    // Its current velocity in the x direction
    public double xxVel;
    // Its current velocity in the y direction
    public double yyVel;
    // Its mass
    public double mass;
    //Name of corresponding image
    public String imgFileName;

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(@NotNull Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(@NotNull Planet x) {
        double distance;
        distance = Math.sqrt(Math.pow((x.xxPos - this.xxPos), 2) + Math.pow((x.yyPos - this.yyPos), 2));
        return distance;
    }

    public double calcForce(Planet x) {
        double g = 6.67E-11;
        double distance = this.calcDistance(x);
        double force = (g * x.mass * this.mass) / Math.pow(distance, 2);
        return force;
    }

    public double calcForceExertedByX(Planet x) {
        double g = 6.67E-11;
        double distance = this.calcDistance(x);
        double force = (g * x.mass * this.mass) / Math.pow(distance, 2);
        double forceX = force * (x.xxPos - this.xxPos) / distance;
        return forceX;
    }

    public double calcForceExertedByY(Planet x) {
        double g = 6.67E-11;
        double distance = this.calcDistance(x);
        double force = (g * x.mass * this.mass) / Math.pow(distance, 2);
        double forceY = force * (x.yyPos - this.yyPos) / distance;
        return forceY;
    }

    public double calcNetForceExertedByX(@NotNull Planet[] allPlant){
        double netForceX = 0;
        for(int i = 0; i < allPlant.length; i++) {
            if (!allPlant[i].equals(this))
                netForceX += calcForceExertedByX(allPlant[i]);
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(@NotNull Planet[] allPlant){
        double netForceY = 0;
        for(int i = 0; i < allPlant.length; i++) {
            if (!allPlant[i].equals(this))
                netForceY += calcForceExertedByY(allPlant[i]);
        }
        return netForceY;
    }

    public void update(double t, double xForce, double yForce){
        double aX = xForce / this.mass;
        double aY = yForce / this.mass;
        this.xxVel += t * aX;
        this.yyVel += t * aY;
        this.xxPos += this.xxVel * t;
        this.yyPos += this.yyVel * t;
    }
}

//    public static void main(String[] args) {
//        Planet sun = new Planet(1E12,2E11,0,0,2E30,"sun.gif");
//        Planet saturn = new Planet(2.3E12,9.5E11,0,0,6.0E26,"saturn.gif");
//    }



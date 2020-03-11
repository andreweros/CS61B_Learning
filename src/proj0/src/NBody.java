package proj0.src;

public class NBody {
    public static double readRadius(String path){
        In in = new In(path);
        int n = in.readInt();
        double radius = in.readDouble();
        return radius;
    }
    public static int readN(String path){
        In in = new In(path);
        int n = in.readInt();
        return n;
    }
    public static Planet[] readPlanets(String path){
        In in = new In(path);
        int n = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[n];
        for(int i = 0; i < n; i++)
           planets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];
        double r = readRadius(filename);
        int n = readN(filename);
        double time = 0.0;
        Planet[] planets = readPlanets(filename);
        double xForces[] = new double[n];
        double yForces[] = new double[n];

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-10*r, 10*r);
        StdDraw.clear();

        for (int i = 0; i < n; i++) {
            xForces[i] = planets[i].calcNetForceExertedByX(planets);
            yForces[i] = planets[i].calcNetForceExertedByY(planets);
        }

        while (time < T) {
            time += dt;
            for (int i = 0; i < n; i++) {
                StdDraw.picture(planets[i].xxPos, planets[i].yyPos, "images/" + planets[i].imgFileName);
                planets[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.show();
            StdDraw.pause(10);
            StdDraw.clear();
        }

    }
}

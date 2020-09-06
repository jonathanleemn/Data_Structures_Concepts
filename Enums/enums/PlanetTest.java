package enums;

public class PlanetTest {

    public static void main(String[] args) {
        Planets planets = Planets.EARTH;
        double earthWeight = 165;
        double mass = earthWeight/planets.surfaceGravity();
        for (Planets p : Planets.values())
           System.out.printf("Your weight on %s is %f%n",
                             p, p.surfaceWeight(mass));
    }
}

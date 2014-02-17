/**
 * @author Joey Bloom
 * Assignment #33
 * Utility class for calculating surface areas
 * and volumes of common 3D figures.
 */
public class Geometry
{
    /**
     * Calculates the volume of the sphere with radius r
     * @param r radius
     * @return volume
     */
    public static double sphereVolume(double r)
    {
        return 4.0/3.0 * Math.PI * r * r * r;
    }
    /**
     * Calculates the surface area of the sphere with radius
     * @param r radius
     * @return surface area
     */
    public static double sphereSurface(double r)
    {
        return 4 * Math.PI * r * r;
    }
    /**
     * Calculates the volume of the cylinder with radius r
     * and height h
     * @param r radius
     * @param h height
     * @return volume
     */
    public static double cylinderVolume(double r, double h)
    {
        return Math.PI * r * r * h;
    }
    /**
     * Calculates the surface area of the cylinder with radius r
     * and height h
     * @param r radius
     * @param h height
     * @return surface area
     */
    public static double cylinderSurface(double r, double h)
    {
        return 2 * Math.PI * r * (r + h);
    }
    /**
     * Calculates the volume of the cone with radius r
     * and height h
     * @param r radius
     * @param h height
     * @return volume
     */
    public static double coneVolume(double r, double h)
    {
        return 1.0 / 3.0 * Math.PI * r * r * h;
    }
    /**
     * Calculates the surface area of the cone with radius r
     * and height h
     * @param r radius
     * @param h height
     * @return surface area
     */
    public static double coneSurface(double r, double h)
    {
        return Math.PI * r * r + Math.PI * Math.sqrt(r * r + h * h);
    }
}

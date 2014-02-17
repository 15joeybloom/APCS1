/**
 * @author Joey Bloom
 * Assignment #33
 * Tests the static methods in the Geometry class
 */
public class GeometryTester
{
    public static void main(String[] args)
    {
        
        System.out.println("sphere: radius 1");
        System.out.println("Vol: " + Geometry.sphereVolume(1));
        System.out.println("SA: " + Geometry.sphereSurface(1) + "\n");
        System.out.println("sphere: radius 5");
        System.out.println("Vol: " + Geometry.sphereVolume(5));
        System.out.println("SA: " + Geometry.sphereSurface(5) + "\n");
        System.out.println("sphere: radius 1717");
        System.out.println("Vol: " + Geometry.sphereVolume(1717));
        System.out.println("SA: " + Geometry.sphereSurface(1717) + "\n");
        
        System.out.println("cylinder: radius 1 height 1");
        System.out.println("Vol: " + Geometry.cylinderVolume(1,1));
        System.out.println("SA: " + Geometry.cylinderSurface(1,1) + "\n");
        System.out.println("cylinder: radius 25 height 30");
        System.out.println("Vol: " + Geometry.cylinderVolume(25,30));
        System.out.println("SA: " + Geometry.cylinderSurface(25,30) + "\n");
        System.out.println("cylinder: radius 1717 height 71");
        System.out.println("Vol: " + Geometry.cylinderVolume(1717,71));
        System.out.println("SA: " + Geometry.cylinderSurface(1717,71) + "\n");
        
        System.out.println("cone: radius 1 height 1");
        System.out.println("Vol: " + Geometry.coneVolume(1,1));
        System.out.println("SA: " + Geometry.coneSurface(1,1) + "\n");
        System.out.println("cone: radius 25 height 30");
        System.out.println("Vol: " + Geometry.coneVolume(25,30));
        System.out.println("SA: " + Geometry.coneSurface(25,30) + "\n");
        System.out.println("cone: radius 1717 height 71");
        System.out.println("Vol: " + Geometry.coneVolume(1717,71));
        System.out.println("SA: " + Geometry.coneSurface(1717,71) + "\n");
    }
}
/*
Output:
sphere: radius 1
Vol: 4.1887902047863905
SA: 12.566370614359172

sphere: radius 5
Vol: 523.5987755982989
SA: 314.1592653589793

sphere: radius 1717
Vol: 2.1203106501808113E10
SA: 3.7046778978115514E7

cylinder: radius 1 height 1
Vol: 3.141592653589793
SA: 12.566370614359172

cylinder: radius 25 height 30
Vol: 58904.86225480862
SA: 8639.379797371932

cylinder: radius 1717 height 71
Vol: 6.575803268615503E8
SA: 1.92893537603001E7

cone: radius 1 height 1
Vol: 1.0471975511965976
SA: 7.584475591748159

cone: radius 25 height 30
Vol: 19634.954084936206
SA: 2086.178523516273

cone: radius 1717 height 71
Vol: 2.191934422871835E8
SA: 9267093.468900893


 */
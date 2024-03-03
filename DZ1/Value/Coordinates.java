package Value;

public class Coordinates 
{
    public int x;
    public int y;

   public Coordinates(int x, int y)
   {
        this.x = x;
        this.y = y;
   }

   public double getDistance(Coordinates coordinates)
   {
       return Math.sqrt(Math.pow((this.x-coordinates.x), 2)+Math.pow((this.y-coordinates.y), 2));
   }

   public String toString()
   {
          return "x: " + x + ". y: " + y;
   }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Processor {

    private static List<Point> pointList;

    public static void readFile(String filePath) throws FileNotFoundException
    {
        pointList = new ArrayList<>();

        File infile = new File(filePath);
        Scanner scan = new Scanner(infile);

        while (scan.hasNextLine())
        {
            String[] line = scan.nextLine().split(", ");
            Point p = new Point(Double.parseDouble(line[0]),
                    Double.parseDouble(line[1]),
                    Integer.parseInt(line[2]));
            pointList.add(p);
        }
    }

    public static void processPoints()
    {
        pointList = pointList.stream()
                .filter(p -> p.getZ() <= 2)
                .map(p -> new Point(p.getX() * 0.5, p.getY() * 0.5, p.getZ()))
                .map(p -> new Point(p.getX() - 150, p.getY() - 37, p.getZ())).toList();
    }

    public static void printNewList() throws FileNotFoundException
    {
        File outfile = new File("drawMe.txt");
        PrintStream printStream = new PrintStream(outfile);
        for (Point p : pointList)
        {
            printStream.println(p);
        }
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        readFile(args[0]);
        processPoints();
        printNewList();
    }

}

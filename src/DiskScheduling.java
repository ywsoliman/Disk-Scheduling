import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class DiskScheduling {

    static int total = 0;

    static ArrayList<Integer> setTempArray(ArrayList<Integer> sequence) {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < sequence.size(); i++){
            temp.add(sequence.get(i));
        }
        return temp;
    }

    static void addRange(ArrayList<Integer> temp, int start, int end) {
        temp.add(0, start);
        temp.add(end);
    }

    static void sortTemp(ArrayList<Integer> temp) {
        Collections.sort(temp);
    }

    static int getHeadIndex(ArrayList<Integer> temp, int head) {
        int headIndex = 0;
        for(int i = 0; i < temp.size(); i++)
        {
            if(head < temp.get(i))
            {
                headIndex = i;
                break;
            }
        }
        return headIndex;
    }

    static void FCFS(ArrayList<Integer> requests, int head) {

        int size = requests.size();
        int difference, sum = 0;

        System.out.println("FCFS Algorithm:");

        for(int i = 0; i < size; i++) {

            int req = requests.get(i);
            difference = Math.abs(req-head);
            sum += difference;
            System.out.print("("+head +"-> "+ req+")");
            head = req;

        }

        System.out.println("\nTotal head movements: " + sum);
    }

    static void SSTF(ArrayList<Integer> requests, int head) {

        int size = requests.size();
        int difference, req = 0, sum = 0;
        ArrayList<Integer> currentRequests = new ArrayList<>();
        for(int i : requests){
            currentRequests.add(i);
        }

        System.out.println("\nSSTF Algorithm:");

        int count = 0;
        while(count < size){
            int min = Integer.MAX_VALUE;
            for(int i : currentRequests){
                if(Math.abs(i - head) < min){
                    min = Math.abs(i - head);
                    req = i;
                }
            }
            difference = min;

            System.out.print("("+head +"-> "+ req+")");
            head = req;
            count++;

            sum += difference;
            currentRequests.remove(new Integer(req));
        }
        System.out.println("\nTotal head movements: "+ sum);
    }


    static void Scan(ArrayList<Integer> sequence, int head, String direction, int maxCylinder)
    {
        ArrayList<Integer> temp = setTempArray(sequence);
        addRange(temp, 0, maxCylinder);
        sortTemp(temp);
        int headIndex = getHeadIndex(temp, head);

        System.out.println("\nScan Algorithm:");

        if(direction.equalsIgnoreCase("right"))
        {
            for(int i = headIndex; i<temp.size(); i++)
            {
                System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
                total+= Math.abs(temp.get(i) - head);
                head = temp.get(i) ;
            }


            for(int i = headIndex-1; i>0; i--)
            {
                System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
                total+= Math.abs(temp.get(i) - head);
                head = temp.get(i) ;
            }
        }
        else
        {
            for(int i = headIndex-1; i>=0; i--)
            {
                System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
                total+= Math.abs(temp.get(i) - head);
                head = temp.get(i) ;
            }


            for(int i = headIndex; i<temp.size()-1; i++)
            {
                System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
                total+= Math.abs(temp.get(i) - head);
                head = temp.get(i) ;
            }
        }
        System.out.println("\nTotal head movements: "  + total);
        total = 0;
    }


    static void CircularScan(ArrayList<Integer> sequence, int head, String direction, int maxCylinder)
    {

        ArrayList<Integer> temp = setTempArray(sequence);
        addRange(temp, 0, maxCylinder);
        sortTemp(temp);
        int headIndex = getHeadIndex(temp, head);

        System.out.println("\nCircular Scan Algorithm:");

        if(direction.equalsIgnoreCase("right"))
        {
            for(int i = headIndex; i<temp.size(); i++)
            {
                System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
                total+= Math.abs(temp.get(i) - head);
                head = temp.get(i) ;
            }


            for(int i = 0; i<headIndex; i++)
            {
                System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
                total+= Math.abs(temp.get(i) - head);
                head = temp.get(i) ;
            }
        }
        else
        {
            for(int i = headIndex-1; i>=0; i--)
            {
                System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
                total+= Math.abs(temp.get(i) - head);
                head = temp.get(i) ;
            }


            for(int i = temp.size()-1; i>=headIndex; i--)
            {
                System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
                total+= Math.abs(temp.get(i) - head);
                head = temp.get(i) ;
            }
        }
        System.out.println("\nTotal head movements: "  + total);
        total = 0;
    }


    static void Look(ArrayList<Integer> sequence, int head, String direction)
    {
        ArrayList<Integer> temp = setTempArray(sequence);
        sortTemp(temp);
        int headIndex = getHeadIndex(temp, head);

        System.out.println("\nLook Algorithm:");

        if(direction.equalsIgnoreCase("right"))
        {
            for(int i = headIndex; i<temp.size(); i++)
            {
                System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
                total+= Math.abs(temp.get(i) - head);
                head = temp.get(i) ;
            }


            for(int i = headIndex-1; i>=0; i--)
            {
                System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
                total+= Math.abs(temp.get(i) - head);
                head = temp.get(i) ;
            }
        }
        else
        {
            for(int i = headIndex-1; i>=0; i--)
            {
                System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
                total+= Math.abs(temp.get(i) - head);
                head = temp.get(i) ;
            }


            for(int i = headIndex; i<temp.size(); i++)
            {
                System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
                total+= Math.abs(temp.get(i) - head);
                head = temp.get(i) ;
            }
        }
        System.out.println("\nTotal head movements: "  + total);
        total = 0;
    }



    static void CircularLook(ArrayList<Integer> sequence, int head, String direction)
    {
        ArrayList<Integer> temp = setTempArray(sequence);
        sortTemp(temp);
        int headIndex = getHeadIndex(temp, head);

        System.out.println("\nCircular Look Algorithm:");

        if(direction.equalsIgnoreCase("right"))
        {
            for(int i = headIndex; i<temp.size(); i++)
            {
                System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
                total+= Math.abs(temp.get(i) - head);
                head = temp.get(i) ;
            }


            for(int i = 0; i<headIndex; i++)
            {
                System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
                total+= Math.abs(temp.get(i) - head);
                head = temp.get(i) ;
            }
        }
        else
        {
            for(int i = headIndex-1; i>=0; i--)
            {
                System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
                total+= Math.abs(temp.get(i) - head);
                head = temp.get(i) ;
            }


            for(int i = temp.size()-1; i>=headIndex; i--)
            {
                System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
                total+= Math.abs(temp.get(i) - head);
                head = temp.get(i) ;
            }
        }
        System.out.println("\nTotal head movements: " + total);
        total = 0;
    }

    static void NewAlgorithm(ArrayList<Integer> sequence)
    {

        ArrayList<Integer> temp = setTempArray(sequence);
        sortTemp(temp);

        int head = 0;

        System.out.println("\nNewly optimized algorithm:");

        for(int i = 0; i<temp.size(); i++)
        {
            System.out.print( "(" + head + " -> " + temp.get(i) + ")" );
            total+= Math.abs(temp.get(i) - head);
            head = temp.get(i) ;
        }

        System.out.println("\nTotal head movements: " + total);
        total = 0;
    }




    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter head start cylinder: ");
        int head = scan.nextInt();

        System.out.print("Enter the number of requests: ");
        int size = scan.nextInt();

        System.out.println("Enter requests separated by spaces: ");
        ArrayList<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < size; i++)
            sequence.add(scan.nextInt());

        System.out.print("Enter the maximum range of the cylinder: ");
        int maxCylinder = scan.nextInt();

        System.out.print("Enter one direction 'Right' or 'Left': ");
        String direction = scan.next();

        FCFS(sequence, head);
        SSTF(sequence, head);
        Scan(sequence, head, direction, maxCylinder);
        CircularScan(sequence, head, direction, maxCylinder);
        Look(sequence, head, direction);
        CircularLook(sequence, head, direction);
        NewAlgorithm(sequence);

    }

}

import java.util.*;

public class bruh {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int i = 0;
        while(i<1000000){
            int temp = (int)Math.random()*1000000;
            if(!numbers.contains(temp)){
                numbers.add(temp);
                i++;
            }
        }
        Collections.sort(numbers);
        Scanner console = new Scanner(System.in);
        System.out.println("Enter a number between 1 - 1,000,000: ");
        int index = find(console.nextInt(), numbers);

        if(index==1)
            System.out.println("Number not found");
        else
            System.out.println("Number is at index: " + index);
    }

    public static int find(int number, ArrayList<Integer> list){

    }
}

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        // Does the String contains upper arrow "^"? \\
       //  INPUTS:                     OUTPUT         \\
      //_______________________________________________\\
     //  dasundai^dnoasd              will print YES    \\
    //___________________________________________________\\
   //  d,10[387ue891uq10-F%@E%!E!     will print NO       \\
  //_______________________________________________________\\
 //  ^                                will print YES        \\
//___________________________________________________________\\

        String randomString = scanner.nextLine();

        if(randomString.contains("^")){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}

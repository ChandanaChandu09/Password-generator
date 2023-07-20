import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class PasswordGenerator {

    // Constraints of the password are:
    // 1.It should contain at least one capital case letter.
    // 2.It should contain at least one lower-case letter.
    // 3.It should contain at least one number.
    // 4.It should contain at least one of the following special characters : ~,!,@,#,$,%,^,&,*,(,:,_,+,-,=,)
    // 5.Minimum length of the password is 8.

    public static char[] passwordgenerator(int n)
    {
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String specialchar = "~!@#$%^&*():_+-=";
        String numbers = "0123456789";

        char[] password=new char[n];
        String combination = uppercase + lowercase + specialchar + numbers;

        Random r=new Random();
        password[0] = uppercase.charAt(r.nextInt(uppercase.length()));
        password[1] = lowercase.charAt(r.nextInt(lowercase.length()));
        password[2] = numbers.charAt(r.nextInt(numbers.length()));
        password[3] = specialchar.charAt(r.nextInt(specialchar.length()));

        for(int i=4;i<n;i++)
        {
            password[i]=combination.charAt(r.nextInt(combination.length()));
        }
        return password;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the length of the password required(Minimum length of the password is 8): ");
        int n=Integer.parseInt(br.readLine());
        if(n<8)
        {
            System.out.println("Minimum length should be 8");
        }
        else
        {
            System.out.println("The generated password is:");
            System.out.println(passwordgenerator(n));
        }
    }
}

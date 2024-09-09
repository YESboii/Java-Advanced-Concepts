import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Test {
    public static void main(String[] args)throws CustomException {
        try{
            throw new CustomException("Custom");
        }
        catch (ArithmeticException | NullPointerException | CustomException exception){
//            exception.printStackTrace();


        }
    }
}
/*

Exception is an event that stops the normal execution of the program.
The main difference between error and exception is that error is not recoverable.

The first kind of exception is the Checked exception.:A well written code must recover from the checked exceptions.
such as IOException,FileNotFoundException. Leaving Unchecked exceptions (includes all subclasses of the RuntimeException class,
 as well as the Error class and its subclasses) all exceptions are Checked exceptions.

The second kind of exception is the error. These are exceptional conditions that are external to the application,
and that the application usually cannot anticipate or recover from. For example, suppose
that an application successfully opens a file for input, but is unable to read the file because of a hardware or system malfunction
java.io.IOError

The third kind of exception is the runtime exception.These are generally caused due to flawed logic,programming bugs, bad use of APIs.
And generally can go unnoticed and that the application usually cannot anticipate or recover from.
The application can catch this exception, but it probably makes more sense to eliminate the bug that caused the exception to occur.
NullPointer,Arithmetic,ArrayIndexOutOfBounds
 */

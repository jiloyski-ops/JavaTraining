package M4_Act5;

//Unchecked exception (RuntimeException: does not need to be declared)
class InvalidAccountFormatException extends RuntimeException {
public InvalidAccountFormatException(String message) {
   super(message);
}
}

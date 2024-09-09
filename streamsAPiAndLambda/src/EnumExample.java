public class EnumExample {
    public static void main(String[] args) {
        Status status = Status.OK;
        System.out.println("%s %s %s".formatted(status.name(),status.getStatus(),status.getPhrase()));
    }
}
enum Status{
    //these are all public static final instances of Status;
    OK(200,"Informational"), NOT_FOUND(404,"Client error");

    private int status;
    private String phrase;

    //constructor is always private of an enum
    Status(int status,String phrase){
        this.phrase = phrase;
        this.status = status;
    }
    public int getStatus(){
        return status;
    }
    public String getPhrase(){
        return phrase;
    }
}

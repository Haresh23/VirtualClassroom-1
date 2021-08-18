package bootcampdb;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Emailvalidation {
    private Pattern pattern;
    private  Matcher matcher;
    private static final String name_regex="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    public Emailvalidation() {
        // TODO Auto-generated constructor stub
        pattern= Pattern.compile(name_regex);
    }
    public boolean  idvalidator(final String name){
        matcher=pattern.matcher(name);
        return matcher.matches();
    }
}
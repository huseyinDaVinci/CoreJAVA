/**
 * Created by barin.huseyin on 2/21/2016.
 */
public class FunctionalInterface {

    public FunctionalInterface() {
        PasswordEncoder passwordEncoder = makeBadEncoder();
        doEncoding(passwordEncoder);
    }

    public PasswordEncoder makeBadEncoder() {
        return ((password, salt) -> {
            System.out.println("Coming result:" + password.toUpperCase());
            return password.toUpperCase();
        });
    }

    public void doEncoding(PasswordEncoder passwordEncoder) {
        passwordEncoder.encode("deneme", "deneme");
    }

    public static void main(String[] args) {

        new FunctionalInterface();


    }


}

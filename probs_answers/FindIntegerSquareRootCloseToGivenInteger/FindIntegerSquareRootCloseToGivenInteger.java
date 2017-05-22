package myfavorites;

/**
 * Created by huseyinbarin on 5/21/17.
 */
class FindIntegerSquareRootCloseToGivenInteger {


    static int findIntegerSquareRootCloseToGivenInteger(int k) throws Exception {
        if (k < 0) {
            throw new Exception("k cannot be lower than zero.");
        }

        long l = 0;
        long r = k;


        while (l <= r) {
            long mid = l + ((r - l) / 2);
            long midSquared = mid * mid;
            if (midSquared <= k) {
                l = mid + 1;
            } else {
                r = (mid - 1);    //r=3
            }
        }
        return (int) l - 1;

    }


    //alternative solution... if allowed...
    static int findIntegerSquareRootCloseToGivenInteger2(int k) throws Exception {

        if (k < 0) {
            throw new Exception("k cannot be lower than zero.");
        }

        double res = Math.exp(0.5 * Math.log(Double.parseDouble("" + k)));


        return (int) res;
    }
}

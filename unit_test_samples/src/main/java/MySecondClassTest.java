/**
 * Created by barin.huseyin on 2/7/2016.
 */
public class MySecondClassTest {


    public int[] sortArrayWithBubble(int[] nums) {


        int temp;

        for (int i = nums.length; i >= 1; i--) {   // i=6,5,4,3,2,1

            for (int j = 0; j < i - 1; j++) {               //j=0,1,2,3   5,11  11,2  2,55  55,7  7,99

                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                }
            }

        }

        return nums;

    }


    public void makeOperation(){

        int a=5/0;
    }


    public MySecondClassTest() {


    }
}

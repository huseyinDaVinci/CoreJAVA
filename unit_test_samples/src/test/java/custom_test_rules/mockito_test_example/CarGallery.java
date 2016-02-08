package custom_test_rules.mockito_test_example;

import java.util.ArrayList;
import java.util.List;


public class CarGallery {

    List<Car> cars = new ArrayList<>();

    public String addCarToGallery(Car c) {
        cars.add(c);
        return c.model + " is add to gallery";
    }

    public int removeCarFromGallery(Car c) {
        cars.remove(c);
        return c.year;
    }

    public Car getOldestCar() {
        Car oldest = cars.get(0);
        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).year < oldest.year) {
                oldest = cars.get(i);
            }
        }
        return oldest;
    }

    public List<Car> getCars() {

        return cars;

    }

    public void updateCar(Car c, String model) {

        for (Car car : cars) {
            if (car.equals(c)) {
                c.model = model;
                break;
            }
        }
    }



}

package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      User user1 = new User("Vlad", "Maltsev", "www.komi" );
      User user2 = new User("Leha", "Kudrash", "www.smr" );
      User user3 = new User("Igor", "Grom", "www.spb" );
      User user4 = new User("Anna", "Jakovleva", "www.cmr" );


      Car car1 = new Car("Mark", 2);
      Car car2 = new Car("BMW", 5);
      Car car3 = new Car("Ford", 6);
      Car car4 = new Car("Jeep", 1);

      userService.add(user1.setCar(car2).setUser(user1));
      userService.add(user2.setCar(car1).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));




      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user.toString());
         System.out.println( );
      }
     System.out.println(userService.getUserbyCarmodelandseries("BMW", 5));
      context.close();
   }
}

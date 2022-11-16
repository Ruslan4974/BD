package persist.gettingStarted;

import com.sleepycat.persist.EntityCursor;
import config.Database;
import entity.auto;
import entity.prodazhi;
import repository.autoDA;
import repository.prodazhiDA;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static jdk.internal.reflect.ReflectionFactory.config;

public class app {
    private static final Random random = new Random();

    public static void Lab3(){
        System.out.println("Lab 3 Starting");
        Database.setup();
        prodazhiDA prodazhiDA = new prodazhiDA(Database.getStore());
        autoDA autoDA = new autoDA(Database.getStore());

        auto customer = new auto();
        auto.setId(0);

        autoDA.save(auto);

        prodazhi one = new prodazhi(
                0,
                new ArrayList<>(),
                auto.getId(),
                false
        );

        prodazhi two = new prodazhi(
                0,
                new ArrayList<>(),
                customer.getId(),
                false
        );

        prodazhi three = new prodazhi(
                0,
                new ArrayList<>(),
                customer.getId(),
                false
        );

        prodazhiDA.save(one);
        prodazhiDA.save(two);
        prodazhiDA.save(three);

        List<prodazhi> orders = prodazhiDA.get();
        System.out.println("prodazhi: ");
        System.out.println(prodazhi);

        System.out.println("prodazhi with id = 2: ");
        System.out.println(prodazhiDA.get(2));


        System.out.println("id = 1: ");
        System.out.println(prodazhiDA.getByautoId(1));

        System.out.println(prodazhiDA.delete(2));
        one.setCancelled(true);
        System.out.println(prodazhiDA.update(one));

        System.out.println("deleting and updating: ");
        System.out.println(prodazhiDA.get());
    }

    public static void Lab4() {

        Database.setup();
        prodazhiDA prodazhiDA = new prodazhiDA(Database.getStore());
        autoDA customerDA = new autoDA(Database.getStore());

        auto auto = new auto();
        autoDA.save(auto);
        auto = new auto();
        autoDA.save(auto);

        System.out.println("auto: ");
        System.out.println(autoDA.get());

        for (int i = 0; i < 4; i++){
            prodazhi order = new prodazhi(
                    0,
                    new ArrayList<>(),
                    1,
                    random.nextBoolean()
            );
            prodazhiDA.save(order);
        }

        int target = 5;

        try (EntityCursor<prodazhi> entityCursor = prodazhiDA.cursor()) {
            for (prodazhi order: entityCursor){
                if (prodazhi.getId() == target)
                {
                    System.out.println(" ");
                    System.out.println(prodazhi);
                }
            }
        }

        target = 2;

        System.out.println(" ");
        System.out.println(prodazhiDA.get(target));

        try (EntityCursor<prodazhi> entityCursor = prodazhiDA.cursor()) {
            for (prodazhi prodazhi: entityCursor){
                if (prodazhi.getId() == 2)
                {
                    prodazhi.setCancelled(!prodazhi.isCancelled());
                    entityCursor.update(prodazhi);
                }
            }
        }

        System.out.println("after updating: ");
        System.out.println(prodazhiDA.get(target));
    }

    public static void main(String[] args) {
        Lab3();
        Lab4();
    }
}

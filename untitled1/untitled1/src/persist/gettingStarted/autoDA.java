package persist.gettingStarted;

package repository;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.PrimaryIndex;
import entity.Customer;

import java.util.List;
import java.util.Map;

public class autoDA {
    PrimaryIndex<Integer, auto> id;

    public autoDA(EntityStore store) throws DatabaseException {

        id = store.getPrimaryIndex(Integer.class, auto.class);
    }

    public List<auto> get(){
        return this.id.map().values().stream().toList();
    }

    public static auto save(auto auto){
        Integer id = this.id.sortedMap().lastKey();
        id = id == null ? 0 : id + 1;
        customer.setId(id);
        return this.id.put(auto);
    }

}

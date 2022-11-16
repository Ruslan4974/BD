package persist.gettingStarted;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.persist.*;
import entity.prodazhi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class prodazhiDA {

    PrimaryIndex<Integer, auto> id;
    SecondaryIndex<Integer, Integer, prodazhi> customerId;

    public prodazhiDA(EntityStore store) throws DatabaseException {

        // Primary key for Customer class
        id = store.getPrimaryIndex(Integer.class, prodazhi.class);
        SecondaryIndex<Integer, Integer, prodazhi> prodazhi_kodAuto = store.getSecondaryIndex(id, Integer.class, "auto");
    }
    public EntityCursor<prodazhi> cursor(){
        return this.id.entities();
    }

    public List<prodazhi> get(){
        return this.id.map().values().stream().toList();
    }

    public prodazhi get(Integer id){
        return this.id.get(id);
    }

    public List<prodazhi> getByprodazhi_kodAuto(Integer prodazhi_kodAuto){
        EntityJoin<Integer, prodazhi> join = new EntityJoin<>(this.id);
        join.addCondition(this.prodazhi_kodAuto, prodazhi_kodAuto);
        try (ForwardCursor<prodazhi> entities = join.entities()) {
            return StreamSupport.stream(entities.spliterator(), false).toList();
        }
        catch (DatabaseException exc){
            return new ArrayList<>();
        }
    }

    public prodazhi save(prodazhi prodazhi){
        Integer id = this.id.sortedMap().lastKey();
        id = id == null ? 0 : id + 1;
        order.setId(id);
        return this.id.put(prodazhi);

    public List<prodazhi> getCancelledprodazhiForCustomer(int prodazhi_kodMashini){
        EntityJoin<Integer, prodazhi> join = new EntityJoin<>(this.id);
        join.addCondition(this.prodazhi_kodMashini, prodazhi_kodMashini);
        try (ForwardCursor<prodazhi> entities = join.entities()) {
            return StreamSupport.stream(entities.spliterator(), false)
                    .filter(prodazhi::isCancelled)
                    .toList();
        }
        catch (DatabaseException exc){
            return new ArrayList<>();
        }
    }

    public prodazhi update(prodazhi prodazhi){
        return this.id.put(prodazhi);
    }

    public boolean delete(Integer id){
        return this.id.delete(id);
    }

    public boolean getByautoId(int i) {
    }
}}

package com.test_6.Inventory.Repository;

import com.test_6.Inventory.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
    @Query(value = "select * FROM inventory WHERE item_id=?1", nativeQuery = true)
    Inventory getItemByItemId(int itemId);
}

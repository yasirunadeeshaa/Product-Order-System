package com.test_6.Inventory.Service;

import com.test_6.Inventory.DTO.InventoryDTO;
import com.test_6.Inventory.Model.Inventory;
import com.test_6.Inventory.Repository.InventoryRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InventoryService {
    @Autowired
    private InventoryRepo inventoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    public List<InventoryDTO> getAllInventory() {
        List<Inventory> inventoryList = inventoryRepo.findAll();
        return modelMapper.map(inventoryList, new TypeToken<List<InventoryDTO>>(){}.getType());
    }
    public InventoryDTO saveItem(InventoryDTO inventoryDTO) {
        inventoryRepo.save(modelMapper.map(inventoryDTO, Inventory.class));
        return inventoryDTO;
    }
    public InventoryDTO updateItem(InventoryDTO inventoryDTO) {
        inventoryRepo.save(modelMapper.map(inventoryDTO, Inventory.class));
        return inventoryDTO;
    }
    public String deleteItem(Integer itemId) {
        inventoryRepo.deleteById(itemId);
        return "Item deleted";
    }
    public InventoryDTO getItemById(Integer itemId) {
        Inventory item = inventoryRepo.getItemByItemId(itemId);
        return modelMapper.map(item, InventoryDTO.class);
    }
}

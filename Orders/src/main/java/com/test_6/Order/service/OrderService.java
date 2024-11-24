package com.test_6.Order.service;


import com.test_6.Inventory.DTO.InventoryDTO;
import com.test_6.Order.DTO.OrderDTO;
import com.test_6.Order.common.ErrorOrderResponse;
import com.test_6.Order.common.OrderResponse;
import com.test_6.Order.common.SuccessOrderResponse;
import com.test_6.Order.model.Order;
import com.test_6.Order.repository.OrderRepo;
import com.test_6.Prouduct.DTO.ProuductDTO;
import com.test_6.Prouduct.model.Prouduct;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

//import static com.test_6.Order.DTO.OrderDTO.getItemId;

@Service
@Transactional
public class OrderService {

    private final WebClient inventoryWebClient;
    private final WebClient productWebClient;

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ModelMapper modelMapper;

    public OrderService(WebClient inventoryWebClient, WebClient productWebClient) {
        this.inventoryWebClient = inventoryWebClient;
        this.productWebClient = productWebClient;
    }


    public List<OrderDTO> getAllOrders() {
        List<Order>orderList = orderRepo.findAll();
        return modelMapper.map(orderList, new TypeToken<List<OrderDTO>>(){}.getType());
    }
    public OrderResponse saveOrder(OrderDTO orderDTO) {

        int itemId = orderDTO.getItemId();

        try{
            InventoryDTO inventoryResponse = inventoryWebClient.get()
                    .uri(uriBuilder -> uriBuilder.path("/item/{itemId}").build(itemId))
                    .retrieve()
                    .bodyToMono(InventoryDTO.class)
                    .block();
            assert inventoryResponse != null;

            int productId = inventoryResponse.getProductId();
            ProuductDTO productResponse =productWebClient.get()
                    .uri(uriBuilder -> uriBuilder.path("/product/{productId}").build(productId))
                    .retrieve()
                    .bodyToMono(ProuductDTO.class)
                    .block();
            assert productResponse != null;

            if(inventoryResponse.getQuantity()>0 && inventoryResponse.getQuantity()>orderDTO.getAmount()){
                if(productResponse.getForSale()==1){
                    orderRepo.save(modelMapper.map(orderDTO, Order.class));
                }
                else {
                    return new ErrorOrderResponse("Item not for sale");
                }

                return new SuccessOrderResponse(orderDTO);
            }else{
                return new ErrorOrderResponse("Item not available");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return new ErrorOrderResponse("An error occurred while processing the order" + e.getMessage()) ;

        }

    }

    public OrderDTO updateOrder(OrderDTO OrderDTO) {
        orderRepo.save(modelMapper.map(OrderDTO, Order.class));
        return OrderDTO ;
    }

    public String deleteOrder(Integer Id) {
        orderRepo.deleteById(Id);
        return "Order deleted";
    }

    public OrderDTO getOrderById(Integer id) {
        Order order = orderRepo.getOrderById(id);
        return modelMapper.map(order, OrderDTO.class);
    }
//    public ProuductDTO getProductByProductId(int productId) {
//        //productRepo.findById(productId);
//        //return modelMapper.map(productRepo.findById(productId).get(), ProuductDTO.class);
//        Prouduct product = productRepo.findByProductId(productId); // Or use findById with Optional
//        if (product == null) {
//            throw new RuntimeException("Product not found with ID: " + productId);
//        }
//        return modelMapper.map(product, ProuductDTO.class);
//
//    }
}
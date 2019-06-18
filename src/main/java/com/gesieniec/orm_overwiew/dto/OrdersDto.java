package com.gesieniec.orm_overwiew.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDto {

    private UserDto purchaserUser;
    private String orderId;
    private List<ProductDto> productList;
}

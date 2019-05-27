package com.gesieniec.orm_overwiew.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrdersDto {

    private UserDto purchaserUser;
    private String orderId;
    private List<ProductDto> productList;
}

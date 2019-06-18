package com.gesieniec.orm_overwiew.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderDao {
    private List<Long> productIds;
    private String userEmail;
}

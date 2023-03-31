package com.cpg.cloudrunprocessor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class ProductEntity {

    private Long id;

    private Long count;
}

package com.oneNote.dto.responses;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
public class Paginated<T> {

    private List<T> content;
    private long totalPages;
    private long totalElements;

    public Paginated(Page<?> page){
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
    }

}

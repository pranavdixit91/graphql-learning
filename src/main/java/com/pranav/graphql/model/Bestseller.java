package com.pranav.graphql.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "bestsellers")
public class Bestseller {
    @Id
    private String id;
    private String category;   // e.g., "Fiction", "Science", "Self-Help", "Marathi"
    private List<String> bookIds;  // Array of Book IDs
}
package com.sda.java3.ecommerce.controllers;

import com.sda.java3.ecommerce.domains.Category;
import com.sda.java3.ecommerce.services.category.CategoryService;
import com.sda.java3.ecommerce.services.category.SaveCategoryRequest;
import com.sda.java3.ecommerce.services.product.SaveProductRequest;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.inject.Named;
import javax.inject.Provider;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryApiController {
    private final CategoryService categoryService;

    private static final String USAGE =
            "SplitCorpus paramFile\n"
                    + "Parameters are:\n"
                    + "\tcom.bbn.bue.splitCorpus.inputList: list of files to split. Optional.\n"
                    + "\tcom.bbn.bue.splitCorpus.inputMap: docId to file map of files to split. Optional.\n"
                    + "\tcom.bbn.bue.splitCorpus.outputDir: path to write output\n"
                    + "\tcom.bbn.bue.splitCorpus.numChunks: the number of chunks to split the corpus into. Optional.\n"
                    + "\tcom.bbn.bue.splitCorpus.chunkSize: the number of of files to put in each chunk. Optional.\n"
                    + "\n"
                    + "If inputList is given, output file lists will be written to outputDir/split/fileList.txt\n"
                    + "\tand a list of these lists will be written to outputDir/listOfLists.txt\n"
                    + "If inputMap is given, output file maps will be written to outputDir/split/fileMap.txt\n"
                    + "\tand a list of these maps will be written to outputDir/listOfMaps.txt\n"
                    + "At least one of inputList and inputMap must be specified.\n"
                    + "Exactly one of numChunks and chunkSize may be specified.";

//    @GetMapping("/id")
//    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
////        var item = this.productService.getProductById(id.toString());
//
////        return new ResponseEntity<>(categoryService.getCategories(id.toString()), HttpStatus.OK);
////    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping
    public UUID save(@RequestBody @Valid SaveCategoryRequest request) {
        return categoryService.save(request);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        categoryService.delete(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> get(@PathVariable UUID id) {
        var item = this.categoryService.findById(id);
        return item.isPresent()
                ? ResponseEntity.ok(item.get())
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}


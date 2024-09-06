package com.sda.java3.ecommerce.services.category;

import com.sda.java3.ecommerce.domains.Category;
import com.sda.java3.ecommerce.repositories.CategoryRepository;
import lombok.var;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import javax.inject.Singleton;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    protected final CategoryRepository categoryRepository;

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

    public CategoryServiceImpl(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getRootCategories() {
        return categoryRepository.getRootCategories();
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void delete(UUID id) {
        var item = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        categoryRepository.delete(item);
    }

    @Override
    public UUID save(SaveCategoryRequest request) {
        var dbItem = categoryRepository.findById(request.getId());
        if (dbItem.isPresent()) {
            dbItem.get().setName(request.getName());
            categoryRepository.save(dbItem.get());
            return dbItem.get().getId();
        }
        var newItem = Category.builder()
                .id(UUID.randomUUID())
                .name(request.getName())
                .build();
        categoryRepository.save(newItem);
        return newItem.getId();
    }

    @Override
    public Optional<Category> findById(UUID id) {
        return categoryRepository.findById(id);
    }

}

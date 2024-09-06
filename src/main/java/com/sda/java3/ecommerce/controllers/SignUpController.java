package com.sda.java3.ecommerce.controllers;

import com.sda.java3.ecommerce.services.category.CategoryService;
import com.sda.java3.ecommerce.services.product.ProductService;
import com.sda.java3.ecommerce.utils.Breadcrumb;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import javax.inject.Named;
import javax.inject.Provider;

import java.util.Arrays;

@Controller
public class SignUpController extends BaseController{

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

    public SignUpController(ProductService productService, CategoryService categoryService) {
        super(productService, categoryService);
    }

    @GetMapping("/sign-up")
    public String home(ModelMap modelMap) {
        initModelMap(modelMap);
        modelMap.addAttribute("breadcrumbs", Arrays.asList(
                Breadcrumb.builder().name("Home").url("/").build(),
                Breadcrumb.builder().name("Sign-up").url("/sign-up").last(true).build()
        ));
        return "sign-up";
    }
}

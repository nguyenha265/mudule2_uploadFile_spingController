package com.codegym.controller;
import com.codegym.model.ImageFrom;
import com.codegym.model.Products;
import com.codegym.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/upload")
@PropertySource("classpath:upload.properties")
public class ProductController {
    @Autowired
    Environment env;

    @Autowired
    private ImageService imageService;

    @GetMapping("/list*")
    public ModelAndView findAll() {

        List<Products> imageList = imageService.findAll();

        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("image", imageList);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showcreate(){
       ModelAndView modelAndView =new ModelAndView("/create") ;
       modelAndView.addObject("imagefrom", new ImageFrom());
       return modelAndView;
    }




    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute ImageFrom imageFrom){
        // lay ten file
        MultipartFile multipartFile = imageFrom.getImage();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();

        // luu file len server
        try {
            FileCopyUtils.copy(imageFrom.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // tao doi tuong de luu vao db
        Products productObject = new Products(fileName);

        // luu vao db
        imageService.addImage(productObject);

        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("imagefrom", new ImageFrom());
        modelAndView.addObject("message","Success");

        return modelAndView;
    }

}


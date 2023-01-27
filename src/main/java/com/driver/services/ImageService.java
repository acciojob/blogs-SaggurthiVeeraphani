package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;

    @Autowired
    BlogRepository blogRepository;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog
        Image image = new Image();
        image.setBlog(blog);
        image.setDescription(description);
        image.setDimensions(dimensions);

        List<Image> imageList = blog.getImageList();
        imageList.add(image);
        blog.setImageList(imageList);

        imageRepository2.save(image);

        return image;

    }

    public void deleteImage(Image image){
       imageRepository2.delete(image);
    }

    public Image findById(int id) {
        Image image = imageRepository2.findById(id).get();
        return image;

    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0
        int ans = 0;
        String size = image.getDimensions();
        int sizeValue = size.charAt(0)*size.charAt(2);
        int screenDimensionValue = screenDimensions.charAt(0)*screenDimensions.charAt(2);
        ans = sizeValue/screenDimensionValue;
        return ans;
    }
}

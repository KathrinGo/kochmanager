package de.kathrin.kochmanager.rest;

import de.kathrin.kochmanager.entities.ImageRezept;
import de.kathrin.kochmanager.repos.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@CrossOrigin
@RequestMapping(path = "image")
public class ImageController {
    @Autowired
    ImageRepo imageRepository;
    @PostMapping("/upload")
    public ImageRezept uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        ImageRezept img = new ImageRezept(file.getOriginalFilename(), file.getContentType(),
                compressBytes(file.getBytes()));
        ImageRezept response = imageRepository.save(img);
        return response;
    }
    @GetMapping( "/get/{imageName}")
    public ImageRezept getImage(@PathVariable("imageName") String imageName) throws IOException {
        final Optional<ImageRezept> retrievedImage = imageRepository.findByName(imageName);
        return new ImageRezept(retrievedImage.get().getName(), retrievedImage.get().getType(),
                decompressBytes(retrievedImage.get().getPicByte()));
    }
        // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }
        // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}

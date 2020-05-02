package de.kathrin.kochmanager.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "image_table")
public class ImageRezept {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name = "type")
    private String type;

    @Column(name = "picByte", length = 1000)
    private byte[] picByte;

        //image bytes can have large lengths so we specify a value
        //which is more than the default length for picByte column

    public ImageRezept() {
        super();
    }
    public ImageRezept(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }




}

package com.steep.practice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Pet implements Serializable {

    @Serial //se esta especificando un identificador de serializacion personalizado (bytes)
    private static final long serialVersionUID = 4889087778273529265L;
    //lectura desde un archivo o almacenamiento
    // transmision de objetos a traves de la red
    // comunicacion entre hilos o procesos
    // almacenamiento en cache
    //sesiones de aplicaciones web
    @Id
    private String name;

    private String owner;

    private String species;

    private char sex;

    @Temporal(TemporalType.DATE)
    private Date birth;

    @Temporal(TemporalType.DATE)
    private Date death;

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", species='" + species + '\'' +
                ", sex=" + sex +
                ", birth=" + birth +
                ", death=" + death +
                '}';
    }
}

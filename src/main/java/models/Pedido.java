package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Entity
@Table
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date fecha;

    private String cliente;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "producto")
    private Producto producto;

    public Pedido() {
        Date fecha = new Date();
        this.fecha = fecha;
        this.estado = "Pendiente";
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", cliente='" + cliente + '\'' +
                ", estado='" + estado + '\'' +
                ", producto=" + producto.getNombre() +
                '}';
    }
}

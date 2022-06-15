package dao.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "currents", schema = "currentyhandbook")
public class Currency {
    private Long id;
    private String name;
    private String description;
    private String code;
    private LocalDateTime dateCreat;
    private LocalDateTime dateUpdate;

    public Currency() {
    }

    public Currency(String name, String description, String code, LocalDateTime dateCreat) {
        this.name = name;
        this.description = description;
        this.code = code;
        this.dateCreat = dateCreat;
    }

    public Currency(LocalDateTime dateUpdate, String name, String description, String code) {
        this.name = name;
        this.description = description;
        this.code = code;
        this.dateUpdate = dateUpdate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getDateCreat() {
        return dateCreat;
    }

    public void setDateCreat(LocalDateTime dateCreat) {
        this.dateCreat = dateCreat;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", dateCreat=" + dateCreat +
                ", dateUpdate=" + dateUpdate +
                '}';
    }
}

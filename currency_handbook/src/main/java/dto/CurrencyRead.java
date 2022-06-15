package dto;

import java.time.LocalDateTime;

public class CurrencyRead {
    private Long id;
    private String name;
    private String description;
    private String code;
    private LocalDateTime dateCreat;
    private LocalDateTime dateUpdate;

    public CurrencyRead(Long id, String name, String description,
                        String code, LocalDateTime dateCreat, LocalDateTime dateUpdate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.code = code;
        this.dateCreat = dateCreat;
        this.dateUpdate = dateUpdate;
    }

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
}

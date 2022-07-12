import lombok.Data;

import java.time.LocalDate;

public @Data class Project {
    private long ID;
    private String name;
    private LocalDate timeOfCreation;
    private long customerId;
    private long companyId;

}
